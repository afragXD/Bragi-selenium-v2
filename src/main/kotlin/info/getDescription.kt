package info

import org.jsoup.Jsoup
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

fun getDescription(
    driver: ChromeDriver
): String {
    val element = WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions
            .presenceOfElementLocated(By.cssSelector(".r-desription > div:nth-child(1) > div:nth-child(1)"))
    ).getAttribute("innerHTML")
    val description = Jsoup.parse(element)
    description.select("style").remove()
    return description.body().html()
}