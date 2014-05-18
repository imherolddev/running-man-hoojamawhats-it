/**
 * TreadmillSim<br>
 * <br>
 * 1/24/14<br>
 * <br>
 * Last edited: 1/26/14<br>
 * <br>
 * Class Description:<br>
 * -Takes a users choice as input and uses a switch statement to perform the desired method.<br>
 *---------------------------------<br>
 * Change log:<br>
 * -MAJOR SURGERY!!!
 * -Added speedMenu() for changing speeds<br>
 * -Moved to separate class from Treadmill to modularize code<br>
 * @author Jason Hall - imherolddev
 */
public class MainMenu {

    /**
     * Sentinel value to end the switch statement
     */
    final int QUIT = 99;
    /**
     * Users selection from the menu
     */
    int choice;
    /**
     * Default value for choice
     */
    final int DEFAULT = 0;

    /**
     * Method Description:<br>
     * -Main menu for Treadmill options<br>
     * -Takes input from user to perform actions based on a switch statement<br>
     * @param user - passes User for input, and use in Treadmill
     * @param timer - passes Timer to be used in Treadmill
     * @param treadmill - passes Treadmill to operate treadmill methods
     */
    public void mainMenu( Timer timer, CalorieCalculator calCalc, Treadmill treadmill, User user) {

        this.choice = DEFAULT;

        while(this.choice != this.QUIT) {

            System.out.println("Make your selection from the following (enter the number of your choice):");
            System.out.println();
            System.out.println("---MAIN MENU---");
            System.out.println("1: Start running");
            System.out.println("2: Change speed");
            System.out.println("3: Display stats");
            System.out.println("4: Stop running");
            System.out.println("99: Quit program");

            //input choice by user
            this.choice = user.getUserInput();

            //main menu switch
            switch (this.choice) {

                case 1: treadmill.startRun(timer, calCalc, treadmill, user);
                    break;
                case 2: this.speedMenu(timer, calCalc, treadmill, user);
                    break;
                case 3: treadmill.display(timer, calCalc, treadmill, user);
                    break;
                case 4: treadmill.stopRun(timer, calCalc, treadmill, user);
                    break;
                case 99: System.out.println("That was a great run!");
                    treadmill.display(timer, calCalc, treadmill, user);
                    break;
                default: System.out.println("Please enter the number of the option you would like to perform");

            } //end mainMenu() switch

        } //end while() switch

    } //end mainMenu()

    /**
     * Method Description:<br>
     * -Menu for change speed option
     */
    public void speedMenu(Timer timer, CalorieCalculator calCalc, Treadmill treadmill, User user) {

        if(treadmill.isRunning()) {

            this.choice = DEFAULT;

            while(this.choice != this.QUIT) {

                System.out.println("Make your selection from the following");
                System.out.println();
                System.out.println("---CHANGE SPEED---");
                System.out.println();
                System.out.println("1: Increase speed by 1 mph");
                System.out.println("2: Decrease speed by 1 mph");
                System.out.println("3: Increase speed by 0.1 mph");
                System.out.println("4: Decrease speed by 0.1 mph");
                System.out.println("99: EXIT");

                //input by user
                this.choice = user.getUserInput();

                //speedMenu switch
                switch(choice) {

                    case 1: treadmill.incByOne(timer);
                        break;
                    case 2: treadmill.decByOne(timer);
                        break;
                    case 3: treadmill.incByDecimal(timer);
                        break;
                    case 4: treadmill.decByDecimal(timer);
                        break;
                    case 99: System.out.println("Back to Main Menu");
                        break;
                    default: System.out.println("Please enter the number of the option you would like to perform");
                        break;

                } //end speedMenu switch

            } //end while

        } else {

            System.out.println("Pleas start the treadmill, then you may change speed");

        } //end if/else

        this.mainMenu(timer, calCalc, treadmill, user);

    } //end speedMenu

} //end MainMenu
