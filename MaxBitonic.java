//Find Max element in a bitonic array

public int findMax(int[] arr) {
    int low = 0, high = arr.length - 1, mid = 0;
    while (low < high) {
        mid = low + (high - low) / 2;
        if (arr[mid] > arr[mid + 1]) {
            return arr[mid];
        } else {
            low = mid + 1;
        }
    }
    return arr[low];
}