package avramenko.lab01.fillers;

public class GenerateLength {

    public static int[] generateLength(){
        int[] arrayLength = new int[13];
        arrayLength[0] = 2;
        for(int i = 1; i < 13 ; i++){
            arrayLength[i] = arrayLength[i-1] * 2;
        }
        return arrayLength;
    }
}
