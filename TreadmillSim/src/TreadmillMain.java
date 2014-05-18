/**
 * TreadmillSim<br>
 * 1/12/14<br>
 * <br>
 * Last edited: 1/24/14<br>
 * <br>
 * Class Description:<br>
 * -Main entry point for TreadmillSim<br>
 * ---------------------------------<br>
 * Change log:<br>
 * -Instantiate all objects, and invoke mainMenu()<br>
 * -Attempting to truly modularize, initializing objects here and passing them into methods in other classes<br>
 * -Continue to build class, using user methods<br>
 * @author Jason Hall - imherolddev
 */
public class TreadmillMain {

    /**
     * Method Description<br>
     * -Main method for the Treadmill program
     * @param args - command line arguments
     */
    public static void main(String[] args) {

        /**
         * Invokes Treadmill
         */
        Treadmill newTreadmill = new Treadmill();
        Timer newTimer = new Timer();
        User newUser = new User();
        CalorieCalculator calCalc = new CalorieCalculator();
        MainMenu mainMenu = new MainMenu();

        newUser.setUserWeight();

        mainMenu.mainMenu(newTimer, calCalc, newTreadmill, newUser);

    } //end main()

} //end TreadmillMain
