package tools;

public class Chrono {
    private long start, end, total;
    private String name = null;
    
    public Chrono(String name){
        this.name = name;
        start = System.nanoTime();
    }
    public Chrono(){
        start = System.nanoTime();
    }

    /**
     * Stop the chrono and return the total time in us
     * @return the total length in us
     */
    public long stop(){
        end = System.nanoTime();
        total = (long) ((end - start)/1000.0);
        return total;
    }

    public String toString(){
        String s = "";
        if (name == null){
            s += total;
            s += " uS"; 
        } else {
            s += name;
            s += " : \t";
            s += total;
            s += " uS";
        }
        return s;
    }
}
