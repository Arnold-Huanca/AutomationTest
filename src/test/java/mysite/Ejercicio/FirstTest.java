package mysite.Ejercicio;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstTest {

    @Test
    public void EjercicioP(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.collegeview.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("a[alt=\"SuperMatch\"] > img")).click();
		
        WebDriverWait w = new WebDriverWait(driver,15);
        driver.switchTo().frame("supermatch");

        driver.findElement(By.id("critHeader0")).click();
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Ohio')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath("//*[@id=\"locationCriteria\"]/div[1]/div/div[2]/div[47]")).click();
        driver.findElements(By.id("locationCriteriaClearButton"));
        driver.findElement(By.xpath("//*[@id=\"locationCriteria\"]/div[1]/div/div[2]/div[47]")).click();


        driver.findElement(By.id("critHeader1")).click();
        driver.findElement(By.id("critHeader1")).click();
        driver.findElement(By.id("degreeTypeRadio0")).click();
        driver.findElement(By.id("majorSearchText")).sendKeys("Computer Software Engineering");
        WebDriverWait wait2 = new WebDriverWait(driver, 60);
        WebElement ele2 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),  'Computer Software Engineering')]")));
        ele2.click();

        String Univ = driver.findElement(By.cssSelector("#result1100738 > div.column.column3 > div.nameLogoBlock > a")).getText();
        String Porc = driver.findElement(By.xpath("//*[@id=\"result1100738\"]/div[1]/div/div")).getText();

        Assert.assertTrue(Univ.equals("Miami University-Oxford"));
        Assert.assertTrue(Porc.equals("100%"));

        //driver.close();
        // driver.quit();

    }
}
