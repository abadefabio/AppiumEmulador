package br.ce.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import br.ce.appium.core.DriverFactory;

public class FormularioTeste {

	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() throws MalformedURLException{
		driver = DriverFactory.getDriver();

		//selecionar menu formulario
		MobileElement form = driver.findElement(By.xpath("//*[@text='Formulário']"));
		form.click();

	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver(); //fechar sessão appium no final
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {


		//selecionar menu formulario
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		for(MobileElement elemento: elementosEncontrados) {
			System.out.println(elemento.getText());	   		
		}
		elementosEncontrados.get(1).click();
		//escrever nome
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Fabio");
		//checar nome escrito
		String text = campoNome.getText();
		Assert.assertEquals("Fabio", text);

	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {


		//clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		// selecionar opção desejado
		
		driver.findElement(By.xpath("//*[@text='Nintendo Switch']")).click();
		
		// verificar a opção
		String nitendo = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		Assert.assertEquals("Nintendo Switch", nitendo);

	}
	
	@Test
	public void deveInteragirSwitch() throws MalformedURLException {

//		verificar status do elemetos
		
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement swite = driver.findElement(MobileBy.AccessibilityId("switch"));
		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(swite.getAttribute("checked").equals("true"));
		
		//clicar elementos
		check.click();
		swite.click();
		
		
		//verificar status alterados
		Assert.assertFalse(check.getAttribute("checked").equals("false"));
		Assert.assertFalse(swite.getAttribute("checked").equals("true"));
	

	}
	
	@Test
	public void devePreencherCadastro() throws MalformedURLException {
		
		// preencher nome
		MobileElement nome = driver.findElement(By.xpath("//*[@text='Nome']"));
		nome.clear();
		nome.sendKeys("Fabio R ABade");
		
//		 selecionar combo
		MobileElement cbx = driver.findElement(By.id("android:id/text1"));		
		cbx.click();
		
		//selecionar nitendo
		MobileElement nitendo = driver.findElement(By.xpath("//*[@text='Nintendo Switch']"));
		nitendo.click();
		
		// selecionar check
	   MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	   Assert.assertTrue(check.getAttribute("checked").equals("false"));
	   check.click();
	  
//		MobileElement swite = driver.findElement(MobileBy.AccessibilityId("switch"));
	
	   
	   //selecionar switch
	   MobileElement swite = driver.findElement(By.className("android.widget.Switch"));
	   Assert.assertTrue(swite.getAttribute("checked").equals("true"));
	   swite.click();
	   
	   //clicar em salvar
	   MobileElement save = driver.findElement(By.xpath("//*[@text='SALVAR']"));
	   save.click();
	   
	   //validar dados
	  MobileElement validaNome = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]"));
	  Assert.assertEquals("Nome: Fabio R ABade", validaNome.getText());
	  
	  MobileElement switi = driver .findElement(By.xpath("//*[@text='Switch: Off']"));
	  Assert.assertTrue(switi.getText().endsWith("Off"));
	  

	  MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	  String teste = combo.getText();
	  Assert.assertEquals("Console: switch", combo.getText());
	  
	  MobileElement checke = driver .findElement(By.xpath("//*[@text='Checkbox: Marcado']"));
	  Assert.assertTrue(checke.getText().endsWith("Marcado"));

	}

}
