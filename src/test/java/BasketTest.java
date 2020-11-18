import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
//mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/Test.xml
//mvn allure:report

public class BasketTest {
    HomePageStep homePageStep;
    ProductListPageStep productListPageStep;
    ProductPageStep productPageStep;

    String mainMenuName = "Смартфоны";
    String menuName = "Apple";
    String productName = "Apple iPhone 11 128Gb Black";

    @BeforeClass
    public void start() {
        Configuration.baseUrl = "https://www.citrus.ua";
        Configuration.timeout = 10000;
        open("/");
        homePageStep = new HomePageStep();
        productListPageStep = new ProductListPageStep();
        productPageStep = new ProductPageStep();
    }

    @BeforeMethod
    public void cleanBasket() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
    }

    @Test
    public void addProductToBasketViaSearchResults() {
        homePageStep.searchProduct(productName);
        String productPrice = productListPageStep.addProductToBasket(productName);
        productListPageStep.verifyBasketContent(productName, productPrice);
    }

    @Test
    public void addProductToBasketViaMenu() {
        homePageStep.clickOnLinkInMenu(mainMenuName, menuName);
        productListPageStep.clickOnProduct(productName);

        String productPrice = productPageStep.addProductToBasket();
        productPageStep.verifyBasketContent(productName, productPrice);
    }
}
