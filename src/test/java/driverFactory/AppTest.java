package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.PageClasses.CustomerPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil{
String inputpath ="./FileInput/Customer.xlsx";
String outputpath ="./FileOutPut/DataDrivenResults.xlsx";
String TCSheet ="CustomerData";
ExtentReports reports;
ExtentTest logger;
@Test
public void startTest() throws Throwable
{
	//define path of html
	reports = new ExtentReports("./target/ExtentReports/Customer.html");
	//create object for excelfile util class
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	//count no of rows in sheet
	int rc = xl.rowCount(TCSheet);
	Reporter.log("No of rows are::"+rc,true);
	//iterate all rows
	for(int i=1;i<=rc;i++)
	{
		logger = reports.startTest("Customer");
		logger.assignAuthor("Ranga");
		//read all cells
		String cname = xl.getCellData(TCSheet, i, 0);
		String Address = xl.getCellData(TCSheet, i, 1);
		String city = xl.getCellData(TCSheet, i, 2);
		String country = xl.getCellData(TCSheet, i, 3);
		String cperson = xl.getCellData(TCSheet, i, 4);
		String pnumber = xl.getCellData(TCSheet, i, 5);
		String email = xl.getCellData(TCSheet, i, 6);
		String mnumber = xl.getCellData(TCSheet, i, 7);
		String notes = xl.getCellData(TCSheet, i, 8);
		CustomerPage cus = PageFactory.initElements(driver, CustomerPage.class);
		boolean res =cus.add_Customer(cname, Address, city, country, cperson, pnumber, email, mnumber, notes);
		logger.log(LogStatus.INFO, cname+"---"+ Address+"---"+ city+"---"+ country+"---"+ cperson+"---"+ pnumber+"---"+ email+"---"+ mnumber+"---"+ notes);
		if(res)
		{
			//if res is true write as pass into status cell 
			xl.setCellData(TCSheet, i, 9, "pass", outputpath);
			logger.log(LogStatus.PASS, "Customer Addes Suucess");
		}
		else
		{
			//if res is false write as fail into status cell 
			xl.setCellData(TCSheet, i, 9, "Fail", outputpath);
			logger.log(LogStatus.FAIL, "Customer Addes Fail");
		}
		reports.endTest(logger);
		reports.flush();
	}
}
}













