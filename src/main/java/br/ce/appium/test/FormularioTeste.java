package br.ce.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.appium.core.BaseTest;
import br.ce.appium.core.DriverFactory;
import br.ce.appium.page.FormularioPage;
import br.ce.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.functions.ExpectedCondition;

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
	
	@Test
	public void devePreencherCadastroDemorado() throws MalformedURLException {
		
		// preencher nome
		formPage.escreverNome("Fabio R ABade");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
		//clicar em salvar
		formPage.btnSalvarDemorado();
	   // esperar(4000);
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Fabio R ABade']")));
		   
		//validar dados
		Assert.assertEquals("Nome: Fabio R ABade", formPage.obterNomeCadastrado());
		}
	
	@Test
	public void deveAlterarData() {
		formPage.clicarPorTexto("01/01/2000");
		formPage.clicarPorTexto("20");
		formPage.clicarPorTexto("OK");
		Assert.assertTrue(formPage.existeElementoPorTexto("20/2/2000"));
		
	}

	@Test
	public void deveAlterarHora() {
		formPage.clicarPorTexto("06:00");
		formPage.clicar(MobileBy.AccessibilityId("10"));
		formPage.clicar(MobileBy.AccessibilityId("40"));
		formPage.clicarPorTexto("OK");
		Assert.assertTrue(formPage.existeElementoPorTexto("10:40"));
	}
	
	@Test
	public void deveInteragirComSeekbar() {		
		//clica no seekbar
		formPage.clicarSeekbar(0.05);
		
		//obter valor
		formPage.btnSalvar();
		
	}
}
