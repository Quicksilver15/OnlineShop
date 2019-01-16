package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CheckOutPage {

    BaseFunc baseFunc;
    private final By FIRST_ITEM_PRICE = By.xpath(".//span[@id = 'product_price_3_13_0']");
    private final By SECOND_ITEM_PRICE = By.xpath(".//span[contains(@class, 'special-price')]");
    private final By SHIPPING_PRICE = By.xpath(".//td[@id = 'total_shipping']");
    private final By TOTAL_PRICE = By.xpath(".//span[@id = 'total_price']");
    NumberFormat formatter = new DecimalFormat("#0.00");

    public CheckOutPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void AssertPrice() {
        Double firstItemPrice = Double.valueOf(baseFunc.getElement(FIRST_ITEM_PRICE).getText().substring(1));
        Double secondItemPrice = Double.valueOf(baseFunc.getElement(SECOND_ITEM_PRICE).getText().substring(1));
        Double shippingPrice = Double.valueOf(baseFunc.getElement(SHIPPING_PRICE).getText().substring(1));
        Double sumOfItemPrice = firstItemPrice + secondItemPrice + shippingPrice;
        Double totalPrice = Double.valueOf(baseFunc.getElement(TOTAL_PRICE).getText().substring(1));

        Assertions.assertEquals(formatter.format(totalPrice), formatter.format(sumOfItemPrice), "Incorrect price calculation");
    }

}
