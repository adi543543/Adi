import java.awt.*;

public class Face {
    // the Dimension
    private Color[][] faceColors;
    private CubeSize sizeOfCube;

    public Face(Color[][] faceColors, int sizeOfCube) {
        //A constructor that Build a standard cube (3 on 3).
        this.faceColors = faceColors;
        this.sizeOfCube = new CubeSize(sizeOfCube);
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

    public Color[] getRowOrColumnColors(boolean isRow, int numOfRowOrColumn){
        if (isRow){
            return this.faceColors[numOfRowOrColumn];
        }
        Color[] temp = new Color[this.sizeOfCube.getSizeOfCube()];
        for (int i = 0; i < this.sizeOfCube.getSizeOfCube(); i++)
        {
            temp[i] = this.faceColors[i][numOfRowOrColumn];
        }
        return temp;
    }

    public void setSizeOfCube(int sizeOfCube) {
        this.sizeOfCube.setSizeOfCube(sizeOfCube);
    }

    public void setFaceColors(Color[][] faceColors) {
        this.faceColors = faceColors;
    }

    public void rotateSide(boolean isRow, int numOfRowOrColumn, Color[] rowOrColumnColor) {
        // The action is responsible for the movement of a row or column in the face

        if (isRow) {
            for (int i = 0; i < this.sizeOfCube.getSizeOfCube(); i++) {
                this.faceColors[numOfRowOrColumn][i] = rowOrColumnColor[i];
            }
        }
        else {
            for (int i = 0; i < this.sizeOfCube.getSizeOfCube(); i++) {
                this.faceColors[i][numOfRowOrColumn] = rowOrColumnColor[i];
            }
        }
    }

    public void rotateFace(boolean dirFlag) {
        // The action is responsible for the movement of the face
        Color[][] new_wigColors = new Color[this.sizeOfCube.getSizeOfCube()][this.sizeOfCube.getSizeOfCube()];

        for (int i = 0; i < this.sizeOfCube.getSizeOfCube(); i++) {
            for (int j = 0; j < this.sizeOfCube.getSizeOfCube(); j++) {
                if (dirFlag){
                    new_wigColors[this.sizeOfCube.getSizeOfCube() - 1 - j][this.sizeOfCube.getSizeOfCube() - 1 - i] = this.faceColors[i][j];
                }
                else{
                    new_wigColors[j][i] = this.faceColors[i][j];
                }
            }
        }
        this.faceColors = new_wigColors;
    }

}
