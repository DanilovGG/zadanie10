public class Radio {
    private int numStations;                          // Количество радиостанций
    private int currentStationNumber;                 // Текущий номер станции
    private int currentVolume;                        // Текущий уровень громкости

    public Radio(int numberOfStations) {
        this.numStations = numberOfStations;
        this.currentStationNumber = 0;
        this.currentVolume = 0;
    }

    public Radio() {
        this(10);                                     // Если параметры не заданы, то устанавливаем 10 станций по умолчанию
    }

    public void setCurrentStationNumber(int newCurrentStationNumber) {
        if (newCurrentStationNumber < 0 || newCurrentStationNumber >= this.numStations) {
            throw new IllegalArgumentException("Номер станции должен быть в диапазоне от 0 до " + (this.numStations - 1));
        }
        this.currentStationNumber = newCurrentStationNumber;
    }

    public int getCurrentStationNumber() {
        return this.currentStationNumber;
    }

    public void nextStation() {
        if (this.currentStationNumber == this.numStations - 1) {
            this.currentStationNumber = 0;
        } else {
            this.currentStationNumber++;
        }
    }

    public void previousStation() {
        if (this.currentStationNumber == 0) {
            this.currentStationNumber = this.numStations - 1;
        } else {
            this.currentStationNumber--;
        }
    }

    public void increaseVolume() {
        if (this.currentVolume == 100) {
            this.currentVolume = 0;
        } else {
            this.currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (this.currentVolume == 0) {
            this.currentVolume = 100;
        } else {
            this.currentVolume--;
        }
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < 0 || newCurrentVolume > 100) {
            throw new IllegalArgumentException("Громкость должна быть от 0 до 100");
        }
        this.currentVolume = newCurrentVolume;
    }

    public int getCurrentVolume() {
        return this.currentVolume;
    }
}