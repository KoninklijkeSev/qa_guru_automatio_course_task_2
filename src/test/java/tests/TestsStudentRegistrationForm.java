package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestsStudentRegistrationForm {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void studentRegistrationForm() {

        open("https://demoqa.com/automation-practice-form");
        $(byText ("Practice Form")).shouldHave(text("Practice Form"));
        $("#firstName").setValue("FirstName");
        $("#lastName").setValue("LastName");
        $("#userEmail").setValue("useremail@fake.com");
        // gender-radio-1
        $(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2021");
        $(".react-datepicker__day.react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        // hobbies-checkbox-1
        $(byText("Sports")).click();
        // uploadPicture
        $("#uploadPicture").uploadFromClasspath("Picture.jpg");
        //$("#uploadPicture").pressEnter();
        $("#currentAddress").setValue("HereCurrentAddress");
        // Select State
        $("#state").click();
        $(byText("NCR")).click();
        // city
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("tr:nth-of-type(1) > td:nth-of-type(2)").shouldHave(text("FirstName LastName"));
        $("tr:nth-of-type(2) > td:nth-of-type(2)").shouldHave(text("useremail@fake.com"));
        $("tr:nth-of-type(3) > td:nth-of-type(2)").shouldHave(text("Male"));
        $("tr:nth-of-type(4) > td:nth-of-type(2)").shouldHave(text("0123456789"));
        $("tr:nth-of-type(5) > td:nth-of-type(2)").shouldHave(text("1 January,2021"));
        $("tr:nth-of-type(6) > td:nth-of-type(2)").shouldHave(text("Maths"));
        $("tr:nth-of-type(7) > td:nth-of-type(2)").shouldHave(text("Sports"));
        $("tr:nth-of-type(8) > td:nth-of-type(2)").shouldHave(text("Picture.jpg"));
        $("tr:nth-of-type(9) > td:nth-of-type(2)").shouldHave(text("HereCurrentAddress"));
        $("tr:nth-of-type(10) > td:nth-of-type(2)").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
    }

    @Test
    void TestStructure() {
        // arrange  |   given   - подготовка

        // act      |   when    - действие

        // assert   |   then    - проверка
    }
}
