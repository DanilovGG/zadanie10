import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test //Проверяет начальное состояние радио, когда все параметры установлены в ноль
    public void testInitialState() {
        Radio radio = new Radio();

        Assertions.assertEquals(0, radio.getCurrentStationNumber());
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testSettingValidStationNumber() {
        Radio radio = new Radio();

        for (int i = 0; i <= 9; i++) {
            radio.setCurrentStationNumber(i);
            Assertions.assertEquals(i, radio.getCurrentStationNumber());
        }
    }

    @Test
    public void testNextStationResetsToZeroAfter9() {
        Radio radio = new Radio();
        radio.setCurrentStationNumber(9);
        radio.nextStation();
        Assertions.assertEquals(0, radio.getCurrentStationNumber());
    }

    @Test
    public void testNextStation() {
        Radio radio = new Radio();

        for (int i = 0; i < 9; i++) {
            radio.nextStation();
            Assertions.assertEquals(i + 1, radio.getCurrentStationNumber());
        }
    }

    @Test
    public void testPreviousStation() {
        Radio radio = new Radio();

        for (int i = 9; i > 0; i--) {
            radio.previousStation();
            Assertions.assertEquals(i, radio.getCurrentStationNumber());
        }
    }

    @Test
    public void testIllegalArgumentsForSetCurrentStationNumber() {
        Radio radio = new Radio();

        int[] illegalValues = {-1, 10};
        for (int value : illegalValues) {
            Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> radio.setCurrentStationNumber(value));
            String expectedMessage = "Номер станции должен быть в диапазоне от 0 до 9";
            Assertions.assertEquals(expectedMessage, exception.getMessage());
        }
    }

    @Test
    public void testSetCurrentVolume() {
        Radio radio = new Radio();

        for (int i = 0; i <= 100; i++) {
            radio.setCurrentVolume(i);
            Assertions.assertEquals(i, radio.getCurrentVolume());
        }
    }

    @Test
    public void testIncreaseVolumeResetsToZeroAfter100() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();

        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
            Assertions.assertEquals(i + 1, radio.getCurrentVolume());
        }
    }

    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();

        for (int i = 100; i > 0; i--) {
            radio.decreaseVolume();
            Assertions.assertEquals(i, radio.getCurrentVolume());
        }
    }

    @Test
    public void testIllegalArgumentsForSetCurrentVolume() {
        Radio radio = new Radio();
        int[] illegalValues = {-1, 101};
        for (int value : illegalValues) {
            Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> radio.setCurrentVolume(value));
            String expectedMessage = "Громкость должна быть от 0 до 100";
            Assertions.assertEquals(expectedMessage, exception.getMessage());
        }
    }

    @Test //правильности установки и получения текущего номера станции
    public void testGetAndSetCurrentStationNumber() {
        Radio radio = new Radio();

        for (int i = 0; i <= 9; i++) {
            radio.setCurrentStationNumber(i);
            Assertions.assertEquals(radio.getCurrentStationNumber(), i);
        }

        try {
            radio.setCurrentStationNumber(-1);
            Assertions.fail("Ожидаемое исключение не возникло.");
        } catch (IllegalArgumentException e) {
            Assertions.assertTrue(true);
        }

        try {
            radio.setCurrentStationNumber(10);
            Assertions.fail("Ожидаемое исключение не возникло..");
        } catch (IllegalArgumentException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test //навигации по станциям
    public void testNavigationBetweenStations() {
        Radio radio = new Radio(20);

        int currentStationNumber = radio.getCurrentStationNumber();
        while (currentStationNumber < 19) {
            radio.nextStation();
            currentStationNumber = radio.getCurrentStationNumber();
        }

        radio.nextStation();
        Assertions.assertEquals(radio.getCurrentStationNumber(), 0);

        currentStationNumber = radio.getCurrentStationNumber();
        while (currentStationNumber > 0) {
            radio.previousStation();
            currentStationNumber = radio.getCurrentStationNumber();
        }

        radio.previousStation();
        Assertions.assertEquals(radio.getCurrentStationNumber(), 19);
    }

    @Test //управления уровнем громкости
    public void testIncreaseAndDecreaseVolume() {
        Radio radio = new Radio();

        int initialVolume = radio.getCurrentVolume();
        while (initialVolume != 100) {
            radio.increaseVolume();
            initialVolume = radio.getCurrentVolume();
        }

        Assertions.assertEquals(radio.getCurrentVolume(), 100);

        radio.increaseVolume();
        Assertions.assertEquals(radio.getCurrentVolume(), 0);

        initialVolume = radio.getCurrentVolume();
        while (initialVolume != 100) {
            radio.decreaseVolume();
            initialVolume = radio.getCurrentVolume();
        }

        Assertions.assertEquals(radio.getCurrentVolume(), 100);
    }
}