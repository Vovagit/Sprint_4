package praktikum;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import praktikum.constants.TestValues;
import praktikum.pages.MainPage;
import praktikum.pages.OrderPage;

import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.MatcherAssert;
@RunWith(Parameterized.class)
public class PositiveScooterTest {

    @Rule
    public DriverRule driverRule = new DriverRule();
    private final String orderButton;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroName;
    private final String phoneNumber;
    private final String data;
    private final String time;
    private final String color;
    private final String comment;
    private final String successHeader;
    private OrderPage order;

    public PositiveScooterTest(String orderButton, String firstName, String lastName, String address, String metroName, String phoneNumber, String data, String time, String color, String comment, String successHeader) {
        this.orderButton = orderButton;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroName = metroName;
        this.phoneNumber = phoneNumber;
        this.data = data;
        this.time = time;
        this.color = color;
        this.comment = comment;
        this.successHeader = successHeader;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                TestValues.ORDER_TEST1,
                TestValues.ORDER_TEST2,
        };
    }

    @Test
    public void positiveOrderFlow(){

        WebDriver driver = driverRule.getDriver();
        MainPage main = new MainPage(driver);
        main.open();

        if("Lower".equals(orderButton)){
            order =main.clickLowerOrderButton();
        }else{
            order = main.clickUpperOrderButton();
        }

        order.orderPageOneFill(firstName,lastName,address,metroName,phoneNumber);
        order.buttonNextClick();
        order.orderPageTwoFill(data,time,color,comment);
        order.buttonFinalOrderClick();
        order.buttonYesClick();
        String actualOrderHeader=order.getOrderHeader();
        MatcherAssert.assertThat("Заголовок не соответствует ожиданию!",actualOrderHeader, containsString(successHeader));

    }

}
