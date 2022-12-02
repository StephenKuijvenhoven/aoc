import utils.InputReader;

public class CalorieCounting {
    private static final String FOLDER_NAME = "1-calorie-counting";
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String INPUT_FILE_PATH = String.format("solutions/%s/%s", FOLDER_NAME, INPUT_FILE_NAME);

    public static void main(String[] args) {
        String[] lines = InputReader.readInput(INPUT_FILE_PATH);
        part1(lines);
        part2(lines); 
    }

    private static void part1(String[] lines) {

        int highestElf = 0;
        int currentElf = 0;
        for (String line : lines) {
            int lenght = line.length();
            if(lenght != 0){
                currentElf += Integer.valueOf(line);
            }else{
                if(currentElf > highestElf){
                    highestElf = currentElf;
                    
                }
                currentElf = 0;
            } 
        }
        System.out.println(highestElf);
    }

    private static void part2(String[] lines){
        int currentElf = 0;
        int[] top3Elfs = {3,2,1};
        for (String line : lines) {
            int lenght = line.length();
            if(lenght != 0){
                currentElf += Integer.valueOf(line);
            }else{
                for (int i = 0; i < top3Elfs.length; i++) {
                    if(currentElf>top3Elfs[i]){
                        int tempElf = top3Elfs[i];
                        top3Elfs[i]=currentElf;
                        currentElf = tempElf;
                    }
                }
                currentElf = 0;
            } 
        }
        System.out.println(top3Elfs[0] + top3Elfs[1] + top3Elfs[2]);
    }
}
