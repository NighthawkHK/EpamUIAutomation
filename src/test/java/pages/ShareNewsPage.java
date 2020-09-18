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

    public void typeQuestion(String question) {
        textareaField.clear();
        textareaField.sendKeys(question);
    }

    public void typeName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void typeEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void typeContactNumber(String contactNumber) {
        contactNumberField.click();
        contactNumberField.sendKeys(contactNumber);
    }

    public void isAdultConfirmation(boolean isAdult) {
        if (isAdult)
            isAdultCheckbox.click();
    }

    public void acceptTermsConfirmation(boolean acceptTerms) {
        if (acceptTerms)
            acceptTheTermsCheckbox.click();
    }

    public void clickSubmitFormButton() {
        submitButton.click();
    }

    public boolean submitButtonIsDisplayed() {
        return submitButton.isDisplayed();
    }
}
