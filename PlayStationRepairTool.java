import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class PlayStationRepairTool {

    private void createGUI() {

        //Title
        JFrame frame = new JFrame("PlayStation Repair Tool!");
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7,1));

        //Console type
        JLabel consoleLabel = new JLabel("Please Select Console...");
        String [] consoles =  {"PS1 (PlayStation 1)", "PS2 (PlayStation 2)", "PS3 (PlayStation 3)", "PS4 (PlayStation 4)", "PS5 (PlayStation 5)"};
        JComboBox<String> consoleBox = new JComboBox<>(consoles);

        //Issues selection
        JLabel issuesLabel = new JLabel("Please Select Issue (If Not Listed Please Select Other): ");
        String [] issues = {"Wont Power On", "Not Reading Discs", "Powers On But No Display", "Not Reading Controler Input", "Trys To Power On But Light Goes From Green To Red (PS2)", 
        "Yellow Light (YLOD) (PS3)", "Very Slow Proformance", "Blinking Blue Light (BLOD) (PS4)", "Overheating Red Light (RLOD) (PS4)", "Auto Disc Eject (PS4)", "Database Corruption (PS5)"};
        JComboBox<String> issuesBox = new JComboBox<>(issues);

        //Prevent console specific issues finding wrong consoles
        consoleBox.addActionListener(e -> {
            issuesBox.removeAllItems();
            String selected = (String) consoleBox.getSelectedItem();

            if (selected.contains("PS2 (PlayStation 2)")) {
                issuesBox.addItem("Trys To Power On But Light Goes From Green To Red (PS2)");
                issuesBox.addItem("Wont Power On");
                issuesBox.addItem("Not Reading Discs");
                issuesBox.addItem("Powers On But No Display");
                issuesBox.addItem("Not Reading Controler Input");
            } else if (selected.contains("PS3 (PlayStation 3)")) {
                issuesBox.addItem("Yellow Light (YLOD) (PS3)");
                issuesBox.addItem("Wont Power On");
                issuesBox.addItem("Not Reading Discs");
                issuesBox.addItem("Powers On But No Display");
                issuesBox.addItem("Not Reading Controler Input");
                issuesBox.addItem("Very Slow Proformance");
            } else if (selected.contains("PS4 (PlayStation 4)")) {
                issuesBox.addItem("Blinking Blue Light (BLOD) (PS4)");
                issuesBox.addItem("Overheating Red Light (RLOD) (PS4)");
                issuesBox.addItem("Auto Disc Eject (PS4)");
                issuesBox.addItem("Wont Power On");
                issuesBox.addItem("Not Reading Discs");
                issuesBox.addItem("Powers On But No Display");
            } else if (selected.contains("PS5 (PlayStation 5)")){
                issuesBox.addItem("Database Corruption (PS5)");
                issuesBox.addItem("Wont Power On");
                issuesBox.addItem("Not Reading Discs");
                issuesBox.addItem("Powers On But No Display");
            } else {
                issuesBox.addItem("Wont Power On");
                issuesBox.addItem("Not Reading Discs");
                issuesBox.addItem("Powers On But No Display");
                issuesBox.addItem("Not Reading Controler Input");
            }
        });

        //Results
        JTextArea resultsArea = new JTextArea(10,40);
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);

        //Diagnose
        JButton diagnoseButton = new JButton("Diagnose");

        //Save diagnose
        JButton saveButton = new JButton("Save Report");

        //Diagnose logic
        diagnoseButton.addActionListener(e -> {
            String console = (String) consoleBox.getSelectedItem();
            String issue = (String) issuesBox.getSelectedItem();
            String diagnosis = "";
            String solution = "";

            if (issue.equals("Wont Power On")) {
                diagnosis = "Possible power supply failure.";
                solution = "Replace power cable or replace PSU (Power Supply Unit).";
            } else if (issue.equals("Overheating")) {
                diagnosis = "Possible dust build up and/or bad thermal paste";
                solution = "Dust out console or replace thermal paste";
            } else if (issue.equals("Not Reading Discs")) {
                diagnosis = "Often a failing or worn out laser lens";
                solution = "Replace or clean laser lens";
            } else if (issue.equals("Powers On But No Display")) {
                diagnosis = "Faulty HDMI/AV port or Cable";
                solution = "Replace cable or port";
            } else if (issue.equals("Not Reading Controler Input")) {
                diagnosis = "Bad contoller port (PS1, PS2), broken buletooth chip (PS3), falulty contoller";
                solution = "Controller port replacement or contoller replacement";
            } else if (issue.equals("Trys To Power On But Light Goes From Green To Red (PS2)")) {
                diagnosis = "Possible blown fuse, faulty power cord, or failing PSU (Power Supply Unit)";
                solution = "Replace power cable, fuse, or PSU";
            } else if (issue.equals("Yellow Light (YLOD) (PS3)")) {
                diagnosis = "Major hardware failure most likley related to the motherboard, GPU, or CPU thermal paste drying out";
                solution = "Replace thermal paste or buy a new console";
            } else if (issue.equals("Very Slow Proformance")) {
                diagnosis = "Most likey related to a failing hard drive";
                solution = "May need to replace hard drive";
            } else if (issue.equals("Blinking Blue Light (BLOD) (PS4)")) {
                diagnosis = "Often HDMI, PSU, or hard drive failure.";
                solution = "Check HDMI, ensure the hard drive is properly seated, or try booting is safe mode";
            } else if (issue.equals("Overheating Red Light (RLOD) (PS4)")) {
                diagnosis = "Often due to high temperatures and fan issues.";
                solution = "Clean air vents, open ventilation, and remove dust.";
            } else if (issue.equals("Auto Disc Eject (PS4)")) {
                diagnosis = "Often due to a loose screw or faulty sensors.";
                solution = "Tighten the manual eject screw, replace disc sensor, or place the console vertically.";
            } else if (issue.equals("Database Corruption (PS5)")) {
                diagnosis = "Often indicate issue with SSD";
                solution = "Preform a hard reset or safe mode repair to the console";
            } else {
                diagnosis = "Unknown Issue.";
                solution = "Please contact other reapir services.";
            }

            String result = "Console: " + console + "\n" + "Issue: " + issue + "\n\n" + "Diagnosis: " + diagnosis + "\n" + "Solution: " + solution;
            resultsArea.setText(result);
        });

        //Save report
        saveButton.addActionListener(e -> {
            try {
                FileWriter writer = new FileWriter("diagnostic_report.txt");
                writer.write(resultsArea.getText());
                writer.close();
                JOptionPane.showMessageDialog(frame, "Report saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving file!");
            }
        });

        //Components
        frame.add(consoleLabel);
        frame.add(consoleBox);
        frame.add(issuesLabel);
        frame.add(issuesBox);
        frame.add(diagnoseButton);
        frame.add(saveButton);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PlayStationRepairTool().createGUI());

    }

}
