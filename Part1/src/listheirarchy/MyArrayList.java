package listheirarchy;

public class MyArrayList<E> extends MyAbstractList<E> {

	protected E[] arr;
	final static int INITIAL_CAPACITY=4;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		arr= (E[]) new Object[INITIAL_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(E[] eArr){
		if(eArr.length==0){
			arr=(E[]) new Object[INITIAL_CAPACITY];
		}else{
			arr= (E[]) new Object[eArr.length];
			for (int i = 0; i < eArr.length; i++) {
				this.arr[i]=eArr[i];
			}
			size=eArr.length;
		}
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
		if(i>=arr.length){
			ensureCapacity((i+1));			
		}
		E temp1 = arr[i];
		arr[i]=e;		
		//shifting each previous values
		++size;//increment size	
		if(size>arr.length||i>arr.length){
			ensureCapacity(size);
		}
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
		trimToSize();
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
		return arr.length;
	}
	
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCap) throws IllegalArgumentException{
		if(newCap<=0){
			throw new IllegalArgumentException();			
		}
		E[] temp = (E[]) new Object[arr.length];
		if(newCap>arr.length){
			System.arraycopy(arr, 0, temp, 0, arr.length);
			arr=(E[]) new Object[newCap];
			System.arraycopy(temp, 0, arr, 0, temp.length);
		}
	}

	public void trimToSize(){
		E[] temp = (E[]) new Object[arr.length];
		System.arraycopy(arr, 0, temp, 0, arr.length);
		arr=(E[]) new Object[size];
		System.arraycopy(temp, 0, arr, 0, size);
	}
}
