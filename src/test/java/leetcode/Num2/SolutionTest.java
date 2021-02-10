package leetcode.Num2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1(){
        ListNode input1 = new ListNode(2);
        input1.next=new ListNode(4);
        input1.next.next=new ListNode(3);
        ListNode input2 = new ListNode(5);
        input2.next=new ListNode(6);
        input2.next.next=new ListNode(4);

        Solution solution = new Solution();
        ListNode output = solution.addTwoNumbers(input1, input2);

        assertEquals(7, output.val);
        assertEquals(0, output.next.val);
        assertEquals(8, output.next.next.val);
    }

}