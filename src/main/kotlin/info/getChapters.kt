package info

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

val chaptersXPathList = listOf(
    "//*[@id=\"fs-info\"]/div[2]/ul[1]/li[4]/span/span",
    "",
)

fun getChapters(
    driver: ChromeDriver,
    index: Int,
): Short {
    return WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions
            .presenceOfElementLocated(By.xpath(chaptersXPathList[index]))
    ).text.toShort()
}