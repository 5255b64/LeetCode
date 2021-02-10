package leetcode.Num2;

/**
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode ptrResult = result;

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        int carry = 0;
        while(ptr1!=null||ptr2!=null){
            int num1, num2;
            if(ptr1!=null){
                num1=ptr1.val;
            }else{
                num1=0;
            }
            if(ptr2!=null){
                num2 = ptr2.val;
            }else{
                num2=0;
            }

            int sum = num1+num2+carry;
            carry=sum/10;
            sum=sum%10;
            ptrResult.next=new ListNode(sum);


            ptrResult=ptrResult.next;
            if(ptr1!=null) {
                ptr1 = ptr1.next;
            }
            if(ptr2!=null) {
                ptr2 = ptr2.next;
            }
        }
        if(carry>0){
            ptrResult.next=new ListNode(carry);
        }

        return result.next;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}