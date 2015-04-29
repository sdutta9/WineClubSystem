
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator implements java.io.Serializable{
    private static AtomicInteger nextID = new AtomicInteger();;
    
    public static void setID(int x){
        nextID.set(x);
    }
    public static int getID(){
        return nextID.get();
    }
    
    public static int newID() {
        return nextID.getAndIncrement();
    }

}
