package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class RequestPage {

    private SelenideElement btnBuy = $(byText("Купить"));
    private SelenideElement btnBuyCredit = $(byText("Купить в кредит"));
    private SelenideElement btnContinue = $(byText("Продолжить"));

    private SelenideElement cardField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");

    private SelenideElement nameField = $(byText("Владелец")).parent().$(".input__control");
    private SelenideElement cvcField = $("[placeholder='999']");

    private SelenideElement successLable = $(".notification_status_ok .notification__content");
    private SelenideElement errorLabel = $(".notification_status_error .notification__content");

    private SelenideElement errorYear = $(byText("Неверно указан срок действия карты"));
    private SelenideElement errorText = $(byText("Неверный формат"));
    private SelenideElement errorName = $(byText("Поле обязательно для заполнения"));
    private SelenideElement errorLimitYear = $(byText("Истёк срок действия карты"));


    DataHelper dataHelper = new DataHelper();

    public void chooseBuyTicket(String card, String month, String year, String name, String cvc) {
        btnBuy.click();
        cardField.setValue(card);
        monthField.setValue(month);
        yearField.setValue(year);
        nameField.setValue(name);
        cvcField.setValue(cvc);
        btnContinue.scrollIntoView(false).click();
    }

    public void chooseBuyCreditTicket(String card, String month, String year, String name, String cvc) {
        btnBuyCredit.click();
        cardField.setValue(card);
        monthField.setValue(month);
        yearField.setValue(year);
        nameField.setValue(name);
        cvcField.setValue(cvc);
        btnContinue.scrollIntoView(false).click();
    }

    public void setSuccessLabel() {
        successLable.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void setErrorLabel() {
        errorLabel.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void setErrorText() {
        errorText.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void setErrorYear() {
        errorYear.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void setErrorName() {
        errorName.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void setLimitTime() {
        errorLimitYear.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

}
