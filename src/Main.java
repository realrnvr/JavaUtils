import CustomUtil.CustomArrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        boolean allTestsPassed = true;

        // Test 1: Initial size should be 0
        if (list.isEmpty()) {
            System.out.println("Test 1 Passed ✅");
        } else {
            System.out.println("Test 1 Failed ❌");
            allTestsPassed = false;
        }

        // Test 2: Adding elements
        list.add(10);
        list.add(20);
        list.add(30);
        if (list.size() == 3 && list.get(0) == 10 && list.get(1) == 20 && list.get(2) == 30) {
            System.out.println("Test 2 Passed ✅");
        } else {
            System.out.println("Test 2 Failed ❌");
            allTestsPassed = false;
        }

        // Test 3: Inserting at a specific index
        list.add(1, 15); // [10, 15, 20, 30]
        if (list.size() == 4 && list.get(1) == 15 && list.get(2) == 20) {
            System.out.println("Test 3 Passed ✅");
        } else {
            System.out.println("Test 3 Failed ❌");
            allTestsPassed = false;
        }

        // Test 4: Removing elements
        list.remove(1); // [10, 20, 30]
        if (list.size() == 3 && list.get(1) == 20) {
            System.out.println("Test 4 Passed ✅");
        } else {
            System.out.println("Test 4 Failed ❌");
            allTestsPassed = false;
        }

        // Test 5: Checking contains()
        if (list.contains(20) && !list.contains(100)) {
            System.out.println("Test 5 Passed ✅");
        } else {
            System.out.println("Test 5 Failed ❌");
            allTestsPassed = false;
        }

        // Test 6: Checking indexOf()
        if (list.indexOf(30) == 2 && list.indexOf(100) == -1) {
            System.out.println("Test 6 Passed ✅");
        } else {
            System.out.println("Test 6 Failed ❌");
            allTestsPassed = false;
        }

        // Test 7: Checking isEmpty()
        if (!list.isEmpty()) {
            System.out.println("Test 7 Passed ✅");
        } else {
            System.out.println("Test 7 Failed ❌");
            allTestsPassed = false;
        }

        // Test 8: Clearing the list
        list.clear();
        if (list.isEmpty()) {
            System.out.println("Test 8 Passed ✅");
        } else {
            System.out.println("Test 8 Failed ❌");
            allTestsPassed = false;
        }

        // Final test result
        if (allTestsPassed) {
            System.out.println("\n🎉 All tests passed successfully! 🎉");
        } else {
            System.out.println("\n⚠️ Some tests failed. Check the output for details. ⚠️");
        }
    }
}