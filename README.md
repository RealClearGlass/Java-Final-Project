# PlayStation Repair Tool!

## Project Overveiw: This program allows people to find/diagnose the most common issues for PlayStation consoles. Compatible from PlayStation 1 through the Playstation 5.

## Motivation: I was very interrested to persue this project because I ran into an issue with my personal PlayStation 3 console. When I went to power it on the power light turned yellow when this happens it's called the yellow light of death, But with some reaserh I was able to find a solution to fix it.
I dont want what happen to me, happen to others. So I made this program.

## How to run: To run this program you'll need the PlayStstionRepairTool java file found in the file section. 
[Image Caption] (<img width="980" height="679" alt="FinalJava" src="https://github.com/user-attachments/assets/314a3953-de0a-4ad5-87c8-297221abc202" />)

## Code example: The code I'm most proud of is diffently the console specific issue so it wont classify a PS5 issue with a PS2. I'm also very pround of the diagnostic report. I'm very proud of these because I took at lot of brain power to figure out how to code it, and ive also not seen any repair service where you can save a diagnostic report.
'''
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
'''
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
'''
## Testing: Using JUnit4 to test. All you need to do to run the program is to use the code and hit run and it should start right up. To save the diagnostic report hit the save button.

## Contibutors: To Jump into this project you'll need a program to code and you can start right there. I worked on this code by myself and finshed it in 7 hours, I did have addition help from the Bro Code OOP Java videos. @Bro Code on youtube.
