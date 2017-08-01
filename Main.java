import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.nio.file.Path;
/**
 * Created by Masha on 29.07.2017.
 */
public class Main {
    public static void main (String[] args) {
        TestCreator test = new TestCreator();
        Path path = FileSystems.getDefault().getPath("C:\\Users\\Masha\\IdeaProjects\\Test_for_Anny\\src\\data.txt");
        try {
            test.initialize(path, StandardCharsets.UTF_8);
        } catch (java.io.IOException e) {
            System.out.print("wrong initialization!");
        } finally {
            test.randomize(5);
            ArrayList<TestCreator.TestElement> arr = test.getArray();
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i).getQuestion());
                System.out.println(arr.get(i).getMap());
                System.out.println();
            }
        }
    }

}