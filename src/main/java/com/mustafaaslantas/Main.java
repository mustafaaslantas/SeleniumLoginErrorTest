package com.mustafaaslantas;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        try {
            KitapYurduHomePage homePage = new KitapYurduHomePage(driver);

            driver.get("https://www.kitapyurdu.com");

            homePage.login("email","password" );
            Thread.sleep(5000);

            boolean isErrorDisplayed = homePage.loginError();
            if (isErrorDisplayed) {
                System.out.println("Hata mesajı doğru şekilde görüntülendi.");
            } else {
                System.out.println("Hata mesajı görüntülenemedi.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }


    }
}
