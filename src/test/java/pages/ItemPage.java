package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemPage {

    BaseFunc baseFunc;
    private final By CHECKOUT = By.xpath(".//a[contains(@title, 'shopping')]");
    private final By ADD_TO_CART = By.xpath(".//button[@name = 'Submit']");
    private final By ORANGE = By.xpath(".//a[@style = 'background:#F39C11;']");
    private final By COLOR_SELECTED = By.xpath(".//li[@class = 'selected']");

    public ItemPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void addToCart() {
        baseFunc.getElement(ADD_TO_CART).click();
    }

    public CheckOutPage goToCheckout() {
        baseFunc.getElement(CHECKOUT).click();
        return new CheckOutPage(baseFunc);
    }

    public void checkColorSelected(By locator) {
        WebElement colorSelected = baseFunc.getElement(COLOR_SELECTED);
        if (colorSelected.findElements(locator).isEmpty()) {
            System.out.println("Chosen color is not selected.");
        }
    }

}
