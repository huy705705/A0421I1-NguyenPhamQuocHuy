package b10.bai_tap.b1_;

public class MyList2<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList2() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList2(int capacity) {
        elements = new Object[capacity];
    }


    public void add(int index, E element) {
        if(index==0&&size==0){
            elements[size]=element;
        }
        if(index>size||index<0){
            throw new ArrayIndexOutOfBoundsException("Index: "+index+"is not correct");
//           chuong se dung lai neu if tren dung , bo qua code ben duoi
        }
        if(size==elements.length){
            ensureCapacity(elements.length*2);
        }
        for(int i=size;i>index;i--){
            elements[i]=elements[i-1];
        }
        elements[index]=element;
        size++;
    }
    public E remove(int index){
        if(size==0){
            System.out.println("Array chua co phan tu nao de xoa");
            return null;
        }
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + " is not correct");
//           chuong se dung lai neu if tren dung , bo qua code ben duoi
        }
        return null;
    }
    public int size(){
        return size;
    }
    public E clone(){
        return null;
    }
    public boolean contain(E element){
        return true;
    }
    public int indexOf(E element){
        return -1;
    }
    public boolean add(E element){
        return true;
    }
    public void ensureCapacity(int minCapacity){

    }
    public E get(){
        return null;
    }
    public void clean(){

    }
}
