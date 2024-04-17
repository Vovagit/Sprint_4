package praktikum;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import praktikum.constants.TestValues;
import praktikum.pages.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuestionsTest {
    @Rule

    public DriverRule driverRule = new DriverRule();
    private final int id;
    private final String answer;
    private WebDriver driver;

    public QuestionsTest(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    @Before
    public void before(){
        driver = driverRule.getDriver();
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return TestValues.ANSWER_TEST;

    }

    @Test
    public void positiveQuestionsTest(){
        MainPage main = new MainPage(driver);
        main.open();
        main.divQuestionByIdClick(id);
        String actualAnswer=main.divAnswerByIdGetText(id);
        assertEquals("Неверный текст ответа!",answer,actualAnswer);
    }
}
