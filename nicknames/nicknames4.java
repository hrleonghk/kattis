import java.util.*;

public class nicknames4{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int names = io.getInt();
        AVL tree = new AVL();
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < names; i++){
            String name = io.getWord();
                tree.insert(name);
            }
        
        int nicks = io.getInt();
        
        for (int i = 0; i < nicks; i++){
            String nick = io.getWord();
            if (map.containsKey(nick)){
                io.println(map.get(nick));
            }else{
                int freq = tree.search(nick);
                io.println(freq);
                map.put(nick, freq);
            }
            //io.println(trees[len-1].search(nick)+maps.get(len).get(nick));
            //trees[len-1].inorder();
            //io.println(nick);
            //io.println(tree.search(nick));
        }

        tree.inorder();
        io.close();
    }
}

class Node{
    String element;
    int h;
    Node left;
    Node right;

    public Node(String element){
        left = null;
        right = null;
        this.element = element;
        h = 0;
    }
}

class AVL{
    private Node root;
    
    public AVL(){
        root = null;
    }

    public void insert(String element){
        root = insert(element, root);
    }

    private int getHeight(Node node){
        if (node == null){
            return 0;
        }
        return node.h;
    }

    private int getMaxHeight(int leftheight, int rightheight){
        return (leftheight > rightheight) ? leftheight : rightheight;
    }

    private Node leftrotate(Node node){
        Node a = node.right;
        Node b = a.left;
        a.left = node;
        node.right = b;

        node.h = getMaxHeight(getHeight(node.left), getHeight(node.right)) + 1;
        a.h = getMaxHeight(getHeight(a.left), getHeight(a.right)) + 1;
        return a;
    }

    private Node rightrotate(Node node){
        Node a = node.left;
        Node b = a.right;
        a.right = node;
        node.left = b;

        node.h = getMaxHeight(getHeight(node.left),getHeight(node.right)) + 1;
        a.h = getMaxHeight(getHeight(a.left), getHeight(a.right)) + 1;
        return a;
    }

    private int getBalance(Node node){
        if (node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node insert(String element, Node node){
        if (node == null){
            return (new Node(element));
        }
        if (element.compareTo(node.element) < 0){
            node.left = insert(element, node.left);
        }else if (element.compareTo(node.element) > 0){
            node.right = insert(element, node.right);
        }else{
            return node;
        }
        node.h = getMaxHeight(getHeight(node.left), getHeight(node.right)) + 1;

        int balance = getBalance(node);

        if (balance > 1 && element.compareTo(node.left.element) < 0){
            return rightrotate(node);
        }
        if (balance > 1 && element.compareTo(node.left.element) > 0){
            node.left = leftrotate(node.left);
            return rightrotate(node);
        }
        if (balance < -1 && element.compareTo(node.right.element) < 0){
            node.right = rightrotate(node.right);
            return leftrotate(node);
        }
        if (balance < -1 && element.compareTo(node.right.element) > 0){
            return leftrotate(node);
        }
        return node;
    }

    public int search(String element){
        return search(root, element);
    }

    private int search(Node head, String element){
        //int len = element.length();
        if (head == null){
            return 0;
        }else{
            String HeadElement = head.element;
            if (HeadElement.indexOf(element) == 0){
                return 1 + search(head.left, element) + search(head.right, element);
            }else if (element.compareTo(HeadElement) < 0){
                return search(head.left, element);
            }else{
                return search(head.right, element);
            }
        }
    }

    // private int newsearch(Node head, String element){
    //     int len = element.length();
    //     // int count = 0;
    //     if (head == null){
    //         return 0;
    //     }
    //     //System.out.println(head.element);
    //     //System.out.println(element);
    //     String HeadElement = head.element;
    //     if (element.compareTo(HeadElement) == 0){
    //         return 1 + newsearch(head.left, element) + newsearch(head.right, element);
    //     }else{
    //         //System.out.println(head.element);
    //         if (HeadElement.compareTo(element) > 0){
    //             return newsearch(head.left, element);
    //         }else{
    //             return newsearch(head.right, element);
    //         }
    //         // return newsearch(head.left, element) + newsearch(head.right, element);
    //         // count += newsearch(head.left, element);
    //         // count += newsearch(head.right, element);
    //         // return count;
    //     }
    // }

    public void inorder(){
        inorder(root);
    }

    private void inorder(Node head){
        if (head != null){
            inorder(head.left);
            System.out.print(head.element + " ");
            System.out.print(head.h + ", ");    
            inorder(head.right);
        }
    }
}