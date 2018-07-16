package com.gmail.vjacheslavmailk;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class LoginJiraTest {
    public WebDriver driver;
    public String url="http://jira.hillel.it:8080/login.jsp";
    public String login="webinar5";
    public String password="webinar5";

    @BeforeTest
    public void beforeMethod()
    {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");//Latest Release: ChromeDriver 2.40
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void testLogin()
    {

        WebElement loginField = driver.findElement(By.id("login-form-username"));
        loginField.sendKeys(login);
        WebElement passwordField = driver.findElement(By.id("login-form-password"));
        passwordField.sendKeys(password);
        WebElement logInButton = driver.findElement(By.id("login-form-submit"));
        logInButton.click();
        WebElement userProfileButton = driver.findElement(By.id("header-details-user-fullname"));
        userProfileButton.click();
        WebElement profileButton = driver.findElement(By.id("view_profile"));
        profileButton.click();
        WebElement userName = driver.findElement(By.id("up-user-title-name"));

        Assert.assertEquals(login,userName.getText());

    }
    @AfterTest
    public void afterMethod()
    {
        if (driver != null)
            driver.quit();
    }
}
