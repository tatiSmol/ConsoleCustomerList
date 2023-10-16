import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        String[] names = {"Tatiana", "Julius", "Vasiliy"};

        try {
            System.out.println(names[5]);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
//            ex.printStackTrace();
        }

        try {
            List<String> lines = Files.readAllLines(Paths.get("file.txt"));
            // проверяемое исключение, его необходимо обрабатывать
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }


        System.out.println("hey");
    }
}
