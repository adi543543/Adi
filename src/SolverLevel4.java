import java.awt.*;
import java.util.Arrays;

public class SolverLevel4 {
    enum SIDES {
        YELLOW,
        ORANGE,
        GREEN,
        RED,
        BLUE,
        WHITE
    }

    ;
    private Cube fullCube;
    private CubeSize sizeOfCube;

    public SolverLevel4(Face[] fullCube, int sizeOfCube) {
        this.fullCube = new Cube(fullCube, sizeOfCube);
        this.sizeOfCube = new CubeSize(sizeOfCube);
    }

    public void setFullCube(Cube fullCube) {
        this.fullCube = fullCube;
    }

    public Cube getFullCube() {
        return fullCube;
    }

    public void setSizeOfCube(int sizeOfCube) {
        this.sizeOfCube.setSizeOfCube(sizeOfCube);
    }
}