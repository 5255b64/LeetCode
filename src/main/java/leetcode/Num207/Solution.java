package leetcode.Num207;

import java.util.*;

/**
 * 207. Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * https://leetcode-cn.com/problems/course-schedule/
 */

/**
 * 解题思路: 深度优先遍历 判断图中是否有环
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建图
        Node[] nodeList = new Node[numCourses];

        for(int i=0;i<numCourses;i++){
            nodeList[i]=new Node(i);
        }

        for(int[] xList:prerequisites){
            if(xList.length!=2){
                System.err.println("xList.length!=2");
                System.exit(-1);
            }
            nodeList[xList[0]].addNext(nodeList[xList[1]]);
        }

        // 深度优先遍历
        boolean result = true;
        Stack<Integer> stack = new Stack<>();   // 遍历时用栈记录当前遍历的路径
        Set<Integer> alreadyTraveled = new HashSet<>();  // 记录已遍历过的节点
        for(int i=0;i<numCourses;i++){
            if(!alreadyTraveled.contains(i)){
                stack.push(i);
                result = DFT(nodeList[i], stack, alreadyTraveled);
                alreadyTraveled.add(i);
                if(!result){
                    break;
                }
            }
        }
        return result;
    }

    /**
     *
     * @param node  当前visit的节点
     * @param stack 记录当前遍历路径的栈
     * @param alreadyTraveled   已经遍历过的节点 如果visit到这些节点，则返回
     * @return  存在环路则返回false 否则返回true
     */
    private boolean DFT(Node node,Stack<Integer> stack,Set<Integer> alreadyTraveled){
        List<Node> nextList = node.nextList;
        if(nextList.size()==0){
            stack.pop();
            return true;
        }

        boolean result = true;
        // 判断子节点中是否含有错误节点
        for(int i=0;i<nextList.size();i++){
            if(stack.contains(nextList.get(i).value)){
                result=false;
                break;
            }
        }
        if(result){
            for(int i=0;i<nextList.size();i++){
                int nextNode = nextList.get(i).value;
                if(!alreadyTraveled.contains(nextNode)) {
                    stack.push(nextNode);
                    result = DFT(nextList.get(i), stack, alreadyTraveled);
                    alreadyTraveled.add(nextNode);
                    if(!result){
                        break;
                    }
                }
            }
        }
        stack.pop();
        return result;
    }

}
class Node{
    public int value;
    public List<Node> nextList;

    public Node(){
        this.value=-1;
        nextList=new ArrayList<>();
    }

    public Node(int value){
        this();
        this.value=value;
    }

    public Node(int value, Node next){
        this(value);
        nextList.add(next);
    }

    public void addNext(Node next){
        nextList.add(next);
    }
}
