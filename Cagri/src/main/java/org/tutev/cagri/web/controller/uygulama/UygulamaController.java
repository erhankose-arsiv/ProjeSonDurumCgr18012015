package org.tutev.cagri.web.controller.uygulama;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.genel.Kullanici;
import org.tutev.cagri.web.dto.uygulama.AltMenu;
import org.tutev.cagri.web.dto.uygulama.Menu;
import org.tutev.cagri.web.dto.uygulama.Yetki;
import org.tutev.cagri.web.service.uygulama.UygulamaService;

@Controller("uygulamaController")
@Scope(value = "globalSession")
public class UygulamaController {

	MenuModel menuModel;

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	@Autowired
	private transient UygulamaService uygulamaService;

	@PostConstruct
	private void init() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
//		if(uygulamaService!=null ){
		Kullanici kullanici = (Kullanici) session.getAttribute("kullanici");

		List<Menu> menuList = uygulamaService.getAll();

		menuModel = new DefaultMenuModel();
		for (Menu menu : menuList) {

			boolean flag = false;
			for (Yetki yetkiKul : kullanici.getYetkiList()) {
				for (Yetki yetkiMenu : menu.getYetkiList()) {
					if (yetkiMenu.getId() == yetkiKul.getId()) {
						flag = true;
					}
				}
				if (flag) {
					DefaultSubMenu submenu = new DefaultSubMenu(menu.getAdi());

					for (AltMenu altmenu : menu.getAltMenuList()) {
						if (altmenu.getAltMenuList().size() == 0) {
							DefaultMenuItem item = new DefaultMenuItem(altmenu.getAdi());
							item.setUrl(altmenu.getUrl());
							submenu.addElement(item);
						} else {
							DefaultSubMenu submenu2 = new DefaultSubMenu(altmenu.getAdi());

							for (AltMenu altmenuAlt : altmenu.getAltMenuList()) {
								DefaultMenuItem itemAlt = new DefaultMenuItem(altmenuAlt.getAdi());
								itemAlt.setUrl(altmenuAlt.getUrl());
								submenu2.addElement(itemAlt);
							}
							submenu.addElement(submenu2);
						}
					}
					menuModel.addElement(submenu);

					break;
				}
			}
		}
	}
}
