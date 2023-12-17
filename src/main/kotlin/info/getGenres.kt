package info

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

fun getGenres(
    driver: ChromeDriver
): Set<String> {
    return WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions
            .presenceOfElementLocated(By.xpath("//*[@id=\"mc-fs-genre\"]/div"))
    ).text.split(", ").map { it.trim() }.toSet()
}