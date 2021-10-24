//Search in a sorted rotated array
public int search(int[] nums, int target) {
        int l = 0, h = nums.length -1, mid = 0;
        while(l <= h) {
            mid = (l+h)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] <= nums[h]) {
                if (target > nums[mid] && target <= nums[h]) {
                   l = mid + 1;
                } else {
                    h = mid - 1;
                }
                
            } else {
                if (target >= nums[l] && target < nums[mid]) {
                    h = mid -1;
                } else {
                   l = mid + 1;
                }
            }
        
        }
        
        return -1;
    }