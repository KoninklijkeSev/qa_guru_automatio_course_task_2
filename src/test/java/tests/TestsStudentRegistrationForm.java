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
        $(byText ("Practice Form")).shouldHave(text("Practice Form"));              // проверка, на наличие в main-header текста Practice Form
        $("#firstName").setValue("First Name");                                      // заополняем имя
        $("#lastName").setValue("Last Name");                                        // заополняем фамилию
        $("#userEmail").setValue("useremail@fake.com");                              // заополняем email
        // gender-radio-1
        $(byText("Male")).click();                                                  // отмечаем чекбокс с мужчским полом
        $("#userNumber").setValue("0123456789");                                     // заополняем номер телефона
        $("#dateOfBirthInput").click();                                              // заполняем дату рождения
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2021");
        $(".react-datepicker__day.react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Maths").pressEnter();                          // заполняем предмет
        // hobbies-checkbox-1
        $(byText("Sports")).click();                                                // заполняем хобби
        // uploadPicture
        $("#uploadPicture").uploadFromClasspath("Picture.jpg");             // грузим фото
//        $("#uploadPicture").pressEnter();
        $("#currentAddress").setValue("Here Current Address");                       // заполняем адрес
        // Select State
        $("#state").click();                                                         // заполняем штат
        $(byText("NCR")).click();
        // city
        $("#city").click();                                                          // заполняем город
        $(byText("Delhi")).click();
        $("#submit").click();                                                        // нажимаем на submit
        // Проверка на отображение формы после заполнения
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("#closeLargeModal").click();
    }

    @Test
    void TestStructure() {
        // arrange  |   given   - подготовка

        // act      |   when    - действие

        // assert   |   then    - проверка
    }
}
