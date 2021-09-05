package b11_stack_queue_map_tree.thuc_hanh.b2_queue;

import java.util.EmptyStackException;

public class MyLinkedListQueue {
    private Node head;
    private Node tail;
    private int numNode=0;
    public void MyLinkedListQueue(){
        this.head=null;
        this.tail=null;
    }
    public void enqueue(int key){
        Node newNode=new Node(key);
        Node node=head;
        if(node==null){
            head=newNode;
        }else {
            while (node.next!=null){
                node=node.next;
            }
            node.next=newNode;
        }
        numNode++;
    }
    public void dequeue(){
        Node node=head;
        if(node==null){
            throw new EmptyStackException();
        }else {
            head=node.next;
            node=null;
        }
        numNode--;
    }
    public int size(){
        return numNode;
    }
    public void getKey(){
        Node node=new Node();
        node=head;
        for(int i=0;i<size();i++){
            System.out.println(node.getKey());
            node=node.next;
        }
    }
    @Override
    public String toString() {
        return "MyLinkedListQueue{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    private class Node{
        private int key;
        private Node next;

        public Node() {
        }

        public Node(int key) {
            this.key = key;
            this.next=null;
        }
        public int getKey(){
            return this.key;
        }
    }
}
