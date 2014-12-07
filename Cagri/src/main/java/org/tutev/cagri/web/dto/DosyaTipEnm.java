package org.tutev.cagri.web.dto;

public enum DosyaTipEnm {

	EXCEL(0, "Excel"),
	PDF(1, "PDF"),
	RESIM(2, "Resim");
	
	private int no;
	private String label;

	private DosyaTipEnm(int no, String label) {
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
