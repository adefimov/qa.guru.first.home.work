package ru.aefimov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FirstTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTextFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alexey");
        $("#lastName").setValue("Efimov");
        $("#userEmail").setValue("i@aefimov.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9061234567");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1980");
        $((".react-datepicker__day--009")).click();

        $("#subjectsInput").setValue("Computer").pressEnter();
        $("#subjectsInput").setValue("Eng").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).scrollIntoView(true).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/gravatar.png"));
        $("#currentAddress").setValue("123098, Moscow, RED sq.1").pressEnter();

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").scrollIntoView(true).click();


// check set values
        $(byText("Student Name")).parent().shouldHave(text("Alexey Efimov"));
        $(byText("Student Email")).parent().shouldHave(text("i@aefimov.ru"));
        $("tbody").$(byText("Gender")).parent().shouldHave(text("Male"));
        $("tbody").$(byText("Mobile")).parent().shouldHave(text("9061234567"));
        $("tbody").$(byText("Date of Birth")).parent().shouldHave(text("09 February,1980"));
        $("tbody").$(byText("Subjects")).parent().shouldHave(text("Computer Science, English"));
        $("tbody").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $("tbody").$(byText("Picture")).parent().shouldHave(text("gravatar.png"));
        $(byText("Address")).parent().shouldHave(text("123098, Moscow, RED sq.1"));
        $("tbody").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }

}
