package br.ce.appium.test;

import org.junit.Test;

import br.ce.appium.core.BaseTest;
import br.ce.appium.page.CliquesPage;
import br.ce.appium.page.MenuPage;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

public class CliquesTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquesPage clique = new CliquesPage();
	
	@Test
	public void deveRealizarCliqueLongo() {
		//acessar menu
		menu.acessarCliques();
		
		//clicar longo
		clique.cliqueLongo();
		
		//verificar texto
		Assert.assertEquals("Clique Longo", clique.obterTexto());
	}

}
