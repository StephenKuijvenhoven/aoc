import utils.InputReader;

public class Template {
    private static final String FOLDER_NAME = "5-supply-stacks";
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String INPUT_FILE_PATH = String.format("solutions/%s/%s", FOLDER_NAME, INPUT_FILE_NAME);

    public static void main(String[] args) {
        String[] lines = InputReader.readInput(INPUT_FILE_PATH);
        part1(lines);
        part2(lines); 
    }

    private static void part1(String[]lines) {
        String[] stacks = 
        {"FTNZMGHJ",
        "JWV",
        "HTBJLVG",
        "LVDCNJPB",
        "GRPMSWF",
        "MVNBFCHG",
        "RMGHD",
        "DZVMNH",
        "HFNG"};

        int index = 0;

        for (String line : lines) {
            index++;
            if(index > 10){
                
                String[] moves = line.split(" ");
                int amount = Integer.parseInt(moves[1]);
                int from = Integer.parseInt(moves[3]);
                int to = Integer.parseInt(moves[5]);
                String valuesToMove = "";
                for (int i = 0; i < amount; i++) {
                    if(i < stacks[from-1].length()){
                        valuesToMove = stacks[from-1].charAt(i)+ valuesToMove.substring(0);
                    }
                }
                if(valuesToMove.length() != 0){
                    stacks[from-1] = stacks[from-1].substring(amount);
                    stacks[to-1] = valuesToMove + stacks[to-1];
                }
            }

        }
        for (String string : stacks) {
            System.out.print(string.charAt(0));
        }
    }

    private static void part2(String[] lines) {
        String[] stacks = 
        {"FTNZMGHJ",
        "JWV",
        "HTBJLVG",
        "LVDCNJPB",
        "GRPMSWF",
        "MVNBFCHG",
        "RMGHD",
        "DZVMNH",
        "HFNG"};

        int index = 0;

        for (String line : lines) {
            index++;
            if(index > 10){
                
                String[] moves = line.split(" ");
                int amount = Integer.parseInt(moves[1]);
                int from = Integer.parseInt(moves[3]);
                int to = Integer.parseInt(moves[5]);
                String valuesToMove = "";
                for (int i = 0; i < amount; i++) {
                    if(i < stacks[from-1].length()){
                        valuesToMove = valuesToMove.substring(0) + stacks[from-1].charAt(i);
                    }
                }
                if(valuesToMove.length() != 0){
                    stacks[from-1] = stacks[from-1].substring(amount);
                    stacks[to-1] = valuesToMove + stacks[to-1];
                }
            }

        }
        for (String string : stacks) {
            System.out.print(string.charAt(0));
        }
    }
}