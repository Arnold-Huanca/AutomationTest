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
        driver.switchTo().frame("supermatch");
        driver.findElement(By.id("critHeader0")).click();
        //driver.findElements(By.id("locationCriteriaClearButton"));
        driver.findElement(By.xpath("//span[contains(text(),'Ohio')]")).click();

        driver.findElement(By.id("critHeader1")).click();
        driver.findElement(By.id("degreeTypeRadio0")).click();
        driver.findElement(By.id("majorSearchText")).sendKeys("Computer Software Engineering");
        driver.findElement(By.xpath("//span[contains(text(),  'Computer Software Engineering')]")).click();

        String Univ  = driver.findElement(By.cssSelector("#result1100738 > div.column.column3 > div.nameLogoBlock > a")).getText();
        Assert.assertTrue(Univ.equals("Miami University-Oxford"));

        //driver.close();
        // driver.quit();

    }
}
