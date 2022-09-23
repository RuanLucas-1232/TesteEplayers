package com.ruancode.testes;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAutomatizado {
	private ChromeDriver driver;
	@Before
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();//O construtor faz com que o driver (bot) tenha acesso ao navegador e o abra.
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/");
	}
	
	@Test
	public void botTest() throws InterruptedException{
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"usuario\"]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-home/app-header/header/div/nav/a[6]")).click();
		
		String[] listUser = {"Ruan","João","Pedro"};
		String[] listEmail = {"Ruan@email.com","João@email.com", "Pedro@email.com"};
		String[] listPassword= {"123456789","987456321","123987456"};
		String[] blackList = {"SELECT", "FROM", " ", "DATABASE", "OR", "--", "DROP", ";", "1=1", "\"=\"", "AND"};
		try {
				
			
			for(int i=0;i<listUser.length;i++) {
				driver.findElement(By.id("usuario")).clear();
				Thread.sleep(2000);
				driver.findElement(By.id("usuario")).sendKeys(listUser[0]);
				
				for(int i1 = 0; i1 < listEmail.length; i1++) {
					driver.findElement(By.id("email")).clear();
					Thread.sleep(2000);
					driver.findElement(By.id("email")).sendKeys(listEmail[i1]);
					
					for(int i2 = 0; i2 < listPassword.length; i2++) {
						driver.findElement(By.id("senha")).clear();
						Thread.sleep(2000);
						driver.findElement(By.id("senha")).sendKeys(listPassword[i2]);
						Thread.sleep(2000);
						driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/button")).click();
					}
				}
			}
		
			for(int i = 0; i < blackList.length; i++) {
				driver.findElement(By.id("usuario")).clear();
				Thread.sleep(2000);
				driver.findElement(By.id("usuario")).sendKeys(blackList[i]);
			
				driver.findElement(By.id("email")).clear();
				Thread.sleep(2000);
				driver.findElement(By.id("email")).sendKeys(blackList[i]);
			
				driver.findElement(By.id("senha")).clear();
				Thread.sleep(2000);
				driver.findElement(By.id("senha")).sendKeys(blackList[i]);
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/button")).click();
			}
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
}
