package info

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

val genresXPathList = listOf(
    "//*[@id=\"mc-fs-genre\"]/div",
    "",
)

fun getGenres(
    driver: ChromeDriver,
    index: Int,
): Set<String> {
    return WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions
            .presenceOfElementLocated(By.xpath(genresXPathList[index]))
    ).text.split(", ").map { it.trim() }.toSet()
}