package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


public class Catalogue {

    BaseFunc baseFunc;
    private final By PRODUCT_NAME = By.xpath(".//a[@class = 'product-name']");
    private final By ITEMS = By.xpath(".//div[@class = 'product-container']");
    private final By LOADER = By.xpath(".//img[contains(@src, 'img/loader.gif')]");

    public Catalogue(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public WebElement getItemById(int id) {
        return baseFunc.getElements(ITEMS).get(id);
    }

    public ItemPage goToItem(int id) {
        baseFunc.waitForPage(LOADER);
        getItemById(id).findElement(PRODUCT_NAME).click();
        return new ItemPage(baseFunc);
    }

    public void checkColor(By locator) {
        baseFunc.waitForPage(LOADER);
        List<WebElement> Items = baseFunc.getElements(ITEMS);
        for (int i = 0; i < Items.size(); i++) {
            if (Items.get(i).findElements(locator).isEmpty()) {
                System.out.println("Item Nr." + (i + 1) + " does not contain chosen color.");
            }
        }
    }

}