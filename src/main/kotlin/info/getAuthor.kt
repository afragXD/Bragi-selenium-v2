package info

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

val authorXPathList = listOf(
    "//*[@id=\"fs-info\"]/div[2]/ul[1]/li[7]/span/a",
    "",
)

fun getAuthor(
    driver: ChromeDriver,
    index: Int,
): String {
    return WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions
            .presenceOfElementLocated(By.xpath(authorXPathList[index]))
    ).text
}