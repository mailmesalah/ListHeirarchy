package listheirarchy;

public class MyLinkedList<E> extends MyAbstractList<E> {

	protected SNode<E> head;
	protected SNode<E>tail;
	
	@SuppressWarnings("unchecked")
	public MyLinkedList() {
		head=null;
		tail=null;
	}
	
	public MyLinkedList(E[] eArr){
		head=null;
		tail=null;
		size=eArr.length;
		if(size>0){
			SNode<E> temp = head;
			for (int i = 0; i < eArr.length; i++) {
				SNode<E> newNode=new SNode<>();
				newNode.e=eArr[i];
				newNode.next=null;
				if(temp==null){
					temp=newNode;
					head=temp;					
				}else{
					temp.next=newNode;
					temp=newNode;
				}
				
				tail=temp;
			}
		}
	}
	
	@Override
	public E get(int i) throws IndexOutOfBoundsException {		
		if(i<0||i>=(size())){
			throw new IndexOutOfBoundsException();
		}
		SNode<E> temp=head;	
		for (int j = 0; j < size; j++) {
			if(j==i){				
				return temp.e;				
			}
			temp=temp.next;
		}
		
		return null;
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {		
		if(i<0||i>size()){
			throw new IndexOutOfBoundsException();
		}		
		
		
		SNode<E> nextNode=head;
		SNode<E> prevNode=head;
		++size;			
		for (int j = 0; j < size; j++) {
			if(j==i){
				SNode<E> newNode=new SNode<>();
				newNode.e=e;				
				if(nextNode!=head){
					prevNode.next=newNode;
					newNode.next=nextNode;
				}else{
					newNode.next=head;
					head=newNode;
					tail=newNode;					
				}
				break;
			}
			
			//next node
			prevNode=nextNode;
			nextNode=nextNode.next;			
		}		
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if(i<0||i>(size()-1)){
			throw new IndexOutOfBoundsException();
		}

		SNode<E> temp=head;
		for (int j = 0; j < size; j++) {
			if(j==i){
				E retV=temp.e;
				temp.e=e;
				return retV;				
			}
			temp=temp.next;
		}
		
		return null;
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		if(i<0||i>=size()){
			throw new IndexOutOfBoundsException();
		}
		
		SNode<E> nextNode=head;
		SNode<E> prevNode=head;
		E retE=null;		
		for (int j = 0; j < size; j++) {
			if(j==i){
				retE=nextNode.e;
				
				if(nextNode!=head){
					prevNode.next=nextNode.next;
				}else{
					head=nextNode.next;
					tail=nextNode.next;
				}
				break;
			}
			
			//next node
			prevNode=nextNode;
			nextNode=nextNode.next;			
		}
		--size;
		
		return retE;
	}

	@Override
	public int firstIndexOf(E e) {		
		SNode<E> temp=head;
		for (int j = 0; j < size; j++) {
			if(temp.e==e){
				return j;				
			}
			temp=temp.next;
		}
		
		return -1;		
	}

	@Override
	public int lastIndexOf(E e) {
		int index=-1;
		SNode<E> temp=head;
		for (int j = 0; j < size; j++) {
			if(temp.e==e){
				index=j;				
			}
			temp=temp.next;
		}
		
		return index;
	}
		
}
