package elements;

public class RBTree{

    private RBNode head;

    public RBTree(){
        this.head = null;
    }

    public void addNode(int value){
        RBNode newNode = new RBNode(value);

        RBNode current = this.head;
        RBNode prev = null;

        // Find the correct position to insert the new node
        while (current != null) {
            prev = current;
            if(newNode.getValue() < current.getValue()){
                current = current.getLeftPrev();
            }else{
                current = current.getRightPrev();
            }
        }

        newNode.setNext(prev);
        if(prev == null){
            this.head = newNode;
        }else if(newNode.getValue() < prev.getValue()){
            prev.setLeftPrev(newNode);
        }else{
            prev.setRightPrev(newNode);
        }

        if(newNode.getNext() == null){
            newNode.setRed(false);
            return;
        }

        if(newNode.getNext().getNext() == null){
            return;
        }

        fixInsert(newNode);
    }

    private void fixInsert(RBNode current) {
        RBNode temp;
        while(current.getNext().isRed()){
            if(current.getNext() == current.getNext().getNext().getRightPrev()){
                temp = current.getNext().getNext().getLeftPrev();
                if(temp.isRed()){
                    temp.setRed(false);
                    current.getNext().setRed(false);
                    current.getNext().getNext().setRed(true);
                    current = current.getNext().getNext();
                }else{
                    if(current == current.getNext().getLeftPrev()){
                        current = current.getNext();
                        rightRotate(current);
                    }
                    current.getNext().setRed(false);
                    current.getNext().getNext().setRed(true);
                    leftRotate(current.getNext().getNext());
                }
            }else{
                temp = current.getNext().getNext().getRightPrev();

                if(temp.isRed()){
                    temp.setRed(false);
                    current.getNext().setRed(false);
                    current.getNext().getNext().setRed(true);
                    current = current.getNext().getNext();
                }else{
                    if(current == current.getNext().getRightPrev()){
                        current = current.getNext();
                        leftRotate(current);
                    }
                    current.getNext().setRed(false);
                    current.getNext().getNext().setRed(true);
                    rightRotate(current.getNext().getNext());
                }
            }
            if(current == head){
                break;
            }
        }
        head.setRed(false);
    }
    
    private void leftRotate(RBNode current) {
        RBNode temp = current.getRightPrev();
        current.setRightPrev(temp.getLeftPrev());
        if(temp.getLeftPrev() != null){
            temp.getLeftPrev().setNext(current);
        }
        temp.setNext(current.getNext());
        if(current.getNext() == null){
            this.head = temp;
        }else if(current == current.getNext().getLeftPrev()){
            current.getNext().setLeftPrev(temp);
        }else{
            current.getNext().setRightPrev(temp);
        }
        temp.setLeftPrev(current);
        current.setNext(temp);
    }

    private void rightRotate(RBNode current) {
        RBNode temp = current.getLeftPrev();
        current.setLeftPrev(temp.getRightPrev());
        if(temp.getRightPrev() != null){
            temp.getRightPrev().setNext(current);
        }
        temp.setNext(current.getNext());
        if(current.getNext() == null){
            this.head = temp;
        }else if(current == current.getNext().getRightPrev()){
            current.getNext().setRightPrev(temp);
        }else{
            current.getNext().setLeftPrev(temp);
        }
        temp.setRightPrev(current);
        current.setNext(temp);
    }

    public RBNode getHead(){
        return this.head;
    }
    public void setHead(RBNode head){
        this.head = head;
    }

}
