package player;
import aic2022.user.*;

public class Base {

    public static void MakeDecision(UnitController uc){
        int randomNumber = (int)(Math.random()*8);

        Direction[] directions = Direction.values();
        for (Direction dir: directions) {
            if (uc.canSpawn(UnitType.EXPLORER, dir)) uc.spawn(UnitType.EXPLORER, dir);
        }
    }

}
