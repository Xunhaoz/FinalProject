package hellofx.models;

public class LevelController {
    static protected int moneyMax = 1000;
    static protected int moneyRate = 1;
    static protected int moneyLevel;

    static public void changeMaxM(int setM) {
        moneyMax += setM;
    }

    static public void changeRateM(int setM) {
        moneyRate += setM;
    }

}
