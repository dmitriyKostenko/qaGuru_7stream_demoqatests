package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitForTest() {

        open("https://demoqa.com/automation-practice-form");

        $("[id=firstName]").setValue("Dmitry");
        $("[id=lastName]").setValue("Kostenko");
        $("[id=userEmail]").setValue("kdm.tag@gmail.com");
        $(byText("Male")).click();
        $("[id=userNumber]").setValue("9281281020");

        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1985");
        $("[aria-label='Choose Tuesday, July 23rd, 1985']").click();

        $(byText("Sports")).click();
        $("[id=currentAddress]").setValue("Taganrog");
        $("[id=submit]").click();

        $(".table-responsive").find("td",1).shouldHave(text("Dmitry Kostenko"));
        $(".table-responsive").find("td",3).shouldHave(text("kdm.tag@gmail.com"));
        $(".table-responsive").find("td",5).shouldHave(text("Male"));
        $(".table-responsive").find("td",7).shouldHave(text("9281281020"));
        $(".table-responsive").find("td",9).shouldHave(text("23 July,1985"));
        $(".table-responsive").find("td",13).shouldHave(text("Sports"));
        $(".table-responsive").find("td",17).shouldHave(text("Taganrog"));
    }
}
