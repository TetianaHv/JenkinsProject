import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NegativeTests extends BaseUITest {
    String loginUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    String login = "1303";
    String password = "Guru99";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(loginUrl);
    }

    @Test
    public void negativeWrongPasswordTest() {
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys("11111");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void negativeWrongLoginTest() {
        driver.findElement(By.name("uid")).sendKeys("sdkh");
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void negativeNullLoginTest() {
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void negativeNullPasswordTest() {
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void negativeLoginStartsWithSpaceTest() {
        driver.findElement(By.name("uid")).sendKeys(" " + login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }

    @Test
    public void negativePasswordStartsWithSpaceTest() {
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(" " + password);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), loginUrl);
    }
}
