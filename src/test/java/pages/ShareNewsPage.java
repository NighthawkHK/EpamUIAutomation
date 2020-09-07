package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    public void fillTheRegistrationForm(String text, String name, String email, String phoneNumber, boolean isAdult, boolean acceptTerms) {
        textareaField.click();
        textareaField.sendKeys(text);

        nameField.click();
        nameField.sendKeys(name);

        emailField.click();
        emailField.sendKeys(email);

        contactNumberField.click();
        contactNumberField.sendKeys(phoneNumber);

        if (isAdult)
            isAdultCheckbox.click();

        if (acceptTerms)
            acceptTheTermsCheckbox.click();
    }

    public void submitTheRegistrationForm() {
        submitButton.click();
    }

    public void assertThatSubmissionDidNotWork() {
        Assert.assertTrue(submitButton.isDisplayed(), "Submission did not work.");
    }
}
