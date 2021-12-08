package TestRunner;

import Page.Registration;
import Setup.SetUp;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTestRunner extends SetUp {
    Registration objreg;
    @Test(description = "Member Registration",groups = "Registration")
    public void DoRegistration() throws InterruptedException, IOException {
        driver.get("https://priyoshop.com");
        Thread.sleep(10000);
        //driver.findElement(By.className("close")).click();

        driver.findElement(By.xpath("//body/div[@id='myModal']/div[1]/div[1]/div[1]/button[1]")).click();
        objreg=new Registration(driver);
        objreg.MemberRegistration();
    }


}
