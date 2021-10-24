//Number of times an array is rotated

public int countRotations(int[] arr) {
    int low = 0, high = arr.length - 1, mid;
    while(low <= high) {
        mid = low + (high - low) / 2;
        if (mid < high && arr[mid] > arr[mid + 1]) {
            return mid + 1;
        } else if (mid > low && arr[mid - 1] > arr[mid]) {
            return mid;
        }
        if (arr[mid] < arr[high]) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
     return 0;
}