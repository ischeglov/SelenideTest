package hh;

import core.BaseSelenideTest;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HhTest extends BaseSelenideTest {

    /**
     * Ссылка на резюме для получения данных
     */
    private static final String URL = "ВАША_ССЫЛКА_НА_РЕЗЮМЕ";

    @Test
    @DisplayName("Сравнение с использованием HashMap")
    public void checkAttributesHashMap() {
        HhResumePage hhResumePage = new HhResumePage(URL);
        /**
         * Создаем HashMap с ожидаемыми результатами
         */
        Map<String, Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(HhResumePage.GENDER, "М");
        expectedAttributes.put(HhResumePage.AGE, 36);
        expectedAttributes.put(HhResumePage.CITY, "Уфа");
        expectedAttributes.put(HhResumePage.CONFIRMED_PHONE_NUMBER, true);
        expectedAttributes.put(HhResumePage.RELOCATE, false);

        /**
         * Получаем HashMap с актуальными результатами
         */
        Map<String, Object> actualAttributes = hhResumePage.getAttributes();

        /**
         * Сравниваем ожидаемый и актуальный результат
         */
        Assertions.assertEquals(expectedAttributes, actualAttributes);
    }

    @Test
    @DisplayName("Сравнение с использованием классов")
    public void checkAttributesClass() {
        HhResumePage hhResumePage = new HhResumePage(URL);

        /**
         * Создаем экземпляр класса с ожидаемыми результатами
         */
        Resume expectedResult = new Resume("М", 36, "Уфа",
                true, false);

        /**
         * Получаем экземпляр класса с актуальными результатами
         */
        Resume aclualResult = new Resume(hhResumePage.getGender(), hhResumePage.getAge(), hhResumePage.getCity(),
                hhResumePage.isConfirmedPhoneNumber(), hhResumePage.isReadyToRelocate());

        /**
         * Сравниваем ожидаемый и актуальный результат
         * Первый способ (сравнение классов)
         */
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(expectedResult, aclualResult));

        /**
         * Второй способ (сравнение переменных в классе)
         */
//        Assertions.assertEquals(expectedResult.getGender(), aclualResult.getGender());
//        Assertions.assertEquals(expectedResult.getAge(), aclualResult.getAge());
//        Assertions.assertEquals(expectedResult.getCity(), aclualResult.getCity());
//        Assertions.assertEquals(expectedResult.isConfirmedPhoneNumber(), aclualResult.isConfirmedPhoneNumber());
//        Assertions.assertEquals(expectedResult.isReadyToRelocate(), aclualResult.isReadyToRelocate());
    }
}
