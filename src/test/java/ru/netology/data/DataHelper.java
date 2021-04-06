package ru.netology.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {

    Faker faker = new Faker(new Locale("ru"));

    /**
     *
     * Данные по карте
     *
     */

    public String enterValidCard() {
        return "4444444444444441";
    }

    public String enterInvalidCard() {
        return "4444444444444442";
    }

    public String enterRandomCard() {
        return "4444444444443487";
    }

    public String enterShortCard() {
        return "44444444";
    }

    public String enterEmptyCard() {
        return " ";
    }

    /**
     *
     * Данные по месяцу
     *
     */

    public String enterValidMouth() {
        return "04";
    }

    public String enterWithZeroMouth() {
        return "00";
    }

    public String enterEmptyMouth() {
        return " ";
    }

    public String enterWithOneNumbMouth() {
        return "3";
    }

    /**
     *
     * Данные по году
     *
     */

    public String enterValidYear() {
        return "25";
    }

    public String enterInvalidYear() {
        return "45";
    }

    public String enterMoreThanMaxYear() {
        return "29";
    }

    public String enterMoreThanMinYear() {
        return "20";
    }

    public String enterWithOneNumbYear() {
        return "4";
    }

    public String enterEmptyYear() {
        return " ";
    }

    /**
     *
     * Данные по имени
     *
     */


    public String enterValidName() {
        return faker.name().fullName();
    }

    public String enterInvalidName() {
        return "Ssdfb";
    }

    public String enterOneLetterName() {
        return "K";
    }

    public String enterEmptyName() {
        return " ";
    }

    public String enterArabicName() {
        return "سيبليسيب";
    }


    /**
     *
     * Данные по CVC
     *
     */

    public String enterValidCVC() {
        return "123";
    }

    public String enterInvalidCVC() {
        return "999";
    }

    public String enterZeroCVC() {
        return "000";
    }

    public String enterEmptyCVC() {
        return " ";
    }

    public String enterWithOneNumbCVC() {
        return "2";
    }
}
