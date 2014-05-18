import java.text.DecimalFormat;

/**
 * TreadmillSim<br>
 * <br>
 * 1/26/14<br>
 * <br>
 * Last edited: creation<br>
 * <br>
 * Class Description:<br>
 * -<br>
 * ---------------------------------<br>
 * Change log:<br>
 * -Created class, added attributes and methods<br>
 *
 * @author Jason Hall - imherolddev
 */
public class CalorieCalculator {

    /**
     * Calories burned
     */
    double caloriesBurned = 0.0;
    /**
     * Formatted String for displaying calories
     */
    String displayCalories;
    /**
     * Weight in kilograms
     */
    double weightInKg = 0.0;
    /**
     * Meters per minute
     */
    double mpm = 0.0;
    /**
     * Constant for speed in calculating oxygen
     */
    final double K_MPH = 3.7;
    /**
     * Constant for mpm low speed
     */
    final double L_MPM = 0.1;
    /**
     * Constant for mpm high speed
     */
    final double H_MPM = 0.2;
    /**
     * Constant increment for Oxygen calculation
     */
    final double ADD = 3.5;

    /**
     * Method Description:<br>
     * -Set mpm
     * @param treadmill - passes treadmill to get speed conversion
     */
    private void setMpm(Treadmill treadmill) {

        mpm = treadmill.getMpm();

    } //end setMpm()

    /**
     * Method Description:<br>
     * -Set weight in kilograms
     * @param user - passes treadmill to get weight conversion
     */
    private void setWeightInKg(User user) {

        weightInKg = user.getWeightInKg();

    } //end setWeightInKg()

    /**
     * Method Description:<br>
     * -Get oxygen used
     * @param treadmill - passes speed of treadmill
     * @return - double O2 in mL/kg/min
     */
    private double getOxygenUsed(Treadmill treadmill, Timer timer) {

        /**
         * Oxygen used
         */
        double oxygenUsed;

        this.setMpm(treadmill);

        if(treadmill.getSpeed() <= this.K_MPH) {

            oxygenUsed = (L_MPM * this.mpm) + ADD;

        } else {

            oxygenUsed = (H_MPM * this.mpm) + ADD;

        } //end if/else

        oxygenUsed = oxygenUsed * timer.getMinutes();

        return oxygenUsed;

    } //end getOxygenUsed()

    /**
     * Method Description:<br>
     * -Calculate and store calories burned
     * @param treadmill - passes treadmill to get oxygen used
     * @param user - passes user to set weight
     */
    double calcCalories(Treadmill treadmill,Timer timer, User user) {

            this.setWeightInKg(user);

            this.caloriesBurned = this.caloriesBurned + ((this.getOxygenUsed(treadmill, timer) * this.weightInKg) / 200);

            return caloriesBurned;

    } //end calcCalories()

    /**
     * Method Description:<br>
     * -Convert calories burned to String for display
     * @param treadmill - passes treadmill to calculate calories
     * @param user - passes user to calculate calories
     */
    public String displayCalories(Treadmill treadmill,Timer timer, User user) {

        DecimalFormat format = new DecimalFormat("#.##");

        this.displayCalories = format.format(this.calcCalories(treadmill,timer, user));

        return this.displayCalories;

    } //end setDisplayCalories()

} //CalorieCalculator
