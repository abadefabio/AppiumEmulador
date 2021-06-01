package br.ce.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static br.ce.appium.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import br.ce.appium.core.BasePage;
import br.ce.appium.core.DriverFactory;

public class SplashPage extends BasePage {

	public boolean isTelaSplashVisivel() {
		return existeElementoPorTexto("Splash!");
	}
	
	public void aguardarSplashSumir() {
		getDriver().manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
	}
}
