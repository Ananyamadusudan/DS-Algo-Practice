//Find floor of an element

public int floorOfAnElement(int arr[], int k) {
    int low = 0, high = arr.length - 1, mid, min;
    while(low <= high) {
        mid = low + (high - low) / 2;
        if (arr[mid] == k) {
            return mid;
        } else if (k - arr[mid] < 0) {
            high = mid - 1;
        } else {
            min = Math.min(min, k - arr[mid]);
            low = mid + 1;
        }
    }
    return min;
}