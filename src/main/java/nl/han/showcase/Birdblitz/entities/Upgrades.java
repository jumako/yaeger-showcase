package nl.han.showcase.Birdblitz.entities;

public class Upgrades {
    static int UpgradeSnelheid(int upgrade){
        int snelheidVogel = 3;
        if (upgrade == 1){
            snelheidVogel =snelheidVogel*2;
        }
        return snelheidVogel;
    }
    static int UpgradeLevens(int upgrade){
        int levens = 100;
        if (upgrade == 2) {
            levens= levens * 2;
        }
        return levens;
    }

    public static int Upgradeschade(int upgrade) {
        int schade = 100;
        if(upgrade == 3){
            schade = schade * 2;
        }
        return schade;
    }
}
