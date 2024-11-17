package elements;

public class AVLTree extends BinaryTree{

    private Node imbalanced;

    public AVLTree(){
        super();
        this.imbalanced = null;
    }

    @Override
    public void addNode(int value){
        super.addNode(value);
        if(!this.checkBalance(this.getHead())){
            this.balanceTree(value);
        }
    }

    @Override
    public void removeNode(int value){
        super.removeNode(value);
        if(!this.checkBalance(this.getHead())){
            this.balanceTree(value);
        }
    }

    public boolean checkBalance(Node current){
        int lh, rh;

        if (current == null) {
            return true;
        }

        lh = getHeight(current.getLeftPrev());
        rh = getHeight(current.getRightPrev());

        if(Math.abs(lh - rh) > 1){
            this.imbalanced = current;
        }

        return Math.abs(lh - rh) <= 1 && checkBalance(current.getLeftPrev()) && checkBalance(current.getRightPrev());
    }

    public int getHeight(Node current){
        if (current == null){
            return 0;
        }

        return 1 + Math.max(getHeight(current.getLeftPrev()), getHeight(current.getRightPrev()));
    }

    public void balanceTree(int value){
        if(this.imbalanced.getLeftPrev() == null){
            this.leftRotate(imbalanced);
            return;
        }else if(this.imbalanced.getRightPrev() == null){
            this.rightRotate(imbalanced);
            return;
        }

        if(this.imbalanced.getValue() <= value){
            if(this.imbalanced.getRightPrev().getValue() > value){
                this.rightRotate(this.imbalanced.getRightPrev());
            }
            this.leftRotate(this.imbalanced);
        }else{
            if(this.imbalanced.getRightPrev().getValue() <= value){
                this.leftRotate(this.imbalanced.getRightPrev());
            }
            this.rightRotate(this.imbalanced);
        }

        this.imbalanced = null;
    }

    public void rightRotate(Node current){
        Node tempLeft = current.getLeftPrev();
        current.setLeftPrev(tempLeft.getRightPrev());
        tempLeft.setNext(current);
        tempLeft.setLeftPrev(current);

        if(current.getNext() == null){
            this.setHead(tempLeft);
            return;
        }

        tempLeft.setNext(current.getNext());
        if(current.getNext().getLeftPrev().equals(current)){
            current.getNext().setLeftPrev(current);
        }else{
            current.getNext().setRightPrev(current);
        }
        current.setNext(tempLeft);
    }

    public void leftRotate(Node current){
        Node tempRight = current.getRightPrev();
        current.setRightPrev(tempRight.getLeftPrev());
        tempRight.setNext(current);
        tempRight.setRightPrev(current);

        if(current.getNext() == null){
            this.setHead(tempRight);
            return;
        }

        tempRight.setNext(current.getNext());
        if(current.getNext().getLeftPrev().equals(current)){
            current.getNext().setLeftPrev(current);
        }else{
            current.getNext().setRightPrev(current);
        }
        current.setNext(tempRight);

    }

}
