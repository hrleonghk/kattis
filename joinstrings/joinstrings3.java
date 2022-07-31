import java.util.*;

public class joinstrings3{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        if (n == 1){
            System.out.println(io.getWord());
            return;
        }
        String[] str = new String[n];
        HashMap<Integer, TailedLinkedList> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            str[i] = io.getWord();
        }
        for (int i = 0; i < n-1; i++){
            int front = io.getInt();
            int back = io.getInt();
            if (map.containsKey(front) && map.containsKey(back)){
                TailedLinkedList a = map.get(front);
                TailedLinkedList b = map.get(back);
                // ListNode a_head = a.get_head();
                // ListNode b_head = b.get_head();
                // for (int j = 0; j < a.size(); j++){
                //     System.out.println(a_head.getItem());
                //     a_head = a_head.getNext();
                // }
                // for (int j = 0; j < b.size(); j++){
                //     System.out.println(b_head.getItem());
                //     b_head = b_head.getNext();
                // }
                a.append(b);
            }else if (map.containsKey(front)){
                TailedLinkedList a = map.get(front);
                a.insert(a.get_tail(), new ListNode(back));
            }else if (map.containsKey(back)){
                TailedLinkedList b = map.get(back);
                ListNode res = new ListNode(front);
                b.insert(null, res);
                map.put(front, b);
            }else{
                ListNode a = new ListNode(front);
                ListNode b = new ListNode(back);
                TailedLinkedList c = new TailedLinkedList();
                c.insert(null, a);
                c.insert(a, b);
                map.put(front, c);
            }
            if (i == n-2){
                TailedLinkedList a = map.get(front);
                int sz = a.size();
                ListNode pointer = a.get_head();
                for (i = 0; i < sz; i++){
                    int idx = pointer.getItem();
                    System.out.print(str[idx-1]);
                    pointer = pointer.getNext();
                }
            }
        }

        io.close();
    }
}

class ListNode {
	/* attributes */
	public int item;
	public ListNode next;

	/* constructors */
	public ListNode(int val) { this(val, null); }

	public ListNode(int val, ListNode n) { 
		item = val; 
		next = n; 
	}

	/* get the next ListNode */
	public ListNode getNext() { return next; }

	/* get the item of the ListNode */
	public int getItem() { return item; }

  /* set the item of the ListNode */
  public void setItem(int val) { item = val; }

	/* set the next reference */
	public void setNext(ListNode n) { next = n; }
}

class TailedLinkedList{
    public ListNode head;
    public ListNode tail;
    public int num_nodes;

    public int size() {return num_nodes;}
    public ListNode get_head() {return head;}
    public ListNode get_tail() {return tail;}

    // insert newNode after the node referenced by cur 
    public void insert(ListNode cur, ListNode n) {
    // insert in front
        if (cur == null) {
            n.setNext(head);
            head = n; // update head
            if (tail == null) // update tail if list originally empty
                tail = head;
        }
        else { // insert anywhere else
            n.setNext(cur.getNext());
            cur.setNext(n);
            if (cur == tail) // update tail if inserted new last item
                tail = tail.getNext();
        }
        num_nodes++;
    }

    public void appendNode(int val){
        if (head == null){
            head = new ListNode(val);
        }else{
            tail.setNext(new ListNode(val));
        }
        tail = tail.getNext();
        num_nodes++;
    }

    public void append(TailedLinkedList list){
        if (list.head == null){
            return;
        }
        else{
            ListNode curr = list.get_head();
            while (curr != null){
                appendNode(curr.getItem());
                curr = curr.getNext();
            }
        }
    }
}