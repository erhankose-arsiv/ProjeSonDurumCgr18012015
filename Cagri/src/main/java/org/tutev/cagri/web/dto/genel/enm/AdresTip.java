package org.tutev.cagri.web.dto.genel.enm;

public enum AdresTip {

	EV(1, "Ev Adresi"), IS(2, "Ýþ Adresi"), DIGER(3, "Diðer");

	String tanim;
	int no;

	private AdresTip(int no, String tanim) {
		this.no = no;
		this.tanim = tanim;
	}

	private AdresTip() {
	}
}
