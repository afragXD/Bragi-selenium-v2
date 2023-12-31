package info

import org.jsoup.Jsoup
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

val descriptionCssSelectorList = listOf(
    ".r-desription > div:nth-child(1) > div:nth-child(1)",
    "",
)

fun getDescription(
    driver: ChromeDriver,
    index: Int,
): String {
    val element = WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions
            .presenceOfElementLocated(By.cssSelector(descriptionCssSelectorList[index]))
    ).getAttribute("innerHTML")
    val description = Jsoup.parse(element)
    description.select("style").remove()
    return description.body().html()
}