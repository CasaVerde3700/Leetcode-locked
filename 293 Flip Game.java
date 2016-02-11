/**
 * take turns to flip two consecutive "++" into "--". 
 * The game ends when a person can no longer make a move 
 * and therefore the other person will be the winner.
 * Write a function to determine if the starting player 
 * can guarantee a win.
 */

public boolean canWin(String s) {
	int i = -1;

	while (s.indexOf("++", i + 1) >= 0) {
		i = s.indexOf("++", i + 1);
		//opponent's turn
		if (!canWin(s.substring(0, i) + "-" + s.substring(i + 2))) {
			return true;
		}
	}

	return false;
}