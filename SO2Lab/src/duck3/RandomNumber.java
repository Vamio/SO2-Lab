package duck3;

/* Random number generator, copied from the lab 2 manual
 * 
 * Authors: Soinikov, Nikita
 */

public class RandomNumber {
	public static int between(int min, int max) {
		return (int) (Math.random() * ((max - min) + 1) + min);
	}
}
