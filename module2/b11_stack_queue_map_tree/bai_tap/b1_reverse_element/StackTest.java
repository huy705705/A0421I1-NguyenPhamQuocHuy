package b11_stack_queue_map_tree.bai_tap.b1_reverse_element;

public class StackTest {

    public static void main(String[] args) {
        stackOfInteger();

    }
    private static void stackOfInteger(){
        Stack<Integer> stack=new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.reverse());
    }
}
