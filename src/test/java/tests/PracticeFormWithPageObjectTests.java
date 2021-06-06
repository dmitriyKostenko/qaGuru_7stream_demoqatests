package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeForm;


public class PracticeFormWithPageObjectTests extends TestBase {

    String firstName = "Dmitry",
            lastName = "Kostenko",
            email = "kdm.tag@gmail.com",
            gender = "Male",
            mobile = "9281281020",
            monthOfBirth = "May",
            yearOfBirth = "1985",
            dayOfBirth = "30",
            subject = "Chemistry",
            hobby = "Sports",
            picture = "testPicture.jpg",
            currentAddress = "Taganrog, Lenina street, 100",
            state = "Haryana",
            city = "Panipat";

    PracticeForm practiceForm = new PracticeForm();

    @Test
    void successfulSubmitForTest() {

        //Arrange
        practiceForm.openPage();

        //Act
        practiceForm.typeFirstName(firstName);
        practiceForm.typeLastName(lastName);
        practiceForm.typeEmail(email);
        practiceForm.setGender(gender);
        practiceForm.typePhoneNumber(mobile);
        practiceForm.setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        practiceForm.setSubject(subject);
        practiceForm.setHobby(hobby);
        practiceForm.uploadPicture(picture);
        practiceForm.typeCurrentAddress(currentAddress);
        practiceForm.setState(state);
        practiceForm.setCity(city);
        practiceForm.pressSubmit();

        //Assert
        practiceForm.assertResults(firstName,
                lastName,
                email,
                gender,
                mobile,
                monthOfBirth,
                yearOfBirth,
                dayOfBirth,
                subject,
                hobby,
                picture,
                currentAddress,
                state,
                city);

    }
}
