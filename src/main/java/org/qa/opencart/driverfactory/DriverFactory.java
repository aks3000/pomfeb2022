package org.qa.opencart.driverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	private WebDriver driver;
	public  FileInputStream Ip;
	public Properties prop;
	public static String highlight;
	
	public WebDriver  init_driver(Properties prop) {
		prop=init_prop();
		String browsername=prop.getProperty("browser").trim();
		System.out.println("Browser is launching :"+browsername);
		
		highlight=prop.getProperty("highlight");
		
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			System.err.println("Pass the correct browser chrome or firefox"
					+"but you have passed :"+browsername);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get(prop.getProperty("url").trim());
		return driver;
	}
	
	
	public Properties init_prop() {
		  prop= new Properties();
			
		try {
			Ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(Ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 
		return prop;
		 
		}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
