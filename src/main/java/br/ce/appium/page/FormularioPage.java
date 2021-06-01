package br.ce.appium.page;

import org.openqa.selenium.By;

import br.ce.appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage{


	public void escreverNome(String nome) {
		//escrever nome
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);	
	}
	
	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}

	public void clicarCheckBox() {
		clicar(By.className("android.widget.CheckBox"));
	}

	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));	
	}
	
	public boolean isCheckBoxMarcado() {
		return isCheckMarcado(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void btnSalvar() {
		clicarPorTexto("SALVAR");
	}

	public void btnSalvarDemorado() {
		clicarPorTexto("SALVAR DEMORADO");
	}
	
	
	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]"));
	}
	
	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}
	
	public String obterCheckBoxCadastrado() {
		return obterTexto(By.xpath("//*[@text='Checkbox: Marcado']"));
	}
	
	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//*[@text='Switch: Off']"));
	}
	
	
	 

}

