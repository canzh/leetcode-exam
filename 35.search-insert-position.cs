/*
 * @lc app=leetcode id=35 lang=csharp
 *
 * [35] Search Insert Position
 */
public class Solution
{
    public int SearchInsert(int[] nums, int target)
    {
        int front = 0;
        int tail = nums.Length - 1;

        while (front <= tail)
        {
            int mid = front + (tail - front) / 2;

            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] < target)
            {
                front = mid + 1;
            }
            else if (nums[mid] > target)
            {
                tail = mid - 1;
            }
        }

        return front;
    }
}

