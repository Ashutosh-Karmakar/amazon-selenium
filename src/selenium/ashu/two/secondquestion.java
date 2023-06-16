package selenium.ashu.two;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Random;
import org.openqa.selenium.support.ui.Select;



public class secondquestion {

	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", ".\\driver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.navigate().to("https://amazon.in");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
//		WebElement element1 = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
//		Actions action = new Actions(driver);
//		action.moveToElement(element1);
////		action.click();
////		action.perform();
		
		String randomItem = randomItem();
		
		
		WebElement searchbox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		searchbox.sendKeys(randomItem);
		searchbox.submit();
		
		WebElement searchElement1 = driver.findElement(By.cssSelector("div[data-component-type='s-search-result'] h2 a"));
		searchElement1.click();
		String firstWindowHandle = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
		    if (!windowHandle.equals(firstWindowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}	

		String title2 = driver.getCurrentUrl();
		System.out.println(title2);
		
		Thread.sleep(4000);
	
//		WebElement addTo_cart = driver.findElement(By.id("gw-sign-in-button"));
//		addTo_cart.click();
		
		WebElement quantityDropdown = driver.findElement(By.xpath("//select[@name='quantity']"));
		System.out.println("now" + quantityDropdown.getText());
//		quantityDropdown.click();
		String randomQty = randomquantity(quantityDropdown.getText());
		Select quantitySelect = new Select(quantityDropdown);
		quantitySelect.selectByValue(randomQty);
		
		WebElement addTo_cart = driver.findElement(By.id("add-to-cart-button"));
		addTo_cart.click();
		Thread.sleep(4000);
		
		driver.switchTo().window(firstWindowHandle);
		driver.navigate().refresh();
		
		WebElement cart = driver.findElement(By.cssSelector("#nav-cart-count"));
		cart.click();
//		
		Thread.sleep(3000);
//		driver.quit();
		
	}
	
	static String randomItem() {
		String[] array = {"Fridge", "AC", "Phone", "Ipad", "cover"};
		Random random = new Random();
        int randomIndex = random.nextInt(array.length);
        String randomElement = array[randomIndex];
        System.out.println(randomElement);
		return randomElement;
		
	}
	
	static String randomquantity(String title) {
		ArrayList<String> qty = new ArrayList<>();
		for(int i=0;i<title.length();i++) {
			if(Character.isDigit(title.charAt(i))) {
				qty.add(String.valueOf(title.charAt(i)));
			}
		}
		Random random = new Random();
        int randomIndex = random.nextInt(qty.size());
        System.out.println(qty.get(randomIndex));
        return qty.get(randomIndex);
		
	}

}
