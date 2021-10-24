//Search in a nearly sorted array

public int searchNearlySorted(int[] arr, int x) {
    int low = 0, high = arr.length - 1, mid;
    while(low <= high) {
        mid = low + (high - low) / 2;
        if (arr[mid] == x) {
            return mid;
        } else if (mid > start && arr[mid - 1] == x) {
            return mid - 1;
        } else if (mid < high && arr[mid + 1] == x) {
            return mid + 1;
        } else if (arr[mid] > x) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return -1;
}