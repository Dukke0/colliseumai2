package player;
import aic2022.user.*;

public class Base {

    public static void MakeDecision(UnitController uc) {
        int randomNumber = (int)(Math.random()*8);

        if (uc.getRound() == 0) {
            Base.Opening(uc);
        } else {
            Direction[] directions = Direction.values();

            for (Direction dir : directions) {
                if (uc.canSpawn(UnitType.KNIGHT, dir)) uc.spawn(UnitType.KNIGHT, dir);
            }
        }
    }

    private static void Opening(UnitController uc) {

        if (uc.canSpawn(UnitType.EXPLORER, Direction.NORTHEAST))
            uc.spawn(UnitType.EXPLORER, Direction.NORTHEAST);

        if (uc.canSpawn(UnitType.EXPLORER, Direction.SOUTHWEST))
            uc.spawn(UnitType.EXPLORER, Direction.SOUTHWEST);
    }

}
