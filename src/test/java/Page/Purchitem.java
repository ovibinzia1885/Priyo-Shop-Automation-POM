package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Purchitem {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "search-input")
    WebElement searchinput;
    @FindBy(xpath = "//input[@value='Search']")
    WebElement btnsubmitsearch;
    @FindBy(className = "item-box")
    List<WebElement> imgitem;
    @FindBy(xpath = "//h1[normalize-space()='Search - dress']")
    WebElement dresssearch;
    @FindBy(xpath = "//img[@title='Kay Kraft Stitched 3 Piece Dress Set for Women SKO-LN-688']")
    WebElement firstimageclick;
    @FindBy(id = "product_attribute_36246_135940")
    WebElement radiobtnclick;
    @FindBy(id = "add-add-to-cart-button-130129")
    WebElement addcard;
    @FindBy(id = "add-to-cart-button-130129")
    WebElement buynowbtn;
    @FindBy(id = "checkout")
    WebElement confiromoderbtn;
    @FindBy(className = "discount-coupon-code")
    WebElement couponbox;
    @FindBy(name = "applydiscountcouponcode")
    WebElement couponbtnapply;
    @FindBy(name = "continueshopping")
    WebElement moreshoppingbtn;
    @FindBy(xpath = "//h1[normalize-space()='Exciting Offers']")
    WebElement offerinsert;
    @FindBy(xpath = "//span[normalize-space()=\"Men's Clothing\"]")
    WebElement mousehover;

}
