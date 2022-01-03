package TestRunner;

import Page.Login;
import Page.Purchitem;
import Setup.SetUp;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class PurchItemTestRunner extends SetUp {
    Purchitem objPurchase;
    Login objLogin;
    Utils utils;

    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {
        driver.get("https://priyoshop.com");
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//body/div[@id='myModal']/div[1]/div[1]/div[1]/button[1]")).click();
        utils=new Utils(driver);
        utils.readJSONFile();
        String email=utils.getEmail();
        String password=utils.getPassword();
        objLogin=new Login(driver);
        objLogin.DoLogin(email,password);
    }
    @Test(groups = "purchitem")
    public void CheckHeading(){
        objPurchase = new Purchitem (driver);
        String gery=objPurchase.Checkheading();
        Assert.assertEquals(gery,"Grocery Items");
    }
    @Test(groups = "purchitem")
    public void CheckSearBox() throws InterruptedException {
        objPurchase = new Purchitem (driver);
        String result=objPurchase.SearchItem();
        Assert.assertTrue(result.contains("Search - dress"));

    }
    @Test(groups = "purchitem")
    public void CheckAddCard() throws InterruptedException {
        objPurchase=new Purchitem(driver);
         String result1=objPurchase.AddCard();
         Assert.assertTrue(result1.contains("KAY KRAFT"));

    }
    @Test(groups = "purchitem")
    public void CardCheck(){
        objPurchase=new Purchitem(driver);
        String result2=objPurchase.CheckCard();
        Assert.assertTrue(result2.contains("Offer"));
    }
}
