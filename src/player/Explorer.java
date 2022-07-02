package player;
import aic2022.user.*;

public class Explorer {

    public static void MakeDecision(UnitController uc) {
        if (uc.getRound() == 1) {
            setSpawnDirection(uc, 0, Direction.NORTHEAST);
            setSpawnDirection(uc, 3, Direction.SOUTHWEST);
        }

        if (uc.getInfo().getID() == uc.readOnSharedArray(0)) {
            moveDirection(uc,0);
        } else if (uc.getInfo().getID() == uc.readOnSharedArray(3)) {
            moveDirection(uc,3);
        }
    }

    private static void moveDirection(UnitController uc, int idx) {
        int dx = uc.readOnSharedArray(idx + 1);
        int dy = uc.readOnSharedArray(idx + 2);
        if (uc.canMove(Direction.getDirection(dx, dy))) uc.move(Direction.getDirection(dx, dy));
    }

    private static void setSpawnDirection(UnitController uc, int idx, Direction d) {
        Location loc = new Location(d.dx, d.dy);
        if (uc.senseUnitAtLocation(loc) == null) {
            uc.writeOnSharedArray(idx+1, d.dx);
            uc.writeOnSharedArray(idx+2, d.dy);
        } else {
            uc.writeOnSharedArray(idx+1, d.opposite().dx);
            uc.writeOnSharedArray(idx+2, d.opposite().dy);
        }
        uc.writeOnSharedArray(idx, uc.getInfo().getID());


    }

}
