package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;

public class PracticeFormWithFakerTests extends TestBase {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            mobile = faker.phoneNumber().subscriberNumber(10),
            monthOfBirth = getRandomMonth(),
            yearOfBirth = "1985",
            dayOfBirth = getRandomDay(),
            subject = getRandomSubject(),
            hobby = getRandomHobby(),
            picture = "testPicture.jpg",
            currentAddress = faker.address().streetAddress(),
            state = "Haryana",
            city = "Panipat";


    @Test
    void successfulSubmitForTest() {

        //Arrange
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //Act
        $("#firstName").val(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").val(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dayOfBirth)).click();
        $("#subjectsInput").val(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/img/testPicture.jpg"));
        $("#currentAddress").val(currentAddress);
        $("#react-select-3-input").val(state).pressEnter();
        $("#react-select-4-input").val(city).pressEnter();
        $("#submit").click();

        //Assert
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));

    }
}
