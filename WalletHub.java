import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class WalletHub {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://wallethub.com/join/login");
	getSleep(3000);
        WebElement elem = driver.findElement(By.name("em"));
        elem.sendKeys("mhossain39@gmail.com");
	elem = driver.findElement(By.name("pw"));
        elem.sendKeys("Linked21@");
	elem.sendKeys(Keys.RETURN);
	getSleep(3000);
        driver.get("https://wallethub.com/profile/test_insurance_company");
	getSleep(3000);
	elem = driver.findElement(By.id("reviews-section"));
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView();", elem);

	WebElement elem1 = driver.findElement(By.cssSelector("#reviews-section > div.review-stat-box > div.review-action.ng-enter-element > review-star > div > svg:nth-child(1)"));
	WebElement elem2 = driver.findElement(By.cssSelector("#reviews-section > div.review-stat-box > div.review-action.ng-enter-element > review-star > div > svg:nth-child(2)"));
	WebElement elem3 = driver.findElement(By.cssSelector("#reviews-section > div.review-stat-box > div.review-action.ng-enter-element > review-star > div > svg:nth-child(3)"));
	WebElement elem4 = driver.findElement(By.cssSelector("#reviews-section > div.review-stat-box > div.review-action.ng-enter-element > review-star > div > svg:nth-child(4)"));
	WebElement elem5 = driver.findElement(By.cssSelector("#reviews-section > div.review-stat-box > div.review-action.ng-enter-element > review-star > div > svg:nth-child(5)"));
	new Actions(driver).moveToElement(elem1).moveToElement(elem2).moveToElement(elem3).moveToElement(elem4).moveToElement(elem5).click(elem5).build().perform();
	getSleep(3000);
	elem = driver.findElement(By.cssSelector("#reviews-section > modal-dialog > div > div > write-review > div > ng-dropdown > div"));
	elem.click();
	elem = driver.findElement(By.cssSelector("#reviews-section > modal-dialog > div > div > write-review > div > ng-dropdown > div > ul > li:nth-child(2)"));
	elem.click();
	elem = driver.findElement(By.cssSelector("#reviews-section > modal-dialog > div > div > write-review > div > div.android > textarea"));
	String reviewMessage = getAlphaNumericString(50);
        //System.out.println(reviewMessage);  
	elem.sendKeys(reviewMessage+reviewMessage+reviewMessage+reviewMessage+reviewMessage);
        //jse.executeScript("arguments[0].value='"+reviewMessage+"';", elem);
        getSleep(3000);
	elem = driver.findElement(By.cssSelector("#reviews-section > modal-dialog > div > div > write-review > sub-navigation > div > div.sbn-action.semi-bold-font.btn.fixed-w-c.tall"));
	elem.click();
	getSleep(3000);
        driver.get("https://wallethub.com/profile/mhossain39");
	getSleep(3000);
	boolean isTheTextPresent = driver.getPageSource().contains(reviewMessage);
	assertTrue(isTheTextPresent);

        driver.quit();
 
    }
     static void getSleep(int n) 
    {
	try 
	{
	    Thread.sleep(n);
	} 
	catch(InterruptedException e)
	{
	     System.out.println("Thread sleep failed");  
	} 
    }
	
   // function to generate a random string of length n 
    static String getAlphaNumericString(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 

            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
	 
        } 
  
        return sb.toString(); 
    } 
}

