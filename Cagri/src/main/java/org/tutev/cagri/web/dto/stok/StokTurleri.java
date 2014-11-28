package org.tutev.cagri.web.dto.stok;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STOK_TURLERI")
@SequenceGenerator(name="STOK_TURLERI_ID_SEQ")
public class StokTurleri implements Serializable {


}
