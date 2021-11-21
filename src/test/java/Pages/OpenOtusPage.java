package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenOtusPage extends BasePage {

    public OpenOtusPage(WebDriver driver) {
        super(driver);
    }

    public void openSite() {
        String URL = "http://otus.ru";
        driver.get(URL);
    }

    public void chooseTesting() {
        driver.findElement(By.xpath("//div[@class='nav__items course-categories__nav']//a[last()-1]")).click();
    }

    public void chooseEventCalendar() {
        driver.findElement(By.xpath("//*[contains(text(), 'События')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Календарь мероприятий')]")).click();
    }

}
