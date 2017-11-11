package ru.edhunter.independent_seatwork.gof_patterns.iterator.developerskills;

public class JavaDeveloperRunner {
    public static void main(String[] args) {
        String[] skills = {"Java Core", "Maven", "Hibernate", "SQL", "Spring"};

        JavaDeveloper javaDeveloper = new JavaDeveloper("Vova", skills);

        final Iterator<String> iterator = javaDeveloper.getIterator();
        System.out.println("Developer: " + javaDeveloper.getName());
        System.out.println("Skills: ");

        while (iterator.hasNext()) {
            System.out.print(iterator.next()+ " ");
        }

        System.out.println();
    }
}
