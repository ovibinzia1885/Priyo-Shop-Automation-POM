package TestRunner;

import Page.Login;
import Setup.SetUp;
import Utils.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LogInTestRunner extends SetUp {
    Login objLogin;
    Utils utils;

    @Test(enabled = true, description = "login with valid username and password", groups = "login")
    public void validLogin() throws IOException, ParseException, InterruptedException {
        driver.get("https://priyoshop.com");
        Thread.sleep(10000);
        //driver.findElement(By.className("close")).click();

        driver.findElement(By.xpath("//body/div[@id='myModal']/div[1]/div[1]/div[1]/button[1]")).click();
        objLogin = new Login(driver);
        utils = new Utils(driver);
        utils.readJSONArray(0);
        String user = objLogin.DoLogin(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(user, "nazmul35-1885@diu.edu.bd");
        driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();

//        String user1=objLogin.dologin("nazmul35-1885@diu.edu.bd","123456");
//        Assert.assertEquals(user1,"nazmul35-1885@diu.edu.bd");
    }

    @Test(enabled = false, description = "login with wrong password")
    public void doLoginWrongPassword() throws IOException, ParseException, InterruptedException {
        driver.get("https://priyoshop.com");
        Thread.sleep(10000);
        //driver.findElement(By.className("close")).click();

        driver.findElement(By.xpath("//body/div[@id='myModal']/div[1]/div[1]/div[1]/button[1]")).click();
        objLogin = new Login(driver);
        utils = new Utils(driver);
        utils.readJSONArray(1);
        String autherror = objLogin.DoLoginForWrongPassword(utils.getEmail(), utils.getPassword());
        Thread.sleep(1000);
        Assert.assertEquals(autherror, "Login was unsuccessful. Please correct the errors and try again.");
    }

    @Test(enabled = false, description = "login with invalid email")
    public void dologininvalidemail() throws IOException, ParseException, InterruptedException {
        driver.get("https://priyoshop.com");
        Thread.sleep(10000);
        //driver.findElement(By.className("close")).click();

        driver.findElement(By.xpath("//body/div[@id='myModal']/div[1]/div[1]/div[1]/button[1]")).click();
        objLogin = new Login(driver);
        utils = new Utils(driver);
        utils.readJSONArray(2);
        String error = objLogin.DoLoginForInvalidEmail(utils.getEmail(), utils.getPassword());
        Thread.sleep(1000);
        Assert.assertEquals(error, "Login was unsuccessful. Please correct the errors and try again.");
    }

}
