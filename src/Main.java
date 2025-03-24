import CustomUtil.HashMap.CustomHashMap;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CustomHashMap<Integer, Integer> ref = new CustomHashMap<>();

        ref.put(1, 2);
        ref.put(2, 4);
        ref.put(3, 6);
        ref.put(4, 8);

        System.out.println(ref.get(1));
        System.out.println(ref.get(2));
        System.out.println(ref.get(3));
        System.out.println(ref.get(4));

        ref.remove(3);

        System.out.println(ref.get(3));

        System.out.println(ref);
    }
}