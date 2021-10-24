//Search in row wise and column wise sorted array

public int[] searchMatrix(int[][] arr, int key) {
    
    int m= arr.length, n = arr[0].length;
    int res[] = new int[2];
    int i = 0,j = n - 1;
    while (i < m && j >= 0) {
        if (key == arr[i][j]) {
            res[0] = i;
            res[1] = j;
            return res;
        } else if (key < arr[i][j]) {
            j--;
        } else {
            i++;
        }
    }
    res[0] = -1;
    res[1] = -1;
    return res;
    
}