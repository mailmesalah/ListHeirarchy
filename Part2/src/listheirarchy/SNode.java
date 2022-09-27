package listheirarchy;

public class SNode<E> {
	protected E	e;
	protected SNode<E>	next;

	protected SNode(E e){
		this.e=e;
	}
	
	@SuppressWarnings("unchecked")
	protected SNode(){
		this.e=(E) new Object();
	}
}
