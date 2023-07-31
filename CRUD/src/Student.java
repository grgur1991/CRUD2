public class Student {
    private String name;
    private int age;
    private boolean isMale;

    public Student(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return isMale;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }
}