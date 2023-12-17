package info

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

fun getImg(
    driver: ChromeDriver
): String {
    return WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions
            .presenceOfElementLocated(By.xpath("//*[@id=\"dle-content\"]/article/main/div[1]/div/div[1]/div[2]/div[1]/a/img"))
    ).getAttribute("src")
}