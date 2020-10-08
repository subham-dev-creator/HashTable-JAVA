package com.training.hashtable;


public class LinkedList<T> {
    private Node<T> Head = null;
    private Node<T> Tail = null;

    // Function to print the LinkedList
    public void printList() {
        Node<T> iteratorNode = Head;
        while(iteratorNode!=null) {
            System.out.print(iteratorNode.getValue() + " -->> ");
            iteratorNode = iteratorNode.getNext();
        }
        System.out.println();
    }
    public Node<T> getHead(){
        return Head;
    }
    // Add node in linkedList in the front
    public void addNodeFront(T value){
        Node<T> temp = new Node<T>(value);
        if((Tail==Head) && (Head==null)){
            Head=temp;
            Tail=temp;
        }
        else
        {
            temp.setNext(Head);
            Head=temp;
        }
    }

    // Add node in LinkedList at the end
    public void addNodeLast(T value){
        Node<T> temp = new Node<T>(value);

        if((Tail==null) && (Head==null)){
            Head=temp;
        }
        else
        {
            Tail.setNext(temp);
        }
        Tail=temp;

    }

    // returns the length of the Linked List
    private int length(){
        int len=0;
        Node<T> iteratorNode = Head;
        while(iteratorNode!=null){
            len++;
            iteratorNode = iteratorNode.getNext();
        }
        return len;
    }

    // Add Node in the middle of LinkedList
    public void addNodeMid(T value){
        Node<T> temp = new Node<T>(value);

        if((Tail==null) && (Head==null)){
            Head=temp;
            Tail=temp;
        }
        else
        {
            Node<T> iteratorNode = Head;

            int len = length();
            if(len%2==0)
                len--;
            len=len/2;

            while(len>0){
                iteratorNode = iteratorNode.getNext();
                len--;
            }

            temp.setNext(iteratorNode.getNext());
            iteratorNode.setNext(temp);
        }
    }

    // DELETION OF NODE AT THE FRONT OF LINKED LIST
    public void deleteNodeFront(){
        if(Head == null) // if no node is there
            return;
        else if(Head==Tail) // for single element in linked list
        {
            Head = null;
            Tail = null;
        }
        else{
            // Any other case
            Head=Head.getNext();
        }
    }

    //DELETION OF NODE AT THE END OF THE LINKED LIST
    public void deleteNodeEnd(){
        if(Head == null) // if no node is there
            return;
        else if(Head==Tail) // for single element in linked list
        {
            Head = null;
            Tail = null;
        }
        else{
            // Any other case
            Node<T> iterator = Head;
            while(iterator.getNext().getNext()!=null){
                iterator=iterator.getNext();
            }
            iterator.setNext(null);
            Tail=iterator;
        }
    }

    // Finds that node with value is present in the linked list or not
    public boolean findNodeWithValue(T value){
        Node<T> iterator = Head;
        while(iterator!=null){
            if(iterator.getValue()==value)
                return true;
            iterator = iterator.getNext();
        }
        return false;
    }

    //
    public void insertAtTargetPosition(T target,T value){
        if(findNodeWithValue(target)){
            Node<T> iterator = Head;
            while(true && iterator!=null){
                if(iterator.getValue()==target){
                    break;
                }
                else
                    iterator=iterator.getNext();
            }

            Node<T> temp = new Node<>(value);
            temp.setNext(iterator.getNext());
            iterator.setNext(temp);
        }
        else{
            System.out.println("Node with Value " + target + " is not present");
        }
    }

    //
    public void deleteSpecificNode(T value){
        if(findNodeWithValue(value)){
            if(Head==Tail && Head.getValue()==value)
            {
                Head=null;
                Tail=null;
            }
            else if(Head.getValue()==value) {
                Head=Head.getNext();
            }
            else{
                Node<T> iterator = Head;
                while(iterator.getNext().getValue()!=value){
                    iterator=iterator.getNext();
                }
                iterator.setNext(iterator.getNext().getNext());
            }
        }
        else{
            System.out.println("No node present ");
        }
    }
}
