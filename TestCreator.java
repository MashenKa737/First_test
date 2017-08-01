/**
 * Created by Masha on 29.07.2017.
 */
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TestCreator {
    private ArrayList<TestElement> arrayList = new ArrayList<TestElement>();
    private Random rnd = new Random(System.currentTimeMillis());

    /**
     * Initialization by getting data from file.
     * The information in file must be given as follows:
     * Question1?
     * true answer1
     * false answer2
     * false answer3
     *
     * Question2?
     * false answer1
     * ...
     * No extra spases, no spases in the end of lines.
     * Empty line splits different questions.
     *
     * @param path is the absolute path to file
     * @param cs is the encoding of file
     * @throws java.io.IOException
     */
    public void initialize(Path path, Charset cs) throws java.io.IOException {
        BufferedReader reader = Files.newBufferedReader(path, cs);
        String line = null;
        while ((line = reader.readLine()) != null) {
            String question = line;
            Map<String, Boolean> ans = new TreeMap<String, Boolean>();
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                int i = line.indexOf(" ");
                Boolean b = Boolean.valueOf(line.substring(0, i));
                String a = line.substring(i + 1);
                ans.put(a, b);
            }
            arrayList.add(new TestElement(question, ans));
        }
    }

    /**
     * @return random element from arrayList or null if list is empty
     */
    public TestElement getRandom() {
        if (!arrayList.isEmpty()) {
            return arrayList.get(rnd.nextInt(arrayList.size()));
        }
        return null;
    }

    /**
     * @return list of TestElements without clone.
     */
    public ArrayList<TestElement> getArray () {
        return arrayList;
    }

    /**
     * Change arrange in arrayList
     * @param n is a number of random swap for elements
     */
    public void randomize(int n) {
        for (int i = 0; i < n; i++) {
            int a = rnd.nextInt(arrayList.size());
            int b = rnd.nextInt(arrayList.size());
            TestElement c = arrayList.get(a);
            arrayList.set(a, arrayList.get(b));
            arrayList.set(b, c);
        }
    }

    /**
     * A class for objects to store in the TestCreator.
     * Has two fields: String question and Map<String, Boolean> of answers
     */
    public static class TestElement {
        private String question = null;
        private Map<String, Boolean> answers = null;

        public TestElement() {
        }

        public TestElement(String question, Map<String, Boolean> answers) {
            this.question = question;
            this.answers = answers;
        }

        public String getQuestion() {
            return question;
        }

        public Map<String, Boolean> getMap() {
            return answers;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public void setAnswers(Map<String, Boolean> answers) {
            this.answers = answers;
        }
    }

}

