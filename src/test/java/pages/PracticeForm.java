package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeForm {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            uploadFileInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submit = $("#submit");

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void typeFirstName(String firstName) {
        firstNameInput.val(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameInput.val(lastName);
    }

    public void typeEmail(String email) {
        emailInput.val(email);
    }

    public void setGender(String gender) {
        genderInput.$(byText(gender)).click();
    }

    public void typePhoneNumber(String mobile) {
        phoneInput.val(mobile);
    }

    public void setDateOfBirth(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dayOfBirth)).click();
    }

    public void setSubject(String subject) {
        subjectInput.val(subject).pressEnter();
    }

    public void setHobby(String hobby) {
        hobbyInput.$(byText(hobby)).click();
    }

    public void uploadPicture(String picture) {
        uploadFileInput.uploadFile(new File("src/test/java/resources/img/" + picture));
    }

    public void typeCurrentAddress(String currentAddress) {
        currentAddressInput.val(currentAddress);
    }

    public void setState(String state) {
        stateInput.val(state).pressEnter();
    }

    public void setCity(String city) {
        cityInput.val(city).pressEnter();
    }

    public void pressSubmit() {
        submit.click();
    }

    public void assertResults(String firstName,
                              String lastName,
                              String email,
                              String gender,
                              String mobile,
                              String monthOfBirth,
                              String yearOfBirth,
                              String dayOfBirth,
                              String subject,
                              String hobby,
                              String picture,
                              String currentAddress,
                              String state,
                              String city) {

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent()
                .shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }

}
