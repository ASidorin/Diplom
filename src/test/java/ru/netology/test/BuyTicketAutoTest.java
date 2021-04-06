package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.DataSql;
import ru.netology.page.RequestPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyTicketAutoTest {

    @BeforeAll
    static void setUpAll(){

        SelenideLogger.addListener("allure",new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll(){
        SelenideLogger.removeListener("allure");
    }

    @Test
    public void shouldValidTestData() {
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setSuccessLabel();
        String sqlData = DataSql.getPaymentStatus();
        String expect = "APPROVED";
        assertEquals(expect, sqlData);
    }


    @Test
    public void shouldInvalidTestData() {
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterInvalidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorLabel();
        String sqlData = DataSql.getPaymentStatus();
        String expect = "DECLINED";
        assertEquals(expect, sqlData);
    }


    /**
     * Checked negative tests
     * on bank cards
     */

    @Test
    public void shouldRandomNumberCardTestData() {
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterRandomCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorLabel();
    }

    @Test
    public void shouldErrorEmptyCardTestData() {
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterEmptyCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();
    }

    @Test
    public void shouldShortEnteredCardTestData(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterShortCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();
    }


    /**
     *
     * Checked negative tests
     * on month
     */

    @Test
    public void shouldMonthZeroNumb(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterWithZeroMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();

    }

    @Test
    public void shouldMonthWithOneNumb(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterWithOneNumbMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();

    }

    @Test
    public void shouldMonthEmpty(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterEmptyMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();

    }


    /**
     *
     * Checked negative tests
     * on Year
     */

    @Test
    public void shouldInvalidYear(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterInvalidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorYear();
    }

    @Test
    public void shouldMoreThanMaxYear(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterMoreThanMaxYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorYear();
    }

    @Test
    public void shouldMoreThanMinYear(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterMoreThanMinYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setLimitTime();
    }

    @Test
    public void shouldOnlyOneNumbYear(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterWithOneNumbYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();
    }

    @Test
    public void shouldWithoutNumbYear(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterEmptyYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();
    }


    /**
     * Checked negative tests
     * on name
     */

    @Test
    public void shouldInvalidName(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterInvalidName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();
    }

    @Test
    public void shouldOnlyOneLetterName(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterOneLetterName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();
    }

    @Test
    public void shouldEmptyFieldName(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterEmptyName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorName();
    }

    @Test
    public void shouldOnArabicLanguageName(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterArabicName();
        String cvc = dataHelper.enterValidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();
    }


    /**
     *
     * Checked negative tests
     * on CVC
     */

    @Test
    public void shouldInvalidCVC(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterInvalidCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();
    }

    @Test
    public void shouldZeroCVC(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterZeroCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();
    }

    @Test
    public void shouldEmptyCVC(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterEmptyCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();
    }

    @Test
    public void shouldOnlyOneLetterCVC(){
        RequestPage requestPage = new RequestPage();
        DataHelper dataHelper = new DataHelper();
        open("http://localhost:8080");
        String card = dataHelper.enterValidCard();
        String month = dataHelper.enterValidMouth();
        String year = dataHelper.enterValidYear();
        String name = dataHelper.enterValidName();
        String cvc = dataHelper.enterWithOneNumbCVC();
        requestPage.chooseBuyTicket(card, month, year, name, cvc);
        requestPage.setErrorText();
    }


}
