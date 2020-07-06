package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;

public class MainPage {
    static WebDriver driver;
    public static WebElement element = null;



    public static WebElement correo(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        return element;
    }

    public static WebElement Siguiente(WebDriver driver){
        element = driver.findElement(By.xpath("//span[.='Siguiente']"));
        return element;
    }



}
