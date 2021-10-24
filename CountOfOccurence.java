//Count of an element in sorted array

public int countOfElement(int[] arr, int k) {
    int firstIndex = binarySearch(arr, k, true);
    int lastIndex = binarySearch(arr, k, false);
    if (firstIndex != -1) {
        return lastIndex - firstIndex + 1;
    } else {
        return -1;
    }
    
}

int binarySearch(int[] arr, int k, boolean isFirst) {
    int low = 0, high = arr.length - 1, mid = -1;
    while (low <= high) {
        mid = low + (high - low) / 2;
        if (arr[mid] == k) {
            if (isFirst) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else if (k < arr[mid]) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return mid;
}