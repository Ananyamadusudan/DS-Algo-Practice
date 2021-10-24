package com.company;


import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
      /*int[][] graph = {{1,2},{0}};
      int[] result = getCompilationOrder(graph, 3);
      for (int i : result) {
        System.out.println(i);
      }*/

        Tree.Node node = new Tree.Node(1);
        Tree.Node node1 = new Tree.Node(3);
      Tree.Node node3 = new Tree.Node(4);
      Tree.Node node4 = new Tree.Node(6);
      Tree.Node node5 = new Tree.Node(7);
      Tree.Node node6 = new Tree.Node(8);

      node1.setLeft(node4);
      node1.setRight(node5);
      node3.setLeft(node6);
      node.setLeft(node1);
      node.setRight(node3);
      Tree.spiralTraversal(node);

    }
    static int[] getCompilationOrder(int[][] graph, int V) {
      boolean visited[] = new boolean[V];
      Stack<Integer> stack = new Stack<>();
      Set<Integer> set = new HashSet<>();
      if (graph.length == 0) {
        int res[] = new int[V];
        for (int i= 0; i < V; i++) {
          res[i] = i;
        }
        return res;
      }
      for(int i = 0; i < V; i++) {
        if (topoSortUtil(graph, visited, i, stack, set)) {
          return new int[0];
        }
      }
      List<Integer> list = new ArrayList<>();
      while (!stack.isEmpty()) {
        list.add(stack.pop());
      }
      Collections.reverse(list);
      return list.stream().mapToInt(j -> j).toArray();
    }

    static boolean topoSortUtil(int[][] graph, boolean[] visited, int i,
                                Stack<Integer> stack, Set<Integer> set) {
      if (!visited[i]) {
        visited[i] = true;
        set.add(i);
        for (int v: graph[i]) {
          if (!visited[v] && topoSortUtil(graph, visited, v, stack, set)) {
            return true;
          } else if (set.contains(v)) {
            return true;
          }
        }
        stack.push(i);
      }
        set.remove(new Integer(i));

      return false;
    }
}
