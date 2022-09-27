package listheirarchy;

public class DNode<E> {
	protected E	e;
	protected DNode<E>	next;
	protected DNode<E>	prev;
	
	@SuppressWarnings("unchecked")
	protected	DNode(){
		e= (E) new Object();
		next=null;
		prev=null;
	}
	
	protected	DNode(E e){
		this.e= e;
		next=null;
		prev=null;
	}
}
