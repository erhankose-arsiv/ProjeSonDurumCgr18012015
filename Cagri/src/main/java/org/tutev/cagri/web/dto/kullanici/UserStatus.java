package org.tutev.cagri.web.dto.kullanici;

public enum UserStatus {
	ACTIVE(1),
	INACTIVE(0);
	
	private int no;
	private UserStatus(int no) {
		this.no = no;

	}

	public int getNo() {
		return this.no;
	}

}
