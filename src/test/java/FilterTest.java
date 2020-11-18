import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class FilterTest {
    HomePageStep homePageStep;
    ProductListPageStep productListPageStep;

    String mainMenuName = "Смартфоны";
    String menuName2 = "Xiaomi";
    String memoryFilterBlock = "Объем встроенной памяти";
    String memorySizeFilter1 = "32";
    String memorySizeFilter2 = "64";

    @BeforeClass
    public void start() {
        Configuration.baseUrl = "https://www.citrus.ua";
        Configuration.timeout = 10000;
        open("/");
        homePageStep = new HomePageStep();
        productListPageStep = new ProductListPageStep();

    }

    @BeforeMethod
    public void cleanBasket() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
    }

    @Test
    public void memorySizeFilterTest() {
        homePageStep.clickOnLinkInMenu(mainMenuName, menuName2);
        productListPageStep.setFilter(memoryFilterBlock, memorySizeFilter1);
        productListPageStep.setFilter(memoryFilterBlock, memorySizeFilter2);
        productListPageStep.verifyProductNamesByFilter(menuName2);
        productListPageStep.verifyProductNamesByFilter(memorySizeFilter1, memorySizeFilter2);
    }
}
