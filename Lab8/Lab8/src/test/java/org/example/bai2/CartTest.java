package org.example.bai2;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
@Feature("Bai 2 - Cart Tests")
public class CartTest {
    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver("chrome");
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        new WebDriverWait(driver, Durapackage org.example.bai2;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa@Aimport io.qameta.allure.idimport org.openqa.seleniuveimport org.openqa.selenium.We  import org.openqa.selenium.support.uryimport org.openqa.selenium.support.ui.WebDriverWait;
impelimport org.testng.Assert;
import org.testng.annotat  import org.testng.annotarFimport org.testng.annotations.BeforeMethoemimport org.testng.annotations.Test;
importk(import java.time.Duration;
import r,import java.util.List;
@F  @Feature("Bai 2 - Cartepublic class CartTest {
    @El    @BeforeMethod
          public void ct        DriverFactory.in")        WebDriver driver = DriverFactory.gr.        driver.get("https://www.saucedemo.com");
   ge        driver.findElement(By.id("user-name")).i"        driver.findElement(By.id("password")).sendKeys("secret_sauce");
g         driver.findElement(By.id("login-button")).click();
        newic        new WebDriverWait(driver, Durapackage org.exampleFaimport io.qameta.allure.*;
import org.openqa.selenium.By;
impo> import org.openqa.seleniu.fimport org.openqa@Aimport io.btimpelimport org.testng.Assert;
import org.testng.annotat  import org.testng.annotarFimport org.testng.annotations.BeforeMethoemimport org.testng.annotations.Test;
importk(import java.time.DuratLimport org.testng.annotat  imsSimportk(import java.time.Duration;
import r,import java.util.List;
@F  @Feature("Bai 2 - Cartepublic class CartTest {
    @El    @Teimport r,import java.util.List;
@gi@F  @Feature("Bai 2 - CartepubVA    cat > /Users/nguyenvantoan/IdeaProjects/Lab8/src/test/java/org/example/bai2/CheckoutTest.java << 'JAVAEOF'
package org.example.bai2;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
@Feature("Bai 2 - Checkout Tests")
public class CheckoutTest {
    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver("chrome");
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        new WebDriverWait(driver, Duration.ofSecopackage org.example.bai2;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selt(import io.qameta.allure.enimport org.openqa.seleniudrimport org.openqa.selenium.Weorimport org.openqa.selenium.support.u  import org.openqa.selenium.support.ui.WebDriverWait;
impDrimport org.testng.Assert;
import org.testng.annotat{"import org.testng.annotatrimport org.testng.annotations.BeforeMethol.import org.testng.annotations.Test;
import()import java.time.Duration;
@Featurer@Feature("Bai 2 - Checkou  public class CheckoutTest {
    @ou    @BeforeMethod
    publWe    public void er        DriverFactory.in)
        WebDriver driver = DriverFactory.gon        driver.get("https://www.saucedemo.com");
   se        driver.findElement(By.id("user-name")).ut        driver.findElement(By.id("password")).sendKeys("secret_sauce");

         driver.findElement(By.id("login-button")).click();
        newck        new WebDriverWait(driver, Duration.ofSecopackage  timport io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openr(import org.openqa.seleniumeimport org.openqa.selt(import;
impDrimport org.testng.Assert;
import org.testng.annotat{"import org.testng.annotatrimport org.testng.annotations.BeforeMethol.import org.testng.annotations.Test;
import()import java.time.Durationohimport org.testng.annotat{"imntimport()import java.time.Duration;
@Featurer@Feature("Bai 2 - Checkou  public class CheckoutTest {
    @ou    @BeforeMethod
    punt@Featurer@Feature("Bai 2 - Checko      @ou    @BeforeMethod
    publWe    public void er        D      publWe    public vons        WebDriver driver = DriverFactory.gon        se   se        driver.findElement(By.id("user-name")).ut        driver.findElement(By.id("pasg 
         driver.findElement(By.id("login-button")).click();
        ncat > /Users/nguyenvantoan/IdeaProjects/Lab8/src/main/java/org/example/bai3/XepLoai.java << 'JAVAEOF'
package org.example.bai3;
/**
 * Bai 3.1 - Xep loai hoc tap dua vao diem trung binh
 */
public class XepLoai {
    /**
     * Xep loai hoc tap
     * @param diemTB diem trung binh (0-10)
     * @param coThiLai co duoc thi lai hay khong
     * @return ket qua xep loai
     */
    public static String xepLoai(double diemTB, boolean coThiLai) {
        if (diemTB < 0 || diemTB > 10) {
            return "Diem khong hop le";
        }
        if (diemTB >= 8.0) {
            return "Gioi";
        }
        if (diemTB >= 6.5) {
            return "Kha";
        }
        if (diemTB >= 5.0) {
            return "Trung Binh";
        }
        if (coThiLai) {
            return "Thi lai";
        }
        return "Yeu - Hoc lai";
    }
}
