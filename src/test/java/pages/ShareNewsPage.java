package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShareNewsPage extends BasePage {

    @FindBy(xpath = "//div[starts-with(@id, 'hearken-curiosity')]//textarea")
    private WebElement textareaField;

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

    @FindBy(xpath = "//div[@class='embed-content-container']/div[8]/button")
    private WebElement submitButton;

    public ShareNewsPage typeQuestion(String question) {
        textareaField.clear();
        textareaField.sendKeys(question);
        return this;
    }

    public ShareNewsPage typeName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public ShareNewsPage typeEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public ShareNewsPage typeContactNumber(String contactNumber) {
        contactNumberField.click();
        contactNumberField.sendKeys(contactNumber);
        return this;
    }

    public ShareNewsPage isAdultConfirmation(boolean isAdult) {
        if (isAdult)
            isAdultCheckbox.click();
        return this;
    }

    public ShareNewsPage acceptTermsConfirmation(boolean acceptTerms) {
        if (acceptTerms)
            acceptTheTermsCheckbox.click();
        return this;
    }

    public ShareNewsPage clickSubmitFormButton() {
        submitButton.click();
        return this;
    }

    public boolean submitButtonIsDisplayed() {
        return submitButton.isDisplayed();
    }
}
