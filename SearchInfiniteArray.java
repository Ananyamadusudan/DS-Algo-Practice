//Search an element in an infinte sorted array

public int search(int[] arr, int key) {
    int low = 0, high = 1, newLow = 0;
    while (key > arr[high]) {
        newLow = high + 1;
        high = (high - low + 1) * 2;
        low = newLow;
    }
    return binarySearch(arr, low, high, key);
}

int binarySearch(int[] arr, int low, int high, int key) {
    int mid = 0;
    while (low <= high) {
        mid = low + (high - low) / 2;
        if (arr[mid] == high) {
            return mid;
        } else if (key < arr[mid]) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return -1;
}