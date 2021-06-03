package br.ce.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.appium.core.BaseTest;
import br.ce.appium.page.AccordionPage;
import br.ce.appium.page.MenuPage;

public class AccordionTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AccordionPage accordion = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
		//acessar menu
		menu.acessarAccordion();
		//clicar op 1
		accordion.selecionarOp1();
		
		//verificar texto op1
		esperar(1000);
		Assert.assertEquals("Esta é a descrição da opção 1",accordion.obterValorOp1());
	}
}
