

import java.util.*;

import java.lang.ref.WeakReference;

public class WeakReferenceStack<E> {

	private final List<WeakReference<E>> stackReferences; 

	private int stackPointer = 0;

	public WeakReferenceStack() { 
		this.stackReferences = new ArrayList<>();
	}

	public void push(E element) { 
		this.stackReferences.add(stackPointer, new WeakReference<>(element)); 
		stackPointer++;
	}

	public E pop() { 
		stackPointer--;
		return this.stackReferences.get(stackPointer).get(); 
	}

	public E peek() {
		return this.stackReferences.get(stackPointer-1).get();
	} 
}