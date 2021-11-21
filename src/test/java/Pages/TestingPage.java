package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestingPage extends BasePage {

    public TestingPage(WebDriver driver) {

        super(driver);
    }

    public void countCards() {
        int courseAmount = driver.findElements(By.xpath("//div[@class='lessons__new-item-container']")).size();
        Assert.assertEquals("На странице не 11 курсов", 11, courseAmount);

    }

    public void chooseCourseCard() {
        List<WebElement> courses = driver.findElements(By.xpath("//div[@class=\"lessons\"]//a[@class=\"js-stats lessons__new-item lessons__new-item_hovered\"]"));
        WebDriverWait wait = new WebDriverWait(driver, 5);

        for (int i = 1; i <=courses.size(); i++) {
            courses = driver.findElements(By.xpath("//div[@class=\"lessons\"]//a[@class=\"js-stats lessons__new-item lessons__new-item_hovered\"]"));
            wait.until(ExpectedConditions.visibilityOf(courses.get(i-1)));
            String courseUrl = courses.get(i-1).getAttribute("href");
            driver.get(courseUrl);
            switch (courseUrl) {
                case "https://otus.ru/lessons/qa-auto-java-specialization/?int_source=courses_catalog&int_term=testing":
                case "https://otus.ru/online/manualtesting/":
                    driver.navigate().back();//Эти две страницы имеют вообще другой формат. Просто пропускаю
                    break;
                case "https://otus.ru/lessons/java-qa-pro/?int_source=courses_catalog&int_term=testing"://Т.к локаторы на страницах отличаются, пришлось наплодить кэйсов
                case "https://otus.ru/lessons/avtomatizaciya-web-testirovaniya/?int_source=courses_catalog&int_term=testing":
                    Assert.assertFalse("Не указан заголовок курса", driver.findElement(By.xpath("//div[@class='course-header2__title']")).getText().isEmpty());
                    Assert.assertFalse("Не указано описание курса", driver.findElement(By.xpath("//div[@class='course-header2__admin-text']")).getText().isEmpty());
                    commonCheck();
                    break;
                case "https://otus.ru/lessons/java-qa-basic/?int_source=courses_catalog&int_term=testing":
                case "https://otus.ru/lessons/qajs/?int_source=courses_catalog&int_term=testing":
                    Assert.assertFalse("Не указан заголовок курса", driver.findElement(By.xpath("//div[@class='course-header2__title']")).getText().isEmpty());
                    Assert.assertFalse("Не указано описание курса", driver.findElement(By.xpath("//h1[@class='course-header2__subtitle']")).getText().isEmpty());
                    commonCheck();
                    break;
                case "https://otus.ru/lessons/kotlin-qa-engineer/?int_source=courses_catalog&int_term=testing"://в этой карточке отсутствует характеристика Формат
                    Assert.assertFalse("Не указан заголовок курса", driver.findElement(By.xpath("//div[@class='course-header2__title']")).getText().isEmpty());
                    Assert.assertFalse("Не указано описание курса", driver.findElement(By.xpath("//div[@class='course-header2__admin-text']")).getText().isEmpty());
                    Assert.assertFalse("Не указана длительность курса", driver.findElement(By.xpath("//p[@class='course-header2-bottom__item-text']")).getText().isEmpty());
                    driver.navigate().back();
                    break;
                default:
                    Assert.assertFalse("Не указан заголовок курса", driver.findElement(By.xpath("//h1[@class='course-header2__title']")).getText().isEmpty());
                    Assert.assertFalse("Не указано описание курса", driver.findElement(By.xpath("//div[@class='course-header2__admin-text']")).getText().isEmpty());
                    commonCheck();
                    break;
            }
        }
    }

    private void commonCheck() {
        Assert.assertFalse("Не указана длительность курса", driver.findElement(By.xpath("//p[@class='course-header2-bottom__item-text']")).getText().isEmpty());
        Assert.assertFalse("Не указан формат курса", driver.findElement(By.xpath("//div[@class='course-header2-bottom__content-item container__col container__col_2 container__col_md-2 container__col_ssm-12']//p[@class='course-header2-bottom__item-text']")).getText().isEmpty());
        driver.navigate().back();
    }


}
