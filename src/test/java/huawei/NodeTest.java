package huawei;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    @Test
    public void findNodeTest(){
        Node n = new Node();
        n.addChild(new Node("a"));
        Node result;
        result = n.findNode("/");
        result = n.findNode("/a");
        result = n.findNode("/a/b");
    }

    @Test
    public void printTest(){
        Node n = new Node();
        n.addChild(new Node("a"));
        n.print();
    }

    @Test
    public void mkdirTest(){
        Node n = new Node();
        n.mkdir("/a/b/c");
        n.mkdir("/a/b/d/e");
        n.print();
    }

    @Test
    public void rmTest(){
        Node n = new Node();
        n.mkdir("/a/b/c");
        n.mkdir("/a/b/d/e");
        n.print();
        n.rm("/a/b/d");
        System.out.println("n.rm(\"/a/b/d\");");
        n.print();
        n.rm("/");
        System.out.println("n.rm(\"/\");");
        n.print();
    }

    @Test
    public void mvTest(){
        Node n = new Node();
        n.mkdir("/a");
        n.mkdir("/b/x/x/x");
        n.mkdir("/c/d");
        n.print();
        n.mv("/b","/a/c");
        System.out.println("n.mv(\"/b\",\"/a/c\");");
        n.print();
    }

    @Test
    public void mvTest2(){
        Node n = new Node();
        n.mkdir("/a/b/c");
        n.print();
        System.out.println("n.mv(\"/a\",\"/\");");
        n.mv("/a","/");
        n.print();
    }
}