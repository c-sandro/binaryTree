package elements;

public class BinaryTree{

    private Node head;

    public BinaryTree(){
        this.head = null;
    }

    public void addNode(int value){
        Node newNode = new Node(value);
        if(this.head == null){
            this.head = newNode;
            return;
        }

        Node current = this.head;
        while(current != null){
            if(current.getValue() >= value){
                if(current.getRightPrev() == null){
                    newNode.setNext(current);
                    current.setRightPrev(newNode);
                    return;
                }
                current = current.getRightPrev();
                continue;
            }
            if(current.getLeftPrev() == null){
                newNode.setNext(current);
                current.setLeftPrev(newNode);
                return;
            }
            current = current.getLeftPrev();
        }
    }

    public void removeNode(int value){
        if(this.head.getValue() == value){
            if(this.head.getRightPrev() == null && this.head.getLeftPrev() != null){
                this.head.getLeftPrev().setNext(null);
                this.head = this.head.getLeftPrev();
                return;
            }else if(this.head.getLeftPrev() == null && this.head.getRightPrev() != null){
                this.head.getRightPrev().setNext(null);
                this.head = this.head.getRightPrev();
                return;
            }
            this.head = null;
            return;
        }

        Node current = this.head;
        boolean isLeft = false;
        while(current != null){
            if(current.getValue() > value){
                current = current.getLeftPrev();
                isLeft = true;
                continue;
            }else if(current.getValue() < value){
                current = current.getRightPrev();
                isLeft = false;
                continue;
            }
            break;
        }
        if(current == null){
            return;
        }

        if(isLeft){
            this.leftRemove(current);
        }else{
            this.rightRemove(current);
        }

    }

    public void leftRemove(Node current){
        if(current.getLeftPrev() == null && current.getRightPrev() == null){
            current.getNext().setLeftPrev(null);
            return;
        }else if(current.getLeftPrev() != null && current.getRightPrev() == null){
            current.getNext().setLeftPrev(current.getLeftPrev());
            return;
        }
        current = this.closestNode(current);
        current.getNext().setLeftPrev(current.getRightPrev());

    }

    public void rightRemove(Node current){
        if(current.getLeftPrev() == null && current.getRightPrev() == null){
            current.getNext().setRightPrev(null);
            return;
        }else if(current.getLeftPrev() != null && current.getRightPrev() == null){
            current.getNext().setRightPrev(current.getLeftPrev());
            return;
        }
        current = this.closestNode(current);
        current.getNext().setRightPrev(current.getRightPrev());
    }

    public Node closestNode(Node current){
        while(current.getLeftPrev() != null){
            current = current.getLeftPrev();
        }
        return current;
    }

    public Node getHead(){
        return this.head;
    }
    public void setHead(Node head){
        this.head = head;
    }
}
