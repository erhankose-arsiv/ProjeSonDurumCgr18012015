package org.tutev.cagri.web.dto.genel.enm;

public enum AdresTip {

	EV(1, "Ev Adresi"), IS(2, "�� Adresi"), DIGER(3, "Di�er");

	String tanim;
	int no;

	private AdresTip(int no, String tanim) {
		this.no = no;
		this.tanim = tanim;
	}

	private AdresTip() {
	}
}
