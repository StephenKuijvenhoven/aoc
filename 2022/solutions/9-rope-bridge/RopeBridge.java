import utils.InputReader;

public class RopeBridge {
    private static final String FOLDER_NAME = "9-rope-bridge";
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String INPUT_FILE_PATH = String.format("solutions/%s/%s", FOLDER_NAME, INPUT_FILE_NAME);

    public static void main(String[] args) {
        String[] lines = InputReader.readInput(INPUT_FILE_PATH);
        part1(lines);
        part2(lines);
    }

    private static void part1(String[]lines) {
        int hX = 0;
        int hY = 0;
        int tX = 0;
        int tY = 0;
        Coord[] coords = new Coord[0];
        for (String line : lines) {
            char command = line.charAt(0);
            int value = Integer.parseInt(line.substring(2, line.length()));
            switch(command){
                case 'U':
                    for (int i = 0; i < value; i++) {
                        hY++;
                        if((hY - tY) == 2){
                            tY = (hY -1);
                            tX = hX;
                        }
                        Coord tail = new Coord(tX, tY);
                        coords = addCoordIfNew(tail, coords);
                    }
                    break;
                case 'L':
                    for (int i = 0; i < value; i++) {
                        hX--;
                        if((hX - tX)== -2){
                            tX = (hX +1);
                            tY = hY;
                        }
                        Coord tail = new Coord(tX, tY);
                        coords = addCoordIfNew(tail, coords);
                    }
                    break;
                case 'R':
                    for (int i = 0; i < value; i++) {
                        hX++;
                        if((hX - tX) == 2){
                            tX = (hX -1);
                            tY = hY;
                        }
                        Coord tail = new Coord(tX, tY);
                        coords = addCoordIfNew(tail, coords);
                    }
                    break;
                case 'D':
                    for (int i = 0; i < value; i++) {
                        hY--;
                        if((hY - tY) == -2){
                           tY = (hY +1);
                           tX = hX;
                        }
                        Coord tail = new Coord(tX, tY);
                        coords = addCoordIfNew(tail, coords);
                    }
                    break;
            }
        }
        System.out.println(coords.length);
    }

    private static void part2(String[]lines){
        Coord[] rope = new Coord[10];

        for (int i = 0; i < rope.length; i++) {
            rope[i] = new Coord(0, 0);
        }
        
        Coord[] coords = new Coord[0];

        for (String line : lines) {
            char command = line.charAt(0);
            int value = Integer.parseInt(line.substring(2, line.length()));
            switch(command){
                case 'U':
                    for (int i = 0; i < value; i++) {
                        rope[0].y++;

                        for (int j = 1; j < rope.length; j++) {
                            rope[j] = follow(rope[j], rope[j-1]);
                        }
                        Coord tail = new Coord(rope[9].x, rope[9].y);
                        if(isNewCoord(tail, coords)){
                            Coord[] temp = coords;
                            coords = new Coord[coords.length+1];
                            for (int k = 0; k < temp.length; k++) {
                                coords[k] = temp[k];
                            }
                            coords[coords.length-1] = tail;
                        }
                    }
                    
                    break;
                case 'L':
                    for (int i = 0; i < value; i++) {
                        rope[0].x++;

                        for (int j = 1; j < rope.length; j++) {
                            rope[j] = follow(rope[j], rope[j-1]);
                        }
                        Coord tail = new Coord(rope[9].x, rope[9].y);
                        if(isNewCoord(tail, coords)){
                            Coord[] temp = coords;
                            coords = new Coord[coords.length+1];
                            for (int k = 0; k < temp.length; k++) {
                                coords[k] = temp[k];
                            }
                            coords[coords.length-1] = tail;
                        }
                    }
                    
                    break;
                case 'R':
                    for (int i = 0; i < value; i++) {
                        rope[0].x--;

                        for (int j = 1; j < rope.length; j++) {
                            rope[j] = follow(rope[j], rope[j-1]);
                        }
                        Coord tail = new Coord(rope[9].x, rope[9].y);
                        if(isNewCoord(tail, coords)){
                            Coord[] temp = coords;
                            coords = new Coord[coords.length+1];
                            for (int k = 0; k < temp.length; k++) {
                                coords[k] = temp[k];
                            }
                            coords[coords.length-1] = tail;
                        }
                    }
                  
                    break;
                case 'D':
                    for (int i = 0; i < value; i++) {
                        rope[0].y--;

                        for (int j = 1; j < rope.length; j++) {
                            rope[j] = follow(rope[j], rope[j-1]);
                        }
                        Coord tail = new Coord(rope[9].x, rope[9].y);
                        if(isNewCoord(tail, coords)){
                            Coord[] temp = coords;
                            coords = new Coord[coords.length+1];
                            for (int k = 0; k < temp.length; k++) {
                                coords[k] = temp[k];
                            }
                            coords[coords.length-1] = tail;
                        }
                    }
                    break;
            }
        }
        System.out.println(coords.length);
    }

    private static Coord follow(Coord current, Coord CoordToFollow){
        if(((CoordToFollow.y - current.y) == -2) && ((CoordToFollow.x - current.x)== 2)){
            current.y = (CoordToFollow.y +1);
            current.x = (CoordToFollow.x -1);
        }else
        if(((CoordToFollow.y - current.y) == -2) && ((CoordToFollow.x - current.x)== -2)){
            current.y = (CoordToFollow.y +1);
            current.x = (CoordToFollow.x +1);
        }else
        if(((CoordToFollow.y - current.y) == 2) && ((CoordToFollow.x - current.x)== 2)){
            current.y = (CoordToFollow.y -1);
            current.x = (CoordToFollow.x -1);
        }else
        if(((CoordToFollow.y - current.y) == 2) && ((CoordToFollow.x - current.x)== -2)){
            current.y = (CoordToFollow.y -1);
            current.x = (CoordToFollow.x +1);
        }else
        if((CoordToFollow.x - current.x) == 2){
            current.x = (CoordToFollow.x -1);
            current.y = CoordToFollow.y;
        }else
        if((CoordToFollow.x - current.x) == -2){
            current.x = (CoordToFollow.x +1);
            current.y = CoordToFollow.y;
        }else
        if((CoordToFollow.y - current.y) == 2){
            current.y = (CoordToFollow.y -1);
            current.x = CoordToFollow.x;
        }else
        if((CoordToFollow.y - current.y) == -2){
            current.y = (CoordToFollow.y +1);
            current.x = CoordToFollow.x;
        }
        return current;
    }

    private static boolean isNewCoord(Coord tail, Coord[] coords){
        for (Coord coord : coords) {
            if(coord.x == tail.x && coord.y == tail.y){
                return false;
            }
        }
        return true;
    }

    private static Coord[] addCoordIfNew(Coord tail, Coord[] coords){
        for (Coord coord : coords) {
            if(coord.x == tail.x && coord.y == tail.y){
                return coords;
            }
        }
        Coord[] temp = coords;
        coords = new Coord[coords.length+1];
        for (int i = 0; i < temp.length; i++) {
            coords[i] = temp[i];
        }
        coords[coords.length-1] = tail;
        return coords;
    }

}