package randomlinl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.*;

import java.io.FileWriter;
import java.io.IOException;


public class fourth {
	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		String filePath = ".\\output\\data.txt";
		
		
		System.setProperty("webdriver.chrome.driver", ".\\driver2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("https://medium.com/");
		driver.manage().window().maximize();
		
	
		List<WebElement> linkElements = driver.findElements(By.xpath("//div[@class='n dc']//a"));
		List<WebElement> links = new ArrayList<>();
		for (WebElement element : linkElements) {
		    links.add(element);
		}
		//Choosing random element:
		int listSize = links.size();
        Random random = new Random();
        int randomIndex = random.nextInt(listSize);
        System.out.println(randomIndex);

        WebElement randomelement = links.get(randomIndex);
        randomelement.click();
        
        Thread.sleep(3000);
        String title = driver.getTitle();
        
//        List<WebElement> paragraphElements = driver.findElements(By.cssSelector("p"));
//        List<String> paragraphsText = new ArrayList<>();
//        for (WebElement element : paragraphElements) {
//            String text = element.getText();
//            if (text != null && !text.isEmpty()) {
//                paragraphsText.add(text);
//            }
//        }
        
        
        
        List<WebElement> headingElements = driver.findElements(By.cssSelector("h1"));
        headingElements.addAll(driver.findElements(By.cssSelector("h2")));
        headingElements.addAll(driver.findElements(By.cssSelector("h3")));
        List<String> headingText = new ArrayList<>();
        for (WebElement element : headingElements) {
            String text = element.getText();
            if (text != null && !text.isEmpty()) {
                headingText.add(text);
            }
        }
        
        
        
        
        try (FileWriter writer = new FileWriter(filePath)) {
        	writer.write(title + "\n\n\n");
            for (String text : headingText) {
            	System.out.println(text + "\n");
            	writer.write(text);
            	writer.write("\n\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
        System.out.println("over");
        driver.quit();
        

		//27 66
	}

}
