/**
*This is a simple application which implements the use of random numbers to create a slot machine also the user has a menu option 
*/
import java.util.*;

public class SlotMachine {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); // Create Scanner object to take the user's input
		Random randomNumber = new Random(); // Create a random number generator object
		// Declare and intialise the varuables to 0
		int credits = 10; // The user will start the game with ten credits
		int userInput = 0; 
		int firstSpin = 0; 
		int secondSpin = 0;
		int thirdSpin = 0;
		int exit = 0; // Variable to exit the application
		int jackpot = 7;// Declare and intialise a jackpot variable to 7 as a  triple seven will result in a jackpot

		System.out.println("Welcome to my Slot Machine do you think it has what it takes..."); // Desplay message to the screen
			// Display the Ascii art of a slot machine
			System.out.println( "       -----------                 "   );
			System.out.println( "  ----|  JACKPOT |----             "   );
			System.out.println( "  |------------------|   O  "   );
			System.out.println( "   |__|__|__|__|__|__|   |  "   );     
			System.out.println( "   |  |  |  |  |  |  |   |  "   );
			System.out.println( "   ___________________ __|  "   );
			System.out.println( "   |"+ jackpot + "   | " + jackpot + "    |"  + jackpot + "    |"   );
			System.out.println( "   |    |      |     |"  + "  "   );
			System.out.println( "   |____|______|_____|  " );
			System.out.println( "   ------------------ "   );

		while(credits > 0) { // The credits will run as long as it is greater than 0
			// Display these options as the menu screen
			System.out.println("1. Display remaining credits");
			System.out.println("2. Play again");
			System.out.println("3. Exit game");
			userInput = keyboard.nextInt();

			if(userInput == 1) { // Display the amounts of credits which the user has left
				System.out.println("You have " + credits + " credits");
			}else if(userInput == 2) {
				firstSpin = randomNumber.nextInt(7)+1; // Set the value of the firstspin to a random number
			    secondSpin = randomNumber.nextInt(7)+1; // Set the value of the secondspin to a random number
				thirdSpin = randomNumber.nextInt(7)+1; // Set the value of the thirdspin to a random number

			// Display the slot machine which will contain the values of the firstpin,secondspin,thirdspin and will change each time as the values of each spin is changed

			System.out.println( "       -----------                 "   );
			System.out.println( "  ----|  JACKPOT |----             "   );
			System.out.println( "  |------------------|   O  "   );
			System.out.println( "   |__|__|__|__|__|__|   |  "   );     
			System.out.println( "   |  |  |  |  |  |  |   |  "   );
			System.out.println( "   ___________________ __|  "   );
			System.out.println( "   |"+ firstSpin + "   | " + secondSpin + "    |"  + thirdSpin + "    |"   );
			System.out.println( "   |    |      |     |"  + "  "   );
			System.out.println( "   |____|______|_____|  " );
			System.out.println( "   ------------------ "   );

						
			if(firstSpin == 7 && secondSpin == 7 && thirdSpin == 7) { // If the user gets 7 for the first , second and third spin simultaneously add 150 credits to the users credits
				credits =  credits + 150;
				System.out.println("Wow you have hit the jackpot !!! You have won 150 credits :-) "); // Print this message to the screen
			}else if(firstSpin == secondSpin && secondSpin == thirdSpin) { // If all three spins have the same matching number add 80 credits to the users credits
					credits = 80;
					System.out.println("Impressive you got three matching numbers you have won 80 credits !");
			}else if(firstSpin == secondSpin - 1 && secondSpin == thirdSpin - 1) { // If the user gets a spin which occurs in a sequential ro 1,2, 3 add 40 credits to the users credits
					credits = credits + 40;
					System.out.println("Excellent your spins occured in a sequential row you have won 40 credits !"); // Print this message to the screen
			}else if((secondSpin == firstSpin - 1 && thirdSpin == firstSpin + 1) 
					||(secondSpin == firstSpin + 1 &&  thirdSpin == firstSpin - 1)
					||(secondSpin == firstSpin - 2 &&  thirdSpin == firstSpin - 1)
					||(secondSpin ==  firstSpin + 2 && thirdSpin == firstSpin + 1)
					||(secondSpin == firstSpin - 1 && thirdSpin == firstSpin + 2)) { // If the user gets a spin which occurs in a non-sequential row 1,3, 2 add 25 credits to the users credits

					credits = credits + 25;
					System.out.println("Superb you got 25 credits as your spins occured in a non sequential order"); // Print this message to the screen
				}else if(firstSpin == secondSpin || secondSpin == thirdSpin || thirdSpin == firstSpin) { // If the user has two matching spins

				  if((firstSpin % 2 == 0 && secondSpin % 2 == 0)  // If both the users spins are even add ten credits to the user's credits
					|| (secondSpin % 2 == 0 && thirdSpin % 2 == 0) 
					|| (thirdSpin % 2 == 0 && firstSpin % 2 == 0) ){
					credits = credits + 10;
					System.out.println("Well done you got ten credits for two matching even numbers"); // Print this message to the screen
			}else {
					credits = credits + 5; // If both the users spins are odd add five credits to the user's credits
					System.out.println("Well done you got five credits for two matching odd numbers"); // Print this message to the screen
				  }
			}else if(firstSpin == 7 || secondSpin == 7 || thirdSpin == 7) {
					credits = credits + 2; // If at least one of the spins contains seven add two credits to the user's credits
				    System.out.println("One of your spins had the number 7 well done you got 2 credits"); // Print this message to the screen
				}else {
					System.out.println(" Unlucky try again next time you didn't win any credits :-( "); // Print this message to the screen
				}
			}if(userInput == 3) {
				System.out.println("Goodbye thankyou and we will miss you :-( "); // Print this message to the screen
				System.exit(0); // Exit the application
			}
			System.out.println(); // Add a space each time it runs
			credits = credits - 1; // Subtract one each time the user plays again
		}
	}
}