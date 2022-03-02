package lab10_lists;

import java.util.Vector;

public class App {
    public static void main(String[] args) throws Exception {
        // 1
        Vector<String> v = new Vector<>();
        v.add("Louis");
        v.add("Paul");
        v.add("Henri");
        v.add("Pascal");

        // 2
        System.out.println("2: " + v.toString());

        // 3
        System.out.print("3: ");
        if(v.contains("Paul")){
            System.out.println("Paul is on this list");
        } else {
            System.out.println("Paul is not on this list");
        }

        // 4
        v.remove("Paul");

        // 5
        System.out.println("5: " + v.toString());

    }
}
