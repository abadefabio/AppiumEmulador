package br.ce.appium.core;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import static br.ce.appium.core.DriverFactory.getDriver;

public class DSL {
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
		////util.escrever(MobileBy.AccessibilityId("nome"), "Fabio"); exemplo de chamada para utilizar
	}
	
	public String obterTexto(By by) {

		return getDriver().findElement(by).getText();
		
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}
	
	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor); 
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
}
