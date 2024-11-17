package elements;

public class RBNode{

    private RBNode next, leftPrev, rightPrev;
    private int value;
    private boolean isRed;

    public RBNode(int value){
        this.value = value;
        this.next = null;
        this.leftPrev = null;
        this.rightPrev = null;
        this.isRed = true;
    }

    public RBNode getNext(){
        return this.next;
    }
    public void setNext(RBNode next){
        this.next = next;
    }

    public RBNode getLeftPrev(){
        return this.leftPrev;
    }
    public void setLeftPrev(RBNode leftPrev){
        this.leftPrev = leftPrev;
    }

    public RBNode getRightPrev(){
        return this.rightPrev;
    }
    public void setRightPrev(RBNode rightPrev){
        this.rightPrev = rightPrev;
    }

    public int getValue(){
        return this.value;
    }
    public void setValue(int value){
        this.value = value;
    }

    public boolean isRed(){
        return this.isRed;
    }
    public void setRed(boolean isRed){
        this.isRed = isRed;
    }

}
