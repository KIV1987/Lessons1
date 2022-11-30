


public class Human {
    private String name;
    private int age, weight;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private Human() {
    }

    public void info() {
        System.out.println(name + " - возраст " + age + ", вес " + weight);
    }

    public static HumanBuilder builder() {
        return new HumanBuilder();
    }

    public static class HumanBuilder {
        private Human human;

        public HumanBuilder name(String name) {
            human.setName(name);
            return this;
        }

        public HumanBuilder age(int age) {
            human.setAge(age);
            return this;
        }

        public HumanBuilder weight(int weight) {
            human.setWeight(weight);
            return this;
        }

        public HumanBuilder() {
            human = new Human();
        }

        public Human build() {
            return human;
        }
    }

    public static void main(String[] args) {
        Human human = Human.builder().name("Alex").age(25).weight(77).build();
        human.info();
    }
}

