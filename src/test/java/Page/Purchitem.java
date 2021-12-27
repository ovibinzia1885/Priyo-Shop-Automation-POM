package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Purchitem {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//a[contains(text(),'Hijab Combo-UP TO 56% DISCOUNT (bKash Payment 16% ')]")
    WebElement checklogin;
    @FindBy(id = "search-input")
    WebElement searchinput;
    @FindBy(xpath = "//input[@value='Search']")
    WebElement btnsubmitsearch;
    @FindBy(className = "item-box")
    List<WebElement> imgitem;
    @FindBy(xpath = "//h1[normalize-space()='Search - dress']")
    WebElement dresssearch;
    @FindBy(xpath = "product_attribute_58144_803199")
    WebElement childitem;
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
    @FindBy(xpath = "//span[@class='cart-ttl']")
    WebElement checkitem;
    @FindBy(xpath = "//h2[contains(text(),'Offer')]")
    WebElement offer;
    public Purchitem(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean Checkheading(){
        wait=new WebDriverWait(driver,30);
        boolean status=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Hijab Combo-UP TO 56% DISCOUNT (bKash Payment 16% "))).isDisplayed();
        return status;
    }

    public String SearchItem() throws InterruptedException {
        searchinput.sendKeys("Dress");
        Thread.sleep(100);
        btnsubmitsearch.click();
        Thread.sleep(2000);
        return dresssearch.getText();
    }

    public void AddCard() throws InterruptedException {
        imgitem.get(1).click();
        childitem.click();
        Thread.sleep(1000);
        addcard.click();

    }

    public String CheckCard(){
        checkitem.click();
        confiromoderbtn.click();
        return offer.getText();


    }

}
