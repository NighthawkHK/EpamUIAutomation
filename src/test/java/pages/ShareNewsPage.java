package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    }

    public ShareNewsPage fillForm(Map<String, String> formData) {

        if (formData.containsKey("question"))
            questionField.sendKeys(formData.get("question"));

        if (formData.containsKey("name"))
            nameField.sendKeys(formData.get("name"));

        if (formData.containsKey("email"))
            emailField.sendKeys(formData.get("email"));

        if (formData.containsKey("phoneNumber"))
            contactNumberField.sendKeys(formData.get("phoneNumber"));

        if (formData.containsKey("ageConfirmation")) {
            String ageConfirmationText = formData.get("ageConfirmation");
            boolean isAdult = Boolean.parseBoolean(ageConfirmationText);
            if (isAdult)
                isAdultCheckbox.click();
        }

        if (formData.containsKey("termsConfirmation")) {
            String termsConfirmationText = formData.get("termsConfirmation");
            boolean acceptTerms = Boolean.parseBoolean(termsConfirmationText);
            if (acceptTerms)
                acceptTheTermsCheckbox.click();
        }
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
