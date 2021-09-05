package b11_stack_queue_map_tree.bai_tap.b1_reverse_element;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<E> {
    private LinkedList<E> stack;
    private LinkedList<E> wStack=new LinkedList<>();
    public Stack(){
        stack=new LinkedList<>();
    }
    public void push(E element){
        stack.addFirst(element);
    }
    public E  pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }else {
            E result= (E) stack.removeLast();
            return result;
        }

    }
    public boolean isEmpty(){
        if(stack.size()==0){
            return true;
        }else {
            return false;
        }
    }
    public String reverse(){

        for(int i=0;i<stack.size();){
            wStack.add(stack.pop());
        }
//        for(int i=0;i<wStack.size();i++){
//            stack.add(wStack.pop());
//        }
        return " "+wStack;
    }
    public int size(){
        return stack.size();
    }
    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + stack +
                '}';
    }
}
