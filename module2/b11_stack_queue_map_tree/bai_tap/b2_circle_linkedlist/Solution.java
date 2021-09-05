package b11_stack_queue_map_tree.bai_tap.b2_circle_linkedlist;

class Solution{
    static class Node{
        int data;
        Node link;
    }
    static class Queue{
        Node front,rare;
    }
    static void enQueue(Queue q,int value){
        Node temp=new Node();
        temp.data=value;
        if(q.front==null){
            q.front=temp;
        }else {
            q.rare.link=temp;
        }
        q.rare=temp;
        q.rare.link=q.front;
    }
    static int deQueue(Queue q){
        if(q.front==null){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int value;
        if(q.front==q.rare){
            value=q.front.data;
            q.front=null;
            q.rare=null;
        }else {
            Node temp=q.front;
            q.front=q.front.link;
            value=temp.data;
            q.front.link=q.front;
        }
        return value;
    }
    static void displayQueue(Queue q){
        Node temp=q.front;
        System.out.printf("Elements in Circular Queue are: ");
        while (temp.link!=q.front){
            System.out.printf("%d",temp.data);
            temp=temp.link;
        }
        System.out.printf("%d",temp.data);

    }

    public static void main(String[] args) {
        // Create a queue and initialize front and rear
        Queue  q = new Queue();
        q .front = q .rare =  null;

        // Inserting elements in Circular Queue
        enQueue(q, 14);
        enQueue(q, 22);
        enQueue(q, 6);

        // Display elements present in Circular Queue
        displayQueue(q);

        // Deleting elements from Circular Queue
        System.out.printf(" Deleted value = %d", deQueue(q));
        System.out.printf(" Deleted value = %d", deQueue(q));

        // Remaining elements in Circular Queue
        displayQueue(q);

        enQueue(q, 9);
        enQueue(q, 20);
        displayQueue(q);
    }
}
