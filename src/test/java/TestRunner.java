import Page.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

public class TestRunner extends SetUp{
    Login objLogin;
    @Test
    public void loginwith(){
        driver.get("https://priyoshop.com");
        objLogin =new Login(driver);
        objLogin.dologin("nazmul35-1885@diu.edu.bd","123456");
        Assert.assertEquals("dailyneed","dailyneed");
    }

}
