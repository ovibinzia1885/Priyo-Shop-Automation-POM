import Page.Login;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestRunner extends SetUp{
    Login objLogin;
    Utils utils;
    @Test(enabled = false)
    public void loginwith() throws IOException, ParseException {
        driver.get("https://priyoshop.com");
        objLogin =new Login(driver);
        JSONParser jsonParser=new JSONParser();
        Object obj=jsonParser.parse(new FileReader("./src/test/resources/user.json"));
        JSONObject jsonObject=(JSONObject)obj;
        String email=(String)jsonObject.get("email") ;
        String password=(String)jsonObject.get("password");

        String user1=objLogin.dologin(email,password);
        Assert.assertEquals(user1,"nazmul35-1885@diu.edu.bd");

//        String user1=objLogin.dologin("nazmul35-1885@diu.edu.bd","123456");
//        Assert.assertEquals(user1,"nazmul35-1885@diu.edu.bd");
    }
    @Test(enabled = false)
    public void loginwithWrongPassword() throws IOException, ParseException {
        driver.get("https://priyoshop.com");
        objLogin =new Login(driver);
        JSONParser jsonParser=new JSONParser();
        Object obj=jsonParser.parse(new FileReader("./src/test/resources/user.json"));
        JSONObject jsonObject=(JSONObject)obj;
        String email=(String)jsonObject.get("email") ;
        String password=(String)jsonObject.get("password");

        String autherror  =objLogin.dologinforwrongpassword(email,password);
        Assert.assertEquals(autherror,"The credentials provided are incorrect");

    }

    @Test(enabled = false )
    public void loginwithinvalidemail() throws IOException, ParseException {
        driver.get("https://priyoshop.com");
        objLogin =new Login(driver);
        JSONParser jsonParser=new JSONParser();
        Object obj=jsonParser.parse(new FileReader("./src/test/resources/user.json"));
        JSONObject jsonObject=(JSONObject)obj;
        String email=(String)jsonObject.get("email") ;
        String password=(String)jsonObject.get("password");

        String autherror  =objLogin.dologinforinvalidemail(email,password);
        Assert.assertEquals(autherror,"Login was unsuccessful. Please correct the errors and try again.");

    }

    @Test(enabled = true)
    public void doLoginWrongPassword() throws IOException, ParseException {
        driver.get("https://priyoshop.com");
        objLogin = new Login(driver);
        utils=new Utils(driver);
        utils.readJSONArray(1);
        String autherror =objLogin.dologinforwrongpassword(utils.getEmail(),utils.getPassword());
        Assert.assertEquals(autherror,"The credentials provided are incorrect");
    }

}
