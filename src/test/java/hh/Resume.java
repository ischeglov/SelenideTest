package hh;

public class Resume {

    /**
     * Атрибуты для кандидата
     */
    private final String gender;
    private final int age;
    private final String city;
    private final boolean isConfirmedPhoneNumber;
    private final boolean isReadyToRelocate;

    /**
     * Конструктор класса
     * @param gender пол
     * @param age возраст
     * @param city город проживания
     * @param isConfirmedPhoneNumber подтвержденный номер телефона
     * @param isReadyToRelocate готовность к переезду
     */

    public Resume(String gender, int age, String city, boolean isConfirmedPhoneNumber, boolean isReadyToRelocate) {
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.isConfirmedPhoneNumber = isConfirmedPhoneNumber;
        this.isReadyToRelocate = isReadyToRelocate;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public boolean isConfirmedPhoneNumber() {
        return isConfirmedPhoneNumber;
    }

    public boolean isReadyToRelocate() {
        return isReadyToRelocate;
    }
}
