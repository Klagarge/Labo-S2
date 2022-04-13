package lab14_recursivity;

public class HanoiTower {

    public static void main(String[] args) {
        hanoi(3, 'a', 'b', 'c');
    }

    public static void hanoi(int n, char start, char aux, char end){
        if (n != 0){
            hanoi(n-1, start, end, aux);
            System.out.println("Move disk " + n + " from " + start + "->" + end);
            hanoi(n-1, aux, start, end);
        }
    }
}
