package com.rusetskiy.boxOffice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UseCasesTests {

    private WebDriver driver;

    @Test
    public void mainPageTest(){
        System.setProperty("webdriver.chrome.driver","/Users/atreides/BoxOffice/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/");

        assertEquals("Театральная касса", driver.getTitle());
        driver.quit();
    }

    @Test
    public void addTheatreTest(){
        System.setProperty("webdriver.chrome.driver","/Users/atreides/BoxOffice/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/");

        driver.findElement(By.id("theatres_link")).click();
        assertEquals("Театры", driver.getTitle());

        driver.findElement(By.id("add_theatre_button")).click();
        assertEquals("Добавление театра", driver.getTitle());

        driver.findElement(By.id("th_name")).sendKeys("Современник");
        driver.findElement(By.id("address")).sendKeys("Чистопрудный бульвар, дом 19А");
        driver.findElement(By.id("producers")).sendKeys("Олег Ефремов");
        driver.findElement(By.id("actors")).sendKeys("Галина Волчек");
        driver.findElement(By.id("th_image_url")).sendKeys("https://bilety-teatr.ru/netcat_files/210/164/teatr_sovremennik.jpg");
        driver.findElement(By.id("seats_map_image_url")).sendKeys("");
        driver.findElement(By.id("description")).sendKeys("");
        driver.findElement(By.id("submitButton")).click();

        assertEquals("Театры", driver.getTitle());

        driver.quit();
    }

    @Test
    public void buyTicketTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/atreides/BoxOffice/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/");

        driver.findElement(By.id("theatres_link")).click();
        assertEquals("Театры", driver.getTitle());

        List<WebElement> theatres = driver.findElements(By.xpath("//ul[@id='theatres_list']/li"));
        int i = 0;
        while(i < theatres.size() && !Objects.equals(theatres.get(i).getText(), "Театр на Таганке")){ i++;}
        theatres.get(i).click();
        assertEquals("Театр на Таганке", driver.getTitle());

        List<WebElement> performances = driver.findElements(By.xpath("//ul[@id='perfs_list']/li"));
        int j = 0;
        while(j < performances.size() && !Objects.equals(performances.get(j).getText(), "Антимиры")){ j++;}
        performances.get(j).click();
        assertEquals("Антимиры", driver.getTitle());

        List<WebElement> events = driver.findElements(By.xpath("//table[@id='timetable']/tbody/tr"));
        int k = 0;
        while(k < events.size() && !Objects.equals(events.get(k).findElement(By.id("date_column")).getText(), "1965-02-02")){
            k++;
        }
        events.get(k).findElement(By.id("buy_button")).click();
        assertEquals("Оформление заказа", driver.getTitle());


        driver.findElement(By.xpath("//select[@id='seats_list']")).sendKeys("Партер, Ряд 1, место 1");
        driver.findElement(By.id("bank_account_number")).sendKeys("40817810099910004312");
        driver.findElement(By.id("submit_button")).click();
        assertEquals("Success!", driver.getTitle());

        driver.findElement(By.id("button_to_main")).click();
        assertEquals("Театральная касса", driver.getTitle());

        driver.quit();
    }
}
