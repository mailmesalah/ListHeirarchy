package listheirarchy;

public class MyArrayList<E> extends MyAbstractList<E> {

	protected E[] arr;
	static int INITIAL_CAPACITY;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		INITIAL_CAPACITY=50;
		arr= (E[]) new Object[INITIAL_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(E[] eArr){
		INITIAL_CAPACITY=eArr.length;
		arr= (E[]) new Object[INITIAL_CAPACITY];
		for (int i = 0; i < eArr.length; i++) {
			this.arr[i]=eArr[i];
		}
		size=eArr.length;
	}
	
	@Override
	public E get(int i) throws IndexOutOfBoundsException {		
		if(i<0||i>=(size())){
			throw new IndexOutOfBoundsException();
		}
		return arr[i];
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {		
		if(i<0||i>size()){
			throw new IndexOutOfBoundsException();
		}		
		//keeping old value
		E temp1 = arr[i];
		arr[i]=e;		
		//shifting each previous values
		++size;//increment size
		for (int j = i+1; j < size(); j++) {
			E temp2=arr[j];
			arr[j]=temp1;
			temp1=temp2;
		}		
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if(i<0||i>(size()-1)){
			throw new IndexOutOfBoundsException();
		}
		E temp=arr[i];
		arr[i]=e;
		return temp;
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		if(i<0||i>=size()){
			throw new IndexOutOfBoundsException();
		}
		
		//shifting each next values back
		E retV=arr[i];
		for (int j = i; j < size()-1; j++) {
			arr[j]=arr[j+1];
		}
		//decrement size
		--size;
		return retV;
	}

	@Override
	public int firstIndexOf(E e) {
		int index=-1;
		for (int i = 0; i < size(); i++) {
			if(arr[i]==e){
				index=i;
				break;
			}
		}
		return index;
	}

	@Override
	public int lastIndexOf(E e) {
		int index=-1;
		for (int i = size()-1; i >= 0; i--) {
			if(arr[i]==e){
				index=i;
				break;
			}
		}
		return index;
	}
	
	public int capacity(){
		return INITIAL_CAPACITY;
	}
	
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCap) throws IllegalArgumentException{
		if(newCap<=0){
			throw new IllegalArgumentException();			
		}
		
		if(newCap>INITIAL_CAPACITY){
			INITIAL_CAPACITY=newCap;
			arr=(E[]) new Object[INITIAL_CAPACITY];
		}
	}

	public void trimToSize(){
		INITIAL_CAPACITY=size;
	}
}
