package avramenko.lab01.fillers;

/**
 * <h1>LengthGenerator</h1>
 * <p>LengthGenerator class creating array with growing lengths.</p>
 *
 * @author Avramenko Kateryna
 * @version 1.3
 */

public class LengthGenerator {

    /**
     * Generate int[] array with length 13, which consists lengths for arrays for sorting.
     * This array consists powers of 2.
     * Elements of this array [2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192]
     *
     * @return array with growing lengths
     */

    public static int[] generateLength() {
        int[] arrayLength = new int[13];
        arrayLength[0] = 2;
        for (int i = 1; i < 13; i++) {
            arrayLength[i] = arrayLength[i - 1] * 2;
        }
        return arrayLength;
    }
}
