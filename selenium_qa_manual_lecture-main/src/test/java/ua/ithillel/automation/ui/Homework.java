package ua.ithillel.automation.ui;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Homework {

    private WebDriver driver;

    @BeforeClass
    public static void setUpDriver() {
        final String path = String.format("%s/bin/chromedriver", System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver", path);
    }

    @Before
    public void precondition() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test

    public void qaAutoEnd2End() throws InterruptedException {
       driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");


       // Заповнення вікна Registration

        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        driver.findElement(By.id("signupName")).sendKeys("Yuliia");

        driver.findElement(By.id("signupLastName")).sendKeys("Ost");

        driver.findElement(By.id("signupEmail")).sendKeys("yuliia.ostest@gmail.com");

        driver.findElement(By.id("signupPassword")).sendKeys("Qwerty12345@");

        driver.findElement(By.id("signupRepeatPassword")).sendKeys("Qwerty12345@");

        driver.findElement(By.xpath("//button[text()='Register']")).click();
        Thread.sleep(2000);


        // Порівняння з даними в My Profile

        driver.findElement(By.xpath("//a[@routerlink='profile']")).click();
        Thread.sleep(2000);

        WebElement firstAndLastName = driver.findElement(By.xpath("//p[@class='profile_name display-4']"));
        Assert.assertEquals("Дані не співпадають", "Yuliia Ost", firstAndLastName.getText());
        Thread.sleep(2000);



        // Додати авто

        driver.findElement(By.xpath("//a[@routerlink='garage']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Add car']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("addCarMileage")).sendKeys("0");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Add']")).click();
        Thread.sleep(2000);



        // Додати expenses

        driver.findElement(By.xpath("//button[text()='Add fuel expense']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("addExpenseMileage")).clear();
        Thread.sleep(2000);

        driver.findElement(By.id("addExpenseMileage")).sendKeys("5");
        Thread.sleep(2000);

        driver.findElement(By.id("addExpenseLiters")).sendKeys("1");
        Thread.sleep(2000);

        driver.findElement(By.id("addExpenseTotalCost")).sendKeys("100");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Add']")).click();
        Thread.sleep(2000);



        // Видалити акаунт

        driver.findElement(By.xpath("//a[@routerlink='settings']")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("btn-danger-bg")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        Thread.sleep(2000);
    }


    @After
    public void postCondition() {
        driver.quit();
    }
}
