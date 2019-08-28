import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.Keys;

public class FbTest {

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();   
        driver.get("https://www.facebook.com");
        WebElement elem = driver.findElement(By.name("email"));
        elem.sendKeys(args[0]);
	elem = driver.findElement(By.name("pass"));
        elem.sendKeys(args[1]);
	elem.sendKeys(Keys.RETURN);
	try{
		elem = driver.findElement(By.xpath("//textarea[@name='xhpc_message']"));
		elem.sendKeys("Hello World from java selenium");
		elem = driver.findElement(By.xpath("//button[contains(.,'Post')]"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", elem);
		Thread.sleep(1000);
        }
        catch (Exception e) {
           System.out.println("Invalid Login");  
        }
        driver.quit();
 
    }
 
}

