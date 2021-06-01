package br.ce.appium.test;

import org.junit.Test;

import br.ce.appium.core.BaseTest;
import br.ce.appium.page.AlertaPage;
import br.ce.appium.page.MenuPage;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;


public class AlertaTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AlertaPage alerta = new AlertaPage();
	
	@Test
	public void deveConfirmarAlerta() {
		//acessar menu alerta
		menu.acessarAlertas();
		//clicar em alerta confirma
		alerta.clicarAlertaConfirm();
		//verificar os textos
		Assert.assertEquals("Info", alerta.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", alerta.obterMensagemAlerta());
		//confirmar alerta
		alerta.clicarBtnConfirmar();
		//verificar nova mensagem
		Assert.assertEquals("Info",alerta.obterTituloAlerta());
		Assert.assertEquals("Confirmado", alerta.obterMensagemAlerta());
		//sair
		alerta.clicarBtnSair();
	}
}
