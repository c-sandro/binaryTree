package elements;

public class Node{
    private Node next, leftPrev, rightPrev;
    private int value;

    public Node(int value){
        this.value = value;
        this.next = null;
        this.leftPrev = null;
        this.rightPrev = null;
    }

    public Node getNext(){
        return this.next;
    }
    public void setNext(Node next){
        this.next = next;
    }

    public Node getLeftPrev(){
        return this.leftPrev;
    }
    public void setLeftPrev(Node leftPrev){
        this.leftPrev = leftPrev;
    }

    public Node getRightPrev(){
        return this.rightPrev;
    }
    public void setRightPrev(Node rightPrev){
        this.rightPrev = rightPrev;
    }

    public int getValue(){
        return this.value;
    }
    public void setValue(int value){
        this.value = value;
    }
}