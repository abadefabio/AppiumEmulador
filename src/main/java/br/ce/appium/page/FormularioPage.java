package br.ce.appium.page;

import org.openqa.selenium.By;

import br.ce.appium.core.BasePage;
import br.ce.appium.core.DriverFactory;
import static br.ce.appium.core.DriverFactory.getDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

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
	
	public void clicarSeekbar(double posicao) {
		int delta =50;
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
		
		int y = seek.getLocation().y + (seek.getSize().height /2);
		System.out.println(y);
		
		int xinicial = seek.getLocation().x + delta;
		int x = (int) (xinicial + ((seek.getSize().width -2*delta) * posicao));
		System.out.println(x);
		
		tap(x,y);
	}
	 

}

