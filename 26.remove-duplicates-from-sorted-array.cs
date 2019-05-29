/*
 * @lc app=leetcode id=26 lang=csharp
 *
 * [26] Remove Duplicates from Sorted Array
 */
public class Solution
{
    public int RemoveDuplicates(int[] nums)
    {
        if (nums == null || nums.Length == 0) return 0;

        int head = 1;
        int curr = nums[0];

        for (int i = 1; i < nums.Length; i++)
        {
            while (i < nums.Length && nums[i] == curr) i++;

            if (i >= nums.Length) break;

            nums[head] = nums[i];
            head += 1;
            curr = nums[i];
        }

        return head;
    }
}

