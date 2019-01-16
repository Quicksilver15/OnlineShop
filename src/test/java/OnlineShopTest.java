import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.*;

public class OnlineShopTest {

    public BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "automationpractice.com";
    private final By ORANGE = By.xpath(".//a[@style = 'background:#F39C11;']");
    private final By ADDED = By.xpath(".//button[contains(@class, 'added')]");

    @Test
    public void shopWorkCheck() {

        baseFunc.goToPage(HOME_PAGE);
        HomePage homePage = new HomePage(baseFunc);

        CategoryPage categoryPage = homePage.goToCategory(0);

        SubCategoryPage subCategoryPage = categoryPage.goToSubCategory(1);

        Catalogue catalogue = subCategoryPage.ChooseColor(3);
        catalogue.checkColor(ORANGE);

        ItemPage itemPage = catalogue.goToItem(0);
        itemPage.checkColorSelected(ORANGE);
        itemPage.addToCart();

        baseFunc.goBack(ADDED);

        catalogue.goToItem(1).addToCart();

        itemPage.goToCheckout();

        CheckOutPage checkOutPage = new CheckOutPage(baseFunc);

        checkOutPage.AssertPrice();

        baseFunc.CloseBrowser();
    }

}
