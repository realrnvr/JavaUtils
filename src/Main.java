import CustomUtil.HashMap.CustomHashMap;


public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 7, 5, 3, 7};
        CustomHashMap<Integer, Integer> ref = new CustomHashMap<>();

        for (int j : arr) {
            ref.put(j, ref.getOrDefault(j, 0) + 1);
        }

        System.out.println(ref.containsKey(10));
        System.out.println(ref.containsKey(1));
        System.out.println(ref.containsValue(2));

        System.out.println(ref);
    }
}