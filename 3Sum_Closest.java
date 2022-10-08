public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int len = nums.length;
    if(nums[len-3]+nums[len-2]+nums[len-1]<=target) return nums[len-3]+nums[len-2]+nums[len-1];//short  cut
    if(nums[0] + nums[1] + nums[2]>=target) return nums[0] + nums[1] + nums[2];//short cut
    int closest = nums[0] + nums[1] + nums[len - 1];
    for(int s = 0;s<len - 2;s++){
        if(s!=0&&nums[s-1]==nums[s]) continue;
        if(nums[s]+nums[len-1]+nums[len-2]<target&&s<len-3){//short cut
            closest = Math.abs(closest-target)>target - (nums[s]+nums[len-1]+nums[len-2])?nums[s]+nums[len-1]+nums[len-2]:closest;
            continue;
        }
        if(nums[s]+nums[s+1]+nums[s+2]>target){//short cut
            closest = Math.abs(closest-target)>(nums[s]+nums[s+1]+nums[s+2])-target?nums[s]+nums[s+1]+nums[s+2]:closest;
            break;
        }
        int newTarget = target - nums[s];
        int m = s+1;
        int b = len - 1;
        while(m<b){
            while(m!=s+1&&nums[m-1]==nums[m]&&m+1<b)m++; //skip duplicates
            while(b!=len-1&&nums[b+1]==nums[b]&&b-1>m)b--; //skip duplicates
            if(nums[m]+nums[b]<newTarget){
                closest = Math.abs(closest-target)>newTarget - nums[m] - nums[b]?nums[s]+nums[m]+nums[b]:closest;
                m++;
            }
            else if(nums[m]+nums[b]>newTarget){
                closest = Math.abs(closest-target)>nums[m] + nums[b] - newTarget?nums[s]+nums[m]+nums[b]:closest;
                b--;
            }
            else{        
                return target;
            }
            
        }
    }
    return closest;
}
