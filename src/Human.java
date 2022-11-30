


public class Human {
    private String name;
    private int age,weight;

    private Human(HumanBuilder humanBuilder) {
        name = humanBuilder.name;
        age = humanBuilder.age;
        weight = humanBuilder.weight;

    }

    public void info(){
        System.out.println(name + " - возраст " + age + ", вес " + weight);
    }

    public static HumanBuilder builder(){
        return new HumanBuilder();
    }

    public static class HumanBuilder{
        private String name;
        private int age,weight;
        private Human human;

        public HumanBuilder name(String name) {
            this.name = name;
            return this;
        }

        public HumanBuilder age(int age) {
            this.age = age;
            return this;
        }

        public HumanBuilder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public HumanBuilder() {
        }

        public Human build() {
            return new Human(this);
        }
    }


    public static void main(String[] args) {
        Human human = Human.builder().name("Петр").age(25).weight(80).build();
        human.info();
        }
    }

