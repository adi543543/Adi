import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class test {
    private static int sizeOfCube = 3;
    public static void printFace(Face c, Map<Color, String> dictionary) {
        for (int i = 0; i < sizeOfCube; i++) {
            for (int j = 0; j < sizeOfCube; j++) {
                System.out.print(dictionary.get(c.getFaceColors()[i][j]) + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printCube(Cube c, Map<Color, String> dictionary){
        printFace(c.getCube()[0], dictionary);
        printFace(c.getCube()[1], dictionary);
        printFace(c.getCube()[2], dictionary);
        printFace(c.getCube()[3], dictionary);
        printFace(c.getCube()[4], dictionary);
        printFace(c.getCube()[5], dictionary);
    }

    public static void main(String[] args) {
        Map<Color, String> colorsDictionary = new HashMap<Color, String>();
        colorsDictionary.put(Color.BLUE, "BLUE  ");
        colorsDictionary.put(Color.RED, "RED   ");
        colorsDictionary.put(Color.WHITE, "WHITE ");
        colorsDictionary.put(Color.GREEN, "GREEN ");
        colorsDictionary.put(Color.ORANGE, "ORANGE");
        colorsDictionary.put(Color.YELLOW, "YELLOW");

        Color[][] colors = {{Color.WHITE, Color.RED, Color.WHITE},{Color.YELLOW,Color.GREEN,Color.YELLOW},{Color.BLUE,Color.BLUE,Color.BLUE}};

        Cube c = new Cube(3);
//        c.down(false);
//        printCube(c, colorsDictionary);
//
//        System.out.println();
//        System.out.println("hiiiiiiii");
//        System.out.println();

//        c.left(true);
//        printCube(c, colorsDictionary);
//
//        System.out.println();
//        System.out.println("hiiiiiiii");
//        System.out.println();

//        c.up(true);
//        printCube(c, colorsDictionary);
//
//        System.out.println();
//        System.out.println("hiiiiiiii");
//        System.out.println();
//
//        c.down(true);
//        printCube(c, colorsDictionary);

        Model m = new Model(3);
        String moves = m.randomScramble(4);
        System.out.println(moves);
        m.doMoves(moves);
        printCube(m.getFullCube(), colorsDictionary);

//        Color[][] faceColors = {{Color.YELLOW, Color.RED, Color.WHITE}, {Color.BLUE, Color.WHITE, Color.BLUE}, {Color.YELLOW, Color.RED, Color.WHITE}};
//        Face f = new Face(faceColors, 3);
//        printFace(f, colorsDictionary);
//        System.out.println();
//        System.out.println();
//        f.new_rotateFace(true);
//        printFace(f, colorsDictionary);


    }
}