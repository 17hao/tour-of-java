package thinkinginjava.chapter16_arrays;

public class CopyArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] ref = {new Integer(1), new Integer(2)};
        int[] res = new int[4];
        System.arraycopy(arr, 0, res, 0, arr.length);
        System.out.println(arr == res); // false
        System.arraycopy(arr,0, res, 0, arr.length);
        System.out.println(arr == res);
    }
}
