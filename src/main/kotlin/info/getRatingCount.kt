package info

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

fun getRatingCount(
    driver: ChromeDriver
): Int {
    return WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions
            .presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/article/main/aside/div[1]/div[1]/div[2]/div/div[1]/div/div/div/span[2]/span"))
    ).text.toInt()
}