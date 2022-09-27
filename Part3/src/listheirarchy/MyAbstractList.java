package listheirarchy;

public abstract class MyAbstractList<E> implements MyList<E> {

	protected int size;
	protected MyAbstractList(){
		size=0;
	}
	@Override
	public int size() {		
		return size;
	}

	@Override
	public boolean isEmpty() {
		
		return size==0;
	}

	@Override
	public E getFirst() throws IllegalStateException {
		if(size<=0){
			throw new IllegalStateException("Size=0");
		}else{
			return get(0);
		}
	}

	@Override
	public E getLast() throws IllegalStateException {
		if(size<=0){
			throw new IllegalStateException("Size=0");
		}else{
			return get(size-1);
		}
	}

	@Override
	public void add(E e) {		
		add(size, e);	
	}

	@Override
	public void addFirst(E e) {
		add(0, e);		
	}

	@Override
	public void addLast(E e) {		
		add(size,e);
	}

	@Override
	public E setFirst(E e) throws IllegalStateException {
		if(size<=0){
			throw new IllegalStateException("Size=0");
		}else{
			return set(0,e);
		}
	}

	@Override
	public E setLast(E e) throws IllegalStateException {
		if(size<=0){
			throw new IllegalStateException("Size=0");
		}else{
			return set(size-1,e);
		}
	}


	@Override
	public E removeFirst() throws IllegalStateException {
		if(size<=0){
			throw new IllegalStateException("Size=0");
		}else{
			return remove(0);
		}
	}

	@Override
	public E removeLast() throws IllegalStateException {
		if(size<=0){
			throw new IllegalStateException("Size=0");
		}else{
			return remove(size-1);
		}
	}


	@Override
	public void clear() {
		size=0;		
	}

	@Override
	public boolean contains(E e) {		
		for (int i = 0; i < size; i++) {
			if(get(i)==e){
				return true;
			}
		}
		return false;
	}

	@Override
    public String toString(){
		String returnV="[";
		if(size>0){
			returnV+=get(0);
		}
		for (int i = 1; i < size; i++) {
			returnV+=", "+get(i);
		}
		returnV+="]";
		return returnV;
	}
	
}
