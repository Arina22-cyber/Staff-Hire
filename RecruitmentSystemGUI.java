
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystemGUI implements ActionListener {
    private JFrame frame;
    private JTextField vacancyNumberField, designationField, jobTypeField, staffNameField,
            joiningDateField, qualificationField, appointedByField,
            salaryField, weeklyHoursField, workingHourField,
            wagesPerHourField, shiftField;

    private JCheckBox joinedCheckBox, terminatedCheckBox;
    private JButton addFullTimeButton, addPartTimeButton, clearButton, displayButton;

    private ArrayList<StaffHire> staffList = new ArrayList<>();

    public RecruitmentSystemGUI() {
        frame = new JFrame("Recruitment System");
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(17, 2, 5, 5));

        vacancyNumberField = addLabeledTextField("Vacancy Number:");
        designationField = addLabeledTextField("Designation:");
        jobTypeField = addLabeledTextField("Job Type:");
        staffNameField = addLabeledTextField("Staff Name:");
        joiningDateField = addLabeledTextField("Joining Date:");
        qualificationField = addLabeledTextField("Qualification:");
        appointedByField = addLabeledTextField("Appointed By:");
        salaryField = addLabeledTextField("Salary:");
        weeklyHoursField = addLabeledTextField("Weekly Hours:");
        workingHourField = addLabeledTextField("Working Hours:");
        wagesPerHourField = addLabeledTextField("Wages Per Hour:");
        shiftField = addLabeledTextField("Shift (Morning/Evening):");

        joinedCheckBox = new JCheckBox("Joined");
        terminatedCheckBox = new JCheckBox("Terminated");

        frame.add(new JLabel("Joined:"));
        frame.add(joinedCheckBox);

        frame.add(new JLabel("Terminated:"));
        frame.add(terminatedCheckBox);

        addFullTimeButton = new JButton("Add Full-Time Staff");
        addPartTimeButton = new JButton("Add Part-Time Staff");
        clearButton = new JButton("Clear");
        displayButton = new JButton("Display");

        addFullTimeButton.addActionListener(this);
        addPartTimeButton.addActionListener(this);
        clearButton.addActionListener(this);
        displayButton.addActionListener(this);

        frame.add(addFullTimeButton);
        frame.add(addPartTimeButton);
        frame.add(clearButton);
        frame.add(displayButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JTextField addLabeledTextField(String labelText) {
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField();
        frame.add(label);
        frame.add(textField);
        return textField;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addFullTimeButton) {
            addFullTimeStaff();
        } else if (e.getSource() == addPartTimeButton) {
            addPartTimeStaff();
        } else if (e.getSource() == clearButton) {
            clearFields();
        } else if (e.getSource() == displayButton) {
            displayStaff();
        }
    }

    private void addFullTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String designation = designationField.getText();
            String jobType = jobTypeField.getText();
            String staffName = staffNameField.getText();
            String joiningDate = joiningDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = joinedCheckBox.isSelected();
            double salary = Double.parseDouble(salaryField.getText());
            int weeklyHours = Integer.parseInt(weeklyHoursField.getText());

            FullTimeStaffHire fullTime = new FullTimeStaffHire(vacancyNumber, designation, jobType,
                    staffName, joiningDate, qualification, appointedBy, joined, salary, weeklyHours);
            staffList.add(fullTime);

            JOptionPane.showMessageDialog(frame, "Full-Time Staff added successfully.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error in input. Check fields again.");
        }
    }

    private void addPartTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String designation = designationField.getText();
            String jobType = jobTypeField.getText();
            String staffName = staffNameField.getText();
            String joiningDate = joiningDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = joinedCheckBox.isSelected();
            int workingHour = Integer.parseInt(workingHourField.getText());
            double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());
            String shift = shiftField.getText();

            PartTimeStaffHire partTime = new PartTimeStaffHire(vacancyNumber, designation, jobType,
                    staffName, joiningDate, qualification, appointedBy, joined,
                    workingHour, wagesPerHour, shift);
            staffList.add(partTime);

            JOptionPane.showMessageDialog(frame, "Part-Time Staff added successfully.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error in input. Check fields again.");
        }
    }

    private void clearFields() {
        JTextField[] fields = {
                vacancyNumberField, designationField, jobTypeField, staffNameField,
                joiningDateField, qualificationField, appointedByField, salaryField,
                weeklyHoursField, workingHourField, wagesPerHourField, shiftField
        };
        for (JTextField field : fields) {
            field.setText("");
        }
        joinedCheckBox.setSelected(false);
        terminatedCheckBox.setSelected(false);
    }

    private void displayStaff() {
        if (staffList.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No staff to display.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (StaffHire staff : staffList) {
                sb.append(staff.toString()).append("\n\n");
            }
            JTextArea textArea = new JTextArea(sb.toString(), 20, 40);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(frame, scrollPane, "Staff Details", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RecruitmentSystemGUI());
    }
}



    