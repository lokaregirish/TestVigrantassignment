package com.testvigrant.assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectRepository {
	public ObjectRepository(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@id='suggestion-search']")
	private WebElement searchfield;
	public WebElement getSearchfield() {
		return searchfield;
	}
	
	@FindBy(xpath="//button[@id='suggestion-search-button']")
	private WebElement searchbutton;
	public WebElement getsearchbutton() {
		return searchbutton;
	}
	
	@FindBy(xpath="//a[text()='Pushpa: The Rise - Part 1']")
	private WebElement selectpushpamovie;
	public WebElement getselectpushpamovie() {
		return selectpushpamovie;
	}
	
	@FindBy(xpath="//a[text()='December 17, 2021 (United States)']")
	private WebElement extractreleasedate;
	public WebElement getextractreleasedate() {
		return extractreleasedate;
	}
	
	@FindBy(xpath="//a[text()='India']")
	private WebElement extractcountry;
	public WebElement getextractcountry() {
		return extractcountry;
	}
	
	@FindBy(xpath="//table/descendant::tr[12]")
	private WebElement extractreleasedateinwiki;
	public WebElement getextractreleasedateinwiki() {
		return extractreleasedateinwiki;
	}
	
	@FindBy(xpath="//table/descendant::tr[14]")
	private WebElement extractcountryinwiki;
	public WebElement getextractcountryinwiki() {
		return extractcountryinwiki;
	}

	

	
	

}
