package player;
import aic2022.user.*;

public class Unit {

    public static Location[] senseChests(UnitController uc){
        ChestInfo[] info_chests = uc.senseChests();
        Location [] locations = new Location[info_chests.length];

        int index = 0;
        for (ChestInfo chest:info_chests){
            locations[index] = chest.getLocation();
            index += 1;
        }
        return locations;
    }
    public static void senseEnemies(UnitController uc){
        int ENEMIES_POS = 7000;
        UnitInfo[] enemies = uc.senseUnits(uc.getOpponent());

        for(UnitInfo unit:enemies){
            int array_id;
            int unitID = unit.getID();
            for(int i=ENEMIES_POS; i<ENEMIES_POS+100;i = i+4){
                array_id = uc.readOnSharedArray(i);
                if(array_id == 0){
                    uc.writeOnSharedArray(i, unitID);
                    uc.writeOnSharedArray(i+1, unit.getLocation().x);
                    uc.writeOnSharedArray(i+2, unit.getLocation().y);
                    uc.writeOnSharedArray(i+3, 5);

                    break;
                }
                if(array_id == unitID){
                    uc.writeOnSharedArray(i, unitID);
                    uc.writeOnSharedArray(i+1, unit.getLocation().x);
                    uc.writeOnSharedArray(i+2, unit.getLocation().y);
                    uc.writeOnSharedArray(i+3, 5);

                    break;
                }


            }
        }
        if(uc.getRound() > 400) {
            UnitInfo[] neutral = uc.senseUnits(Team.NEUTRAL);

            for (UnitInfo unit : neutral) {
                int array_id;
                int unitID = unit.getID();
                for (int i = ENEMIES_POS; i < ENEMIES_POS + 100; i = i + 4) {
                    array_id = uc.readOnSharedArray(i);
                    if (array_id == 0) {
                        uc.writeOnSharedArray(i, unitID);
                        uc.writeOnSharedArray(i + 1, unit.getLocation().x);
                        uc.writeOnSharedArray(i + 2, unit.getLocation().y);
                        uc.writeOnSharedArray(i + 3, 5);
                        break;
                    }
                    if (array_id == unitID) {
                        uc.writeOnSharedArray(i, unitID);
                        uc.writeOnSharedArray(i + 1, unit.getLocation().x);
                        uc.writeOnSharedArray(i + 2, unit.getLocation().y);
                        uc.writeOnSharedArray(i + 3, 5);
                        break;
                    }
                }
            }
        }

        for(int i=ENEMIES_POS; i<ENEMIES_POS+100;i = i+4){
            int array_id, cooldown;
            array_id = uc.readOnSharedArray(i);
            if(array_id != 0){
                cooldown = uc.readOnSharedArray(i+3);
                uc.writeOnSharedArray(i+3, cooldown-1);
                if(cooldown == 0){
                    uc.writeOnSharedArray(i,0);
                }
            }

        }


    }
    /*
    public static Location[] senseShrine(UnitController uc){
        ShrineInfo[] info_shrines = uc.senseShrines();
        Location [] locations = new Location[info_shrines.length];

        int index = 0;
        for (ShrineInfo shrine:info_shrines){
            locations[index] = shrine.get;
            index += 1;
        }
        return locations;
    }*/



}