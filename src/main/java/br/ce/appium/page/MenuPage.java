package br.ce.appium.page;

import br.ce.appium.core.BasePage;

public class MenuPage extends BasePage{

	
	
	public void acessarFormulario() {
		//selecionar menu formulario
		clicarPorTexto("Formul�rio");
	}
	
	public void acessarSplash() {
		clicarPorTexto("Splash");
	}
	
	public void acessarAlertas() {
		clicarPorTexto("Alertas");
	}
}
