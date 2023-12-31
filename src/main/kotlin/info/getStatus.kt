package info

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

val statusXPathList = listOf(
    "//*[@id=\"fs-info\"]/div[2]/ul[1]/li[2]/span/a",
    "",
)

fun getStatus(
    driver: ChromeDriver,
    index: Int,
): String {
    return WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions
            .presenceOfElementLocated(By.xpath(statusXPathList[index]))
    ).text
}