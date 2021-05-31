package br.ce.appium.page;

import br.ce.appium.core.DSL;

public class MenuPage {

	private DSL util = new DSL();
	
	public void acessarFormulario() {
		//selecionar menu formulario
		util.clicarPorTexto("Formulário");
	}
}
