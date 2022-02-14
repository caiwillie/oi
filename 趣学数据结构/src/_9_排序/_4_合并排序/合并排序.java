package _9_排序._4_合并排序;

class 合并排序 {

    void mergeSort(int[] nums, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while(i <= mid && j <= high) {
            if(nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while(i <= mid) temp[k++] = nums[i++];
        while(j <= high) temp[k++] = nums[j++];
        System.arraycopy(temp, 0, nums, low, temp.length);
    }
}
