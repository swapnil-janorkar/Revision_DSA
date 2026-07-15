public class merge_sort {
    public static void main(String[] args) {
        int []nums={5,4,3,2,1};
        merge_sort obj = new merge_sort();
        obj.mergeSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        
    }
    private void mergeSort(int[] arr, int s, int e) {
        if(s>=e){
            return;
        }
        int m = s + (e - s) / 2;
        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);
        merge(arr, s, e, m);
    }
    private int[] merge(int[] arr, int s, int e, int m) {
        int[] temp = new int[e - s + 1];
        int p1 = s; int p2 = m + 1;
        int p3 = 0;
        while (p1 <= m && p2 <= e) {
            if (arr[p1] <= arr[p2]) {
                temp[p3] = arr[p1];
                p1++;
            } else {
                temp[p3] = arr[p2];
                p2++;
            }
            p3++;
        }

        if (p1 <= m) {
            while (p1 <= m) {
                temp[p3] = arr[p1];
                p1++;
                p3++;
            }
        } else {
            while (p2 <= e) {
                temp[p3] = arr[p2];
                p2++;
                p3++;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            arr[s + i] = temp[i];
        }
        return temp;


    

    }
    
}
