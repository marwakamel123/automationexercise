package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailTextField = By.xpath("(//input[@type =\"email\"])[1]");
    private By passwordTextField = By.xpath("//input[@type =\"password\"]");
    private By loginButton = By.xpath("(//button[@class =\"btn btn-default\"])[1]");

    public LoggedInHomePage login(String email, String password)
    {
        typeOnInputField(emailTextField,email);
        typeOnInputField(passwordTextField, password);
        clickElement(loginButton);
        return new LoggedInHomePage(driver);
    }
}
