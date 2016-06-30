package testService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import domain.Address;
import domain.Coordinate;
import domain.RangeOfAtention;
import domain.Schedule;
import internalService.PoiService;
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
		poiService = PoiService.getInstance();
		admin = new Admin();
		/*
		 * Schedule horario=new Schedule("12", "24"); List<Integer>
		 * daysOfAtention=new ArrayList<Integer>(); List<Schedule> schedules=new
		 * ArrayList<Schedule>(); schedules.add(horario); daysOfAtention.add(1);
		 * daysOfAtention.add(2); daysOfAtention.add(3); daysOfAtention.add(1);
		 * 
		 * RangeOfAtention rangeOfAtention=new RangeOfAtention(schedules,
		 * daysOfAtention); CGPService cgpService=new CGPService(
		 * "atencion de ancianos", rangeOfAtention);
		 */

		admin.addPoi(new Bank("BancoNAcion", new Address("Paraguay 2815"), new Coordinate(1.2, 21.3)));
		admin.addPoi(new ComercialShop("libreria de libros ajajaj", new Address("al lado de la utn"),
				new Coordinate(1.2, 21.3), Newspaper.getInstance(32)));

	}

	@Test
	public void testReportes() {
		this.poiService.searchPois("BancoNAcion", "banco1");
		this.poiService.searchPois("al lado de la utn", "banco1");

		Map<String, Integer> resultados = this.poiService.obtenerReportesFecha();

		System.out.println(resultados.toString());

	}

}
