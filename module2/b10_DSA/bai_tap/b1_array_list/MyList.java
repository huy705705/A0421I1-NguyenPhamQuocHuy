package b10.bai_tap.b1_;


import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }


    public void add(int index, E element) {
        if (index >= size || index < 0) {
//            nen sua nhu MyList2
            throw new ArrayIndexOutOfBoundsException("Index: " + index + "is not correct");
//           chuong se dung lai neu if tren dung , bo qua code ben duoi
        }
        if (size == elements.length) {
            ensureCapacity(elements.length * 2);
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + "is not correct");
//           chuong se dung lai neu if tren dung , bo qua code ben duoi
        }
        E result=(E) elements[index];
        for (int i=index;i<size-1;i++){
            elements[i]=elements[i+1];
        }
        size--;
        elements[size]=null;
        return result;
    }

    public int size() {
        return size;
    }

    public MyList<E> clone() {
        MyList<E> newList=new MyList<>(elements.length);
        newList.elements=Arrays.copyOf(elements,size);
        newList.size=size;
        return newList;
    }

    public boolean contain(E element) {
        for(int i=0;i<size;i++){
            if(elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element) {
        for(int i=0;i<size;i++){
            if(elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public boolean add(E element) {
        if (size == elements.length) {
            ensureCapacity(elements.length * 2);
        }
        elements[size++]=element;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        Object newElement[]=new Object[minCapacity];
        for (int i=0;i<size;i++){
            newElement[i]=elements[i];
        }
        elements=newElement;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + "is not correct");
//           chuong se dung lai neu if tren dung , bo qua code ben duoi
        }
        return (E)elements[index];
    }

    public void clean() {
        size=0;
        elements=new Object[DEFAULT_CAPACITY];
    }
}
