package org.tutev.cagri.web.dto.cagri;

public enum CagriGelisTipEnm {
	TELEFON(0, "Telefon ile"),
	EPOSTA(1, "E-posta ile"),
	WEB(2, "Web ile"),
	FAKS(3, "Faks ile"),
	WEBSERVICE(4, "Web service ile"),
	SMS(5,"SMS ile");
	
	private int no;
	private String label;

	private CagriGelisTipEnm(int no, String label) {
		this.no = no;
		this.label = label;
	}

	public int getNo() {
		return this.no;
	}

	public String getLabel() {
		return this.label;
	}
	
	public String toString() {
		return label;
	}
}
