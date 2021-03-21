package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.*;

public class TextBoxTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulFillTest() {

        String firstName = "Natalia";
        String lastName = "Nesterova";
        String userEmail = "nvnesterova@gmail.com";
        String userNumber = "8902668687";
        String subjectsInput = "Maths";
        String currentAddress = "Yaroslavskaya street";
        String state = "NCR";
        String city = "Delhi";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        //клик по радиобаттону
        //сохраню себе два спокоба клика по элементу
        $(byText("Male")).click();
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue(userNumber);
        //клик по полю и следом клик по дню в календаре
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("April")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1994")).click();
        $(".react-datepicker__day.react-datepicker__day--022").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("avatar.jpg");
        $("#currentAddress").setValue("Yaroslavskaya street");
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $(".modal-content").shouldHave
                (text(firstName),
                        text(userNumber),
                        text(lastName),
                        text(subjectsInput),
                        text(userEmail),
                        text(currentAddress),
                        text(state),
                        text(city),
                        text("avatar.jpg"),
                        text("22 April,1994"));
    }
}