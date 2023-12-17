import clicker.antiBot
import clicker.firstChapter
import clicker.nextChapter
import com.datastax.oss.driver.api.core.CqlSession
import info.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.http.ClientConfig
import java.io.File
import java.net.InetSocketAddress
import java.util.UUID


val url = listOf(
    //"https://ranobes.com/ranobe/5951-a-will-eternal.html",
    "https://ranobes.com/ranobe/151884-the-beginning-after-the-end.html"
)

const val insertBook = """
        INSERT INTO books (
            book_id,
            name,
            en_name,
            image,
            description,
            rating,
            status,
            chapters,
            year,
            author,
            rating_count,
            translator,
            genres
        )
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """

const val insertChar = """
        INSERT INTO chapters (
            chapter_number,
            chapter_name,
            book_id,
            chapter_text
        )
        VALUES (?, ?, ?, ?)
    """

fun main() {
    getData()
}

fun getData(){

    val session = CqlSession.builder()
        .withKeyspace("Bragi")
        .addContactPoint(InetSocketAddress("127.0.0.1", 9042))
        .withLocalDatacenter("datacenter1")
        .build()

    val options = ChromeOptions()
    options.addExtensions(File("./src/main/resources/extensions/AdBlock.crx"))
    options.addArguments("--no-sandbox")
    options.addArguments("disable-dev-shm-usage")
    options.addArguments("--disable-popup-blocking")

    val driver = ChromeDriver(options)

    try {
        antiBot(driver = driver, url = url[0])

        val bookDTO = BookDTO(
            name = getName(driver),
            enName = getEnName(driver),
            image = getImg(driver),
            description = getDescription(driver),
            rating = getRating(driver),
            status = getStatus(driver),
            chapters = getChapters(driver),
            year = getYear(driver),
            author = getAuthor(driver),
            ratingCount = getRatingCount(driver),
            translator = getTranslator(driver),
            genres = getGenres(driver)
        )
        println(bookDTO)

        val uuid = UUID.randomUUID()
        session.execute(
            insertBook,
            uuid,
            bookDTO.name,
            bookDTO.enName,
            bookDTO.image,
            bookDTO.description,
            bookDTO.rating,
            bookDTO.status,
            bookDTO.chapters,
            bookDTO.year,
            bookDTO.author,
            bookDTO.ratingCount,
            bookDTO.translator,
            bookDTO.genres,
        )

        firstChapter(driver)
        for (i in 1..bookDTO.chapters){
            val chapterDTO = ChapterDTO(
                chapterNumber = i,
                chapterName = getChapterName(driver),
                bookId = uuid,
                chapterText = getChapterText(driver)
            )
            session.execute(
                insertChar,
                chapterDTO.chapterNumber,
                chapterDTO.chapterName,
                chapterDTO.bookId,
                chapterDTO.chapterText
            )
            nextChapter(driver)
        }
    }finally {
        session.close()
        driver.quit()
    }
}


//println(getName(driver))
//println(getEnName(driver))
//println(getImg(driver))
//println(getDescription(driver))
//println(getRating(driver))
//println(getStatus(driver))
//println(getChapters(driver))
//println(getYear(driver))
//println(getAuthor(driver))
//println(getRatingCount(driver))
//println(getTranslator(driver))
//println(getGenres(driver))