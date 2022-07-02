package player;
import aic2022.user.*;
import java.lang.Math;

public class Explorer {

    public static void MakeDecision(UnitController uc) {

        //uc.get
        Direction dir = checkMapBoundaries(uc);

        if(dir == null) uc.move(Direction.EAST);
        else if(dir.isEqual(Direction.EAST)) uc.move(Direction.WEST);
        else if(dir.isEqual(Direction.WEST)) uc.move(Direction.EAST);
        else if(dir.isEqual(Direction.NORTH)) uc.move(Direction.SOUTH);
        else if(dir.isEqual(Direction.SOUTH)) uc.move(Direction.NORTH);


    }

    public static Direction checkMapBoundaries(UnitController uc){
        /*
        int EXPLORER_RADIUS = 30;
        Location explorerLoc = uc.getLocation();

        Location[] locs = uc.getVisibleLocations(EXPLORER_RADIUS);
        uc.println(locs);

        int maxX = -10000;
        int minX = +10000;
        int maxY = -10000;
        int minY = +10000;

        for (Location loc : locs){
            maxX = Math.max(loc.x,maxX);
            minX = Math.min(loc.x,minX);
            maxY = Math.max(loc.y,maxY);
            minY = Math.min(loc.y,minY);
        }
        uc.println(maxX);
        uc.println(explorerLoc.x);

        if((explorerLoc.x - maxX) < EXPLORER_RADIUS) return Direction.EAST;
        else if((explorerLoc.x - minX) > EXPLORER_RADIUS) return Direction.WEST;
        else if((explorerLoc.y - maxY) < EXPLORER_RADIUS) return Direction.NORTH;
        else if((explorerLoc.y - minY) < EXPLORER_RADIUS) return Direction.SOUTH;
        else return null;
         */
        if(!uc.canMove(Direction.WEST)) return Direction.WEST;
        else if(!uc.canMove(Direction.EAST)) return Direction.EAST;
        else if(!uc.canMove(Direction.NORTH)) return Direction.NORTH;
        else if(!uc.canMove(Direction.SOUTH)) return Direction.SOUTH;
        else return null;



    }

}
