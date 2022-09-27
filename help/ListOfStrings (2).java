public class ListOfStrings {
    public static final int DEFAULT_CAPACITY = 4;
    private String[] names;
    private int size = 0;
    
    public ListOfStrings(){
        this(DEFAULT_CAPACITY);
    }
    
    public ListOfStrings(int initialCapacity){
        names = new String[initialCapacity];
    }
    
    public int getCapacity(){
        return names.length;
    }
    
    public int getSize(){
        return size;
    }
    
    // Adds name to the end of the list
    public void add(String name){
        if(this.getSize() == this.getCapacity()){
            // Double the size of the array
            String[] temp = new String[this.getCapacity()*2];
            System.arraycopy(names, 0, temp, 0, this.getCapacity());
            names = temp;
        }
        
        names[size] = name;
        size++;
    }
    
    // set item i to the given name
    public void set(int i, String name){
        if(i < 0 || i > this.getSize() - 1){
            // we have a problem
            String message = "index " + i +" not valid";
            throw new IndexOutOfBoundsException(message);
        }
        
        names[i] = name;
    }
    
    // returns the item at index i
    public String get(int i){
        if(i < 0 || i > this.getSize() - 1){
            // we have a problem
            String message = "index " + i +" not valid";
            throw new IndexOutOfBoundsException(message);
        }
        
        return names[i];
    }
    
    public int getIndex(String s){
        for(int i = 0; i < this.getSize(); i++){
            if(this.get(i).equals(s)){
                return i;
            }
        }
        return -1;
    }

    public String remove(String s){
        int index = getIndex(s);
        if(index < 0){
            return null;
        } else {
            return remove(index);
        }
    }
    
    public String removeFirst(){
        if(this.size == 0){
            return null;
        }
        return remove(0);
    }
    
    public String removeLast(){
        if(this.size == 0){
            return null;
        }
        return remove(this.getSize() - 1);
    }

    // removes and returns item i from the list
    public String remove(int i){
        if(i < 0 || i > this.getSize() - 1){
            // we have a problem
            String message = "index " + i +" not valid";
            throw new IndexOutOfBoundsException(message);
        }
        
        String removedItem = this.get(i); // save item to return
        
        // now adjust the array
        if(i < size - 1){
            System.arraycopy(names, i+1, names, i, size-i-1);
        }
        size--;
        
        return removedItem;
    }
    
    public void compress(){
        String[] temp = new String[this.getSize()];
        System.arraycopy(names, 0, temp, 0, this.getSize());
        names = temp;
    }
    
    public void ensureCapacity(int newCapacity){
        if(this.getCapacity() < newCapacity){
            String[] temp = new String[newCapacity];
            System.arraycopy(names, 0, temp, 0, this.getSize());
            names = temp;
        }
    }
    
    public void clear(){
        names = new String[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString(){
        String s = toString1();
        s += " - (" + getSize() + " / " + getCapacity() + ")";
        return s;
    }
    
    public String toString1(){
        String s = "";
        s += "[";
        boolean first = true;
        for(int i = 0; i < size; i++){
            if(first){
                s += names[i];
                first = false;
            } else {
                s += ", ";
                s += names[i];
            }
        }
        s += "]";
        
        return s;
    }
}
