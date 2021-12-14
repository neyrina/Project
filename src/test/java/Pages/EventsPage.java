package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EventsPage extends BasePage {

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public void checkEventsPresenceAndDate() throws ParseException {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        driver.findElement(By.xpath("//a[@href='https://otus.ru/lessons/linux-professional/#event-1793']")).sendKeys(Keys.CONTROL, Keys.END);
        driver.findElement(By.xpath("//a[@href='https://otus.ru/lessons/algorithm/#event-1789']")).sendKeys(Keys.CONTROL, Keys.END);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), '\n" +
                "          Внутреннее устройство каналов Go\n" +
                "        ')]"))));
        List<WebElement> events = driver.findElements(By.xpath("//div[@class='dod_new-events__list js-dod_new_events']//a[@class='dod_new-event']"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM");
        Date today = new Date();
        for (int i = 1; i <= events.size(); i++) {
            String eventUrl = events.get(i - 1).getAttribute("href");
            String eventDate1 = driver.findElement(By.xpath("//div[@class='dod_new-events__list js-dod_new_events']//a[@href='" + eventUrl + "']//span[@class='dod_new-event__date-text']")).getText();
            Date eventDate2 = sdf.parse(eventDate1);
            Assert.assertTrue("Мероприятие прошло " + eventUrl, today.after(eventDate2));
        }
    }

    public void sortingDod() {
        driver.get("https://otus.ru/events/near/open_doors/");
    }

    public void checkDod() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), '\n" +
                "      Demo Day курса «Системный аналитик. Advanced»\n" +
                "    ')]"))));
        List<WebElement> events = driver.findElements(By.xpath("//div[@class='dod_new-events__list js-dod_new_events']//a[@class='dod_new-event']"));
        for (int i = 1; i <= events.size(); i++) {
            String eventUrl = events.get(i - 1).getAttribute("href");
            String text = driver.findElement(By.xpath("//div[@class='dod_new-events__list js-dod_new_events']//a[@href='" + eventUrl + "']//div[@class='dod_new-type__text']")).getText();
            Assert.assertEquals("Не ДОД" + eventUrl, "День открытых дверей", text);
        }
    }
}


