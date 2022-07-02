package player;

import aic2022.user.Direction;
import aic2022.user.Location;
import aic2022.user.UnitController;

public class Knight {

    public static void goForObjective(UnitController uc){
        int enemy =0;
        for(int i=7000; i < 7000+100;i=i+3){
            enemy = uc.readOnSharedArray(i);
            if(enemy != 0){
                Location loc = new Location(uc.readOnSharedArray(i+1), uc.readOnSharedArray(i+2));
                Direction dir = uc.getLocation().directionTo(loc);
                if(uc.canMove(dir)) uc.move(dir);
            }
        }
    }
}
