package br.ce.appium.test;

import org.junit.Test;

import br.ce.appium.core.BaseTest;
import br.ce.appium.page.AlertaPage;
import br.ce.appium.page.MenuPage;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;


public class AlertaTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AlertaPage alerta = new AlertaPage();
	
	@Before
	public void acessarMenuAlertas() {
		//acessar menu alerta
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {
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
	
	@Test
	public void deveClicarForaAlertaPosicional() {
		//clicar alerta simples
		alerta.clicarAlertaSimples();
		//clicar fora da caixa posicional x100 y150
		esperar(1000);
		alerta.clicarForaCaixaPosicional();
		//verificar que mensagem não esta presente
		Assert.assertFalse(alerta.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}
}
