package Solutions;

public class MedianOfTwoSortedArrays {
    public void swap(int[] nums1, int[] nums2){
        int[] nums1Copy = nums1;
        nums1 = nums2;
        nums2 = nums1Copy;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            swap(nums1,nums2);
        }

        int m = nums1.length;
        int n = nums2.length;

        int st = 0;
        int end = m-1;

        while(st <= end){
            int mid = st - (st-end)/2;
            int j = ((m+n)/2 - (mid+1))-1;

            int a1 = nums1[mid];
            int a2 = mid+1 < m ? nums1[mid+1]: Integer.MAX_VALUE;

            int b1 = (j>=0 && j < n) ? nums2[j] : Integer.MIN_VALUE;
            int b2 = (j+1 >= 0 && j+1 < n) ? nums2[j+1] : Integer.MAX_VALUE;

            if(a1 <= b2 && b1 <= a2){
                if((m+n)%2 == 0){
                    return ((double)Math.max(a1,b1) + (double)Math.min(a2,b2))/2;
                } else{
                    return (double)Math.min(a2,b2);
                }
            } else if(a1 > b2){
                end = mid - 1;
            } else if(b1 > a2){
                st = mid + 1;
            }
        }

        int middle = (m+n)/2;

        if((m+n)%2 == 0){
            return ((double)nums2[middle] + (double)nums2[middle + 1])/2;
        }
        return (double)nums2[middle];

    }

    public static void main(String[] args){
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[]{2};
        int[] nums2 = new int[]{};
        medianOfTwoSortedArrays.findMedianSortedArrays(nums1,nums2);
    }
}
