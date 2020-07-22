package practice09;

public class Klass {

    int number;

    Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void assignLeader(Student leader){
        if(leader.getKlass() == null || leader.getKlass().getNumber() != number)
            System.out.print("It is not one of us.\n");
        else
            this.leader = leader;
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

    public void appendMember(Student student){
        if(student.getKlass() == null)
            student.setKlass(this);
    }
}
