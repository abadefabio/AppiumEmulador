package br.ce.appium.page;

import org.openqa.selenium.By;

import br.ce.appium.core.BasePage;
import br.ce.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;

public class AccordionPage extends BasePage {

	public void selecionarOp1() {
		clicarPorTexto("Opção 1");
	}
	
	public String obterValorOp1() {
		return obterTexto(By.xpath("//*[@text='Esta é a descrição da opção 1']"));
		//return obterTexto(By.xpath("//*[@text='Opção 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}
}
