package com.laboratorio.cuatro.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.laboratorio.cuatro.Base;

public class PHPTravels_FlightsPage extends Base {
	
	
	By btnFlights = By.cssSelector("a[href='https://phptravels.net/flights']");
	By btnRoundTrip = By.xpath("//*[@id=\"flights-search\"]/div[1]/div[1]/div/div/div/div[2]");
	By btnOneWay = By.xpath("/html/body/main/section/section/div/div/div/form/div[1]/div[1]/div/div/div/div[1]/label");
	
	By btnSearch = By.xpath("/html/body/main/section/section/div/div/div/form/div[2]/div[5]/button");	
	By returnDateInput = By.id("return_date");
	
	By inputFlyingFromAndDestinationTo = By.xpath("/html/body/span/span/span[1]/input");
	By comboBoxFlyingFrom = By.xpath("/html/body/main/section/section/div/div/div/form/div[2]/div[1]/div[1]/div[2]/span/span[1]/span");
	By comboBoxDestinationTo = By.xpath("/html/body/main/section/section/div/div/div/form/div[2]/div[2]/div[2]/div[2]/span/span[1]/span");
	
	By btnSwap = By.xpath("/html/body/main/section/section/div/div/div/form/div[2]/div[2]/div[1]/div");
	
	By searchContainer = By.xpath("/html/body/main/div[2]/div");
	
	public PHPTravels_FlightsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void selectRoundTripFlight() {
		click(btnFlights);
		click(btnRoundTrip);
		
				
	}
	
	public void selectOneWayAfterSelectRoundTripFlight() {
		click(btnFlights);
		click(btnRoundTrip);
		click(btnOneWay);
	}
	
	public boolean isReturnDateDisplayed() {
		return isDisplayed(returnDateInput);
	}
	
	public void selectSearchWithoutSelectAnythingElse() {
		click(btnFlights);
		click(btnSearch);
	}
	
	public void selectSearchWithFlyingFromAndDestinationToBeingEqual(String city) throws InterruptedException  {
		click(btnFlights);
		
		click(comboBoxFlyingFrom);
		type(city, inputFlyingFromAndDestinationTo);
		Thread.sleep(2000);
		type("\n", inputFlyingFromAndDestinationTo);
		
		click(comboBoxDestinationTo);
		type(city, inputFlyingFromAndDestinationTo);
		Thread.sleep(2000);
		type("\n", inputFlyingFromAndDestinationTo);
		
		click(btnSearch);
	}
	
	public void selectSearchWithFlyingFromButNoDestinationTo(String city) throws InterruptedException {
		click(btnFlights);
		
		click(comboBoxFlyingFrom);
		type(city, inputFlyingFromAndDestinationTo);
		Thread.sleep(2000);
		type("\n", inputFlyingFromAndDestinationTo);
		
		click(btnSearch);
	}
	
	public void selectSearchWithDestinationToButNoFlyingFrom(String city) throws InterruptedException {
		click(btnFlights);
		
		click(comboBoxDestinationTo);
		type(city, inputFlyingFromAndDestinationTo);
		Thread.sleep(2000);
		type("\n", inputFlyingFromAndDestinationTo);
		
		click(btnSearch);
	}
	
	public void swapFlyingFromAndDestinationTo(String city1, String city2) throws InterruptedException {
		click(btnFlights);
		
		click(comboBoxFlyingFrom);
		type(city1, inputFlyingFromAndDestinationTo);
		Thread.sleep(2000);
		type("\n", inputFlyingFromAndDestinationTo);
		
		click(comboBoxDestinationTo);
		type(city2, inputFlyingFromAndDestinationTo);
		Thread.sleep(2000);
		type("\n", inputFlyingFromAndDestinationTo);
		
		click(btnSwap);
	}
	
	public String isComboBoxFlyingFrom() {
		WebElement spanFlyingFrom = driver.findElement(By.xpath("/html/body/main/section/section/div/div/div/form/div[2]/div[1]/div[1]/div[2]/span/span[1]/span"));
		return getText(spanFlyingFrom);
	}
	
	public void selectSearchWithFlyingFromAndDestinationTo(String city1, String city2) throws InterruptedException {
		click(btnFlights);
		
		click(comboBoxFlyingFrom);
		type(city1, inputFlyingFromAndDestinationTo);
		Thread.sleep(2000);
		type("\n", inputFlyingFromAndDestinationTo);
		
		click(comboBoxDestinationTo);
		type(city2, inputFlyingFromAndDestinationTo);
		Thread.sleep(2000);
		type("\n", inputFlyingFromAndDestinationTo);
		
		click(btnSearch);
	}
	
	public boolean isSearchContainerDisplayed() {
		return isDisplayed(searchContainer);
	}

}