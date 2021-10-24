//Find the minimum difference of a key element in a sorted array

public int minimumDifference(int[] arr, int key) {
    if (key <= arr[0]) {
        return arr[0];
    } else if (key >= arr[arr.length - 1]) {
        return arr[arr.length - 1];
    }
    int low = 0, high = arr.length - 1, mid;
    while (low <= high) {
        mid = low + (high - low) / 2;
        if (key < arr[mid]) {
            high = mid - 1;
        } else if (key > arr[mid]) {
            low = mid + 1;
        } else {
            return mid;
        }
    }
    if (Math.abs(arr[low] - key) < Math.abs(arr[high] - key)) {
        return arr[low];
    } else {
        return arr[high];
    }
}