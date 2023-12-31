package info

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

val countryXPathList = listOf(
    "//*[@id=\"fs-info\"]/div[2]/ul[1]/li[6]/span/a",
    "",
)

fun getCountry(
    driver: ChromeDriver,
    index: Int,
): String {
    val country = WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions
            .presenceOfElementLocated(By.xpath(countryXPathList[index]))
    ).getAttribute("src")
    if (index==0) {
        return when (country) {
            "Китайский" -> "Китай"
            "Корейский" -> "Корея"
            "Японский" -> "Япония"
            "Английский" -> "Англия"
            "Русский" -> "Россия"
            else -> "Китай"
        }
    }
    return country
}