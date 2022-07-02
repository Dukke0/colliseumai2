package demoplayer;

import aic2022.user.*;

public class UnitPlayer {

	public void run(UnitController uc) {
		/*Insert here the code that should be executed only at the beginning of the unit's lifespan*/

		/*enemy team*/
		Team opponent = uc.getOpponent();

		while (true){
			/*Insert here the code that should be executed every round*/

			/*Generate a random number from 0 to 7, both included*/
			int randomNumber = (int)(Math.random()*8);

			/*Get corresponding direction*/
			Direction dir = Direction.values()[randomNumber];

			/*move in direction dir if possible*/
			if (uc.canMove(dir)) uc.move(dir);

			/*If this unit is a base, try spawning a barbarian at direction dir*/
			if (uc.getType() == UnitType.BASE) {
				if (uc.canSpawn(UnitType.BARBARIAN, dir)) uc.spawn(UnitType.BARBARIAN, dir);
			}



			uc.yield(); //End of turn
		}
	}
}