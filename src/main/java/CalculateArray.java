public class CalculateArray {


    public static float[] calculate(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }
    public static float[] calculate(float[] arr, int startingIndex){
        int j;
        for (int i = 0; i < arr.length; i++) {
            j = i + startingIndex;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
        return arr;
    }
}
