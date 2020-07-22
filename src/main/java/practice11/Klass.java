package practice11;

import java.util.ArrayList;
import java.util.List;


public class Klass{

    private int number;

    private Student leader;

    private List<Teacher> teachers;

    public Klass(int number) {
        this.number = number;
        teachers = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void assignLeader(Student leader){
        if(leader.getKlass() == null || leader.getKlass().getNumber() != this.getNumber())
            System.out.print("It is not one of us.\n");
        else {
            this.leader = leader;
            for(Teacher teacher: teachers){
                teacher.kownLeader(this, leader);
            }
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public String getDisplayName(){
        return "Class " + number;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void appendMember(Student student){
            student.setKlass(this);
            for(Teacher teacher: teachers){
                teacher.kownJoin(this, student);
            }
    }
}
