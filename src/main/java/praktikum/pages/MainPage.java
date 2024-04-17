package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.constants.EnvConfig;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    //Нижняя кнопка заказа
    private final By lowerOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //Верхняя кнопка заказа
    private final By upperOrderButton = By.className("Button_Button__ra12g");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage clickUpperOrderButton(){
        driver.findElement(upperOrderButton).click();
        return new OrderPage(driver);
    }

    public  OrderPage clickLowerOrderButton(){
        WebElement element=driver.findElement(lowerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(lowerOrderButton));
        element.click();
        return new OrderPage(driver);
    }

    public void open() {
        driver.get(EnvConfig.BASE_URL);
    }

    public void divQuestionByIdClick(int id){

        By byQuestion=By.id("accordion__heading-"+id);

        WebElement element = driver.findElement(byQuestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(byQuestion));

        element.click();
    }
    public String divAnswerByIdGetText(int id){

        By byAnswer = By.xpath(".//div[@id='accordion__panel-" + id + "']/p");

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(byAnswer));

        return driver.findElement(byAnswer).getText();
    }


}
