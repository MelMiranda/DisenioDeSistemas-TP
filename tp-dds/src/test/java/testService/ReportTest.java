package testService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import domain.Address;
import domain.Coordinate;
import internalService.PoiService;
import junit.framework.Assert;
import poi.Bank;

import poi.ComercialShop;
import poi.Newspaper;
import users.Admin;
import users.Terminal;

@SuppressWarnings("deprecation")
public class ReportTest {
	private PoiService poiService;
	private Admin admin;
	private String date;
	private Terminal terminal;
	private Terminal terminal2;

	@Before
	public void setup() {
		this.poiService = PoiService.getInstance();
		this.admin = new Admin();
		this.poiService.resetReports();
		this.poiService.resetAllPois();
		this.poiService.removeAllPois();

		this.admin.addPoi(new Bank("BancoNAcion", new Address("Paraguay 2815"), new Coordinate(1.2, 21.3)));
		this.admin.addPoi(new ComercialShop("libreria de libros ajajaj", new Address("al lado de la utn"),
				new Coordinate(1.2, 21.3), Newspaper.getInstance(32)));

		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		this.date = sdf.format(fecha);

		terminal  = new Terminal("terminalAbasto", this.poiService);
		terminal2 =new Terminal("terminalPalermo",this.poiService);

	}

	@Test
	public void testReportesTotales() {
		this.poiService.searchPois("BancoNAcion", "banco1");
		this.poiService.searchPois("al lado de la utn", "banco1");

		Map<String, Integer> resultadosTotales = this.poiService.getReportesTotalesPorFecha();

		// System.out.println(resultadosTotales);

		Assert.assertEquals((Integer) 2, resultadosTotales.get(date));
		Assert.assertNotNull(resultadosTotales);
	}

	@Test
	public void testReportesParcialesPorTerminal() {

		Map<String, Integer> resultadoPorTerminalAbasto = this.poiService.getParcialesPorTerminal("terminalAbasto");
		this.terminal.searchPoi("BancoNAcion");
		this.terminal.searchPoi("al lado de la utn");
		resultadoPorTerminalAbasto = this.poiService.getParcialesPorTerminal("terminalAbasto");

		Assert.assertEquals((Integer) 2, resultadoPorTerminalAbasto.get(date));
		Assert.assertNotNull(resultadoPorTerminalAbasto);

		this.admin.addPoi(new Bank("acaNomas", new Address("cngvjhgj"), new Coordinate(1.2, 21.3)));
		this.admin.addPoi(new ComercialShop("hgkhjk", new Address("acaNomas"), new Coordinate(1.2, 21.3),
				Newspaper.getInstance(32)));

		this.terminal.searchPoi("acaNomas");
		
				
		// verificar aca esta dando los datos mal
		resultadoPorTerminalAbasto = this.poiService.getParcialesPorTerminal("terminalAbasto");
		Assert.assertEquals((Integer) 6, resultadoPorTerminalAbasto.get(date));
		Assert.assertNotNull(resultadoPorTerminalAbasto);
	}
	
	@Test
	public void testReportesTotalesTodasLasTerminales(){
		this.terminal.searchPoi("BancoNAcion");
		this.terminal.searchPoi("al lado de la utn");	
		
		this.terminal2.searchPoi("BancoNAcion");
		this.terminal2.searchPoi("al lado de la utn");		
		
		Assert.assertEquals((Integer) 2, this.poiService.getReportesTodasLasTerminales().get("terminalAbasto"));
		Assert.assertEquals((Integer) 4, this.poiService.getReportesTodasLasTerminales().get("terminalPalermo"));

	}	
	
}
