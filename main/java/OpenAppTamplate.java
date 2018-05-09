import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.lang.ProcessBuilder;

public class OpenAppTamplate {
    public static void main(String[] argv) throws Exception {
        JFrame frame = new JFrame();
        String message = "Open Application?";
        int answer = JOptionPane.showConfirmDialog(frame, message);
        if (answer == JOptionPane.YES_OPTION) {

        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files\\Notepad++\\notepad++.exe");
        p.start();

        } else if (answer == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }
}