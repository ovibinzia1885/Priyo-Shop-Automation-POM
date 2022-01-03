package Page;

import Utils.Utils;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import java.io.FileWriter;
import java.io.IOException;

public class Registration {
    WebDriver driver;
    @FindBy(xpath = "//label[normalize-space()='My Account']")
    WebElement btnlink;
    @FindBy(className = "ico-register")
    WebElement btnregister;
    @FindBy(id = "email-register")
    WebElement emailregister;
    @FindBy(id = "FirstName")
    WebElement firstname;
    @FindBy(id = "Email")
    WebElement btnemail;
    @FindBy(id = "Phone")
    WebElement phone;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmpassword;
    @FindBy(id = "StreetAddress")
    WebElement streataddress;
    @FindBy(id = "CountryId")
    WebElement dropdowncountryid;
    @FindBy(id = "StateProvinceId")
    WebElement dropdownstateprovience;
    @FindBy(id = "City")
    WebElement dropdownCity;
    @FindBy(id = "accept-privacy-policy")
    WebElement checkboxbtn;
    @FindBy(id = "register-button")
    WebElement submitbtn;

    public Registration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    Utils utils;

    public void MemberRegistration() throws IOException {
        btnlink.click();
        btnregister.click();
        emailregister.click();
        firstname.sendKeys("ovi");
        utils = new Utils(driver);
        String email = utils.generateRandomEmail(100000, 999999);
        Reporter.log(email);
        btnemail.sendKeys(email);
        JSONObject obj = new JSONObject();
        obj.put("email", email);
        obj.put("password", "123456");
        FileWriter file = new FileWriter("./src/test/resources/user.json");
        file.write(obj.toJSONString());
        file.flush();
        System.out.print(obj);
        phone.sendKeys("01819197567");
        password.sendKeys("123456");
        confirmpassword.sendKeys("123456");
        streataddress.sendKeys("Feni,masterpara");
        Select country = new Select(dropdowncountryid);
        //country.deselectByIndex(1);
        country.selectByValue("10");
        Select state = new Select(dropdownstateprovience);
        //state.deselectByIndex(2);
        state.selectByValue("79");
        Select city = new Select(dropdownCity);
        //city.deselectByIndex(2);
        city.selectByValue("Banaripara");
        checkboxbtn.click();
        submitbtn.click();


    }

}
