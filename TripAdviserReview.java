package com.dollibar.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TripAdviserReview {

	public static void main(String[] args) throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  driver.manage().window().fullscreen();
	  driver.get("https://www.tripadvisor.in/");
	  WebElement a = driver.findElement(By.xpath("//span[@class='ui_icon search brand-global-nav-action-search-Search__icon--2DVjd']"));
      a.click();
      a.sendKeys("Club Mahindra");
      a.sendKeys(Keys.ENTER);
      Thread.sleep(1000);
      WebElement link = driver.findElement(By.xpath("//body[@id='BODY_BLOCK_JQUERY_REFLOW']"));
      link.click();
      Thread.sleep(1000);
      driver.get("https://www.tripadvisor.in/Hotel_Review-g641714-d1156207-Reviews-Club_Mahindra_Madikeri_Coorg-Madikeri_Kodagu_Coorg_Karnataka.html");
    
      driver.findElement(By.xpath("div[@class='sbx_close']")).click();

      js.executeScript("window.scrollBy(0,2500)");
      driver.findElement(By.xpath("//a[.='Write a review']")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath(" //span[@class='ui_bubble_rating fl bubble_50']")).click();
    List<WebElement> allele = driver.findElements(By.xpath("//span[@class='ui_bubble_rating fl bubble_50']"));
      driver.findElement(By.xpath("//input[@id='ReviewTitle']")).sendKeys("good place");
      driver.findElement(By.xpath("//textarea[@id='ReviewText']")).sendKeys("Club Mahindra at Madikeri ,Kodagu(Coorg) is one of the best properties I have visited-Friendly and Efficient Staff, Anousha and the team were outstanding . This was the first time we drove from Bangalore via Nelamangala,Holenarsipur and Kushalnagar to Madikeri, a pleasant drive with roads varying from excellent to 'just okay'.The traffic congestion is far,far less than the Bangalore -Mysore Road.If it is a break one is looking for ,the ideal choice in Club Mahindra ,Madikeri -a total destress");
      driver.findElement(By.xpath("//div[.='Family']")).click();
      WebElement sc = driver.findElement(By.xpath("//select[@id='trip_date_month_year']"));
      Select sel=new Select(sc);
      sel.selectByVisibleText("January 2020");
      driver.findElement(By.id("noFraud")).click();
      driver.findElement(By.xpath("//div[@id='SUBMIT']")).click();
      driver.close();

	}

}
