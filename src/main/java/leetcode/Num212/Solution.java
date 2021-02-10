package leetcode.Num212;

/**
 * 212. 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * 提示:
 *
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。
 * 什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
 * 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路：
 * 0-1）构建[字母串,末尾字母位置]的map映射（Map[String,List[Pair[int x,int y]]] existWordMap）   表示存在的字母串
 * 0-2）构建[字母串,末尾字母位置]的map映射（Map[String,List[Pair[int x,int y]]] notExistWordMap）表示不存在的字母串
 * 1）遍历board，将出现过的[字符,字符位置]存入一个map中（Map[Char,List[Pair[int x,int y]]] charMap）
 * 2）遍历所有单词words，对于每个单词，先从charMap寻找首字母；
 * 若首字母不存在，则该单词必定不存在；
 * 若首字母存在，则从charMap中找到首字母的位置，遍历该单词的后续字母；
 * 在遍历一个单词的过程中，先从notExistWordMap中寻找部分字母串是否不存在，若不存在，则终止该单词的遍历；
 * 若部分字母串不存在于notExistWordMap中，那么从existWordMap寻找是否该字母串已存在；
 * 若该字母串已存在，则从existWordMap提示的位置开始遍历；
 * 若该字母串不存在与notExistWordMap与existWordMap两个映射中，则从首字母开始，从上下左右一步步遍历；
 */
public class Solution {
    // TODO
    public List<String> findWords(char[][] board, String[] words) {
        return new ArrayList<String>();
    }
}
