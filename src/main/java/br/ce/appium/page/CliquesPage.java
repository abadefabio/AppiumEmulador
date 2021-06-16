package br.ce.appium.page;

import br.ce.appium.core.BasePage;
import br.ce.appium.core.DriverFactory;
import static br.ce.appium.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import com.google.j2objc.annotations.AutoreleasePool;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CliquesPage extends BasePage {

	
	public void cliqueLongo() {
		//new TouchAction(getDriver()).
		//.longPress(getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))).perform();
		
		//new TouchAction(getDriver()).longPress(((LongPressOptions)LongPressOptions.longPressOptions().withPosition(PointOption.point((int)x,(int)y))).withDuration(Duration.ofMillis((long)duracao))).release().perform();
		//.longPress(getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))).perform();
		
		MobileElement element = getDriver().findElement(By.xpath("//*[@text='Clique Longo']"));
		TouchActions action = new TouchActions(DriverFactory.getDriver());
		action.longPress(element);
		action.perform();


	}
	
	public String obterTexto() {
		return getDriver().findElement(By.xpath("//android.widget.TextView)[3]")).getText();

	}
}
