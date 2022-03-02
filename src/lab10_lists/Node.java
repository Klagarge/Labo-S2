package lab10_lists;

public class Node {
    String item;
    Node next;

    Node(String item, Node next){
        this.item = item;
        this.next = next;
    }
    Node(Node node){
        this.item = node.item;
        this.next = node.next;
    }
    Node(String item){
        this.item = item;
        this.next = null;
    }
}
