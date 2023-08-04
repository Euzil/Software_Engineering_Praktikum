package tnt.enginee;

public class GodCard {
    private String godName;
    private int godNumber;
    private String godCardEffect;

    public String getGodName() {
        return this.godName;
    }

    public void setGodName(String godName) {
        this.godName = godName;
    }

    public int getGodNumber() {
        return this.godNumber;
    }

    public void setGodNumber(int godNumber) {
        this.godNumber = godNumber;
    }

    public String getGodCardEffect() {
        return this.godCardEffect;
    }

    public void setGodCardEffect(String godCardEffect) {
        this.godCardEffect = godCardEffect;
    }

    public GodCard(int godNumber) {
        this.godNumber = godNumber;
        if (godNumber == 0){
        	this.godName = "";
        	this.godCardEffect = "";
        }else if (godNumber == 1) {
            this.godName = "Apollo";
            this.godCardEffect = "Deine Bewegung: Dein Arbeiter kann auf ein von einem gegnerischen Arbeiter besetztes Feld ziehen, "
                    + "indem du ihn zwingst auf das Feld zu gehen, "
                    + "dass du grade verlassen hast.";
        } else if (godNumber == 2) {
            this.godName = "Artemis";
            this.godCardEffect = "Deine Bewegung: Dein Arbeiter darf noch einmal bewegt werden, aber nicht auf zur�ck auf sein �rspr�ngliches Feld";
        } else if (godNumber == 3) {
            this.godName = "Athena";
            this.godCardEffect = "Gegenspieler Runde: Wenn einer deiner Arbeiter in der letzten Runde hochbewegt wurde, "
                    + "k�nnen gegenspieler dies in ihrer Runde nicht durchf�hren";
        } else if (godNumber == 4) {
            this.godName = "Atlas";
            this.godCardEffect = "Deine Bauphase: Dein Arbeiter kann eine Kupel auf eine beliebige ebene bauen.";
        } else if (godNumber == 5) {
            this.godName = "Demeter";
            this.godCardEffect = "Deine Bauphase: Dein Arbeiter kann ein weiteres Mal bauen, "
                    + "aber nicht auf das selbe Feld";
        } else if (godNumber == 6) {
            this.godName = "Hephaestus";
            this.godCardEffect = "Deine Bauphase: Dein Arbeiter darf einen weiteren Block (keine Kuppel) auf dem zuvor errichteten Block bauen.";
        } else if (godNumber == 7) {
            this.godName = "Hermes";
            this.godCardEffect = "Deine Runde: Wenn deine Arbeiter nicht hoch oder runter bewegt werden, "
                    + "kannst du sie eine beliebige Anzahl von Feldern (auch null) bewegen und dann mit einem Arbeiter bauen.";
        } else if (godNumber == 8) {
            this.godName = "Minotaur";
            this.godCardEffect = "Deine Bewegung: Dein Arbeiter kann auf ein gegnerisches Feld ziehen, "
                    + "wenn sein Arbeiter auf ein freies Feld (jeder Ebene) direkt dahinter gezwungen werden kann.";
        } else if (godNumber == 9) {
            this.godName = "Pan";
            this.godCardEffect = "Siegbedingung: Du gewinnst auch, wenn sich einer deiner Arbeiter um zwei Ebenen nach unten bewegt.";
        } else if (godNumber == 10) {
            this.godName = "Prometheus";
            this.godCardEffect = "Deine Bewegung: Wenn dein Arbeiter sich nicht nach oben bewegt, darfst du sowohl vor als auch nach deiner Bewegung bauen.";
        }
    }


}