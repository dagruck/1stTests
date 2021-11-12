import java.util.Random;

public class cloack {
    // h = 1..12, m = 0..59



    private static Random rnd = new Random();

    /**
     * Returns angle in radian between hour and minute pointers
     *
     * @param hours   int  value of hour pointer
     * @param minutes int value of second pointer
     * @return double angle in radians
     */
    public static double angle2(int hours, int minutes) {
        if(hours<0 || hours > 23 || minutes < 0 || minutes > 59) {
            return Double.NaN;
        }
        double hAngle = 2 * Math.PI * (hours % 12) / 12;
        double hMin = 2 * Math.PI * minutes / 60;
        double angle = hAngle - hMin;
        if (angle < 0) {
            angle += 2 * Math.PI;
        }
        if (angle > 2 * Math.PI) {
            angle -= 2 * Math.PI;
        }
        return angle;
    }

    private static double angle3(int hours, int minutes) {
        if(hours<0 || hours > 23 || minutes < 0 || minutes > 59) {
            return Double.NaN;
        }
        double angle = (5 * (hours % 12)- minutes)*Math.PI/30;
        if (angle < 0) {
            angle += 2 * Math.PI;
        }

        return angle;
    }

    public static void main(String[] args) {

        int hours = rnd.nextInt(24);
        int minutes = rnd.nextInt(60);

        double angle2 = angle2(hours, minutes);
        double angle3 = angle3(hours,minutes);

        System.out.printf("Time %02d:%02d angle: %3.0f deg.\n", hours, minutes, angle2 * 180 / Math.PI);
        System.out.printf("Time %02d:%02d angle: %3.0f deg.\n", hours, minutes, angle3 * 180 / Math.PI);



    }

}
