import java.awt.*;

public class SolverLevel3 {
    enum SIDES {
        YELLOW,
        ORANGE,
        GREEN,
        RED,
        BLUE,
        WHITE
    };
    private Cube fullCube;
    private CubeSize sizeOfCube;

    public SolverLevel3(Face[] fullCube, int sizeOfCube) {
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

    public String createYellowCross(){
        String result = "";
        return result;
    }

    public boolean checkYellowCross(){
//        if(this.fullCube.getCube()[SolverLevel1.SIDES.YELLOW.ordinal()].getCubie(0,1) != Color.YELLOW)
        return true;
    }
}