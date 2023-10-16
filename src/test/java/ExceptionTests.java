import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTests {
    private CustomerStorage storage;

    @BeforeEach
    void beforeEach() {
        storage = new CustomerStorage();
    }

    @Test
    @DisplayName("Передано более 4 слов в строке")
    public void moreThenFourElementsInputString() {
        final String input = "Василий Петров vasily.petrov@gmail.com +79215637722 5слово";

        assertThrows(Throwable.class, () -> storage.addCustomer(input),
                "Не выброшено исключение при количестве элементов в строке больше 4");
    }

    @Test
    @DisplayName("Передано менее 4 слов в строке")
    public void lessThanFourElementsInputString() {
        final String input = "Василий Петров vasily.petrov@gmail.com";
        assertThrows(Throwable.class, () -> storage.addCustomer(input),
                "Не выброшено исключение при количестве элементов в строке меньше 4");
    }

    @Test
    @DisplayName("Неверный формат email")
    public void wrongEmailFormatWithoutAt() {
        final String wrongEmail = "thisIsNotAnEmail";
        final String input = "Василий Петров " + wrongEmail + " +79215637722";

        assertThrows(Throwable.class, () -> storage.addCustomer(input),
                "Не выброшено исключение при неверном формате email -> " + wrongEmail);
    }

    @Test
    @DisplayName("Неверный формат номера")
    public void wrongPhoneFormatWithoutDigits() {
        final String wrongPhoneNumber = "+thisIsNotANumber";
        final String input = "Василий Петров hello@skillbox.ru " + wrongPhoneNumber;

        assertThrows(Throwable.class, () -> storage.addCustomer(input),
                "Не выброшено исключение при неверном формате номера -> " + wrongPhoneNumber);
    }
}
