package br.ce.appium.page;

import org.openqa.selenium.By;

import br.ce.appium.core.BasePage;

public class AbasPage extends BasePage {
	
	private MenuPage menu = new MenuPage();
	
	public void acessarMenuAbas() {
		menu.acessarAbas();
	}
	
	public String obterTextoAba() {
		//return obterTexto(By.xpath("//*[contains(@text(),'Este é o conteúdo da Aba 1']"));
		return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 1']"));
	}
	
	public void clicarAba2() {
		clicarPorTexto("ABA 2");
	}
	
	public String obterTextoAba2() {
		return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 2']"));
	}
	
	public boolean isAba1() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 1");
	}
	
	public boolean isAba2() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 2");
	}

}
