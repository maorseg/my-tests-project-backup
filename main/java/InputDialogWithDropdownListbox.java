import javax.swing.JOptionPane;
public class InputDialogWithDropdownListbox {
    public static void main(String[] a) {
        String[] choices = { "A", "B", "C", "D", "E", "F" };
        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use

                choices, // Array of choices
                choices[1]); // Initial choice
                System.out.println("1");


        System.out.println(input);
    }
}