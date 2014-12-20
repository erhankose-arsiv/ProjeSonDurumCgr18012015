package org.tutev.cagri.web.resources.reports;
import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.tutev.cagri.web.controller.Arac;
import org.tutev.cagri.web.controller.MessageController;


@Controller("raporController")
@Scope("request")
public class RaporController implements Serializable {

	@Autowired
	private MessageController messagesController;
	
	@Autowired
	private DataSource dataSource;


	private Map parameters = new HashMap();
	private String raporName = "";

	private int raporPar;

	public int getRaporPar() {
		return raporPar;
	}

	public void setRaporPar(int raporPar) {
		this.raporPar = raporPar;
	}
	

	public void raporParametreTemizle() {
		parameters = new HashMap();
	}

	public void raporAl() {
		Connection connection = null;
		try {
			parameters.put("IL_ID", 6L);
			raporName="org/tutev/cagri/web/resources/reports/rptCagriListe.jrxml";
			
			String png="org/tutev/cagri/web/resources/reports/coffee_stain.png";
			String jpg="org/tutev/cagrli/web/resources/reports/coffee.jpg";
			Resource pngR = new ClassPathResource(png);
			Resource jpgR = new ClassPathResource(jpg);
			parameters.put("PNG", pngR.getInputStream());
			parameters.put("JPG", jpgR.getInputStream());
			
			connection = dataSource.getConnection();
			Resource resource = new ClassPathResource(raporName);
			String report = resource.getFile().getAbsolutePath();
			JasperReport jasperReport = JasperCompileManager.compileReport(report);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

			String raporAdi = resource.getFilename().substring(0,resource.getFilename().lastIndexOf('.')) + ".xls";

			Arac.getResponse().reset();

			Arac.getResponse().setContentType("application/vnd.ms-excel");
			Arac.getResponse().setHeader("Content-disposition",	"attachment; filename=\"" + raporAdi + "\"");
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT,jasperPrint);
			exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,Arac.getResponse().getOutputStream());

			exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.MAXIMUM_ROWS_PER_SHEET, 60000);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,Boolean.TRUE);
			
			exporterXLS.exportReport();

			Arac.getFacesContext().responseComplete();
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("alert('rapor bitti')");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	



}
