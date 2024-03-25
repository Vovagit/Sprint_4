package praktikum;

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

    public QuestionsTest(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                TestValues.ANSWER_TEST1,
                TestValues.ANSWER_TEST2,
                TestValues.ANSWER_TEST3,
                TestValues.ANSWER_TEST4,
                TestValues.ANSWER_TEST5,
                TestValues.ANSWER_TEST6,
                TestValues.ANSWER_TEST7,
                TestValues.ANSWER_TEST8,

        };
    }

    @Test
    public void positiveQuestionsTest(){
        WebDriver driver = driverRule.getDriver();
        MainPage main = new MainPage(driver);
        main.open();
        main.divQuestionByIdClick(id);
        String actualAnswer=main.divAnswerByIdGetText(id);
        assertEquals("Неверный текст ответа!",answer,actualAnswer);
    }
}
