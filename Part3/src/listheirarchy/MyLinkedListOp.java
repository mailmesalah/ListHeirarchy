package listheirarchy;

public class MyLinkedListOp<E> extends MyLinkedList<E> {

	public MyLinkedListOp(){
		
	}
	
	public MyLinkedListOp(E[] eArr){
		super(eArr);
	}
	
	public void clear(){
		head=null;
		tail=null;
		size=0;
	}
	
	public java.lang.String toString(){
		return toString();
	}
}
