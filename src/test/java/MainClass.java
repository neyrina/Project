import Pages.EventsPage;
import Pages.OpenOtusPage;
import Pages.TestingPage;
import org.junit.Test;

import java.text.ParseException;

public class MainClass extends BaseTest {

    @Test
    public void test1CardsCounting() throws RuntimeException {
        //1. Открыть otus.ru
        OpenOtusPage openOtusPage = new OpenOtusPage(driver);
        openOtusPage.openSite();
        logger.info("Открыт сайт Отус");
        openOtusPage.chooseTesting();
        logger.info("Открыт раздел Тестирование");
        //2. На странице отображаются карточки курсов. Количество карточек равно 11
        TestingPage testingPage = new TestingPage(driver);
        testingPage.countCards();
        logger.info("Проверка на 11 элементов прошла");
    }

    @Test
    public void test2CardsChecking() throws RuntimeException {
        //1. Открыть otus.ru
        OpenOtusPage openOtusPage = new OpenOtusPage(driver);
        openOtusPage.openSite();
        logger.info("Открыт сайт Отус");
        openOtusPage.chooseTesting();
        logger.info("Открыт раздел Тестирование");
        TestingPage testingPage = new TestingPage(driver);
        //3. Перейти на карточку курса и проверить информацию о нем
        testingPage.chooseCourseCard();
        logger.info("Карточки курсов проверены");
    }

    @Test
    public void test3DatesChecking() throws RuntimeException, ParseException {
        //1. Открыть otus.ru
        OpenOtusPage openOtusPage = new OpenOtusPage(driver);
        openOtusPage.openSite();
        logger.info("Открыт сайт Отус");
        //4. Валидация дат предстоящих мероприятий
        openOtusPage.chooseEventCalendar();
        logger.info("Перешли в Календарь мероприятий");
        EventsPage eventsPage = new EventsPage(driver);
        eventsPage.checkEventsPresenceAndDate();
        logger.info("Даты проведения мероприятий больше или равны текущей дате");
    }

    @Test
    public void test4DodChecking() throws RuntimeException {
        //1. Открыть otus.ru
        OpenOtusPage openOtusPage = new OpenOtusPage(driver);
        openOtusPage.openSite();
        logger.info("Открыт сайт Отус");
        openOtusPage.chooseEventCalendar();
        logger.info("Перешли в Календарь мероприятий");
        EventsPage eventsPage = new EventsPage(driver);
        //5. Просмотр мероприятий по типу ДОД
        eventsPage.sortingDod();
        logger.info("Отсортировали по ДОД");
        eventsPage.checkDod();
        logger.info("Карточки ДОД проверены");
    }


}
