package nl.han.showcase.Birdblitz.entities;


public class Upgrades {

    public static int spelerLevens = 150;
    public static int spelerSnelheid = 3;
    public static int kogelSchade = 100;
    public static int  spelerUpgrade = 0;



    static void upgradeSpeler() {

        if (spelerUpgrade == 1) {
            spelerSnelheid = spelerSnelheid * 2;
        }
        if (spelerUpgrade == 2) {
            spelerLevens = spelerLevens * 2;
        }
        if (spelerUpgrade == 3) {
            kogelSchade = kogelSchade * 2;
        }
    }


//    }
//    static int UpgradeSnelheid(int upgrade){
//        int snelheidVogel = 3;
//        if (upgrade == 1){
//            snelheidVogel =snelheidVogel*2;
//        }
//        return snelheidVogel;
//    }
//    static int UpgradeLevens(int upgrade){
//        int levens = 100;
//        if (upgrade == 2) {
//            levens= levens * 2;
//        }
//        return levens;
//    }
//
//    public static int Upgradeschade(int upgrade) {
//        int schade = 100;
//        if(upgrade == 3){
//            schade = schade * 2;
//        }
//        return schade;
//    }
}
