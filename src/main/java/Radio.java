import java.util.Arrays;

public class Radio {
    private int numStations;                          // Количество радиостанций
    private int[] stations;                           // Массив радиостанций
    private int currentStationNumber;                 // Текущий номер станции
    private int currentVolume;                        // Текущий уровень громкости

    /**
     * Конструктор класса Radio
     * @param numberOfStations - количество радиостанций
     */
    public Radio(int numberOfStations) {
        if (numberOfStations <= 0) {
            throw new IllegalArgumentException("Размер массива станций должен быть больше 0");
        }
        this.numStations = numberOfStations;
        this.stations = new int[numberOfStations];
        Arrays.fill(this.stations, -1);               // По умолчанию все станции заполнены значением -1
        this.currentStationNumber = 0;
        this.currentVolume = 0;
    }

    /**
     * Конструктор класса Radio без параметров
     */
    public Radio() {
        this(10);                                     // Если параметры не заданы, то устанавливаем 10 станций по умолчанию
    }

    public int getNumStations() {
        return this.numStations;
    }

    /**
     * Метод для установки текущего номера станции
     * @param newCurrentStationNumber - новый номер станции
     */
    public void setCurrentStationNumber(int newCurrentStationNumber) {
        if (newCurrentStationNumber < 0 || newCurrentStationNumber >= this.numStations) {
            throw new IllegalArgumentException("Номер станции должен быть в диапазоне от 0 до " + (this.numStations - 1));
        }
        this.currentStationNumber = newCurrentStationNumber;
    }

    /**
     * Метод для получения текущего номера станции
     */
    public int getCurrentStationNumber() {
        return this.currentStationNumber;
    }

    /**
     * Метод для перехода к следующей станции
     */
    public void nextStation() {
        if (this.currentStationNumber == this.numStations - 1) {
            this.currentStationNumber = 0;
        } else {
            this.currentStationNumber++;
        }
    }

    /**
     * Метод для перехода к предыдущей станции
     */
    public void previousStation() {
        if (this.currentStationNumber == 0) {
            this.currentStationNumber = this.numStations - 1;
        } else {
            this.currentStationNumber--;
        }
    }

    /**
     * Метод для увеличения уровня громкости
     */
    public void increaseVolume() {
        if (this.currentVolume == 100) {
            this.currentVolume = 0;
        } else {
            this.currentVolume++;
        }
    }

    /**
     * Метод для уменьшения уровня громкости
     */
    public void decreaseVolume() {
        if (this.currentVolume == 0) {
            this.currentVolume = 100;
        } else {
            this.currentVolume--;
        }
    }

    /**
     * Метод для установки уровня громкости
     * @param newCurrentVolume - новый уровень громкости
     */
    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < 0 || newCurrentVolume > 100) {
            throw new IllegalArgumentException("Громкость должна быть от 0 до 100");
        }
        this.currentVolume = newCurrentVolume;
    }

    /**
     * Метод для получения текущего уровня громкости
     */
    public int getCurrentVolume() {
        return this.currentVolume;
    }
}