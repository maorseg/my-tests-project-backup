import java.io.IOException;

public class Stop {
  public static void main(String[] args) throws IOException {

    String cmd = "cmd.exe /c start ";


     //String file = "http://www.google.com";
     String file = "c:\\Users\\Maor\\Desktop\\runner\\run.bat";
     
    // String file = "mailto:author@my.com";
   // String file = "mailto:";
    Runtime.getRuntime().exec(cmd + file);
  }

}