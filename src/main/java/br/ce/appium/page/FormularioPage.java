package br.ce.appium.page;

import org.junit.Assert;
import org.openqa.selenium.By;

import br.ce.appium.core.DSL;
import io.appium.java_client.MobileBy;

public class FormularioPage {

	private DSL util = new DSL();

	public void escreverNome(String nome) {
		//escrever nome
		util.escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return util.obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		util.selecionarCombo(MobileBy.AccessibilityId("console"), valor);	
	}
	
	public String obterValorCombo() {
		return util.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}

	public void clicarCheckBox() {
		util.clicar(By.className("android.widget.CheckBox"));
	}

	public void clicarSwitch() {
		util.clicar(MobileBy.AccessibilityId("switch"));	
	}
	
	public boolean isCheckBoxMarcado() {
		return util.isCheckMarcado(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwitchMarcado() {
		return util.isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void btnSalvar() {
		util.clicarPorTexto("SALVAR");
	}

	public String obterNomeCadastrado() {
		return util.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]"));
	}
	
	public String obterConsoleCadastrado() {
		return util.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}
	
	public String obterCheckBoxCadastrado() {
		return util.obterTexto(By.xpath("//*[@text='Checkbox: Marcado']"));
	}
	
	public String obterSwitchCadastrado() {
		return util.obterTexto(By.xpath("//*[@text='Switch: Off']"));
	}
	
	
	 

}

