package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoryPage {

    BaseFunc baseFunc;
    private final By SUB_CATEGORY = By.xpath(".//a[@class = 'subcategory-name']");

    public CategoryPage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }

    public WebElement getSubCategoryById(int id) {
        return baseFunc.getElements(SUB_CATEGORY).get(id);
    }

    public SubCategoryPage goToSubCategory(int id) {
        getSubCategoryById(id).click();
        return new SubCategoryPage(baseFunc);
    }

}
