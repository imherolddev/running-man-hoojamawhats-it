import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TreadmillSim<br>
 * 1/11/14<br>
 * <br>
 * Last edited: 1/26/14<br>
 * <br>
 * Class Description:<br>
 * -User contains an instantiation of Scanner, for receiving input. This also simply contains the users weight,<br>
 * and a method to display it.<br>
 *---------------------------------<br>
 * Change log:<br>
 * -Continue to build class, added scanner and inputs for user info.<br>
 * -Assign values to User attributes with scanner, to allow for display.<br>
 * @author Jason Hall - imherolddev
 */
public class User {

    /**
     * Creates a scanner for input from user at command line
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Users weight
     */
    int weight = 0;
    /**
     * Maximum weight
     */
    final int MAX_WEIGHT = 400;
    /**
     * Minimum weight
     */
    final int MIN_WEIGHT = 80;
    /**
     * Default initialized weight
     */
    final int DEFAULT_WEIGHT = 0;

    /**
     * Method Description:<br>
     * -Gather the Users weight for calculations
     */
    void setUserWeight() {

        /**
         * Error check flag
         */
        boolean inError = true;

        while(inError) {

            System.out.println("Enter your weight in pounds");

            //error checking for weight input
            try {

                this.weight = scanner.nextInt();

            } catch(InputMismatchException e) {

                System.out.println("Please enter your weight in whole pounds");
                scanner.next();
                continue;

            }

            inError = false;

            //verify weight is within range
            if(this.weight > MAX_WEIGHT) {

                inError = true;
                this.weight = DEFAULT_WEIGHT;
                System.out.println("Entered weight is over the limit of this machine");

            } else if(this.weight < MIN_WEIGHT) {

                inError = true;
                this.weight = DEFAULT_WEIGHT;
                System.out.println("Entered weight is below the recommended limit");

            } //end if/else

        } //end while

    } //end getUserInfo()

    /**
     * Method Description:<br>
     * -Calculate weight in kilograms
     * @return - double weight in kg
     */
    public double getWeightInKg() {

        //weight in lbs / 2.2
        return this.weight / 2.2;

    } //end getWeightInKg

    /**
     * Method Description:<br>
     * -Takes input from user
     * @return - an integer
     */
    public int getUserInput() {

        /**
         * Holds user input
         */
        int input = 0;

        try {

            input = scanner.nextInt();

        } catch(InputMismatchException e) {

            System.out.println("Enter a valid number");
            scanner.next();

        } //end try/catch

        return input;

    } //end getUserInput()

} //end User
