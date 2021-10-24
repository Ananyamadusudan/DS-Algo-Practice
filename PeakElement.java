//Find peak element in an unsorted array

public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid > low && nums[mid] > nums[mid - 1]
               && mid < high && nums[mid] > nums[mid + 1])  {
                return mid;
            }  else if (mid < high && nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }     
            
        }
        return mid;
        
    }
}