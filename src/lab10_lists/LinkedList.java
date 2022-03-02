package lab10_lists;

public class LinkedList {
    // Task 2
    public Node head;
    public Node tail;

    public LinkedList(){
        this.head = null;
    }

    public void addToStart(String s){
        Node n = new Node(s, head);
        head = n;
    }
    
    public int getSize(){
        Node foo = head;
        int n = 0;
        while (foo != null) {
            n++;
            foo = foo.next;
        }
        return n;
    }

    public String toString(){
        Node foo;
        if( this.head == null){
            foo = new Node(null, null);
        } else {
            foo = new Node(head);
        }
        String s = "";
        s += "List content (size " + this.getSize() + ") : ";
        for (int i = 0; i <= this.getSize(); i++) {
            if (i>0) {
                s += " -> ";
            }
            if(foo == null){
                s += "null";
            } else {
                s += foo.item;
                foo = foo.next;
            }
        }

        return s;
    }


    // Task 3

    public void removeFirstElement(){
        if(head == null) return;
        Node foo = new Node(head);
        this.head = foo.next;
    }

    public Node getLastElement(){
        if(head == null) return null;
        Node tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }
        return tailNode;
    }

    public void addToEnd(String element){
        Node newNode = new Node(element);
        if(head == null) {
            head = newNode;  
            tail = newNode;  
        }  
        else {
            tail.next = newNode;
            tail = newNode;  
        }
    }

    public boolean isPresent(String e){
        if(head == null) return false;
        boolean present = false;
        Node foo = new Node(head);
        while (foo != null) {
            if (foo.item.equals(e)) {present = true;}
            foo = foo.next;
        }
        return present;
    }


    // Task 4

    public Node findElement(String s){
        if(head == null) return null;
        Node tailNode = head;
        while (tailNode != null) {
            if(tailNode.item.equals(s)) return tailNode;
            tailNode = tailNode.next;
        }
        return null;
    }

    public void swapElements(String e1, String e2){
        Node n1 = findElement(e1);
        Node n2 = findElement(e2);
        if(n1!=null && n2!=null){
            n1.item = e2;
            n2.item = e1;
        }
    }

    public void removeLastElement(){
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node n = head;
        while (n.next.next != null) {
            n = n.next;
        }
        n.next = null;
    }

    public void removeElement(String e){
        Node n = head;
        Node prev = null;
        if (n != null && n.item.equals(e)) {
            head = n.next; // Changed head
            return;
        }
        while (n != null && !n.item.equals(e)) {
            prev = n;
            n = n.next;
        }
        if (n == null) return;
        prev.next = n.next;
    }

    public void insertAfter(String  before,  String  after){
        if(head == null) return;
        if(before == null) return;
        if(after == null) return;
        Node prevNode = findElement(before);
        if(prevNode == null) return;
        Node newNode = new Node(after, prevNode.next);
        prevNode.next = newNode;
    }



    public static void main(String[] args) {
        LinkedList flightList = new LinkedList();
        System.out.println(flightList);
        flightList.addToEnd("Bonn");
        System.out.println(flightList);
        flightList.addToEnd("Zurich");
        System.out.println(flightList);
        flightList.addToEnd("Rome");
        System.out.println(flightList);
        System.out.println(flightList);
        flightList.removeFirstElement();
        System.out.println(flightList);
        flightList.addToEnd("London");
        System.out.println(flightList);
        flightList.swapElements("Rome", "London");
        System.out.println(flightList);
        flightList.removeLastElement();
        System.out.println(flightList);
        flightList.removeLastElement();
        System.out.println(flightList);
        flightList.removeLastElement();
        System.out.println(flightList);
        flightList.removeLastElement();
        System.out.println(flightList);
    }
}
