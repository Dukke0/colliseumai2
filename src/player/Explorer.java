package player;
import aic2022.user.*;

public class Explorer {

    public static void MakeDecision(UnitController uc) {
        int randomNumber = (int)(Math.random()*8);

        /*Get corresponding direction*/
        Direction dir = Direction.values()[randomNumber];

        //uc.get

    }

}
