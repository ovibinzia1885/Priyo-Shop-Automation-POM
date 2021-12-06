package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration {
    @FindBy(xpath = "//label[normalize-space()='My Account']")
    WebElement btnlink;
    @FindBy(className = "ico-register")
    WebElement btnregister;
    @FindBy(id = "email-register")
    WebElement emailregister;
    @FindBy(id = "FirstName")
    WebElement firstname;
    @FindBy(id = "Email")
    WebElement email;
    @FindBy(id = "Phone")
    WebElement phone;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmpassword;
    @FindBy(id = "StreetAddress")
    WebElement streataddress;
    @FindBy(id = "CountryId")
    WebElement countryid;
    @FindBy(id = "StateProvinceId")
    WebElement stateprovience;
    @FindBy(id = "City")
    WebElement City;
    @FindBy(id ="accept-privacy-policy")
    WebElement checkbox;
    @FindBy(id = "register-button")
    WebElement submitbtn;

}
