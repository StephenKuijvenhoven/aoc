import utils.InputReader;

public class Template {
    private static final String FOLDER_NAME = "template";
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String INPUT_FILE_PATH = String.format("solutions/%s/%s", FOLDER_NAME, INPUT_FILE_NAME);

    public static void main(String[] args) {
        String[] lines = InputReader.readInput(INPUT_FILE_PATH);
        part1(lines);
        part2(lines); 
    }

    private static void part1(String[]lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static void part2(String[] lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

}