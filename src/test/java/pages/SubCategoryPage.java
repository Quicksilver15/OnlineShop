package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SubCategoryPage {

    BaseFunc baseFunc;
    private final By COLORS = By.xpath(".//input[contains(@class, 'color-option')]");

    public SubCategoryPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public WebElement getColorById(int id) {
        return baseFunc.getElements(COLORS).get(id);
    }

    public Catalogue ChooseColor(int id) {
        getColorById(id).click();
        return new Catalogue(baseFunc);
    }

}
