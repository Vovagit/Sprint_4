package praktikum.constants;

public class TestValues {

    //Тестовые наборы для проверки ответов списка вопросов
    public static final Object[][] ANSWER_TEST ={
            {0,"Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
            {1,"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
            {2,"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
            {3,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
            {4,"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
            {5,"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
            {6,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
            {7,"Да, обязательно. Всем самокатов! И Москве, и Московской области."}
    };



    //Тестовые наборы для страницы заказа
    public static Object[][] ORDER_TEST = {
            {"Upper","Владимир","Терехов","г. Тестовый. улица Автоматизаций","Курская","+11111111111","12.05.2024","сутки","чёрный жемчуг","Некоторый комментарий для курьера. Тестовые данные.","Заказ оформлен"},
            {"Lower","Алла","Приходъкина","город Звени-Город, улица Чкалова","Комсомольская","+22222222222","12.06.2025","двое суток","серая безысходность","Домофон не работает","Заказ оформлен"}
    };

}
