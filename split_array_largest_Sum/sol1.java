class Solution {
    static int max(int[]arr,int n){
        int max =Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,arr[i]);
        }
        return max;

    }
    static long sum(int[]arr,int n){
        long sum =0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        return sum;
    }
    static int cntsubarr(int arr[],int num){
        int n = arr.length;
        int cnt =1;
        int sum =0;
        for(int i=0;i<n;i++){
            if(sum+arr[i]<=num){
                sum+=arr[i];
            }else{
                cnt++;
                sum=arr[i];
            }

        }
        return cnt;

    }
    public int splitArray(int[] arr, int k) {
        int n = arr.length;
        if(n<k){
            return -1;
        }
        int low = max(arr,n);
        long high = sum(arr,n);
        while(low<=high){
            int mid = (int)(low +(high-low)/2);
            int cnt = cntsubarr(arr,mid);
            if(cnt <=k){
                high = mid-1;
            }else{
                low=mid+1;
            }
             
        }
        return low;
        
    }
}
