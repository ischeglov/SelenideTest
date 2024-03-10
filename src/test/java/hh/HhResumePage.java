package hh;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class HhResumePage {

    private final SelenideElement gender = $x("//span[@data-qa='resume-personal-gender']");
    private final SelenideElement age = $x("//span[@data-qa='resume-personal-age']/span");
    private final SelenideElement city = $x("//span[@data-qa='resume-personal-address']");
    private final SelenideElement livesDada = $x("//span[@data-qa='resume-personal-address']/ancestor::p");

    /**
     * Константы для обозначения ключей в HashMap
     */
    public static String GENDER = "Пол";
    public static String AGE = "Возраст";
    public static String CITY = "Город";
    public static String RELOCATE = "Готовность к переезду";

    public HhResumePage(String url) {
        Selenide.open(url);
    }

    /**
     * Первый вариант
     * Возвращаем HashMap с актуальными данными о резюме
     * @return заполненная HashMap с данными
     */

    public Map<String, Object> getAttributes() {
        return new HashMap<>(){{
            put(GENDER, getGender());
            put(AGE, getAge());
            put(CITY, getCity());
            put(RELOCATE, isReadyToRelocate());
        }};
    }

    /**
     * Второй вариант
     * Возвращаем HashMap с актуальными данными о резюме
     * @return заполненная HashMap с данными
     */
//    public Map<String, Object> getAttributes() {
//        Map<String, Object> attributes = new HashMap<>();
//        attributes.put(GENDER, getGender());
//        attributes.put(AGE, getAge());
//        attributes.put(CITY, getCity());
//        attributes.put(RELOCATE, isReadyToRelocate());
//        return attributes;
//    }

    /**
     * Возвращаем пол кандидата с помощью тернарного оператора
     * @return "М" или "Ж", в зависимости от пола
     */
    public String getGender() {
        return gender.getText().equals("Мужчина") ? "М" : "Ж";
    }

    /**
     * Возвращаем пол кандидата с помощью логического условия
     * @return "М" или "Ж", в зависимости от пола
     */
    public String getGenderTheLogicalCondition() {
        String genderValue = gender.getText();
        if (genderValue.equals("Мужчина")) {
            return "М";
        }
        return "Ж";
    }

    /**
     * Получаем возраст кандидата с использованием регулярного выражения
     *
     * Регулярное выражение "[^0-9]" исключает все символы, не являющиеся цифрой
     * Также можно реализовать через регулярное выражение "\\D+"
     *
     * @return возраст кандидата в числовом формате
     */
    public Integer getAge() {
        return Integer.parseInt(age.getText().replaceAll("[^0-9]", ""));
    }

    /**
     * Возвращаем город проживания кандидата
     * @return город проживания
     */
    public String getCity() {
        return city.getText();
    }

    /**
     * Проверяем готов ли кандидат к переезду
     * @return готовность к переезду
     */
    public boolean isReadyToRelocate() {
        return !livesDada.getText().split(", ")[1].equals("не готов к переезду");
    }
}
