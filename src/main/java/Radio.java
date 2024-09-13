public class Radio {
    public int currentStationNumber;
    public int currentVolume;

    public void setCurrentStationNumber(int newCurrentStationNumber) {
        if (newCurrentStationNumber < 0 || newCurrentStationNumber > 9) {
            throw new IllegalArgumentException("Номер станции должен быть в диапазоне от 0 до 9");
        }
        currentStationNumber = newCurrentStationNumber;
    }

    public int getCurrentStationNumber() {
        return currentStationNumber;
    }

    public void nextStation() {
        if (currentStationNumber == 9) {
            currentStationNumber = 0;
        } else {
            currentStationNumber++;
        }
    }

    public void previousStation() {
        if (currentStationNumber == 0) {
            currentStationNumber = 9;
        } else {
            currentStationNumber--;
        }
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < 0 || newCurrentVolume > 100) {
            throw new IllegalArgumentException("Громкость должна быть от 0 до 100");
        }
        currentVolume = newCurrentVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume == 100) {
                currentVolume = 0;
            } else {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume == 0) {
            currentVolume = 100;
        } else {
            currentVolume--;
        }
    }
}
