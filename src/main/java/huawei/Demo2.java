package huawei;

import java.util.Scanner;
import java.util.TreeMap;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        String input;
        Node root = new Node();
        do {
            input = scan.nextLine();
            String[] inputArgs = input.split(" ");
            if (inputArgs.length > 0) {
                String command = inputArgs[0];
                if ("mkdir".equals(command) && inputArgs.length == 2) {
                    root.mkdir(inputArgs[1]);
                } else if ("rm".equals(command) && inputArgs.length == 2) {
                    root.rm(inputArgs[1]);
                } else if ("mv".equals(command) && inputArgs.length == 3) {
                    root.mv(inputArgs[1], inputArgs[2]);
                } else if ("ls".equals(command) && inputArgs.length == 1) {
                    root.print();
                } else if ("exit".equals(command) && inputArgs.length == 1) {
                    break;
                }
            }
        } while (true);

    }
}

/**
 * 节点对象
 */
class Node {
    // 当前的目录\文件的名字
    public String name;
    // 当前目录的path
    public String pwd;
    // 当前目录的子目录 需要排序 使用TreeMap结构
    // key值为子目录的name value值为子目录的引用
    public TreeMap<String, Node> childrenList;

    {
        childrenList = new TreeMap<>();
        name = "";
        pwd = "/";
    }

    // 无参构造函数
    public Node() {
    }

    // 带name的构造函数
    public Node(String name) {
        this.name = name;
    }

    /**
     * 输出目录结构
     */
    public void print() {
        System.out.println(pwd);
        for (Node child : childrenList.values()) {
            child.print();
        }
    }

    /**
     * 递归构建路径
     *
     * @param dir
     */
    public void mkdir(String dir) {
        // 只有以"/"开头 不以"/"结尾 的是有效路径
        if (dir.startsWith("/") && !dir.endsWith("/")) {
            dir = dir.replaceFirst("/", "");
            String[] paths = dir.split("/", 2);
            if (!childrenList.containsKey(paths[0])) {
                addChild(new Node(paths[0]));
            }
            if (paths.length > 1) {
                // 多个路径 递归创建
                childrenList.get(paths[0]).mkdir("/" + paths[1]);
            }
        }
    }

    public void rm(String dir) {
        // 只有以"/"开头的是有效路径
        if ("/".equals(dir)) {
            // 容错性处理
            return;
        }
        if (dir.startsWith("/")) {
            dir = dir.replaceFirst("/", "");
            String[] paths = dir.split("/");

            if (paths.length == 1) {
                // 从当前节点中删除节点
                removeChildRecursion(paths[0]);
            } else {
                StringBuffer sb = new StringBuffer();
                for (int i = 1; i < paths.length; i++) {
                    sb.append("/").append(paths[i]);
                }
                String nextDir = sb.toString();
                if (childrenList.containsKey(paths[0])) {
                    childrenList.get(paths[0]).rm(nextDir);
                }
            }
        }
    }

    /**
     * 移动节点
     * 注意 移动之后要对所有pwd进行修改
     */
    public void mv(String src, String dst) {
        String[] srcStrs = src.split("/");
        String[] dstStrs = dst.split("/");
        String srcFatherDir;
        String dstFatherDir;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < dstStrs.length - 1; i++) {
            if(!"".endsWith(dstStrs[i])) {
                sb.append("/").append(dstStrs[i]);
            }
        }
        dstFatherDir = sb.toString();
        sb = new StringBuffer();
        for (int i = 0; i < srcStrs.length - 1; i++) {
            if(!"".endsWith(srcStrs[i])) {
                sb.append("/").append(srcStrs[i]);
            }
        }
        srcFatherDir = sb.toString();

        // 判断src对象与dst是否存在祖先关系
        if (src.startsWith(dst) || dst.startsWith(src)) {
            return;
        }

        if (srcStrs.length == 0 || dstStrs.length == 0) {
            return;
        }

        // dst的父目录对象
        Node dstFatherNode;
        // src的目录对象
        Node srcNode;
        // src的父目录对象
        Node srcFatherNode;

        // 判断dst的父目录是否存在 不存在则返回

        dstFatherNode = findNode(dstFatherDir);

        if (dstFatherNode == null) {
            return;
        }
        // 判断dst目录下是否有同名文件
        if (dstFatherNode.childrenList.containsKey(dstStrs[dstStrs.length - 1])) {
            return;
        }

        // 从src的父目录删除src 并获取src对象

        srcFatherNode = findNode(srcFatherDir);
        if (srcFatherNode == null) {
            return;
        } else {
            srcNode = srcFatherNode.removeChild(src);
            // srcNode更名
            srcNode.name = dstStrs[dstStrs.length - 1];
            // 刷新pwd
            dstFatherNode.refreshPwd();
            if ("/".equals(dstFatherNode.pwd)) {
                srcNode.pwd = "/" + srcNode.name;
            } else {
                srcNode.pwd = dstFatherNode.pwd + "/" + srcNode.name;
            }
            // 添加节点
            dstFatherNode.addChild(srcNode);
            srcNode.refreshPwd();
        }
    }

    private void refreshPwd() {
        for (Node child : childrenList.values()) {
            if ("/".equals(pwd)) {
                child.pwd = "/" + child.name;
            } else {
                child.pwd = pwd + "/" + child.name;
            }
            child.refreshPwd();
        }
    }

    /**
     * 向该目录添加子目录
     *
     * @param node
     */
    public void addChild(Node node) {
        // 对已存在的节点不作操作
        if (!childrenList.containsKey(node.name)) {
            if ("/".equals(pwd)) {
                node.pwd = "/" + node.name;
            } else {
                node.pwd = pwd + "/" + node.name;
            }
            childrenList.put(node.name, node);
        }
    }

    /**
     * 根据目录的名字 删除目录
     * 并返回被删除的节点
     *
     * @param dir
     */
    public Node removeChild(String dir) {
        Node result = null;
        if (dir.startsWith("/") && !dir.endsWith("/")) {
            dir = dir.replaceFirst("/", "");
            String[] paths = dir.split("/", 2);
            if (paths.length > 1) {
                if (childrenList.containsKey(paths[0])) {
                    return childrenList.get(paths[0]).removeChild("/" + paths[1]);
                } else {
                    return null;
                }
            }else{
                if (childrenList.containsKey(paths[0])) {
                    result = childrenList.get(paths[0]);
                    childrenList.remove(paths[0]);
                }
            }
        }
        return result;
    }

    /**
     * 根据目录的名字 删除目录 并删除其子目录
     *
     * @param name
     */
    public void removeChildRecursion(String name) {
        if (childrenList.containsKey(name)) {
            Node child = childrenList.get(name);
            childrenList.remove(name);
            for (String childName : child.childrenList.keySet()) {
                child.removeChildRecursion(childName);
            }
        }
    }

    /**
     * 根据path
     * (如"/a/b/c")
     * 找到目标目录的Node对象
     * (最终找到c的对象)
     *
     * @param dir
     * @return null 如果找不到目标对象
     * Node对象 如果能够找到
     */
    public Node findNode(String dir) {
        if (dir.startsWith("/") && !dir.endsWith("/")) {
            dir = dir.replaceFirst("/", "");
            String[] paths = dir.split("/", 2);
            if (paths.length > 1) {
                if (childrenList.containsKey(paths[0])) {
                    return childrenList.get(paths[0]).findNode("/" + paths[1]);
                } else {
                    return null;
                }
            }
            return childrenList.getOrDefault(dir, null);
        } else {
            if("".equals(dir)){
                return this;
            }
            // 找不到目标
            return null;
        }
    }
}
