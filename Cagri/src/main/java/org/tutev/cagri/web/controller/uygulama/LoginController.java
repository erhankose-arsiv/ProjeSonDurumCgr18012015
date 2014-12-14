package org.tutev.cagri.web.controller.uygulama;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.dto.genel.Kullanici;
import org.tutev.cagri.web.service.uygulama.LoginService;

@Controller("loginController")
@Scope("session")
public class LoginController {

	@Autowired
	private transient LoginService loginService;

	private String username;
	private String password;
	private Kullanici kullanici;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public Kullanici getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() throws IOException {
		kullanici = loginService.getKullaniciByUsernamePassword(username, password);
		if (kullanici == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "HatalÄ± KullanÄ±cÄ± AdÄ±/Å�ifre!", "LÃ¼tfen tekrar deneyiniz!"));
			return "login";
		} else {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("kullanici", kullanici);
			FacesContext.getCurrentInstance().getExternalContext().redirect("secure/Cagri/CGR01.xhtml");
			return "index";
		}
	}

	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "login";
	}
}
