import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        BST<Aadhar> bst = new BST<>();
        final Comparator<Aadhar> comparator = Comparator.comparing(Aadhar::getId);
        bst.addNode(new Node<>( new Aadhar(2, "ravi", "TN")), comparator);
        bst.addNode(new Node<>( new Aadhar(3, "ravi", "TN")), comparator);
        bst.addNode(new Node<>( new Aadhar(5, "ravi", "TN")), comparator);
        bst.addNode(new Node<>( new Aadhar(8, "ravi", "TN")), comparator);
        System.out.println(bst);

    }
}

class Node< E>{
    private E element;
    private Node<E> llink;
    private Node<E> rlink;

    public Node(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getLlink() {
        return llink;
    }

    public void setLlink(Node<E> llink) {
        this.llink = llink;
    }

    public Node<E> getRlink() {
        return rlink;
    }

    public void setRlink(Node<E> rlink) {
        this.rlink = rlink;
    }

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", link=" + llink +
                '}';
    }
}
class BST<T> {

    private Node<T> root;

    void addNode(Node<T> node, Comparator<? super T> comparator) {
        if (root != null) {

            addNode(root, node, comparator);
        } else {
            root = node;
        }
    }

    void inorderTraversal(){
        inorderTraversal(root);
    }

    private void inorderTraversal(Node<T> node) {

    }

    public void addNode(Node<T> parent, Node<T> node, Comparator<? super T> comparator) {
        if (comparator.compare(parent.getElement(), node.getElement()) > 1 && parent.getLlink() == null) {
            parent.setLlink(node);
        } else if( comparator.compare(parent.getElement(), node.getElement()) <= 1 && parent.getRlink() == null) {
            parent.setRlink(node);
        } else if (comparator.compare(parent.getElement(), node.getElement()) > 1)  {
            addNode(parent.getLlink(), node, comparator);
        } else {
            addNode(parent.getRlink(), node, comparator);
        }
    }
}

class Aadhar  {

    private int id;
    private String name;
    private String  state;

    public Aadhar(int id, String name, String state){
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Aadhar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }


}