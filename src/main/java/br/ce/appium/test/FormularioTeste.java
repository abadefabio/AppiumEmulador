package br.ce.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.appium.core.BaseTest;
import br.ce.appium.page.FormularioPage;
import br.ce.appium.page.MenuPage;

public class FormularioTeste extends BaseTest{

	
	private MenuPage menuPage = new MenuPage();
	private FormularioPage formPage = new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException{
		menuPage.acessarFormulario();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		
		//escrever nome
		formPage.escreverNome("Fabio");
		
		//checar nome escrito
		assertEquals("Fabio", formPage.obterNome());
		//assertEquals("Fabio", util.obterTexto(MobileBy.AccessibilityId("nome")));

	}
		
	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		//clicar no combo
		formPage.selecionarCombo("Nintendo Switch");
		//util.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");				
		
		// verificar a opção
		Assert.assertEquals("Nintendo Switch", formPage.obterValorCombo());
	}
		
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {

//		verificar status do elemetos
		Assert.assertFalse(formPage.isCheckBoxMarcado());
		Assert.assertTrue(formPage.isSwitchMarcado());
		
		//clicar elementos
		formPage.clicarCheckBox();
		formPage.clicarSwitch();
			
		
		//verificar status alterados
		Assert.assertTrue(formPage.isCheckBoxMarcado());
		Assert.assertFalse(formPage.isSwitchMarcado());
		
	}
	
	@Test
	public void devePreencherCadastro() throws MalformedURLException {

		// preencher nome
		formPage.escreverNome("Fabio R ABade");
			
		// selecionar check
		formPage.clicarCheckBox();
		
		//selecionar switch
		formPage.clicarSwitch();
		
		// selecionar combo nitendo
		formPage.selecionarCombo("Nintendo Switch");
		//util.selecionarCombo(By.xpath("//*[@text='Nintendo Switch']"), "Nintendo Switch");
		//util.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");
		
		//clicar em salvar
		formPage.btnSalvar();
	
	   
		//validar dados
		Assert.assertEquals("Nome: Fabio R ABade", formPage.obterNomeCadastrado());
		Assert.assertTrue(formPage.obterSwitchCadastrado().endsWith("Off"));	  
		Assert.assertEquals("Console: switch", formPage.obterConsoleCadastrado());
		Assert.assertTrue(formPage.obterCheckBoxCadastrado().endsWith("Marcado"));

		}

	}
