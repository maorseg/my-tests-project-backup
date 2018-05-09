// Java program to demonstrate working of Robot
// class. This program is for Windoes. It opens
// notepad and types a message.
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;

public class RobotClass
{
    public static void main(String[] args) throws IOException,
            AWTException, InterruptedException {
        String command = "C:\\Program Files\\Notepad++\\Notepad++.exe";
        Runtime run = Runtime.getRuntime();
        run.exec(command);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Create an instance of Robot class
        Robot robot = new Robot();
        // Creates the delay of 5 sec so that you can open notepad before
        // Robot start writing
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_G);
    }
}