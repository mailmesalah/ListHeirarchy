package listheirarchy;

public class MyDLinkedListOp<E> extends MyDLinkedList<E> {
	
	public MyDLinkedListOp(){
		super();
	}
	
	public MyDLinkedListOp(E[] eArr){
		super(eArr);
	}
	
	public E getLast(){
		return super.getLast();
	}
	
	public void clear(){
		head=null;
		tail=null;
		size=0;
	}
	
	public java.lang.String toString(){
		return super.toString();
	}
}
