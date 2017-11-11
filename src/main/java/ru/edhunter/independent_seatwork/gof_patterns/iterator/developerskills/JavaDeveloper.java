package ru.edhunter.independent_seatwork.gof_patterns.iterator.developerskills;

public class JavaDeveloper implements Collection{
    final private String name;
    final private String[] skills;

    public JavaDeveloper(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String[] getSkills() {
        return skills;
    }

    @Override
    public Iterator<String>  getIterator() {
        return new Iterator<String>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < skills.length;
            }

            @Override
            public String next() {
                return skills[index++];
            }
        };
    }
}
