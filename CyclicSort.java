//Cyclic sort to find missing and duplicate numbers

public List<MissingDuplicate> findMissingAndDuplicate(int arr[]) {
    int temp;
    int i = 0;
    while ( i < arr.length) {
        // check if the element at ith index is at its right position
        // otherwise swap the element to bring element to proper position such that arr[i] = i + 1
        if (arr[i] != arr[arr[i] - 1]) {
            temp = arr[arr[i] - 1];
            arr[arr[i] - 1] = arr[i];
            arr[i] = temp;
        } else {
            //if the element is already in its correct position then move forward
            i++;
        }
    }
    List<MissingDuplicate> res = new ArrayList<>();
    for ( i = 0; i < arr.length; i++) {
        if (arr[i] != i + 1) {
            MissingDuplicate missing = new MissingDuplicate(i + 1, arr[i]);
            res.add(missing);
        }
    }
    return res
}

public class MissingDuplicate {
    private int missing;
    private int duplicate;

    MissingDuplicate(int missing, int duplicate) {
        this.missing = missing;
        this.duplicate = duplicate;
    }
    
    public int getMissing() {
        return this.missing;
    }
    public int getDuplicate() {
        return this.duplicate;
    }


}