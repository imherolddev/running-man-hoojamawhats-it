/**
 * TreadmillSim<br>
 * 1/19/14<br>
 * <br>
 * Last edited: 1/26/14<br>
 * <br>
 * Class Description:<br>
 * -Timer uses currentTimeInMillis() to log time for starting and stopping. Also uses clocked times to display total run time<br>
 *---------------------------------<br>
 * Change log:<br>
 * -Created minutesSeconds(), moved from Treadmill
 * -Testing to keep track of treadmill runtime.<br>
 * -Added conversion to minutes and seconds for displaying run time to the user.<br>
 * @author Jason Hall - imherolddev
 * -http://stackoverflow.com/questions/8255738/is-there-a-stopwatch-in-java<br>
 * Original code considered and reformatted to fit my needs for this project
 */
public class Timer {

    /**
     * Time the event is started, in milliseconds
     */
    private long startTime = 0;
    /**
     * Time the event is stopped, in milliseconds
     */
    private long stopTime = 0;
    /**
     * Verification of running timer
     */
    private boolean running = false;
    /**
     * Records time of change
     */
    private long timeOfChange = 0;
    /**
     * Flag if change is made
     */
    private boolean change = false;
    /**
     * Conversion of milliseconds to seconds
     */
    int MILLI_TO_SEC = 1000;
    /**
     * Conversion of seconds to minutes
     */
    public final int SEC_TO_MIN = 60;

    /**
     * Method Description:<br>
     * -Start timer to record current time in milliseconds, set running flag to true
     */
    public void startTimer() {

        this.startTime = System.currentTimeMillis();
        this.running = true;

    } //end startTimer()

    /**
     * Method Description<br>
     * -Stop timer to record current time in milliseconds, set running flag to false
     */
    public void stopTimer() {

        this.stopTime = System.currentTimeMillis();
        this.running = false;

    } //end stopTimer()

    /**
     * Flag to check if running
     * @return boolean
     */
    public boolean isRunning() {

       return this.running;

   } //end isRunning()

    /**
     * Method Description<br>
     * -Calculates elapsed running time if running flag is true, or total running time if running flag is false
     * @return Total runtime in milliseconds.
     */
    public long getRunningTime() {

        /**
         * Current elapsed running time
         */
        long runTime;

        //gets running time, or total time, based on running flag
        if (this.running) {

            //calculates elapsed run time, converts milliseconds to seconds

            runTime = ((System.currentTimeMillis() - this.startTime) / MILLI_TO_SEC);

        } else {

            //calculates finished run time, converts milliseconds to seconds
            runTime = ((this.stopTime - this.startTime) / MILLI_TO_SEC);

        } //end getRunningTime() if/else

        //return runTime in seconds
        return(runTime);

    } //end getRunningTime()

    /**
     * Return time in minutes only
     */
    public int getMinutes() {

        if(this.change) {

            return (int) (getTimeSinceChange() / SEC_TO_MIN);

        } else {

            return (int) (this.getRunningTime() / SEC_TO_MIN);

        } //end if/else

    } //end getMinutes()

    /**
     * Method Description:<br>
     * -Converts running time to a string to display
     */
    public String minutesSeconds() {

        /**
         * Holds conversion to minutes, converts from long to int
         */
        int minutes = (int) (this.getRunningTime() / SEC_TO_MIN);
        /**
         * Holds conversion to seconds, converts from long to int
         */
        int seconds = (int) (this.getRunningTime() % SEC_TO_MIN);
        /**
         * Will hold conversion to minutes and seconds for display
         */

        return Integer.toString(minutes) + " minutes, " + Integer.toString(seconds) + "seconds";

    } //end minutesSeconds()

    /**
     * Get time of change
     */
    public void getTimeOfChange() {

        change = true;
        timeOfChange = System.currentTimeMillis();

    } //getTimeOfChange()

    /**
     * Get time since last change in seconds
     */
    long getTimeSinceChange() {

        this.change = false;
        return (System.currentTimeMillis() - this.timeOfChange) / MILLI_TO_SEC;

    } //end getTimeSinceChange()

} //end Timer
