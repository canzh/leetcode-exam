/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */
// https://leetcode.com/problems/next-greater-element-ii/description/

// algorithms	Medium (52.68%)	874	52

// Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

// Example 1:
// Input: [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number; 
// The second 1's next greater number needs to search circularly, which is also 2.
// Note: The length of given array won't exceed 10000.
// @lc code=start
class Solution {

    // from left to right
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < n)
                stack.push(i);
        }

        return res;
    }

    // from right to left
    // two pass:
    //  1st pass, process the numbers in the right
    //  2nd pass, correct errors from left part of array (circular)
    public int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    // js
    var nextGreaterElements = function(nums) {
        const ret = [];
        const stack = [];
    
        //paranoid base case.
        if (!nums || nums.length < 1) return ret;
        
        //normal case: while iterating over the array if we find an element which is  bigger
        //than one in the stack, set ret[`smaller element from stack`] to the current
        //larger element found.
        for (let i = 0; i < nums.length; i++) {
            while (stack.length > 0 && nums[stack[stack.length - 1]] < nums[i]) {
                const smallerEleIndexFromStack = stack.pop();
                ret[smallerEleIndexFromStack] = nums[i];
            }
            stack.push(i);
        }
    
        //Now, we again begin from the start of nums and deal with elements
        //for which we couldn't find a 'next bigger element' in the previous for loop
        //Example: nums = [1,4,2,1,2]. After the first loop, the stack would still hold the
        //indexes 1, 2 and 4 since we couldn't find next elements bigger than nums[1],
        //nums[2] and nums[4].
        for (let i = 0; i < nums.length; i++) {
            while (stack.length > 0 && nums[stack[stack.length - 1]] < nums[i]) {
                const smallerEleIndexFromStack = stack.pop();
                ret[smallerEleIndexFromStack] = nums[i];
            }
        }
    
        //Finally, still there would be some elements for which there was no 'next greater element'
        //In the case of nums = [1,4,2,1,2], 4 would be such an element. So we just go over the
        //remaining elements in the stack and assign -1 to them in ret array.
        const remaining = stack.length;
        for (let i = 0; i < remaining; i++) {
            ret[stack.pop()] = -1;
        }
    
        return ret;
    };
}
// @lc code=end
