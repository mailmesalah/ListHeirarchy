package listheirarchy;

public class MyDLinkedList<E> extends MyAbstractList<E> {
	protected DNode<E>	head;
	protected DNode<E>	tail;
	
	public MyDLinkedList(){
		head=null;
		tail=null;
	}
	
	public MyDLinkedList(E[] eArr){
		for (int i = 0; i < eArr.length; i++) {
			add(eArr[i]);
		}
		size=eArr.length;
	}
	
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		if(i<0||i>=(size())){
			throw new IndexOutOfBoundsException();
		}
		
		DNode<E> temp=head;
		
		for (int j = 0; j < size(); j++) {
			if(i==j){
				return temp.e;
			}
			temp=temp.next;
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if(i<0||i>(size())){
			throw new IndexOutOfBoundsException();
		}
		++size;
		DNode<E> temp=head;
		DNode<E> prev=head;
		for (int j = 0; j < size(); j++) {
			if(i==j){
				DNode newNode= new DNode<>();
				newNode.e=e;
				if(temp!=head){
					newNode.next=temp;			
					newNode.prev=prev;
					prev.next=newNode;
					if(temp!=null){						
						temp.prev=newNode;
					}else{
						tail=newNode;
					}
				}else{					
					newNode.next=temp;				
					if(temp!=null){					
						temp.prev=newNode;
					}
					head=newNode;
					tail=newNode;
				}
				break;
			}
			prev=temp;
			temp=temp.next;
		}
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if(i<0||i>(size()-1)){
			throw new IndexOutOfBoundsException();
		}
		
		DNode<E> temp=head;
		
		for (int j = 0; j < size(); j++) {
			if(i==j){
				E retE=temp.e;
				temp.e=e;
				return retE;
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
		
		DNode<E> temp=head;
		
		for (int j = 0; j < size(); j++) {
			if(i==j){
				E retE=temp.e;
				if(temp.prev!=null){
					if(temp.next!=null){
						temp.prev.next=temp.next;
						temp.next.prev=temp.prev;
					}else{
						temp.prev.next=null;
					}					
				}else{
					if(temp.next!=null){
						head=temp.next;
						temp.next.prev=null;
					}else{
						head=null;
					}
				}				
				--size;
				
				return retE;
			}
			temp=temp.next;
		}
		
		return null;
	}

	@Override
	public int firstIndexOf(E e) {
		DNode<E> temp=head;
		for (int i = 0; i < size(); i++) {
			if(temp.e==e){
				return i;
			}
			temp=temp.next;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		DNode<E> temp=head;
		int index=-1;
		for (int i = 0; i <size(); i++) {
			if(temp.e==e){
				index=i;	
			}
			temp=temp.next;
		}
		return index;
	}

}
