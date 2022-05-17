import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

// 0- u y, 1-R o, 2-F, 3- L, 4- B, 5- D
public class Cube {
    enum SIDES {
        YELLOW,
        ORANGE,
        GREEN,
        RED,
        BLUE,
        WHITE
    };

    private Face[] cube;
    private CubeSize sizeOfCube;

    public Cube(Face[] cube, int sizeOfCube) {
        this.sizeOfCube = new CubeSize(sizeOfCube);
        this.cube = new Face[6];
        for (int i = 0; i < 6; i++){
            this.cube[i] = new Face(cube[i], sizeOfCube);
        }
    }

    public Cube(int sizeOfCube) {
        this.sizeOfCube = new CubeSize(sizeOfCube);
        cube = new Face[6];

        this.cube[SIDES.YELLOW.ordinal()] = new Face(Color.YELLOW, 3);
        this.cube[SIDES.ORANGE.ordinal()] = new Face(Color.ORANGE, 3);
        this.cube[SIDES.GREEN.ordinal()] = new Face(Color.GREEN, 3);
        this.cube[SIDES.RED.ordinal()] = new Face(Color.RED, 3);
        this.cube[SIDES.BLUE.ordinal()] = new Face(Color.BLUE, 3);
        this.cube[SIDES.WHITE.ordinal()] = new Face(Color.WHITE, 3);

    }

    public Face[] getCube() {
        return this.cube;
    }

    public void up(boolean dir) {
        this.cube[SIDES.YELLOW.ordinal()].new_rotateFace(dir); // check why not working!!!
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(this.cube[SIDES.ORANGE.ordinal()].getRowOrColumnColors(true, 0, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.GREEN.ordinal()].getRowOrColumnColors(true, 0, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.RED.ordinal()].getRowOrColumnColors(true, 0, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.BLUE.ordinal()].getRowOrColumnColors(true, 0, false)));

        if(dir == false)
        {
            for (int i = 0; i < 4; i++) {
                int index = (i * 3 + 3) % 12;
                this.cube[i + 1].rotateSide(true, 0, arr.subList(index, index + 3 ).toArray(new Color[0]), false);
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                int index = 9;
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                this.cube[i + 1].rotateSide(true, 0, arr.subList(index, index + 3 ).toArray(new Color[0]), false);
            }
        }
    }

    public void down(boolean dir){
        this.cube[SIDES.WHITE.ordinal()].new_rotateFace(dir);
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(this.cube[SIDES.ORANGE.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.GREEN.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.RED.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.BLUE.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1, false)));

        if(dir)
        {
            for (int i = 0; i < 4; i++) {
                int index = (i * 3 + 3) % 12;
                this.cube[i + 1].rotateSide(true, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]), false);
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                int index = 9;
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                this.cube[i + 1].rotateSide(true, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]), false);
            }
        }
    }

    public void left(boolean dir){
        this.cube[SIDES.RED.ordinal()].new_rotateFace(dir);
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(this.cube[SIDES.YELLOW.ordinal()].getRowOrColumnColors(false, 0, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.GREEN.ordinal()].getRowOrColumnColors(false, 0, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.WHITE.ordinal()].getRowOrColumnColors(false, this.sizeOfCube.getSizeOfCube() - 1, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.BLUE.ordinal()].getRowOrColumnColors(false, this.sizeOfCube.getSizeOfCube() - 1, false)));

        int indexArr[] = new int[4];
        indexArr[0] = 0;
        indexArr[1] = 2;
        indexArr[2] = 5;
        indexArr[3] = 4;

        if(dir == false)
        {
            for (int i = 0; i < 4; i++) {
                int index = (i * 3 + 3) % 12;
                if(i < 2) {
                    this.cube[indexArr[i]].rotateSide(false, 0, arr.subList(index, index + 3).toArray(new Color[0]), i % 2 != 0);
                }
                else {
                    this.cube[indexArr[i]].rotateSide(false, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3).toArray(new Color[0]), i % 2 != 0);
                }
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                int index = 9;
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                if(i < 2) {
                    this.cube[indexArr[i]].rotateSide(false, 0, arr.subList(index, index + 3).toArray(new Color[0]), i % 2 == 0);
                }
                else {
                    this.cube[indexArr[i]].rotateSide(false, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3).toArray(new Color[0]), i % 2 == 0);
                }
            }
        }
    }

    public void right(boolean dir){
        this.cube[SIDES.ORANGE.ordinal()].new_rotateFace(dir);
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(this.cube[SIDES.YELLOW.ordinal()].getRowOrColumnColors(false, this.sizeOfCube.getSizeOfCube() - 1, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.GREEN.ordinal()].getRowOrColumnColors(false, this.sizeOfCube.getSizeOfCube() - 1, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.WHITE.ordinal()].getRowOrColumnColors(false, 0, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.BLUE.ordinal()].getRowOrColumnColors(false, 0, false)));

        int indexArr[] = new int[4];
        indexArr[0] = 0;
        indexArr[1] = 2;
        indexArr[2] = 5;
        indexArr[3] = 4;

        if(dir) // check why?
        {
            for (int i = 0; i < 4; i++) {
                int index = (i * 3 + 3) % 12;
                if(i < 2) {
                    this.cube[indexArr[i]].rotateSide(false, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3).toArray(new Color[0]), i % 2 != 0);
                }
                else {
                    this.cube[indexArr[i]].rotateSide(false, 0, arr.subList(index, index + 3).toArray(new Color[0]), i % 2 != 0);
                }
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                int index = 9;
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                if(i < 2) {
                    this.cube[indexArr[i]].rotateSide(false, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3).toArray(new Color[0]), i % 2 == 0);
                }
                else {
                    this.cube[indexArr[i]].rotateSide(false, 0, arr.subList(index, index + 3).toArray(new Color[0]), i % 2 == 0);
                }
            }
        }
    }

    public void front(boolean dir){
        this.cube[SIDES.GREEN.ordinal()].new_rotateFace(dir);
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(this.cube[SIDES.YELLOW.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.ORANGE.ordinal()].getRowOrColumnColors(false, 0, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.WHITE.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.RED.ordinal()].getRowOrColumnColors(false, this.sizeOfCube.getSizeOfCube() - 1, false)));

        int indexArr[] = new int[4];
        indexArr[0] = 0;
        indexArr[1] = 1;
        indexArr[2] = 5;
        indexArr[3] = 3;

        if(dir == false)
        {
            for (int i = 0; i < 4; i++) {
                int index = (i * 3 + 3) % 12;
                if(i == 1){
                    this.cube[indexArr[i]].rotateSide(false, 0, arr.subList(index, index + 3 ).toArray(new Color[0]), false);
                }
                else {
                    this.cube[indexArr[i]].rotateSide(i % 2 == 0, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]), i == 2 || i == 3);
                }

            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                int index = 9;
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                if(i == 1){
                    this.cube[indexArr[i]].rotateSide(false, 0, arr.subList(index, index + 3 ).toArray(new Color[0]), false);
                }
                else {
                    this.cube[indexArr[i]].rotateSide(i % 2 == 0, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]), i == 0 || i == 3);
                }
            }
        }
    }

    public void back(boolean dir){
        this.cube[SIDES.BLUE.ordinal()].new_rotateFace(dir);
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(this.cube[SIDES.YELLOW.ordinal()].getRowOrColumnColors(true, 0, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.RED.ordinal()].getRowOrColumnColors(false, 0, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.WHITE.ordinal()].getRowOrColumnColors(true, 0, false)));
        arr.addAll(Arrays.asList(this.cube[SIDES.ORANGE.ordinal()].getRowOrColumnColors(false, this.sizeOfCube.getSizeOfCube() - 1, false)));

        int indexArr[] = new int[4];
        indexArr[0] = 0;
        indexArr[1] = 3;
        indexArr[2] = 5;
        indexArr[3] = 1;

        if(dir == false)
        {
            for (int i = 0; i < 4; i++) {
                int index = (i * 3 + 3) % 12;
                if(i == 3){
                    this.cube[indexArr[i]].rotateSide(false, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]), false);
                }
                else {
                    this.cube[indexArr[i]].rotateSide(i % 2 == 0, 0, arr.subList(index, index + 3 ).toArray(new Color[0]), i == 0 || i == 1);
                }

            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                int index = 9;
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                if(i == 3){
                    this.cube[indexArr[i]].rotateSide(false, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]), false);
                }
                else {
                    this.cube[indexArr[i]].rotateSide(i % 2 == 0, 0, arr.subList(index, index + 3 ).toArray(new Color[0]), i == 2 || i == 1);
                }
            }
        }
    }

    // not used?
    public Cube getCopyOfCube(){
        return new Cube(this.cube, this.sizeOfCube.getSizeOfCube());
    }

    public boolean checkRows(int numOfRows){
        for (int i = this.sizeOfCube.getSizeOfCube() - 1; i > this.sizeOfCube.getSizeOfCube() - 1 - numOfRows; i--) {
            if (this.cube[SIDES.GREEN.ordinal()].checkSameColorInRow(Color.GREEN, i) == false) {
                return false;
            }
            if (this.cube[SIDES.RED.ordinal()].checkSameColorInRow(Color.RED, i) == false) {
                return false;
            }
            if (this.cube[SIDES.BLUE.ordinal()].checkSameColorInRow(Color.BLUE, i) == false) {
                return false;
            }
            if (this.cube[SIDES.ORANGE.ordinal()].checkSameColorInRow(Color.ORANGE, i) == false) {
                return false;
            }
        }
        return true;
    }

}
