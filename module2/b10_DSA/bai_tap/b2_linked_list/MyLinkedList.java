package b10_DSA.bai_tap.b2_linked_list;

public class MyLinkedList<E> {
    private MyNode head;
    private int numNode;
    public MyLinkedList(){
        numNode=0;
        head=null;
    }
    public void add(int index,E element){
        if(index<0||index>=numNode){
            throw new ArrayIndexOutOfBoundsException();

        }
        MyNode node=head;
        for (int i=0;i<index-1;i++){
            node=node.next();
        }
        MyNode insert=new MyNode(element);
        insert.next=node.next;
        node.next=insert;
        numNode++;
    }
    public void addFirst(E element){
        MyNode insert=new MyNode(element);
        insert.next=head;
        head=insert;
        numNode++;
    }
    public void addLast(E element){
        MyNode node=head;
        MyNode insert=new MyNode(element);
        while (node.next!=null){
            node=node.next;
        }
        node.next=insert;
        numNode++;
    }
    public  E remove(int index){
        if(index<0||index>=numNode){
            throw new ArrayIndexOutOfBoundsException();

        }
        if(index==0){
            E element=(E)head.data;
            head=head.next;
            numNode--;
            return element;
        }
        MyNode node=head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        E element=(E) node.next.data;
        node.next=node.next.next;
        numNode--;
        return element;
    }
    public boolean remove(Object element){
        MyNode node=head;
        if(node.data==element ){
            head=node.next;
            numNode--;
            return true;
        }
        while (node.next!=null){
            if(node.next.data==element){
                node.next=node.next.next;
                numNode--;
                return true;
            }

        }
        return false;
    }



    private class MyNode {
        private MyNode next;
        private Object data;
        public MyNode(Object data){
            this.data=data;
        }
        public Object getData(){
            return this.data;
        }
        public MyNode next(){
            return this.next;
        }
    }
}
