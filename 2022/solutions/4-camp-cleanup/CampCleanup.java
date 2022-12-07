import utils.InputReader;

public class CampCleanup{
    private static final String FOLDER_NAME = "4-camp-cleanup";
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String INPUT_FILE_PATH = String.format("solutions/%s/%s", FOLDER_NAME, INPUT_FILE_NAME);

    public static void main(String[] args) {
        String[] lines = InputReader.readInput(INPUT_FILE_PATH);
        part1(lines);
        part2(lines); 
    }

    private static void part1(String[] lines) {
        int contains = 0;
        for (String line : lines) {
            String[] assignments = line.split(",");
            String[] sectionIds1 = assignments[0].split("-");
            String[] sectionIds2 = assignments[1].split("-");
            int firstLower = Integer.parseInt(sectionIds1[0]);
            int firstUpper = Integer.parseInt(sectionIds1[1]);
            int secondLower = Integer.parseInt(sectionIds2[0]);
            int secondUpper = Integer.parseInt(sectionIds2[1]);
            
            if((firstUpper >= secondLower)){
                if(firstLower>= secondLower && firstUpper <= secondUpper){
                    contains++;
                    System.out.println(firstLower + "-" + firstUpper + "," + secondLower + "-"+secondUpper);
                }else if(secondLower >= firstLower && secondUpper <= firstUpper){
                    contains++;
                    System.out.println(firstLower + "-" + firstUpper + "," + secondLower + "-"+secondUpper);
                }
            }
        }
        System.out.println(contains);
    }

    private static void part2(String[] lines) {
        int overlap = 0;
        for (String line : lines) {
            String[] assignments = line.split(",");
            String[] sectionIds1 = assignments[0].split("-");
            String[] sectionIds2 = assignments[1].split("-");
            int firstLower = Integer.parseInt(sectionIds1[0]);
            int firstUpper = Integer.parseInt(sectionIds1[1]);
            int secondLower = Integer.parseInt(sectionIds2[0]);
            int secondUpper = Integer.parseInt(sectionIds2[1]);

            if((firstUpper >= secondLower)){
                if(!(firstLower > secondUpper)){
                    overlap++;
                }
                System.out.println(firstLower + "-" + firstUpper + "," + secondLower + "-"+secondUpper);
        }
        System.out.println(overlap);
            }           
    }
}