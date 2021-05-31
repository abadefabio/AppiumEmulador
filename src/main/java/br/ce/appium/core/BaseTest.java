package br.ce.appium.core;


import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class BaseTest {

	@Rule
	public TestName testeName = new TestName();
	
	@AfterClass
	public static void finalizaClasse() {
		DriverFactory.killDriver(); //fechar sessão appium no final
	}
	
	@After
	public void tearDown() {
		gerarScreenShot();
		
		//DriverFactory.killDriver();          //fechar sessão appium no final
		DriverFactory.getDriver().resetApp();  // reiniciar o app em vez de encerrar o driver todo teste
	}

	public void gerarScreenShot() {
		try {
			File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(imagem, new File("target/screenshot/"+testeName.getMethodName()+".png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
