import utils.InputReader;

public class RockPaperScissors {
    private static final String FOLDER_NAME = "template";
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String INPUT_FILE_PATH = String.format("solutions/%s/%s", FOLDER_NAME, INPUT_FILE_NAME);

    public static void main(String[] args) {
        part1();
        part2(); 
    }

    private static void part1() {
        String[] lines = InputReader.readInput(INPUT_FILE_PATH);
        int total = 0;
        for (String line : lines) {
            switch (line.charAt(2)){
                case 'X':
                    switch(line.charAt(0)){
                        case 'A':
                            total += 4;
                            break;
                        case 'B':
                            total += 1;
                            break;
                        case 'C':
                            total += 7;
                            break;
                    }
                    break;
                case 'Y':
                    switch(line.charAt(0)){
                        case 'A':
                            total += 8;
                            break;
                        case 'B':
                            total += 5;
                            break;
                        case 'C':
                            total += 2;
                            break;
                }
                    break;
                case 'Z':
                    switch(line.charAt(0)){
                        case 'A':
                            total +=3;
                            break;
                        case 'B':
                            total += 9;
                            break;
                        case 'C':
                            total += 6;
                            break;
                }
                    break;
            }
        }
        System.out.println(total);
    }

    private static void part2() {
        String[] lines = InputReader.readInput(INPUT_FILE_PATH);
        int total = 0;
        for (String line : lines) {
            switch (line.charAt(0)){
                case 'A':
                    switch(line.charAt(2)){
                        case 'X':
                            total += 3;
                            break;
                        case 'Y':
                            total += 4;
                            break;
                        case 'Z':
                            total += 8;
                            break;
                    }
                    break;
                case 'B':
                    switch(line.charAt(2)){
                        case 'X':
                            total += 1;
                            break;
                        case 'Y':
                            total += 5;
                            break;
                        case 'Z':
                            total += 9;
                            break;
                }
                    break;
                case 'C':
                    switch(line.charAt(2)){
                        case 'X':
                            total +=2;
                            break;
                        case 'Y':
                            total += 6;
                            break;
                        case 'Z':
                            total += 7;
                            break;
                }
                    break;
            }
        }
        System.out.println(total);
    }
}