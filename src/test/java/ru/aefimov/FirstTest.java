package ru.aefimov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FirstTest {

    @BeforeAll
    static void setupTest() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTextFormTest() {
        open ("/automation-practice-form");
        $("#firstName").setValue("Alexey");
        $("#lastName").setValue("Efimov");
        $("#userEmail").setValue("i@aefimov.ru");
        $("#userNumber").setValue("906123434");
        $("#dateOfBirthInput").setValue("09.02.1978");
        $("#subjectsInput").setValue("Hello world!");


    }

}
