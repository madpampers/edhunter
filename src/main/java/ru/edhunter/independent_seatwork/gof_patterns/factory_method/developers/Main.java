package ru.edhunter.independent_seatwork.gof_patterns.factory_method.developers;

public class Main {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperFactory("java");
        Developer developer = developerFactory.createDeveloper();
        developer.write();

        DeveloperFactory developerFactory1 = createDeveloperFactory("cpp");
        Developer developer1 = developerFactory1.createDeveloper();
        developer1.write();
    }

    private static DeveloperFactory createDeveloperFactory (String specialization) {
        switch (specialization) {
            case "java" : return new JavaDeveloperFactory();
            case "cpp" : return new CppDeveloperFactory();
            case "php" : return new PhpDeveloperFactory();
            default: throw new RuntimeException(specialization + " specialization os unknown.");
        }
    }
}
