package ru.edhunter.dz1.table;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    private List<String> columnNames;
    private List<Criteria> criterias;
    private List<Entry> entries;

    public static void main(String[] args) throws FileNotFoundException {
        Solution solution = new Solution();
        solution.readInput();
        solution.sortTable(solution.entries, solution.columnNames, solution.criterias);
        solution.printTable(solution.entries);
    }

    private void printTable(List<Entry> entries) {
        for (Entry entry : entries) {
            System.out.println(entry.toString());
        }
    }

    private void sortTable(List<Entry> entries, List<String> columnNames, List<Criteria> criterias) {
        Comparator<Entry> comparator = new Comparator<Entry>() {
            @Override
            public int compare(Entry entry1, Entry entry2) {
                for (Criteria criteria : criterias) {
                    String parameter = criteria.getParameter();
                    int index = columnNames.indexOf(parameter);
                    int result = entry1.getData()[index].compareTo(entry2.getData()[index]);
                    if (result != 0) {
                        if (criteria.getOrder().equals("ASC")) return result;
                        else return -result;
                    }
                }

                return 0;
            }
        };
        entries.sort(comparator);
    }

    private void readInput() throws FileNotFoundException {
                Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(new File("E:\\IDEA\\edhunter\\src\\ru\\edhunter\\dz1\\table\\test"));
        this.columnNames = readColumnNames(scanner);
        this.criterias = readCriterias(scanner);
        this.entries = readEntries(scanner);
    }

    private static List<Entry> readEntries(Scanner scanner) {
        ArrayList<Entry> entries = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] rawEntry = scanner.nextLine().split(" ");
            entries.add(new Entry(rawEntry));
        }
        return entries;
    }

    private static List<Criteria> readCriterias(Scanner scanner) {
        String[] rawCriterias = scanner.nextLine().split(",");
        ArrayList<Criteria> criterias = new ArrayList<>();
        for (String rawCriteria : rawCriterias) {
            String[] criteria = rawCriteria.trim().split(" ");
            criterias.add(new Criteria(criteria[0].trim(), criteria[1].trim()));
        }
        return criterias;
    }

    private static List<String> readColumnNames(Scanner scanner) {
        return Arrays.asList(scanner.nextLine().split(" "));
    }
}

class Entry {
    private String[] data;

    String[] getData() {
        return data;
    }

    Entry(String[] rawEntry) {
        this.data = rawEntry;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String datum : data) {
            builder.append(datum).append(" ");
        }
        return builder.toString().trim();
    }
}

class Criteria {
    private String order;
    private String parameter;

    String getOrder() {
        return order;
    }

    String getParameter() {
        return parameter;
    }

    Criteria(String parameter, String order) {
        this.parameter = parameter;
        this.order = order;
    }
}
