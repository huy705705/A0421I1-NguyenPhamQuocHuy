package b11_stack_queue_map_tree.thuc_hanh.b2_queue;

public class MyLinkedListQueueTest {
    public static void main(String[] args) {
        MyLinkedListQueue queue=new MyLinkedListQueue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.getKey();
    }
}
