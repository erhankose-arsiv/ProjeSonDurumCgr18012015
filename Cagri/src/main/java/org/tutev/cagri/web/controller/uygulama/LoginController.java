package org.tutev.cagri.web.controller.uygulama;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

	String theme = "sunny";

	@SuppressWarnings("finally")
	public String doLogin() {

		try {

			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("j_spring_security_check");

			dispatcher.forward((ServletRequest) context.getRequest(),(ServletResponse) context.getResponse());
			FacesContext.getCurrentInstance().responseComplete();

		} catch (ServletException | IOException ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			return null;
		}
	}
	
	public String logout() {

		try {

			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/j_spring_security_logout");

			dispatcher.forward((ServletRequest) context.getRequest(),(ServletResponse) context.getResponse());
			FacesContext.getCurrentInstance().responseComplete();

		} catch (ServletException | IOException ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			return null;
		}
	}

	public void authorizedUserControl() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication !=null && !authentication.getPrincipal().toString().equals("anonymousUser")) {

			NavigationHandler nh = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
			nh.handleNavigation(FacesContext.getCurrentInstance(), null,"/secure/index.xhtml?faces-redirect=true");

		}
	}
	

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

}
