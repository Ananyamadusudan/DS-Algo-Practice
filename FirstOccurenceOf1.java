// Find the first occurence of 1 in a infinite sorted binary array

public int searchInfiniteArray(int [] arr) {
    int k = 1, low = 0, high = 1, newLow = 0;
    while (arr[high] < k) {
        newLow = high + 1;
        high = (high - low + 1) * 2;
        low = newLow;
    }
    return findFirstOccureence(arr, low, high);
}

int findFirstOccureence(int arr[], int low, int high) {
    int mid = 0;
    while (low <= high) {
        mid = low + (high - low) / 2;
        if (arr[mid] == 1) {
            high = mid - 1;
        } else if (arr[mid] < 1) {
            low = mid + 1;
        }
    }
    return mid;
}