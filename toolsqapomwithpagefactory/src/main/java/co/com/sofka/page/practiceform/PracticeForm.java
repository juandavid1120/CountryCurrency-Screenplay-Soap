package co.com.sofka.page.practiceform;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class PracticeForm extends CommonActionsOnPages {

    private static final Logger LOGGER = Logger.getLogger(PracticeForm.class);
    private PracticeFormModel practiceFormModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //For input test cases.
    @FindBy(id = "firstName")
    @CacheLookup
    private WebElement name;

    @FindBy(id = "lastName")
    @CacheLookup
    private WebElement lastName;

    @FindBy(id = "userEmail")
    @CacheLookup
    private  WebElement userEmail;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    @CacheLookup
    private WebElement genderMale;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")
    @CacheLookup
    private WebElement genderFemale;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")
    @CacheLookup
    private WebElement genderOther;

    @FindBy(id = "userNumber")
    @CacheLookup
    private WebElement mobile;

    @FindBy(id = "dateOfBirthInput")
    @CacheLookup
    private WebElement dateOfBirthInput;

    @FindBy(id = "subjectsInput")
    @CacheLookup
    private WebElement subjects;

    @FindBy(xpath = "//label[text()='Sports']")
    @CacheLookup
    private WebElement hobbiesSports;

    @FindBy(xpath = "//label[text()='Reading']")
    @CacheLookup
    private WebElement hobbiesReading;

    @FindBy(xpath = "//label[text()='Music']")
    @CacheLookup
    private WebElement hobbiesMusic;

    @FindBy(id = "uploadPicture")
    @CacheLookup
    private WebElement selectFileToUpload;

    @FindBy(id = "currentAddress")
    @CacheLookup
    private WebElement currentAddress;

    @FindBy(id = "react-select-3-input")
    @CacheLookup
    private WebElement state;

    @FindBy(id = "react-select-4-input")
    @CacheLookup
    private WebElement city;

    @FindBy(id = "submit")
    @CacheLookup
    private WebElement submit;

    //For Assertions test case.
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")
    @CacheLookup
    private WebElement assertionStudentName;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")
    @CacheLookup
    private WebElement assertionStudentEmail;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")
    @CacheLookup
    private WebElement assertionGender;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")
    @CacheLookup
    private WebElement assertionMobile;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")
    @CacheLookup
    private WebElement assertionStudentDateOfBirth;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")
    @CacheLookup
    private WebElement assertionSubjects;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")
    @CacheLookup
    private WebElement assertionHobbies;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[8]/td[2]")
    @CacheLookup
    private WebElement assertionPicture;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")
    @CacheLookup
    private WebElement assertionAddress;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")
    @CacheLookup
    private WebElement assertionStateAndCity;

    //Sikulix elements.
    private static final String ATTACHMENT_FILE_PATCH = USER_DIR.value() + "\\src\\test\\resources\\images\\practiceform\\happy.jpg";

    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page\\practiceform\\";
    private static final String SELECT_PICTURE_PATCH = PAGE_BASE_PATCH + "selectPicture.PNG";
    private static final String SELECT_OPEN_PATCH = PAGE_BASE_PATCH + "openWindows.PNG";
    private static final String FILE_NAME_TEXT_BOX_PATCH = PAGE_BASE_PATCH + "fileNameWindows.PNG";


    public PracticeForm(WebDriver driver, PracticeFormModel practiceFormModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.practiceFormModel = practiceFormModel;
    }

    public PracticeForm(WebDriver driver, PracticeFormModel practiceFormModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver, this);

        if(practiceFormModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.practiceFormModel = practiceFormModel;

    }

    //Page functions.
    public void fillStudentForm() throws IOException {
        clear(name);
        typeInto(name, practiceFormModel.getName());

        clear(lastName);
        typeInto(lastName, practiceFormModel.getLastName());

        switch (practiceFormModel.getGender()){
            case FEMALE:
                clickOn(genderFemale);
                break;
            case MALE:
                clickOn(genderMale);
                break;
            case OTHER:
                clickOn(genderOther);
                break;
            default:
        }

        clear(mobile);
        typeInto(mobile, practiceFormModel.getMobile());

        doSubmit(submit);
    }

    public void fillStudentFormUsingAllFields(){
        try{
            scrollTo(name);
            withExplicitWaitClear(name);
            withExplicitWaitTypeInto(name, practiceFormModel.getName());

            scrollTo(lastName);
            withExplicitWaitClear(lastName);
            withExplicitWaitTypeInto(lastName, practiceFormModel.getLastName());

            scrollTo(userEmail);
            withExplicitWaitClear(userEmail);
            withExplicitWaitTypeInto(userEmail, practiceFormModel.getEmail());

            switch (practiceFormModel.getGender()){
                case MALE:
                    scrollTo(genderMale);
                    clickOn(genderMale);
                    break;

                case FEMALE:
                    scrollTo(genderFemale);
                    clickOn(genderFemale);
                    break;

                case OTHER:
                    scrollTo(genderOther);
                    clickOn(genderOther);
                    break;

                default:
            }

            scrollTo(mobile);
            withExplicitWaitClear(mobile);
            withExplicitWaitTypeInto(mobile, practiceFormModel.getMobile());

            scrollTo(dateOfBirthInput);
            clickOn(dateOfBirthInput);

            clickOn(By.xpath("//option[. = '" + practiceFormModel.getYear() + "']"));
            clickOn(By.xpath("//option[. = '" + practiceFormModel.getMonth() + "']"));
            clickOn(By.xpath("//div[contains(@aria-label,'" + practiceFormModel.getDay() + "') and contains(@aria-label, '" + practiceFormModel.getMonth() + "')]"));

            scrollTo(subjects);
            for (String element : practiceFormModel.getSubjects()) {
                withExplicitWaitTypeInto(subjects, (CharSequence) element);
                withExplicitWaitTypeInto(subjects, Keys.TAB);
            }

            switch (practiceFormModel.getHobbies()){
                case SPORTS:
                    scrollTo(hobbiesSports);
                    clickOn(hobbiesSports);
                    break;

                case READING:
                    scrollTo(hobbiesReading);
                    clickOn(hobbiesReading);
                    break;

                case MUSIC:
                    scrollTo(hobbiesMusic);
                    clickOn(hobbiesMusic);
                    break;

                default:
            }

            clickOn(SELECT_PICTURE_PATCH);
            insertInto(FILE_NAME_TEXT_BOX_PATCH, ATTACHMENT_FILE_PATCH);
            clickOn(SELECT_OPEN_PATCH);

            scrollTo(currentAddress);
            withExplicitWaitClear(currentAddress);
            withExplicitWaitTypeInto(currentAddress, practiceFormModel.getCurrentAddress());

            scrollTo(state);
            withExplicitWaitTypeInto(state, practiceFormModel.getState(), Keys.TAB);

            scrollTo(city);
            withExplicitWaitTypeInto(city, practiceFormModel.getCity(), Keys.TAB);

            scrollTo(submit);
            clickOn(submit);

        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }

    public List<String> isRegistrationDone() {
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(getText(assertionStudentName).trim());
        submitedFormResult.add(getText(assertionGender).trim());
        submitedFormResult.add(getText(assertionMobile).trim());
        return submitedFormResult;
    }

    public String isNoneInseted() {
        return getText(assertionStudentName).trim();
    }

}
