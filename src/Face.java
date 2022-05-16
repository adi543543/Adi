import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Face {
    // the Dimension
    private Color[][] faceColors;
    private CubeSize sizeOfCube;

    public Face(Face faceColors, int sizeOfCube) {
        //A constructor that Build a standard cube (3 on 3).
        this.faceColors = new Color[sizeOfCube][sizeOfCube];
        this.sizeOfCube = new CubeSize(sizeOfCube);
        for (int i = 0; i < sizeOfCube; i++){
            this.faceColors[i] = faceColors.getRowOrColumnColors(true, i, false).clone();
        }
    }

    public Face(Color c, int sizeOfCube) {
        //A constructor that defines the size of the cube.
        this.sizeOfCube = new CubeSize(sizeOfCube);
        this.faceColors = new Color[this.sizeOfCube.getSizeOfCube()][this.sizeOfCube.getSizeOfCube()];

        for (int i = 0; i < this.sizeOfCube.getSizeOfCube(); i++) {
            for (int j = 0; j < this.sizeOfCube.getSizeOfCube(); j++) {
                this.faceColors[i][j] = c;
            }
        }
    }

    public Color[][] getFaceColors() {
        return faceColors;
    }

    public Color[] getRowOrColumnColors(boolean isRow, int numOfRowOrColumn, boolean isBackwards){
        if (isRow){
            if (isBackwards){
                Color[] temp = new Color[this.sizeOfCube.getSizeOfCube()];
                for (int i = this.sizeOfCube.getSizeOfCube(); i < 0; i--)
                {
                    temp[this.sizeOfCube.getSizeOfCube()- i] = this.faceColors[numOfRowOrColumn][i - 1];
                }
            }
            return this.faceColors[numOfRowOrColumn];
        }
        Color[] temp = new Color[this.sizeOfCube.getSizeOfCube()];
        if (isBackwards){
            for (int i = this.sizeOfCube.getSizeOfCube(); i < 0; i--)
            {
                temp[this.sizeOfCube.getSizeOfCube()- i] = this.faceColors[i - 1][numOfRowOrColumn];
            }
        }
        else {
            for (int i = 0; i < this.sizeOfCube.getSizeOfCube(); i++) {
                temp[i] = this.faceColors[i][numOfRowOrColumn];
            }
        }
        return temp;
    }

    public Color getCubie(int row, int column){
        return this.faceColors[row][column];
    }

    public void setSizeOfCube(int sizeOfCube) {
        this.sizeOfCube.setSizeOfCube(sizeOfCube);
    }

    public void setFaceColors(Color[][] faceColors) {
        this.faceColors = faceColors;
    }

    public void rotateSide(boolean isRow, int numOfRowOrColumn, Color[] rowOrColumnColor, boolean rC) {
        // The action is responsible for the movement of a row or column in the face

        if (isRow) {
            for (int i = 0; i < this.sizeOfCube.getSizeOfCube(); i++) {
                if(rC){
                    this.faceColors[numOfRowOrColumn][i] = rowOrColumnColor[this.sizeOfCube.getSizeOfCube() - i - 1];
                }
                else {
                    this.faceColors[numOfRowOrColumn][i] = rowOrColumnColor[i];
                }
            }
        }
        else {
            for (int i = 0; i < this.sizeOfCube.getSizeOfCube(); i++) {
                if (rC){
                    this.faceColors[i][numOfRowOrColumn] = rowOrColumnColor[this.sizeOfCube.getSizeOfCube() - i - 1];
                }
                else {
                    this.faceColors[i][numOfRowOrColumn] = rowOrColumnColor[i];
                }
            }
        }
    }

    // not working!!!!
    public void rotateFace(boolean dirFlag) {
        // The action is responsible for the movement of the face
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(getRowOrColumnColors(true, 0, false)));
        arr.addAll(Arrays.asList(getRowOrColumnColors(false, this.sizeOfCube.getSizeOfCube() - 1, false)));
        arr.addAll(Arrays.asList(getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1, false)));
        arr.addAll(Arrays.asList(getRowOrColumnColors(false, 0, false)));


//        for (int i = 0; i < this.sizeOfCube.getSizeOfCube(); i++) {
//            for (int j = 0; j < this.sizeOfCube.getSizeOfCube(); j++) {
//                if (dirFlag){
//                    newFaceColors[this.sizeOfCube.getSizeOfCube() - 1 - j][this.sizeOfCube.getSizeOfCube() - 1 - i] = this.faceColors[i][j];
//                }
//                else{
//                    newFaceColors[j][i] = this.faceColors[i][j];
//                }
//            }
//        }
//        System.out.println("\nUsing for-each loop\n");
//        for (Color c : arr)
//        {
//            System.out.println(c);
//        }

        int index = 9;
        for (int i = 0; i < 4; i++)
        {
            if (dirFlag == false){
                index = (i * 3 + 3) % 12;
                if (i == 0 || i == 3)
                {
                    rotateSide(i % 2 == 0, 0, arr.subList(index, index + 3 ).toArray(new Color[0]), i % 2 == 0);
                }
                else {
                    rotateSide(i % 2 == 0, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]), i % 2 == 0);
                }
            }
            else {
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                if (i == 0 || i == 3)
                {
                    rotateSide(i % 2 == 0, 0, arr.subList(index, index + 3 ).toArray(new Color[0]), i % 2 != 0);
                }
                else {
                    rotateSide(i % 2 == 0, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]), i % 2 != 0);
                }
            }

//            printFace(this.faceColors);
        }
    }

    // working!!!!
    public void new_rotateFace(boolean dirFlag){
        ArrayList<Color> arrOfCorners = new ArrayList<>(4);
        arrOfCorners.addAll(Arrays.asList(this.faceColors[0][0]));
        arrOfCorners.addAll(Arrays.asList(this.faceColors[0][this.sizeOfCube.getSizeOfCube() - 1]));
        arrOfCorners.addAll(Arrays.asList(this.faceColors[this.sizeOfCube.getSizeOfCube() - 1][this.sizeOfCube.getSizeOfCube() - 1]));
        arrOfCorners.addAll(Arrays.asList(this.faceColors[this.sizeOfCube.getSizeOfCube() - 1][0]));

        if (dirFlag){
            this.faceColors[0][0] = arrOfCorners.get(3);
            this.faceColors[0][this.sizeOfCube.getSizeOfCube() - 1] = arrOfCorners.get(0);
            this.faceColors[this.sizeOfCube.getSizeOfCube() - 1][this.sizeOfCube.getSizeOfCube() - 1] = arrOfCorners.get(1);
            this.faceColors[this.sizeOfCube.getSizeOfCube() - 1][0] = arrOfCorners.get(2);
        }
        else {
            this.faceColors[0][0] = arrOfCorners.get(1);
            this.faceColors[0][this.sizeOfCube.getSizeOfCube() - 1] = arrOfCorners.get(2);
            this.faceColors[this.sizeOfCube.getSizeOfCube() - 1][this.sizeOfCube.getSizeOfCube() - 1] = arrOfCorners.get(3);
            this.faceColors[this.sizeOfCube.getSizeOfCube() - 1][0] = arrOfCorners.get(0);
        }

        ArrayList<Color> arrOfEdges = new ArrayList<>(4);
        arrOfEdges.addAll(Arrays.asList(this.faceColors[0][1]));
        arrOfEdges.addAll(Arrays.asList(this.faceColors[1][this.sizeOfCube.getSizeOfCube() - 1]));
        arrOfEdges.addAll(Arrays.asList(this.faceColors[this.sizeOfCube.getSizeOfCube() - 1][1]));
        arrOfEdges.addAll(Arrays.asList(this.faceColors[1][0]));

        if (dirFlag){
            this.faceColors[0][1] = arrOfEdges.get(3);
            this.faceColors[1][this.sizeOfCube.getSizeOfCube() - 1] = arrOfEdges.get(0);
            this.faceColors[this.sizeOfCube.getSizeOfCube() - 1][1] = arrOfEdges.get(1);
            this.faceColors[1][0] = arrOfEdges.get(2);
        }
        else {
            this.faceColors[0][1] = arrOfEdges.get(1);
            this.faceColors[1][this.sizeOfCube.getSizeOfCube() - 1] = arrOfEdges.get(2);
            this.faceColors[this.sizeOfCube.getSizeOfCube() - 1][1] = arrOfEdges.get(3);
            this.faceColors[1][0] = arrOfEdges.get(0);
        }
    }

    public static void printFace(Color[][] f){
        Map<Color, String> colorsDictionary = new HashMap<Color, String>();
        colorsDictionary.put(Color.BLUE, "BLUE  ");
        colorsDictionary.put(Color.RED, "RED   ");
        colorsDictionary.put(Color.WHITE, "WHITE ");
        colorsDictionary.put(Color.GREEN, "GREEN ");
        colorsDictionary.put(Color.ORANGE, "ORANGE");
        colorsDictionary.put(Color.YELLOW, "YELLOW");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(colorsDictionary.get(f[i][j]) + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean checkSameColor(Color c){
        for (int i = 0; i < this.sizeOfCube.getSizeOfCube(); i++){
            for (int j = 0; j < this.sizeOfCube.getSizeOfCube(); j++){
                if (this.faceColors[i][j] != c){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkSameColorInRow(Color c, int row){
        for (int i = 0; i < this.sizeOfCube.getSizeOfCube(); i++){
            if (this.faceColors[row][i] != c){
                return false;
            }
        }

        return true;
    }

}
