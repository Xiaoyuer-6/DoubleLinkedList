class ListNode{
    private int  val;
    private ListNode prev;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode getPrev() {
        return prev;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}



public class DoubleLinkedList {
    private ListNode head;
    private ListNode last;

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else {
            //node.next = this.head;
            node.setNext(this.head);
            head.setPrev(node);
            head = node;
        }
    }
    public void display(){
        ListNode cur =this.head;
        while (cur != null){
            System.out.print(cur.getVal() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }
    // 尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            last.setNext(node);
            node.setPrev(last);
            this.last = node;
        }

    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if (index < 0 || index > size()){
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }
        ListNode cur = this.head;
        while (index != 0){
            cur = cur.getNext();
            index--;
        }
        ListNode node =new ListNode(data);
        node.setNext(cur);
        node.setPrev(cur.getPrev());
        node.getPrev().setNext(node);
        cur.setPrev(node);
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while (cur != null){
            if (cur.getVal() == key){
                return true;
            }
            cur= cur.getNext();
        }
        return false;
    }
    public ListNode findNode(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.getVal() == key) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = this.findNode(key);
        if(cur == null) {
            return;
        }
        //
        if(cur == this.head) {
            this.head = this.head.getNext();
            //this.head.prev = null;
            this.head.setPrev(null);
            return;
        }
        if(cur == this.last) {
            cur.getPrev().setNext(null);
            this.last = this.last.getPrev();
            return;
        }
        cur.getPrev().setNext(cur.getNext());
        cur.getNext().setPrev(cur.getPrev());
    }
    // 删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.getVal() == key) {
                if(cur == this.head) {
                    //头结点
                    this.head = this.head.getNext();
                    this.head.setPrev(null);
                }else {
                    cur.getPrev().setNext(cur.getNext());
                    if(cur.getNext() != null) {
                        cur.getNext().setPrev(cur.getPrev());
                    }else {
                        //cur.next == null
                        this.last = this.last.getPrev();
                    }
                }
            }
            cur = cur.getNext();
        }
    }

    // 得到单链表的长度
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }

    public void clear(){
        ListNode cur = this.head;
        while (cur != null) {
            ListNode curNext = cur.getNext();
            cur.setNext(null);
            cur.setPrev(null);
            cur = curNext;
        }
        this.last = null;
        this.head = null;
    }


}
