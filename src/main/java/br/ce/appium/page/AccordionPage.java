package br.ce.appium.page;

import org.openqa.selenium.By;

import br.ce.appium.core.BasePage;
import br.ce.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;

public class AccordionPage extends BasePage {

	public void selecionarOp1() {
		clicarPorTexto("Op??o 1");
	}
	
	public String obterValorOp1() {
		return obterTexto(By.xpath("//*[@text='Esta ? a descri??o da op??o 1']"));
		//return obterTexto(By.xpath("//*[@text='Op??o 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}
}
