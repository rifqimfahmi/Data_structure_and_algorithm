/**
 * Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. During his last hike he took exactly  steps. For every step he took, he noted if it was an uphill, , or a downhill,  step. Gary's hikes start and end at sea level and each step up or down represents a  unit change in altitude. We define the following terms:
 *
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.
 *
 * For example, if Gary's path is , he first enters a valley  units deep. Then he climbs out an up onto a mountain  units high. Finally, he returns to sea level and ends his hike.
 *
 * Function Description
 *
 * Complete the countingValleys function in the editor below. It must return an integer that denotes the number of valleys Gary traversed.
 *
 * countingValleys has the following parameter(s):
 *
 * n: the number of steps Gary takes
 * s: a string describing his path
 *
 * Input Format:
 * The first line contains an integer , the number of steps in Gary's hike.
 * The second line contains a single string , of  characters that describe his path.
 *
 * Output Format:
 * Print a single integer that denotes the number of valleys Gary walked through during his hike.Sample Input
 *
 * Sample:
 * input = 8, UDDDUDUU
 * output = 1
 * If we represent _ as sea level, a step up as /, and a step down as \, Gary's hike can be drawn as:
 * _/\      _
 *    \    /
 *     \/\/
 * He enters and leaves one valley.
 */


public class CountingValley {

    public static void main(String[] args) {
        System.out.println(count(12, "DDUUDDUDUUUD"));
    }

    // Create variable position that determine where he is
    // If U +1 if D -1
    // if pos == 0 and previous position is < 0 then he just came out of valley
    // increase valley count
    static int count(int n, String s) { // DU
        int previousPosition;
        int position = 0;
        int valley = 0;
        for (char tp : s.toCharArray()) {
            previousPosition = position;
            if (tp == 'U') {
                position += 1;
            } else if (tp == 'D') {
                position -= 1;
            }

            if (position == 0 && previousPosition < 0) {
                valley++;
            }
        }
        return valley;
    }
}
