package testing;


import PageObjects.MainPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


import java.io.File;

public class testing {
     static WebDriver driver;
     public static void main(String[] args) throws InterruptedException {
          String absolute = new File("drivers\\chromedriver.exe").getAbsolutePath();
          System.setProperty("webdriver.chrome.driver", absolute);
          //WebDriver driver = new FirefoxDriver();
          //abrir explorador y redireccionar a esta pagina
          ChromeOptions options = new ChromeOptions();
          options.addArguments("start-maximized");

          //options.addArguments("disable-infobars");
          options.addArguments("--disable-extensions");
          driver = new ChromeDriver(options);
          driver.get("https://gbhqatest.firebaseapp.com/");
          driver.manage().window().maximize();

          WebElement root1 = driver.findElement(By.tagName("note-app"));
          WebElement shadow_root1 = expand_shadow_element(root1);

          WebElement root2 = shadow_root1.findElement(By.cssSelector("na-login"));
          WebElement shadow_root2 = expand_shadow_element(root2);

          WebElement search_button = shadow_root2.findElement(By.cssSelector("paper-button"));
          search_button.click();
          Thread.sleep(3000);
          MainPage.correo(driver).sendKeys("user");
          MainPage.Siguiente(driver).click();
      //No es posible continuar debido a que no es posible el incio de sesión, mas info debajo
     }


     public static WebElement expand_shadow_element(WebElement element)
     {
          WebElement shadow_root = (WebElement)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
          return shadow_root;
     }
}
/*
* Con el objetivo de proteger las cuentas, google no permite el inicio de sesión desde ciertos navegadores.
*  Google might stop sign-ins from browsers that:

 - Don’t support JavaScript or have Javascript turned off.
 - Have unsecure or unsupported extensions added.
 - Use automation testing frameworks.
 - Are embedded in a different application.
See: https://support.google.com/accounts/answer/7675428?hl=en
* */
