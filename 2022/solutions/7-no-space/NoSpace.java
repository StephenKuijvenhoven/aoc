import utils.InputReader;

public class Template {
    private static final String FOLDER_NAME = "7-no-space";
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String INPUT_FILE_PATH = String.format("solutions/%s/%s", FOLDER_NAME, INPUT_FILE_NAME);
    private static int total = 0;
    private static int smallest = 0;

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        String[] lines = InputReader.readInput(INPUT_FILE_PATH);

        Folder root = null;
        Folder workingFolder = null;
        for (String line : lines) {
            if(line.contains("$ cd") && !line.contains("..")){
                String name = line.substring(5);
                if(name.equals("/") ){
                    Folder folder = new Folder(name);
                    root = folder;
                    workingFolder = root;
                }else{
                    Folder folder = new Folder(name);
                    workingFolder.addFolder(folder);
                    folder.setParent(workingFolder);
                    workingFolder = folder;
                }
            }
            if(Character.isDigit(line.charAt(0))){
                int value = Integer.parseInt(line.split(" ")[0]);
                workingFolder.addSize(value);
            }
            if(line.contains("..")){
                workingFolder = workingFolder.parent;
            }
        }
        addToTotal(root.folders);
        System.out.println(total);
    }

    private static void part2() {
        String[] lines = InputReader.readInput(INPUT_FILE_PATH);

        Folder root = null;
        Folder workingFolder = null;
        for (String line : lines) {
            if(line.contains("$ cd") && !line.contains("..")){
                String name = line.substring(5);
                if(name.equals("/") ){
                    Folder folder = new Folder(name);
                    root = folder;
                    workingFolder = root;
                }else{
                    Folder folder = new Folder(name);
                    workingFolder.addFolder(folder);
                    folder.setParent(workingFolder);
                    workingFolder = folder;
                }
            }
            if(Character.isDigit(line.charAt(0))){
                int value = Integer.parseInt(line.split(" ")[0]);
                workingFolder.addSize(value);
            }
            if(line.contains("..")){
                workingFolder = workingFolder.parent;
            }
        }
        int freeSpace = 70000000 - root.getFullSize();
        int neededSpace = 30000000 - freeSpace;
        smallest = 30000000;
        findSmallest(root.folders, neededSpace);
        System.out.println(smallest);
        System.out.println(freeSpace);
    }

    private static void findSmallest(Folder[] folders, int neededSpace){
        for (Folder folder: folders) {
            if(folder.getFullSize()> neededSpace){
                if(folder.getFullSize() <= smallest){
                    smallest = folder.getFullSize();
                }
            }
            if(folder.folders.length != 0){
                findSmallest(folder.folders, neededSpace);
            }
        }
    }

    private static void addToTotal(Folder[] folders){
        for (Folder folder: folders) {
            System.out.println(folder.folders.length);
            if(folder.getFullSize()< 100000){
                total += folder.getFullSize();
            }
            if(folder.folders.length != 0){
                addToTotal(folder.folders);
            }
        }
    }

}