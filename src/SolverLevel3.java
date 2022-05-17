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
        while (checkYellowCross() == false){
            String solver = moveToTriangular();
            if (solver.length() != 0){
                result += solver;
            }
            this.fullCube.left(true);
            this.fullCube.up(true);
            this.fullCube.front(true);
            this.fullCube.up(false);
            this.fullCube.front(false);
            this.fullCube.left(false);
            result += "lufUFL";
        }
        return result;
    }

    public boolean checkYellowCross(){
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) != Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) != Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) != Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) != Color.YELLOW){
            return false;
        }
        return true;
    }

    public String moveToTriangular(){
        String result = "";
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) == Color.YELLOW && this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) == Color.YELLOW){
            this.fullCube.up(true);
            result += "u";
        }
        else if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) == Color.YELLOW && this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.YELLOW){
            this.fullCube.up(true);
            this.fullCube.up(true);
            result += "uu";
        }
        else if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW && this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.YELLOW){
            this.fullCube.up(false);
            result += "U";
        }
        return result;
    }

    public String createYellowFace(){
        System.out.println();
        System.out.println();
        System.out.println("hellooooooooooo");

        String result = "";
        while (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].checkSameColor(Color.YELLOW) == false){

            String solver = moveToStates();
            if (solver.length() != 0){
                result += solver;
            }
            this.fullCube.front(true);
            this.fullCube.up(true);
            this.fullCube.front(false);
            this.fullCube.up(true);
            this.fullCube.front(true);
            this.fullCube.up(true);
            this.fullCube.up(true);
            this.fullCube.front(false);
            result += "fuFufuuF";

            System.out.println("hiiiiiii");
        }
        System.out.println("____________________End algorithm____________________");
        test.printCube(this.fullCube, test.colorsDictionary);
        return result;
    }

    public boolean isFirstState(){
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,0) == Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW){
            return false;
        }
        return true;
    }

    public boolean isSecondState(){
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,0) == Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) != Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) != Color.YELLOW){
            return false;
        }
        return true;
    }

    public boolean isThirdState(){
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,0) != Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW){
            return false;
        }
        return true;
    }

    public boolean isFourthState(){
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,0) == Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) != Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) != Color.YELLOW){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW){
            return false;
        }
        return true;
    }

    public boolean isInState(){
        if (isFirstState()){
            System.out.println("isFirstState");

        }
        if (isFirstState() == true || isSecondState() == true || isThirdState() == true || isFourthState() == true ){
            return true;
        }
        return false;
    }

    public String moveToStates(){
        String result = "";
        while (isInState() == false){
            this.fullCube.up(true);
            result += "u";
        }
        if (isFirstState()){
            while (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW){
                this.fullCube.up(true);
                result += "u";
            }
        }

        return result;
    }
}