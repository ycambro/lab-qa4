package com.laboratorio.cuatro.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.laboratorio.cuatro.pages.PHPTravels_FlightsPage;

public class PHPTravels_FlightsPage_Test {
	
	private WebDriver driver;
	PHPTravels_FlightsPage phpTravels_FlightsPage;

	@Before
	public void setUp() throws Exception {
		phpTravels_FlightsPage = new PHPTravels_FlightsPage(driver);
		driver = phpTravels_FlightsPage.chromeDriverConnection();
		driver.manage().window().maximize();
		phpTravels_FlightsPage.visit("https://phptravels.net/");
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test
	public void testReturnDateInputIsVisibileWhenRoundTripIsSelected() throws InterruptedException {
		phpTravels_FlightsPage.selectRoundTripFlight();
		Thread.sleep(2000);
		assertTrue(phpTravels_FlightsPage.isReturnDateDisplayed());
	}
	
	@Test
	public void testReturnDateInputIsInvisibileWhenOneWayIsSelectedAfterRoundTripWasSelected() throws InterruptedException {
		phpTravels_FlightsPage.selectOneWayAfterSelectRoundTripFlight();
		Thread.sleep(2000);
		assertTrue(!phpTravels_FlightsPage.isReturnDateDisplayed());
	}
	
	@Test
    public void testSearchWithoutSelectAnythingElse() throws InterruptedException {
		phpTravels_FlightsPage.selectSearchWithoutSelectAnythingElse();
		Thread.sleep(2000);
		
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals(alertText, "Flying City and Destination City Can`t be same");
        alert.accept();
    }
	
	@Test
	public void testSearchWithFlyingFromAndDestinationToBeingEqual() throws InterruptedException {
		phpTravels_FlightsPage.selectSearchWithFlyingFromAndDestinationToBeingEqual("Lahore");
		Thread.sleep(2000);
		
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals(alertText, "Flying City and Destination City Can`t be same");
        alert.accept();
    }
	
	@Test
	public void testSearchWithFlyingFromButNoDestinationTo() throws InterruptedException {
		phpTravels_FlightsPage.selectSearchWithFlyingFromButNoDestinationTo("Lahore");
		Thread.sleep(2000);
		
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals(alertText, "Add Destination");
        alert.accept();
    }
	
	@Test
	public void testSearchWithDestinationToButNoFlyingFrom() throws InterruptedException {
		phpTravels_FlightsPage.selectSearchWithDestinationToButNoFlyingFrom("Lahore");
		Thread.sleep(2000);
		
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals(alertText, "Add Origin");
        alert.accept();
    }
	
	@Test
	public void testSwapFlyingFromAndDestinationTo() throws InterruptedException {
		phpTravels_FlightsPage.swapFlyingFromAndDestinationTo("LHE", "JED");
		Thread.sleep(2000);
		
        String FlyingFrom = phpTravels_FlightsPage.isComboBoxFlyingFrom();
        assertEquals("Jeddah JED", FlyingFrom);
    }
	
	@Test
	public void testSearchWithFlyingFromAndDestinationTo() throws InterruptedException {
		phpTravels_FlightsPage.selectSearchWithFlyingFromAndDestinationTo("LHE", "JED");
		Thread.sleep(2000);
		
        assertTrue(phpTravels_FlightsPage.isSearchContainerDisplayed());
    }

}