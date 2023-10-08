//Insert in a Sorted List
//https://practice.geeksforgeeks.org/problems/insert-in-a-sorted-list/1
//8-10-2023

class Solution {
    Node sortedInsert(Node head, int key) {
        // Add your code here.
        Node temp = new Node(key);
        if (head == null) {
            //the elemet will be inserted at first
            //returned as the head
            return temp;
        }
        Node before = null;
        Node curr = head;
        while (curr != null) {
            if (curr.data >= key) {
                if (before == null) {
                    //if the element is to be inserted at first
                    temp.next = curr;
                    return temp;
                } else {
                    before.next = temp;
                    temp.next = curr;
                    return head;
                }
            }
            before = curr;
            curr = curr.next;
        }
        //if the list ended without encountering the greater element
        //the element will be inserted at last
        before.next = temp;
        return head;
    }
}