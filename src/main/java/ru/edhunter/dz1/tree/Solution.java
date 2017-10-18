package ru.edhunter.dz1.tree;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int nElements = scanner.nextInt();
        for (int i = 0; i < nElements; i++) {
            list.add(scanner.nextInt());
        }
        List<Integer> newList = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        set.add(list.get(0));
        for (int i = 0; i < list.size(); i++) {
            Integer tmp = set.ceiling(list.get(i) + 1);
            if (tmp == null) {
                newList.add(-1);
            } else {
                newList.add(tmp);
            }
            set.add(list.get(i));
        }
        for (Integer integer : newList) {
            System.out.print(integer + " ");
        }
    }

}