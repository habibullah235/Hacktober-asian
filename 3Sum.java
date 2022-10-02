class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        int len = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        
        for(int i=0;i<nums.length-1;i++) {
            if(i!=0)
            if(nums[i]==nums[i-1])
                continue;
            int j = i+1;
            int k = len-1;
            
            while(j<k) {
                int val = nums[i]+nums[j]+nums[k];
                //if(nums[j-1]==nums[j] && nums[k-1]==nums[k])
                  //  continue;
                if(val == 0) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    --k;
                    ++j;
                }
                else if(val<0)
                    ++j;
                else
                    --k;
            }
        }
        
        
        return new ArrayList<>(set);
    }
}
