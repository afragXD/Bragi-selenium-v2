package clicker

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

val firstChapterXPathList = listOf(
    "//*[@id=\"fs-chapters\"]/div/div[3]/a[1]",
    "",
)



fun firstChapter(
    driver: ChromeDriver,
    index: Int,
    ){
    WebDriverWait(driver, Duration.ofSeconds(5)).until(
        ExpectedConditions
            .presenceOfElementLocated(By.xpath(firstChapterXPathList[index]))
    ).click()
}