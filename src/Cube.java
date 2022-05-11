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
        this.cube = cube;
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

    public void up(boolean dir){
        this.cube[SIDES.YELLOW.ordinal()].rotateFace(dir);
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(this.cube[SIDES.ORANGE.ordinal()].getRowOrColumnColors(true, 0)));
        arr.addAll(Arrays.asList(this.cube[SIDES.GREEN.ordinal()].getRowOrColumnColors(true, 0)));
        arr.addAll(Arrays.asList(this.cube[SIDES.RED.ordinal()].getRowOrColumnColors(true, 0)));
        arr.addAll(Arrays.asList(this.cube[SIDES.BLUE.ordinal()].getRowOrColumnColors(true, 0)));

        if(dir == false)
        {
            for (int i = 0; i < 4; i++) {
                int index = (i * 3 + 3) % 12;
                this.cube[i + 1].rotateSide(true, 0, arr.subList(index, index + 3 ).toArray(new Color[0]));
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                int index = 9;
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                this.cube[i + 1].rotateSide(true, 0, arr.subList(index, index + 3 ).toArray(new Color[0]));
            }
        }
    }

    public void down(boolean dir){
        this.cube[SIDES.WHITE.ordinal()].rotateFace(dir);
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(this.cube[SIDES.ORANGE.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1)));
        arr.addAll(Arrays.asList(this.cube[SIDES.GREEN.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1)));
        arr.addAll(Arrays.asList(this.cube[SIDES.RED.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1)));
        arr.addAll(Arrays.asList(this.cube[SIDES.BLUE.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1)));

        if(dir == false)
        {
            for (int i = 0; i < 4; i++) {
                int index = (i * 3 + 3) % 12;
                this.cube[i + 1].rotateSide(true, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]));
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                int index = 9;
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                this.cube[i + 1].rotateSide(true, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]));
            }
        }
    }

    public void left(boolean dir){
        this.cube[SIDES.RED.ordinal()].rotateFace(dir);
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(this.cube[SIDES.YELLOW.ordinal()].getRowOrColumnColors(false, 0)));
        arr.addAll(Arrays.asList(this.cube[SIDES.GREEN.ordinal()].getRowOrColumnColors(false, 0)));
        arr.addAll(Arrays.asList(this.cube[SIDES.WHITE.ordinal()].getRowOrColumnColors(false, 0)));
        arr.addAll(Arrays.asList(this.cube[SIDES.BLUE.ordinal()].getRowOrColumnColors(false, 0)));

        int indexArr[] = new int[4];
        indexArr[0] = 0;
        indexArr[1] = 2;
        indexArr[2] = 5;
        indexArr[3] = 4;

        if(dir == false)
        {
            for (int i = 0; i < 4; i++) {
                int index = (i * 3 + 3) % 12;
                this.cube[indexArr[i]].rotateSide(false, 0, arr.subList(index, index + 3 ).toArray(new Color[0]));
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                int index = 9;
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                this.cube[indexArr[i]].rotateSide(false, 0, arr.subList(index, index + 3 ).toArray(new Color[0]));
            }
        }
    }

    public void right(boolean dir){
        this.cube[SIDES.ORANGE.ordinal()].rotateFace(dir);
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(this.cube[SIDES.YELLOW.ordinal()].getRowOrColumnColors(false, this.sizeOfCube.getSizeOfCube() - 1)));
        arr.addAll(Arrays.asList(this.cube[SIDES.GREEN.ordinal()].getRowOrColumnColors(false, this.sizeOfCube.getSizeOfCube() - 1)));
        arr.addAll(Arrays.asList(this.cube[SIDES.WHITE.ordinal()].getRowOrColumnColors(false, this.sizeOfCube.getSizeOfCube() - 1)));
        arr.addAll(Arrays.asList(this.cube[SIDES.BLUE.ordinal()].getRowOrColumnColors(false, this.sizeOfCube.getSizeOfCube() - 1)));

        int indexArr[] = new int[4];
        indexArr[0] = 0;
        indexArr[1] = 2;
        indexArr[2] = 5;
        indexArr[3] = 4;

        if(dir) // check why?
        {
            for (int i = 0; i < 4; i++) {
                int index = (i * 3 + 3) % 12;
                this.cube[indexArr[i]].rotateSide(false, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]));
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                int index = 9;
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                this.cube[indexArr[i]].rotateSide(false, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]));
            }
        }
    }

    public void front(boolean dir){
        this.cube[SIDES.GREEN.ordinal()].rotateFace(dir);
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(this.cube[SIDES.YELLOW.ordinal()].getRowOrColumnColors(false, 0)));
        arr.addAll(Arrays.asList(this.cube[SIDES.ORANGE.ordinal()].getRowOrColumnColors(false, 0)));
        arr.addAll(Arrays.asList(this.cube[SIDES.WHITE.ordinal()].getRowOrColumnColors(false, 0)));
        arr.addAll(Arrays.asList(this.cube[SIDES.RED.ordinal()].getRowOrColumnColors(false, 0)));

        int indexArr[] = new int[4];
        indexArr[0] = 0;
        indexArr[1] = 1;
        indexArr[2] = 5;
        indexArr[3] = 3;

        if(dir == false)
        {
            for (int i = 0; i < 4; i++) {
                int index = (i * 3 + 3) % 12;
                this.cube[indexArr[i]].rotateSide(false, 0, arr.subList(index, index + 3 ).toArray(new Color[0]));
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                int index = 9;
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                this.cube[indexArr[i]].rotateSide(false, 0, arr.subList(index, index + 3 ).toArray(new Color[0]));
            }
        }
    }

    public void back(boolean dir){
        this.cube[SIDES.WHITE.ordinal()].rotateFace(dir);
        ArrayList<Color> arr = new ArrayList<>(4 * this.sizeOfCube.getSizeOfCube());

        arr.addAll(Arrays.asList(this.cube[SIDES.ORANGE.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1)));
        arr.addAll(Arrays.asList(this.cube[SIDES.GREEN.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1)));
        arr.addAll(Arrays.asList(this.cube[SIDES.RED.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1)));
        arr.addAll(Arrays.asList(this.cube[SIDES.BLUE.ordinal()].getRowOrColumnColors(true, this.sizeOfCube.getSizeOfCube() - 1)));

        if(dir == false)
        {
            for (int i = 0; i < 4; i++) {
                int index = (i * 3 + 3) % 12;
                this.cube[i + 1].rotateSide(true, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]));
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                int index = 9;
                if (i > 0) {
                    index = (i * 3 - 3) % 12;
                }
                this.cube[i + 1].rotateSide(true, this.sizeOfCube.getSizeOfCube() - 1, arr.subList(index, index + 3 ).toArray(new Color[0]));
            }
        }
    }
}
