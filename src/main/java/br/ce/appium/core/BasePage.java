package br.ce.appium.core;

import static br.ce.appium.core.DriverFactory.getDriver;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import sun.misc.PerformanceLogger;

public class BasePage {

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
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elementos.size()>0;
	}
	

	public void tap(int x, int y) {
		new TouchAction(getDriver()).tap(x,y).perform();
		
		//(new TouchAction(getDriver())).tap(PointOption.point(x,y)).perform();
	}
	
	
	
	public void tocarCoordenada(int x, int y) {
		(new TouchAction(getDriver())).tap(PointOption.point(x,y)).perform();
	}
	
	public <T> void tocarCoodernada(T elemento, int x, int y) throws Exception {
		try {
			(new TouchAction(getDriver())).tap((TapOptions)TapOptions.tapOptions().withElement(ElementOption.element(this.retornaElementoMobile(elemento), x, y))).perform();
		} catch (Exception var6) {
			throw new Exception("Erro ao clicar por coordenadas", var6);
		}		
	}
	
	public <T> MobileElement retornaElementoMobile(T elemento) throws Exception{
		try {
			if(elemento instanceof By) {
				return (MobileElement)getDriver().findElement((By)elemento);
			}else {
				return elemento instanceof MobileBy ? (MobileElement)getDriver().findElement((MobileBy)elemento): (MobileElement)elemento;
			}
		}catch (NoSuchElementException var3) {
			throw new Exception("Não foi possivel localizar o lemento desejadona tela com a estrategia: " + elemento, var3);
		}
	}
}
