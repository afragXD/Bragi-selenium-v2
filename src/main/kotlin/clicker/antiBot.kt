package clicker

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

fun antiBot(
    driver: ChromeDriver,
    url:String
){
    //By.ByXPath("//*[@id=\"content\"]/div")
    driver.get(url)
    WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions
            .presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div"))
    ).click()
}