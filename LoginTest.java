import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class LoginTest {

    /*
    1. Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение dqdq
    3. Ввести в поле password значение dqdq
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
       Epic sadface: Username and password do not match any user in this service
     */

    @Test
    public void checkNegativeLoginWithInvalidUsernameAndPasswordByMessage() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("dqdq");
        driver.findElement(By.id("password")).sendKeys("dqdq");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");

        driver.quit();
    }

    /*
    1. Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение dqdq
    3. Ввести в поле password значение dqdq
    4. Нажать кнопку Login
    5. Проверить, что мы видим круглую красную иконку с белым крестиком
    */

    @Test
    public void checkNegativeLoginWithInvalidUsernameAndPasswordByIcon() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("dqdq");
        driver.findElement(By.id("password")).sendKeys("dqdq");
        driver.findElement(By.id("login-button")).click();

        boolean iconIsVisible = driver.findElement(By.className("fa-times-circle")).isDisplayed();

        Assert.assertTrue(iconIsVisible);

        driver.quit();
    }
}
