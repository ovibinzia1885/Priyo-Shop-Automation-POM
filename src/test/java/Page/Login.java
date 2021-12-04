package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class Login  {
    WebDriver driver;
    @FindBy(xpath = "//label[contains(text(),'My Account')]")
    WebElement linkbtn;
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement loginbtn;
    @FindBy(id ="Username")
    WebElement usernamebtn;
    @FindBy(id = "Password")
    WebElement passwordbtn;
    @FindBy(xpath = "//input[@value='Log in']")
    WebElement submitbtn;

   @FindBy(xpath = "//a[@class='ico-account']")
   WebElement ibnusername;
   @FindBy(xpath = "//body[1]/div[5]/div[4]/div[3]/div[2]/div[1]/h1[1]")
   WebElement dailyneed;

   @FindBy(xpath = "//li[contains(text(),'The credentials provided are incorrect')]")
   WebElement rongauth;
   @FindBy(xpath = "//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]")
   WebElement rongemail;
   @FindBy(className = "page-title")
   WebElement logout;
   @FindBy(xpath = "//span[normalize-space()='×']")
   WebElement cross;







    public Login (WebDriver driver ) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String DoLogin(String email,String password){
       // cross.click();
        linkbtn.click();
        loginbtn.click();
        usernamebtn.sendKeys(email);
        passwordbtn.sendKeys(password);
        submitbtn.click();
        linkbtn.click();
       // logout.click();
       return ibnusername.getText();


    }

    public String DoLoginForWrongPassword(String email,String password){
        linkbtn.click();
        loginbtn.click();
        usernamebtn.sendKeys(email);
        passwordbtn.sendKeys(password);
        submitbtn.click();
        return rongemail.getText();
    }

    public String DoLoginForInvalidEmail(String email,String password){
        linkbtn.click();
        loginbtn.click();
        usernamebtn.sendKeys(email);
        passwordbtn.sendKeys(password);
        submitbtn.click();
        return rongemail.getText();
    }




}
