
public class PartTimeStaffHire extends StaffHire {
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType,
                             String staffName, String joiningDate, String qualification,
                             String appointedBy, boolean joined, int workingHour,
                             double wagesPerHour, String shifts) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }

    public int getWorkingHour() { return workingHour; }
    public void setWorkingHour(int workingHour) { this.workingHour = workingHour; }

    public double getWagesPerHour() { return wagesPerHour; }
    public void setWagesPerHour(double wagesPerHour) { this.wagesPerHour = wagesPerHour; }

    public String getShifts() { return shifts; }
    public void setShifts(String newShifts) {
        if (getJoined()) {
            this.shifts = newShifts;
        } else {
            System.out.println("Cannot change shifts. Staff is not joined yet.");
        }
    }

    public boolean isTerminated() { return terminated; }

    public void terminateStaff() {
        if (terminated) {
            System.out.println("Staff is already terminated.");
        } else {
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            this.terminated = true;
            System.out.println("Staff has been terminated successfully.");
        }
    }

    
    public void display() {
        super.display();
        System.out.println("Working Hour: " + workingHour);
        System.out.println("Wages per Hour: " + wagesPerHour);
        System.out.println("Shifts: " + shifts);
        System.out.println("Terminated: " + terminated);
        System.out.println("Income per Day: " + (workingHour * wagesPerHour));
    }
}
