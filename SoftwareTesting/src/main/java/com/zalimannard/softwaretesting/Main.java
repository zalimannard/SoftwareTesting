package com.zalimannard.softwaretesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main
{
    public static void main(String[] args)
    {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://kpfu.ru");
        
        WebElement logInButton = webDriver.findElement(By.xpath("/html/body/header/div[1]/div[1]/div[1]/a"));
        logInButton.click();
        
        WebElement loginTextField = webDriver.findElement(By.xpath("//*[@id=\"eu_enter\"]/input[1]"));
        loginTextField.sendKeys("DmiAKolesnikov");
        
        WebElement passwordTextField = webDriver.findElement(By.xpath("//*[@id=\"eu_enter\"]/input[2]"));
        passwordTextField.sendKeys("226tg34r");
        
        WebElement confirmButton = webDriver.findElement(By.xpath("//*[@id=\"eu_enter\"]/input[3]"));
        confirmButton.click();
        
        WebElement homeButton = webDriver.findElement(By.xpath("//*[@id=\"page\"]/header/a[2]/i"));
        homeButton.click();
        
        WebElement logInButton2 = webDriver.findElement(By.xpath("//*[@id=\"top-panel\"]/div[1]/div[1]/a"));
        logInButton2.click();
        
        WebElement loginTextField2 = webDriver.findElement(By.xpath("//*[@id=\"eu_enter\"]/input[1]"));
        loginTextField2.sendKeys("DmiAKolesnikov");
        
        WebElement passwordTextField2 = webDriver.findElement(By.xpath("//*[@id=\"eu_enter\"]/input[2]"));
        passwordTextField2.sendKeys("226tg34r");
        
        WebElement confirmButton2 = webDriver.findElement(By.xpath("//*[@id=\"eu_enter\"]/input[3]"));
        confirmButton2.click();
        
        WebElement logOut = webDriver.findElement(By.xpath("//*[@id=\"page\"]/header/a[1]"));
        logOut.click();
        
        webDriver.close();
    }
}
