package com.dollibar.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


 class genenicutils {

	public static int removeco(String price) {
		String[] a1=price.split(",");
		String strFullP="";
		for(int i=0; i<a1.length; i++) {
			strFullP +=a1[i];
		}
		return Integer.parseInt(strFullP);
	}
}

public class Amazon_vs_Flipkart {
	
	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone XR 64gb - yellow");
		driver.findElement(By.className("nav-input")).click();
	
		String a=driver.findElement(By.className("a-price-whole")).getText();
		System.out.println("Cost at amazon is "+a);
		

		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.findElement(By.className("LM6RPg")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.className("LM6RPg")).sendKeys("Apple iPhone XR (Yellow, 64 GB)");
		driver.findElement(By.className("LM6RPg")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	
	
			String f=driver.findElement(By.xpath("//div[@class='_1vC4OE _2rQ-NK']")).getText();
			String g = f.substring(1);
			System.out.println("Cost at Flipkart is "+g);
			int ap =genenicutils.removeco(a);
			int fp =genenicutils.removeco(g);

			
			System.out.println("PRICE COMARISON");
			
			if(ap<fp) {
				System.out.println("Amazon has low price"+ a);
			}else {
				System.out.println("Flipkart has low price"+g);
			}
			
		driver.close();
		}
}

