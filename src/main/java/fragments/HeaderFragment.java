package fragments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderFragment {
    SelenideElement basketIcon = $x("//i[@class='icon-new-citrus-cart']");

    public void clickOnMainBasketIcon() {
        basketIcon.click();
    }
}
