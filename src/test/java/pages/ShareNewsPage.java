package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class ShareNewsPage extends BasePage {

    @FindBy(xpath = "//div[starts-with(@id, 'hearken-curiosity')]//textarea")
    private WebElement questionField;

    @FindBy(xpath = "//div[starts-with(@id, 'hearken-curiosity')]//input[@placeholder='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//div[starts-with(@id, 'hearken-curiosity')]//input[contains(@placeholder, 'Email')]")
    private WebElement emailField;

    @FindBy(xpath = "//div[starts-with(@id, 'hearken-curiosity')]//input[contains(@placeholder, 'Contact')]")
    private WebElement contactNumberField;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[6]//input")
    private WebElement isAdultCheckbox;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[7]//input")
    private WebElement acceptTheTermsCheckbox;

    @FindBy(xpath = "//div[@class='button-container']/button")
    private WebElement submitButton;

    public ShareNewsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ShareNewsPage fillForm(Map<String, String> formFields) {

        if (formFields.containsKey("question"))
            questionField.sendKeys(formFields.get("question"));

        if (formFields.containsKey("name"))
            nameField.sendKeys(formFields.get("name"));

        if (formFields.containsKey("email"))
            emailField.sendKeys(formFields.get("email"));

        if (formFields.containsKey("phoneNumber"))
            contactNumberField.sendKeys(formFields.get("phoneNumber"));
        return this;
    }

    public ShareNewsPage toggleCheckboxes(boolean ageConfirmation, boolean termsConfirmation) {
        if (ageConfirmation)
            isAdultCheckbox.click();
        if (termsConfirmation)
            acceptTheTermsCheckbox.click();
        return this;
    }

    public ShareNewsPage submitForm() {
        submitButton.click();
        return this;
    }

    public boolean verifyThatFormWasSent() {
        return !submitButton.isDisplayed();
    }
}
