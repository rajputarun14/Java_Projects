public class Student implements Comparable<Student> {
    private String name ;
    private int studentId;
    private String address;
    private int rollNumber;

    @Override
    public int compareTo(Student s)
    {
        return this.rollNumber - s.rollNumber;
    }
    
    public Student(String name, int studentId, String address, int rollNumber) {
        this.name = name;
        this.studentId = studentId;
        this.address = address;
        this.rollNumber = rollNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", studentId=" + studentId + ", address=" + address + ", rollNumber="
                + rollNumber + "]";
    }

    
    
}
