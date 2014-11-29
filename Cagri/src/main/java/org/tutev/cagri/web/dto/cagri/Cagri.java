package org.tutev.cagri.web.dto.cagri;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.tutev.cagri.web.dto.Base;

@Entity
@Table(name="CGR_CAGRI")
public class Cagri extends Base {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1717263007061985016L;
	Long id;
	Date gelisTarihi;
	
	@Id 
	@SequenceGenerator(allocationSize=1,initialValue=1,name="CAGRI_ID_SEQ",sequenceName="CAGRI_ID_SEQ")
	@GeneratedValue(generator="CAGRI_ID_SEQ",strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="GELIS_TARIHI")
	public Date getGelisTarihi() {
		return gelisTarihi;
	}
	public void setGelisTarihi(Date gelisTarihi) {
		this.gelisTarihi = gelisTarihi;
	}
	
	

}
