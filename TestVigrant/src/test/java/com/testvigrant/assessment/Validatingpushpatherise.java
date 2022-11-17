package com.testvigrant.assessment;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Validatingpushpatherise {
	public static WebDriver driver=null;
	public static WebDriver driver1=null;
	public static ObjectRepository movie=null;
	public static String Releasedateinimdb=null;
	public static String countryinimdb=null;
	public static String Releasedateinwiki=null;
	public static String countryinwiki=null;
	@Test
	public void launch()
	{
		try
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			movie=new ObjectRepository(driver);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=1)
	public void Navigate()
	{
		try
		{
			driver.get("https://www.imdb.com/");
			movie.getSearchfield().sendKeys("Pushpa the rise");
			movie.getsearchbutton().click();
			movie.getselectpushpamovie().click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=2)
	public void Extractinimdb()
	{
		try
		{
			Releasedateinimdb=movie.getextractreleasedate().getText();
			countryinimdb=movie.getextractcountry().getText();
			System.out.println(Releasedateinimdb);
			System.out.println(countryinimdb);
			driver.quit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=3)
	public void launchagain()
	{
		try
		{
			WebDriverManager.chromedriver().setup();
			driver1=new ChromeDriver();
			driver1.manage().window().maximize();
			movie=new ObjectRepository(driver1);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=4)
	public void navagatetowiki()
	{
		try
		{
			driver1.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
			driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Releasedateinwiki=movie.getextractreleasedateinwiki().getText();
			countryinwiki=movie.getextractcountryinwiki().getText();
			System.out.println(Releasedateinwiki);
			System.out.println(countryinwiki);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=5)
	public void validation()
	{
		try
		{
			Assert.assertTrue(countryinwiki.contains(countryinimdb));
			if((Releasedateinimdb.contains("17"))&&(Releasedateinwiki.contains("17")))
			{
				System.out.println("both release dates are matching in imdb and wiki");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
