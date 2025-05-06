
public class FullTimeStaffHire extends StaffHire {
    private double salary;
    private int weeklyFractionalHours;

    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType,
                             String staffName, String joiningDate, String qualification,
                             String appointedBy, boolean joined, double salary,
                             int weeklyFractionalHours) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (getJoined()) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be set. Staff is not appointed.");
        }
    }

    public int getWeeklyFractionalHours() { return weeklyFractionalHours; }
    public void setWeeklyFractionalHours(int hours) {
        this.weeklyFractionalHours = hours;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Salary: " + salary);
        System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
    }
}
