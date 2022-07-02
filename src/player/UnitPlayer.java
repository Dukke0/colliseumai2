package player;

import aic2022.user.*;
import player.Base;

public class UnitPlayer {

	public void run(UnitController uc) {
		/*Insert here the code that should be executed only at the beginning of the unit's lifespan*/

		/*enemy team*/
		Team opponent = uc.getOpponent();

		while (true){
			/*If this unit is a base, try spawning a barbarian at direction dir*/
			if (uc.getType() == UnitType.BASE) {
				Base.MakeDecision(uc);

			} else if (uc.getType() == UnitType.EXPLORER) {
				Explorer.MakeDecision(uc);
			}

			uc.yield(); //End of turn
		}
	}
}

