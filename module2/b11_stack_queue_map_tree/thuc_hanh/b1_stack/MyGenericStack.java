package b11_stack_queue_map_tree.thuc_hanh.b1_stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<E> {
    private LinkedList<E> stack;
    public MyGenericStack(){
        stack=new LinkedList<>();
    }
    public  void push(E element){
        stack.addFirst(element);
    }
    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    public int size(){
        return stack.size();
    }
    public boolean isEmpty(){
        if(stack.size()==0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "MyGenericStack{" +
                "stack=" + stack +
                '}';
    }
}
