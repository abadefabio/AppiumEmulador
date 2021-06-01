package br.ce.appium.test;

import org.junit.Test;

import br.ce.appium.core.BaseTest;
import br.ce.appium.page.AbasPage;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

public class AbasTestes extends BaseTest {

	private AbasPage aba = new AbasPage();
	
	@Test
	public void deveInteragirComAbas() {
		//acessar menu abas
		aba.acessarMenuAbas();
		//Verificar se esta na aba 1
		Assert.assertEquals("Este é o conteúdo da Aba 1",aba.obterTextoAba());
		Assert.assertTrue(aba.isAba1());
		//acessar aba 2
		aba.clicarAba2();
		//verificar se esta na aba 2
		Assert.assertEquals("Este é o conteúdo da Aba 2", aba.obterTextoAba2());
		Assert.assertTrue(aba.isAba2());
	}
}
