package labWork.WeekSeven;

public class LabThree {
	public static void main(String[] args) {
		int[] nums = { 123, 456, 479, 135, 246, 135 };
		int low = 0, hold, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (nums[i] < nums[j]) {
					hold = nums[j];
					nums[j] = nums[i];
					nums[i] = hold;
					i = 0;
					break;
				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
			sum += nums[i];
		}
		System.out.println("\nAverage = " + (sum / nums.length));
	}
}
