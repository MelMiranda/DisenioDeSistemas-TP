package testService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.processing.SupportedAnnotationTypes;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.AssertThrows;

import domain.Address;
import domain.Coordinate;
import domain.RangeOfAtention;
import domain.Schedule;
import internalService.PoiService;
import junit.framework.Assert;
import poi.Bank;
import poi.CGPService;
import poi.ComercialShop;
import poi.Newspaper;
import users.Admin;

public class ReportTest {
	private PoiService poiService;
	private Admin admin;

	@Before
	public void setup() {
		this.poiService = PoiService.getInstance();
		this.admin = new Admin();
		this.poiService.resetReports();

		this.admin.addPoi(new Bank("BancoNAcion", new Address("Paraguay 2815"), new Coordinate(1.2, 21.3)));
		this.admin.addPoi(new ComercialShop("libreria de libros ajajaj", new Address("al lado de la utn"),
				new Coordinate(1.2, 21.3), Newspaper.getInstance(32)));

	}


	@Test
	public void testReportes() {
		this.poiService.searchPois("BancoNAcion", "banco1");
		this.poiService.searchPois("al lado de la utn", "banco1");

		Map<String, Integer> resultados = this.poiService.obtenerReportesFecha();

	
	    Assert.assertEquals((Integer) 2, resultados.get("30/6/2016"));
	    Assert.assertNotNull(resultados);

	}

}
