public class Ex06 {
    public static void main(String[] args) {
        int[] nums = new int[3];

        for (int i = 0; i < 3; i++) {
            nums[i] = (int) Math.floor(Math.random() * 10);
        }

        System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
        System.out.println(nums[0] + " " + nums[2] + " " + nums[1]);
        System.out.println(nums[1] + " " + nums[0] + " " + nums[2]);
        System.out.println(nums[1] + " " + nums[2] + " " + nums[0]);
        System.out.println(nums[2] + " " + nums[0] + " " + nums[1]);
        System.out.println(nums[2] + " " + nums[1] + " " + nums[0]);
    }
}
