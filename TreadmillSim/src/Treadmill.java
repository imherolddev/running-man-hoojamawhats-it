import java.text.DecimalFormat;

/**
 *TreadmillSim<br>
 * 1/19/14<br>
 * <br>
 * Last edited: 1/26/14<br>
 * <br>
 * Class Description:<br>
 * -Provides start, stop, display, and change speed methods. Also tracks the distance run.<br>
 * --------------------------------<br>
 * Change log:<br>
 * -MAJOR SURGERY!!!
 * -Moved String minutesSeconds to Timer class
 * -Modularize Main Menu to clean up class<br>
 * -Create class for use in main method<br>
 * -Moved instantiation of user object here to allow for calculations<br>
 * @author Jason Hall - imherolddev
 */
public class Treadmill {
    /**
     * Flag for treadmill running
     */
    private boolean running = false;
    /**
     * Holds value for speed in miles per hour
     */
    private double speed = 0.0;
    /**
     * Holds double speed converted to a decimal formatted String
     */
    private String displaySpeed;
    /**
     * Constant min speed
     */
    private final double MIN_SPEED = 1.0;
    /**
     * Constant max speed
     */
    private final double MAX_SPEED = 10.0;
    /**
     * Constant for 1 mph
     */
    private final double ONE_MPH = 1.0;
    /**
     * Constant for 0.1 mph
     */
    private final double TENTH_MPH = 0.10;
    /**
     * Display format for doubles
     */
    DecimalFormat format = new DecimalFormat("#.##");

    /**
     * Method Description:<br>
     * -Displays info for current run
     * @param timer - passes Timer to use its getRunningTime method
     * @param calCalc - passes Cal Calc to display calories
     * @param treadmill - passes treadmill to pass to calCalc
     * @param user - passes user to pass to calCalc
     */
    public void display(Timer timer, CalorieCalculator calCalc, Treadmill treadmill, User user) {

        this.getDistance(timer);

        //bases output on running flag
        if(this.isRunning()) {

            System.out.println("You have been running for: " + timer.minutesSeconds());
            System.out.println("Current speed: " + this.displaySpeed);
            System.out.println("Distance: " + this.displayDistance(timer));
            System.out.println("Calories burned: " + calCalc.displayCalories(treadmill, timer, user));
            System.out.println("Treadmill is running");

        } else {

            System.out.println("Your run lasted: " + timer.minutesSeconds());
            System.out.println("You ran: " + this.displayDistance(timer));
            System.out.println("Calories burned: " + calCalc.displayCalories(treadmill, timer, user));
            System.out.println("Treadmill is stopped");

        } //end display() if/else


    } //end display()

    /**
     * Method Description:<br>
     * -Starts timer and displays run info
     * @param timer - passes Timer to use its start and display methods, also to change running status
     * @param calCalc - passes Cal Calc to display calories
     * @param treadmill - passes treadmill to pass to calCalc
     * @param user - passes user to pass to calCalc
     */
    public void startRun(Timer timer, CalorieCalculator calCalc, Treadmill treadmill, User user) {

        if(this.isRunning()) {

            System.out.println("You are already running");

        } else {

            this.running = true;
            this.changeSpeed(timer, MIN_SPEED);
            timer.startTimer();
            System.out.println("Run started");
            System.out.println();
            this.display(timer, calCalc, treadmill, user);

        } //end startRun() if/else

    } //end startRun()

    /**
     * Method Description:<br>
     * -Stops Timer and displays run info
     * @param timer - passes Timer to use its stop method
     * @param calCalc - passes Cal Calc to display calories
     * @param treadmill - passes treadmill to pass to calCalc
     * @param user - passes user to pass to calCalc
     */
    public void stopRun(Timer timer, CalorieCalculator calCalc, Treadmill treadmill, User user) {

        if(this.isRunning()) {

            this.running = false;
            timer.stopTimer();
            System.out.println("Run stopped");
            System.out.println();
            this.display(timer, calCalc, treadmill, user);

        } else {

            System.out.println("The treadmill is already stopped");

        } //end if/else

    } //end stopRun()

    /**
     * Method Description:<br>
     * -Changes running speed by value
     * @param timer - passes timer to get distance
     * @param inc - value to increase speed by
     */
    private void changeSpeed(Timer timer, double inc) {

        timer.getTimeOfChange();

        this.getDistance(timer);

        this.speed = this.speed + inc;

        if(this.speed < MIN_SPEED) {

            this.speed = MIN_SPEED;

        } //end if/else

        this.displaySpeed = format.format(this.speed) + " mph";

    } //end changeSpeed()

    /**
     * Method Description:<br>
     * -Increase speed by 1 mph
     */
    public void incByOne(Timer timer) {

        timer.getTimeOfChange();

        if(this.speed < MAX_SPEED) {

            this.changeSpeed(timer, ONE_MPH);
            System.out.println("Speed set to: " + this.displaySpeed);

        } else {

            System.out.println("Running at maximum speed");

        } //end if

    } //end incByOne()

    /**
     * Method Description:<br>
     * -Decrease speed by 1 mph
     */
    public void decByOne(Timer timer) {

        timer.getTimeOfChange();

        if(this.speed > MIN_SPEED) {

            this.changeSpeed(timer, -ONE_MPH);
            System.out.println("Speed set to: " + this.displaySpeed);

        } else {

            System.out.println("Running at minimum speed");

        } //end if/else

    } //end decByOne()

    /**
     * Method Description:<br>
     * -Increase speed by 0.1 mph
     */
    public void incByDecimal(Timer timer) {

        timer.getTimeOfChange();

        if(this.speed < MAX_SPEED) {

            this.changeSpeed(timer, TENTH_MPH);
            this.getDistance(timer);
            System.out.println("Speed set to: " + this.displaySpeed);

        } else {

            System.out.println("Running at maximum speed");

        } //end if/else

    } //end incByDecimal()

    /**
     * Method Description:<br>
     * -Decrease speed by 0.1 mph
     */
    public void decByDecimal(Timer timer) {

        timer.getTimeOfChange();

        if(this.speed > MIN_SPEED) {

            this.changeSpeed(timer, -TENTH_MPH);
            this.getDistance(timer);
            System.out.println("Speed set to: " + this.displaySpeed);

        } else {

            System.out.println("Running at minimum speed");

        } //end if/else

    } //end decByDecimal()

    /**
     * Method Description:<br>
     * -Calculates and stores distance run
     */
    private double getDistance(Timer timer) {

        /**
         * Conversion of seconds to minutes
         */
        final int SEC_TO_MIN = 60;
        /**
         * Conversion of minutes to hours
         */
        final int MIN_TO_HRS = 60;

        return this.speed * ((int) timer.getRunningTime() / SEC_TO_MIN / MIN_TO_HRS);

    } //end getDistance()

    /**
     * Gets current speed
     * @return - double speed
     */
    public double getSpeed() {

        return this.speed;

    } //end getSpeed()

    /**
     * Method Description:<br>
     * -Calculate meters per minute
     * @return - double meters per minute
     */
    public double getMpm() {

        //mph * 26.8
        return this.speed * 26.8;

    } //end getMpm()

    public boolean isRunning() {

        return this.running;

    }

    /**
     * Sets display speed
     */
    private String displayDistance(Timer timer) {

        /**
         * Holds double distance converted to a decimal formatted String
         */
        String displayDistance = this.format.format(this.getDistance(timer));

        return (displayDistance + " miles");

    } //setDisplayDistance()

} //end Treadmill
