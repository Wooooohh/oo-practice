package practice11;

import java.util.LinkedList;

public class Teacher extends Person{

    LinkedList<Klass> classes;



    public Teacher(int id, String name, int age) {
        super(id, name, age);
        classes = new LinkedList<Klass>();
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        for(Klass klass : classes){
            klass.getTeachers().add(this);
        }
    }

    @Override
    public String introduce() {
        if(classes == null||classes.size() == 0)
            return super.introduce() + " I am a Teacher. I teach No Class.";
        StringBuilder klasses = new StringBuilder();
        if(!classes.isEmpty()) {
            for (int i = 0; i < classes.size() - 1; i++) {
                klasses.append(classes.get(i).getNumber()+", ");
            }
            klasses.append(classes.get(classes.size() - 1).getNumber());
        }
        return super.introduce() + " I am a Teacher. I teach Class " + klasses.toString() + ".";
    }

    public String introduceWith(Student student){
        for(Klass c: classes){
            if(c.getNumber() == student.getKlass().getNumber())
                return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        }
        return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
    }

    public LinkedList<Klass> getClasses() {
        return classes;
    }

    public void setClasses(LinkedList<Klass> classes) {
        this.classes = classes;
    }

    public boolean isTeaching(Student student) {
        for(Klass c: classes){
            if(c.getNumber() == student.getKlass().getNumber())
                return true;
        }
        return false;
    }

    public void kownLeader(Klass klass, Student student){
        System.out.printf("I am %s. I know %s become Leader of Class %s.\n",this.getName(),student.getName(),klass.getNumber());
    }

    public void kownJoin(Klass klass, Student student){
        System.out.printf("I am %s. I know %s has joined Class %s.\n",this.getName(),student.getName(),klass.getNumber());
    }
}
