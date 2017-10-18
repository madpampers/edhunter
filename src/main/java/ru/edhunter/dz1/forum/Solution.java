package ru.edhunter.dz1.forum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()) - 1;
        Node main = new Node("main", null, 0);
        TreeMap<String, Node> data = new TreeMap<>();
        data.put("main", main);
        for (int i = 0; i < n; i++) {
            String[] entry = reader.readLine().split(" ");
            Node newNode = new Node(entry[0], data.get(entry[1]), data.get(entry[1]).deep + 1);
            data.get(entry[1]).childs.add(newNode);
            data.put(newNode.name, newNode);
        }
        System.out.println("main");
        main.printChildes();
    }

    public static class Node implements Comparable {
        String name;
        Node parent;
        TreeSet<Node> childs = new TreeSet<>();
        int deep;

        Node(String name, Node parent, int deep) {
            this.name = name;
            this.parent = parent;
            this.deep = deep;
        }

        void printChildes() {
            for (Node child : this.childs) {
                for (int i = 0; i < child.deep * 2; i++) {
                    System.out.print(" ");
                }
                System.out.println(child.name);
                child.printChildes();
            }
        }

        @Override
        public int compareTo(Object o) {
            Node node = (Node) o;
            return -node.name.compareTo(this.name);
        }
    }
}