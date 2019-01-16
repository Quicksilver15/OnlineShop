package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    BaseFunc baseFunc;
    private final By CATEGORY = By.xpath(".//a[@class = 'sf-with-ul']");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public WebElement getCategoryById(int id) {
        return baseFunc.getElements(CATEGORY).get(id);
    }

    public CategoryPage goToCategory(int id) {
        getCategoryById(id).click();
        return new CategoryPage(baseFunc);
    }

}
