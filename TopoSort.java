package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopoSort {

    public static void main(String[] args) {
	// write your code here
      int[][] graph = {{1,2},{0}};
      int[] result = getCompilationOrder(graph, 3);
      for (int i : result) {
        System.out.println(i);
      }

     

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
