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
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body/div[@id='myModal']/div[1]/div[1]/div[1]/button[1]")).click();
        utils=new Utils(driver);
        utils.readJSONFile();
        String email=utils.getEmail();
        String password=utils.getPassword();
        objLogin=new Login(driver);
        objLogin.DoLogin(email,password);
    }
    @Test(groups = "justify")
    public void CheckHeading(){
        objPurchase = new Purchitem (driver);
        boolean status=objPurchase.Checkheading();
        Assert.assertEquals(status,true);
    }
    @Test(groups = "justify")
    public void CheckSearBox() throws InterruptedException {
        objPurchase = new Purchitem (driver);
        String result=objPurchase.SearchItem();
        Assert.assertTrue(result.contains("Search - dress"));

    }
    @Test(groups = "justify")
    public void CheckAddCard() throws InterruptedException {
        objPurchase=new Purchitem(driver);
         String result1=objPurchase.AddCard();
         Assert.assertTrue(result1.contains("KAY KRAFT"));

    }
    @Test(groups = "justify")
    public void CardCheck(){
        objPurchase=new Purchitem(driver);
        String result2=objPurchase.CheckCard();
        Assert.assertTrue(result2.contains("Offer"));
    }



}
