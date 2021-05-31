package br.ce.appium.core;

import org.junit.After;
import org.junit.AfterClass;

public class BaseTest {

	@AfterClass
	public static void finalizaClasse() {
		DriverFactory.killDriver(); //fechar sessão appium no final
	}
	
	@After
	public void tearDown() {
		//DriverFactory.killDriver();          //fechar sessão appium no final
		DriverFactory.getDriver().resetApp();  // reiniciar o app em vez de encerrar o driver todo teste
	}
}
