//Order agnostic binary search

public int search(int[] arr, int k) {
    int low = 0, high = arr.length - 1, mid;
    while(low <= high) {
        mid = low + (high - low) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        if(arr[low] < arr[high]) {
            if (k < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else {
            if (k < arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
    return -1;
}