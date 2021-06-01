package br.ce.appium.page;

import org.openqa.selenium.By;

import br.ce.appium.core.BasePage;

public class AlertaPage extends BasePage {

	public void clicarAlertaConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
	}
	
	public void clicarBtnConfirmar() {
		clicarPorTexto("CONFIRMAR");
	}
	
	public void clicarBtnSair() {
		clicarPorTexto("SAIR");
	}
}
