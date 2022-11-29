package elisa.demo.endpoint;

public class FindSmallestPositive {

    private static void swap(int[] numbers, int i, int j)
    {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static int partition(int[] numbers, int size)
    {
        int positiveIndex = 0;
        for (int i = 0; i < size; i++)
        {
            if (numbers[i] > 0) {
                swap(numbers, i, positiveIndex);
                positiveIndex++;
            }
        }
        return positiveIndex; // Index of negative number that was not overwritten
    }



    public static int findSmallestMissing(int[] nums)
    {
        int size = nums.length;
        int indexOfNegativeNumbers = partition(nums, size);

        // use indexes to store checked values
        for (int i = 0; i < indexOfNegativeNumbers; i++)
        {
            int val = Math.abs(nums[i]); // make values absolute because it might be already marked
            if (val-1 < indexOfNegativeNumbers && nums[val-1] >= 0) {
                nums[val-1] = -nums[val-1]; // mark value
            }
        }

        for (int i = 0; i < indexOfNegativeNumbers; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return indexOfNegativeNumbers + 1;
    }
}
