package com.bikes.testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.bikes.baseClass.TestBase;
import com.bikes.pages.HondaDetailsPages;
import com.bikes.pages.LaunchPage;
import com.bikes.pages.SelectManufacturerPage;

public class BikeDetailsTest extends TestBase {

    LaunchPage launchPage = new LaunchPage();
    SelectManufacturerPage selectManufacturer = new SelectManufacturerPage();
    HondaDetailsPages hondaDetails=new HondaDetailsPages();
    
    /***********************************************************************************
     * This method is used for invoking driver
     ***********************************************************************************/
    
    @Test(priority=0, groups = "Smoke Test")
    public void invokedriver() {
		logger = report.createTest("ZigWheels Upcoming Bikes in India - Extracting Honda models");
          setupDriver();
          waitFor(3);
    }
    
    /*************************************************************************************
     * This method is used to call the 'clickUpComingBikes' method
     *************************************************************************************/
    @Test(priority=1, groups = "Smoke Test")
    public void clickUpComingBikes() {
    	
    	logger = report.createTest("ZigWheels Upcoming Bikes in India - Extracting Honda models");
        launchPage.clickUpcomingBikes();
        waitFor(3);
        
    }

    /*************************************************************************************
     * This method is used to call the 'selectHonda' method
     *************************************************************************************/
    
    @Test(dependsOnMethods = "clickUpComingBikes", groups = "Smoke Test")
    public void selectHondaBikes() {
        selectManufacturer.selectHonda();
        
    }
    
    /*************************************************************************************
     * This method is used to call the 'clickViewMore' method
     *************************************************************************************/
    
    @Test(dependsOnMethods = "selectHondaBikes", groups = "Smoke Test")

 public void clickViewMore() {
	
	 hondaDetails.clickViewMore(579,1325);
	   
 }

   /*************************************************************************************
    * This method is used to call the 'displayUpComingBikesInIndia' method
    *************************************************************************************/
    
    @Test(dependsOnMethods = "clickViewMore", groups = "Smoke Test")
    public void displayUpcomingBikes() {
    	   
        hondaDetails.displayUpcomingBikesInIndia();
    }
    
    
    
    @Test(dependsOnMethods = "displayUpcomingBikes", groups = "Regression Test")
    public void verifyHondaPage()
    {
    	hondaDetails.verifyPage();
    	
       }
    
    
    /*************************************************************************************
     * This method is used to close the 'Browser'
     *************************************************************************************/
    
    @AfterClass(groups = "Smoke Test")
    public void quitBrowser() {
    	report.flush();
        driver.quit();
    }
}