package b11_stack_queue_map_tree.thuc_hanh.b1_stack;

public class GenericStackClient {
    private static void stackOfInterger(){
        MyGenericStack<Integer> stack=new MyGenericStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Size of stack: "+stack.size());
        System.out.println(stack.toString());
        System.out.println("Size "+stack.size());
        System.out.println("Pop element from stack");
        while (!stack.isEmpty()){
            System.out.printf("%s ",stack.pop());
        }
        System.out.println(stack.size());
    }
    private static void stackOfString(){
        MyGenericStack<String> stack=new MyGenericStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        System.out.println(stack.toString());
        System.out.println("Size of stack: "+ stack.size());
        System.out.println("Pop element from stack");
        while (!stack.isEmpty()){
            System.out.printf("%s \n",stack.pop());
        }
        System.out.println("Size :");
        System.out.println(stack.size());
    }
    public static void main(String[] args) {
        stackOfInterger();
        stackOfString();
    }
}
