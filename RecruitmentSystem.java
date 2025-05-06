import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class RecruitmentSystem implements ActionListener {
    private JFrame frame;

    private JTextField vacancyNumberTXT, designationTXT, jobTypeTXT, staffNameTXT, joiningDateTXT,
            qualificationTXT, appointedByTXT, salaryTXT, weeklyFractionalHoursTXT, workingHourTXT,
            wagesPerHourTXT, shiftsTXT;

    private JCheckBox joinedCKB, terminatedCKB;

    private JButton AddFullTimeStaffBTN, AddPartTimeStaffBTN, ClearBTN;

    private ArrayList<StaffHire> staffList = new ArrayList<>();

    public RecruitmentSystem() {
        frame = new JFrame("Recruitment System - GridLayout Example");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Function to add labeled field
        int row = 0;
        vacancyNumberTXT = addLabeledField(contentPane, gbc, "Vacancy Number:", 0, row++);
        designationTXT = addLabeledField(contentPane, gbc, "Designation:", 0, row++);
        jobTypeTXT = addLabeledField(contentPane, gbc, "Job Type:", 0, row++);
        staffNameTXT = addLabeledField(contentPane, gbc, "Staff Name:", 0, row++);
        joiningDateTXT = addLabeledField(contentPane, gbc, "Joining Date:", 0, row++);
        qualificationTXT = addLabeledField(contentPane, gbc, "Qualification:", 0, row++);
        appointedByTXT = addLabeledField(contentPane, gbc, "Appointed By:", 0, row++);

        joinedCKB = new JCheckBox("Joined");
        gbc.gridx = 0;
        gbc.gridy = row++;
        contentPane.add(joinedCKB, gbc);

        salaryTXT = addLabeledField(contentPane, gbc, "Salary:", 0, row++);
        weeklyFractionalHoursTXT = addLabeledField(contentPane, gbc, "Weekly Hours:", 0, row++);
        workingHourTXT = addLabeledField(contentPane, gbc, "Working Hours (Per Day):", 0, row++);
        wagesPerHourTXT = addLabeledField(contentPane, gbc, "Wages Per Hour:", 0, row++);
        shiftsTXT = addLabeledField(contentPane, gbc, "Shift (Morning/Evening):", 0, row++);

        terminatedCKB = new JCheckBox("Terminated");
        gbc.gridx = 0;
        gbc.gridy = row++;
        contentPane.add(terminatedCKB, gbc);

        // Buttons
        AddFullTimeStaffBTN = new JButton("Add Full-Time Staff");
        AddFullTimeStaffBTN.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = row++;
        contentPane.add(AddFullTimeStaffBTN, gbc);

        AddPartTimeStaffBTN = new JButton("Add Part-Time Staff");
        AddPartTimeStaffBTN.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = row++;
        contentPane.add(AddPartTimeStaffBTN, gbc);

        ClearBTN = new JButton("Clear");
        ClearBTN.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = row++;
        contentPane.add(ClearBTN, gbc);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JTextField addLabeledField(Container contentPane, GridBagConstraints gbc, String label, int x, int y) {
        JLabel jLabel = new JLabel(label);
        gbc.gridx = x;
        gbc.gridy = y;
        contentPane.add(jLabel, gbc);

        JTextField jTextField = new JTextField(15);
        gbc.gridx = x + 1;
        gbc.gridy = y;
        contentPane.add(jTextField, gbc);

        return jTextField;
    }

    public static void main(String[] args) {
        new RecruitmentSystem();
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("Add Full-Time Staff")) {
            addFullTimeStaff();
        } else if (command.equals("Add Part-Time Staff")) {
            addPartTimeStaff();
        } else if (command.equals("Clear")) {
            clearFields();
        }
    }

    public void addFullTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberTXT.getText());
            String designation = designationTXT.getText();
            String jobType = jobTypeTXT.getText();
            String staffName = staffNameTXT.getText();
            String joiningDate = joiningDateTXT.getText();
            String qualification = qualificationTXT.getText();
            String appointedBy = appointedByTXT.getText();
            boolean joined = joinedCKB.isSelected();
            double salary = Double.parseDouble(salaryTXT.getText());
            int weeklyHours = Integer.parseInt(weeklyFractionalHoursTXT.getText());

            FullTimeStaffHire staff = new FullTimeStaffHire(vacancyNumber, designation, jobType,
                    staffName, joiningDate, qualification, appointedBy, joined, salary, weeklyHours);

            staffList.add(staff);
            JOptionPane.showMessageDialog(frame, "Full-Time Staff Added Successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please check number fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addPartTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberTXT.getText());
            String designation = designationTXT.getText();
            String jobType = jobTypeTXT.getText();
            String staffName = staffNameTXT.getText();
            String joiningDate = joiningDateTXT.getText();
            String qualification = qualificationTXT.getText();
            String appointedBy = appointedByTXT.getText();
            boolean joined = joinedCKB.isSelected();
            int workingHour = Integer.parseInt(workingHourTXT.getText());
            double wagesPerHour = Double.parseDouble(wagesPerHourTXT.getText());
            String shifts = shiftsTXT.getText();

            PartTimeStaffHire staff = new PartTimeStaffHire(vacancyNumber, designation, jobType,
                    staffName, joiningDate, qualification, appointedBy, joined,
                    workingHour, wagesPerHour, shifts);

            staffList.add(staff);
            JOptionPane.showMessageDialog(frame, "Part-Time Staff Added Successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please check number fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clearFields() {
        JTextField[] textFields = {
                vacancyNumberTXT, designationTXT, jobTypeTXT, staffNameTXT, joiningDateTXT,
                qualificationTXT, appointedByTXT, salaryTXT, weeklyFractionalHoursTXT,
                workingHourTXT, wagesPerHourTXT, shiftsTXT
        };

        for (JTextField txt : textFields) {
            txt.setText("");
        }

        joinedCKB.setSelected(false);
        terminatedCKB.setSelected(false);
    }
}


    
