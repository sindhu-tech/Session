package session1;

public class Employee {
        int id;
        String name;
        String salary;
        int age;

        public Employee(){

        }

        public Employee(Integer id, String name, String salary,int age) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.age=age;

        }

        public int getEmp_id() {
            return id;
        }

        public void setEmp_id(int emp_id) {
            this.id = id;
        }

        public String getEmp_name() {
            return name;
        }

        public void setEmp_name(String name) {
            this.name = name;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", age=" + age +
                '}';
    }
}
