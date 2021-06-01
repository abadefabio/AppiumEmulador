package br.ce.appium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import br.ce.appium.core.BaseTest;
import br.ce.appium.page.MenuPage;
import br.ce.appium.page.SplashPage;

public class SplashTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SplashPage splash = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() {
		//acessar menu splash
		menu.acessarSplash();	
		//verificar se esta visivel - verificar se esta sendo exibido
		splash.isTelaSplashVisivel();
		//aguardar splash
		splash.aguardarSplashSumir();
		//verificar se o formulario esta aparecendo
		Assert.assertTrue(splash.existeElementoPorTexto("Formulário"));
		}
	
	 
}

