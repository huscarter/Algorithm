package com.whh.algorithmlib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Create by huscarter@163.com on 2020/8/13
 * <p>
 * 类说明: 树形深度查找
 */
public class DepthJava {
    private Set set;
    private List list;
    private Map map;

    public static void main(String[] args) {

        System.out.println("hello");

        List<Group> grandSons = getChildren(5, null);
        List<Group> sons = getChildren(4, grandSons);
        List<Group> fathers = getChildren(3, sons);
        List<Group> grandFathers = getChildren(2, fathers);
        Group root = new Group(grandFathers);

        int depth = getDepth(root);
        System.out.println("depth:"+depth);
    }

    private static int getDepth(Group root) {
        int childCount = root.getChildCount();
        if (childCount > 0) {
            int max = 0;
            for (int i = 0; i < childCount - 1; i++) {
                // 此处递归从最底层叠加1，层层返回
                int depth = getDepth(root.getChildAt(i)) + 1;
                if(max<depth){
                    max = depth;
                }
            }
            return max;
        }
        return 0;
    }

    private static List<Group> getChildren(int count, List<Group> children) {
        List<Group> temps = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            temps.add(new Group(children));
        }
        return temps;
    }

    /**
     *
     */
    private static class Group {
        private List<Group> children;

        public Group(List<Group> children) {
            this.children = children;
        }

        public int getChildCount() {
            return children == null ? 0 : children.size();
        }

        public Group getChildAt(int index) {
            return children.get(index);
        }
    }
}
