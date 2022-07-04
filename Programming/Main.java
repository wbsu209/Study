import java.util.Objects;

public class Main {
    private static final int MIN_AGE = 20;
    private static final int MAX_AGE = 30;

    public static void main(String[] args) {
        Person kim = new Person("Kim", 19);
        Person lee = new Person("Lee", 22);

        new Main().sample(kim, lee);
	}

    public boolean sample(Person person1, Person person2) {
        if (isNameNotMatched(person1, "Kim")) {
            return false;
        }

        if (isNameNotMatched(person2, "Lee")) {
            return false;
        }

        if (isOutOfLimit(person1)) {
            return false;
        }

        if (isOutOfLimit(person2)) {
            return false;
        }

        return true;
    }

    public static boolean isNameNotMatched(Person person, String name) {
        if (Objects.isNull(person) && Objects.isNull(name)) {
            return true;
        }

        return !name.equals(person.getName());
    }

    public static boolean isOutOfLimit(Person person) {
        if (Objects.isNull(person)) {
            return true;
        }

        return person.getAge() <= MIN_AGE && MAX_AGE <= person.getAge();
    }

    public static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }
        
        public int getAge() {
            return age;
        }
    }
}