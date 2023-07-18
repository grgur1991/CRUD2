

public class Subject {

    private String name;
    private int id;

    public Subject(int id, String name){
        this.id=id;
        this.name=name;
    }

    public void setName(String name){

        this.name = name;
    }

    @Override
    public String toString(){
        return "Subject [id=" + id + ",name=" + name +"]";

    }

}
