
import java.util.Set;

public class ListTester {
    public static void main(String[] args) {
        ListOfStrings L = new ListOfStrings();

        // Add items until the capacity is increased
        System.out.println("\n------- Add List Items -----------------------");
        L.add("A");
        L.add("B");
        L.add("C");
        L.add("D");
        L.add("E");
        System.out.println(L);

        System.out.println("\n------- Set List Items -----------------------");
        L.set(0, "X");
        L.set(1, "Y");
        L.set(2, "Z");
        System.out.println(L);
        
        System.out.println("\n------- Get List Items -----------------------");
        System.out.println(L.get(0) + " - " + L.get(1) + " - " + L.get(4));
        
        System.out.println("\n------- Remove First and Last ----------------");
        System.out.println(L.removeFirst() + " is removed. " + L);
        System.out.println(L.removeLast() + " is removed. " + L);
        
        System.out.println("\n------- Compress -----------------------------");
        L.compress();
        System.out.println(L);
        
        System.out.println("\n------- Ensure Capacity ----------------------");
        L.ensureCapacity(5);
        System.out.println(L);
        
        L.ensureCapacity(2);
        System.out.println(L);
        
        System.out.println("\n------- Get Index ----------------------------");
        System.out.println("A is at " + L.getIndex("A"));
        System.out.println("B is at " + L.getIndex("B"));
        System.out.println("C is at " + L.getIndex("C"));
        System.out.println("D is at " + L.getIndex("D"));
        System.out.println("E is at " + L.getIndex("E"));
        
        System.out.println("\n------- Remove (String s) --------------------");
        System.out.println(L.remove("B") + " is removed. " + L);
        System.out.println(L.remove("X") + " is removed. " + L);
        System.out.println(L.remove("C") + " is removed. " + L);
        System.out.println(L.remove("D") + " is removed. " + L);
        System.out.println(L.remove("Y") + " is removed. " + L);
        System.out.println(L.remove("Z") + " is removed. " + L);

        System.out.println("\n------- Remove (int i) -----------------------");
        L.add("A");
        L.add("B");
        L.add("C");
        L.add("D");
        L.add("E");
        System.out.println(L);
        System.out.println("remove 0, " + L.remove(0) + " is removed. " + L);
        System.out.println("remove 1, " + L.remove(1) + " is removed. " + L);
        System.out.println("remove 2, " + L.remove(2) + " is removed. " + L);
        System.out.println("remove 0, " + L.remove(0) + " is removed. " + L);
        System.out.println("remove 0, " + L.remove(0) + " is removed. " + L);
        
        System.out.println("\n------- Remove First/Last from empty list ----");
        System.out.println(L.removeFirst() + " is removed. " + L);
        System.out.println(L.removeLast() + " is removed. " + L);
        
        System.out.println("\n------- Clear --------------------------------");
        L = new ListOfStrings(7);
        char ch = 'A';
        for(int i = 0; i < L.getCapacity() - 2; i++){
            L.add("" + ch++);
        }
        System.out.println(L);
        
        L.clear();
        System.out.println(L);
    }
    
    
}

