package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import praktikum.constants.EnvConfig;

public class OrderPage {

    private final WebDriver driver;

    //Поле ввода имени
    private final By inputFirstName = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода фамилии
    private final By inputLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода адреса
    private final By inputAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода станции метро
    private final By inputMetro = By.cssSelector(".select-search__input");
    //Поле ввода даты
    private final By inputData = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    //Поле ввода телефонного номера
    private final By inputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка далее
    private final By buttonNext = By.xpath(".//button[text()='Далее']");
    //Первый элемент выпадающего списка метро
    private final By liMetro = By.xpath(".//li[@data-index=0]");
    //Стрелка для раскрытия списка времени
    private final By spanDropDown = By.className("Dropdown-arrow");
    //Поле ввода комментария
    private final By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Финальная кнопка заказа
    private final By buttonOrderFinal = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Кнопка соглашения во всплывающем окне
    private final By buttonYes = By.xpath(".//button[text()='Да']");
    //Заголовок заказа во сплывающем окне
    private final By divOrderHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstNameSet(String firstName){
        driver.findElement(inputFirstName).sendKeys(firstName);
    }

    public void inputLastNameSet(String lastName){
        driver.findElement(inputLastName).sendKeys(lastName);
    }

    public void inputAddressSet(String adress){
        driver.findElement(inputAdress).sendKeys(adress);
    }

    public void inputMetroSet(String metroName){
        driver.findElement(inputMetro).click();

        By metroListElement = By.xpath(".//div[text()='" + metroName + "']");
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(metroListElement));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(metroListElement) );
        driver.findElement(metroListElement).click();

    }

    public void inputPhoneSet(String phoneNumber){
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
    }

    public void buttonNextClick(){
        driver.findElement(buttonNext).click();
    }

    public void inputDataSet(String data){

        driver.findElement(inputData).sendKeys(data);

    }

    public void orderTimeSet(String time){
        driver.findElement(spanDropDown).click();
        By orderTime = By.xpath(".//div[text()='" + time + "']");
        driver.findElement(orderTime).click();
    }

    public void colorScooterSet(String color){
        By inputByColor = By.xpath(".//label[text()='" + color + "']/input");
        driver.findElement(inputByColor).click();
    }

    public void inputCommentSet(String comment){
        driver.findElement(inputComment).sendKeys(comment);
    }

    public void buttonFinalOrderClick(){
        driver.findElement(buttonOrderFinal).click();
    }

    public void buttonYesClick(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(buttonYes));
        driver.findElement(buttonYes).click();
    }

    public String getOrderHeader(){
        return driver.findElement(divOrderHeader).getText();

    }

    public void orderPageOneFill(String firstName,String lastName,String adress,String metro,String phoneNumper){
        inputFirstNameSet(firstName);
        inputLastNameSet(lastName);
        inputAddressSet(adress);
        inputMetroSet(metro);
        inputPhoneSet(phoneNumper);
    }

    public void orderPageTwoFill(String data,String time,String color,String comment){
        inputDataSet(data);
        orderTimeSet(time);
        colorScooterSet(color);
        inputCommentSet(comment);
    }


}
