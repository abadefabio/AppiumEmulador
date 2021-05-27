package br.ce.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			createDriver();
		}
		return driver;
	}

	private static void createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android"); 
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		//desiredCapabilities.setCapability("appPackage", "com.ctappium");
		//desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");

		desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\abade\\eclipse-workspace\\AppiumEmulador\\src\\main\\resources\\CTAppium_1_2.apk");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// clicar no menu formulario
		//driver.findElement(By.xpath("//android.widget.TextView[@text= 'Formulário']")).click();
		//driver.findElement(By.xpath("//*[@text= 'Formulário']")).click();		
	
	}
	
	public static void killDriver() {		
		if(driver!=null) {
			driver.quit();
			driver = null;
		}
	}
}
