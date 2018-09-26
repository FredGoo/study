package gyqw.xiaobaitu.sort;

/**
 * @author fred
 * @date 2018/06/28 15:55
 */
public class InsertionSortMain {
    public static void main(String[] args) {
        InsertionSortMain insertionSortMain = new InsertionSortMain();
        int[] arr = new int[]{31, 12, 99, 10, 29, 77};
        int[] res = insertionSortMain.sort(arr);
        System.out.println(res);
    }

    private int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] >= arr[j - 1]) {

                }
            }
        }

        return arr;
    }
}
