package listheirarchy;

public class MyArrayListOp<E> extends MyArrayList<E> {

	@SuppressWarnings("unchecked")
	public MyArrayListOp(){
		arr=(E[]) new Object[INITIAL_CAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayListOp(E[] eArr){
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
	public E removeLast(){			
		return remove(size()-1);		
	}
	
	@Override
	public void clear(){
		size=0;
	}
}
