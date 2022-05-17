import java.awt.*;

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

    public String firstAlgorithm(String faces){
        String result = "";
        switch (faces){
            case "gr":
                this.fullCube.front(false);
                this.fullCube.left(true);
                this.fullCube.front(false);
                this.fullCube.right(true);
                this.fullCube.right(true);
                this.fullCube.front(true);
                this.fullCube.left(false);
                this.fullCube.front(false);
                this.fullCube.right(true);
                this.fullCube.right(true);
                this.fullCube.front(true);
                this.fullCube.front(true);
                result += "FlFrrfLFrrff";
                break;

            case "rb":
                this.fullCube.left(false);
                this.fullCube.back(true);
                this.fullCube.left(false);
                this.fullCube.front(true);
                this.fullCube.front(true);
                this.fullCube.left(true);
                this.fullCube.back(false);
                this.fullCube.left(false);
                this.fullCube.front(true);
                this.fullCube.front(true);
                this.fullCube.left(true);
                this.fullCube.left(true);
                result += "LbLfflBLffll";
                break;

            case "bo":
                this.fullCube.back(false);
                this.fullCube.right(true);
                this.fullCube.back(false);
                this.fullCube.left(true);
                this.fullCube.left(true);
                this.fullCube.back(true);
                this.fullCube.right(false);
                this.fullCube.back(false);
                this.fullCube.left(true);
                this.fullCube.left(true);
                this.fullCube.back(true);
                this.fullCube.back(true);
                result += "BrBllbRBllbb";
                break;
            default: // case "og"
                this.fullCube.right(false);
                this.fullCube.front(true);
                this.fullCube.right(false);
                this.fullCube.back(true);
                this.fullCube.back(true);
                this.fullCube.right(true);
                this.fullCube.front(false);
                this.fullCube.right(false);
                this.fullCube.back(true);
                this.fullCube.back(true);
                this.fullCube.right(true);
                this.fullCube.right(true);
                result += "RfRbbrFRbbrr";
        }
        return result;
    }

    public String secondAlgorithm(String faces){
        String result = "";
        switch (faces){
            case "g":
                this.fullCube.left(true);
                this.fullCube.left(true);
                this.fullCube.up(true);
                this.fullCube.left(true);
                this.fullCube.up(true);
                this.fullCube.left(false);
                this.fullCube.up(false);
                this.fullCube.left(false);
                this.fullCube.up(false);
                this.fullCube.left(false);
                this.fullCube.up(true);
                this.fullCube.left(false);
                result += "lluluLULULuL";
                break;

            case "r":
                this.fullCube.back(true);
                this.fullCube.back(true);
                this.fullCube.up(true);
                this.fullCube.back(true);
                this.fullCube.up(true);
                this.fullCube.back(false);
                this.fullCube.up(false);
                this.fullCube.back(false);
                this.fullCube.up(false);
                this.fullCube.back(false);
                this.fullCube.up(true);
                this.fullCube.back(false);
                result += "bbubuBUBUBuB";
                break;

            case "b":
                this.fullCube.right(true);
                this.fullCube.right(true);
                this.fullCube.up(true);
                this.fullCube.right(true);
                this.fullCube.up(true);
                this.fullCube.right(false);
                this.fullCube.up(false);
                this.fullCube.right(false);
                this.fullCube.up(false);
                this.fullCube.right(false);
                this.fullCube.up(true);
                this.fullCube.right(false);
                result += "rruruRURURuR";
                break;

            default: // case "o"
                this.fullCube.front(true);
                this.fullCube.front(true);
                this.fullCube.up(true);
                this.fullCube.front(true);
                this.fullCube.up(true);
                this.fullCube.front(false);
                this.fullCube.up(false);
                this.fullCube.front(false);
                this.fullCube.up(false);
                this.fullCube.front(false);
                this.fullCube.up(true);
                this.fullCube.front(false);
                result += "ffufuFUFUFuF";
        }
        return result;
    }

    public String solveThirdLayer(){
        String result = "";
        while (this.fullCube.isSolved() == false){
            System.out.println("solveThirdLayer!");
            test.printCube(this.fullCube, test.colorsDictionary);
            Color completeRow = isAndWhichCompleteRow();
            if(completeRow != Color.BLACK) {
                result += moveToSecondAlgorithm();
                if (isSecondAlgorithm()) {
                    if (completeRow == Color.ORANGE) {
                        result += firstAlgorithm("gr");
                    }
                    else if (completeRow == Color.GREEN) {
                        result += firstAlgorithm("rb");
                    }
                    else if (completeRow == Color.RED) {
                        result += firstAlgorithm("bo");
                    }
                    else { // BLUE
                        result += firstAlgorithm("og");
                    }
                }
                else{ // FIX
                    if (completeRow == Color.ORANGE) {
                        result += secondAlgorithm("o"); // FIRST ALGORITHM
                    }
                    else if (completeRow == Color.GREEN) {
                        result += secondAlgorithm("g"); // FIRST ALGORITHM
                    }
                    else if (completeRow == Color.RED) {
                        result += secondAlgorithm("r"); // FIRST ALGORITHM
                    }
                    else { // BLUE
                        result += secondAlgorithm("b"); // FIRST ALGORITHM
                    }
                }
            }
            else {
                result += doFirstAlgorithm();
            }

        }
        System.out.println("_______________________Solved Cube!______________________");
        test.printCube(this.fullCube, test.colorsDictionary);
        return result;
    }

    public Color isAndWhichCompleteRow(){
        if (this.fullCube.getCube()[SIDES.RED.ordinal()].checkSameColorInRow(Color.RED, 0)){
            return Color.RED;
        }
        if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].checkSameColorInRow(Color.BLUE, 0)){
            return Color.BLUE;
        }
        if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].checkSameColorInRow(Color.ORANGE, 0)){
            return Color.ORANGE;
        }
        if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].checkSameColorInRow(Color.GREEN, 0)){
            return Color.GREEN;
        }
        return Color.BLACK;
    }

    public Color isAndWhichZebraRow(){
        if (this.fullCube.getCube()[SIDES.RED.ordinal()].checkSameColorInRow(Color.RED, 0)){
            return Color.RED;
        }
        if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].checkSameColorInRow(Color.BLUE, 0)){
            return Color.BLUE;
        }
        if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].checkSameColorInRow(Color.ORANGE, 0)){
            return Color.ORANGE;
        }
        if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].checkSameColorInRow(Color.GREEN, 0)){
            return Color.GREEN;
        }
        return Color.BLACK;
    }

    public int getFullFaceSide(){
        Color c = isAndWhichCompleteRow();
        if (c == Color.ORANGE){
            return 1;
        }
        else if (c == Color.GREEN){
            return 2;
        }
        else if (c == Color.RED){
            return 3;
        }
        return 4;
    }

    public boolean isSecondAlgorithm(){
        Color c = isAndWhichCompleteRow();
        if (c != Color.BLACK){
            if(c == Color.RED){
                if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,0) == this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1)){
                    return true;
                }
                return false;
            }
            else {
                if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,0) == this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1)){
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public String moveToSecondAlgorithm(){
        Color c = isAndWhichCompleteRow();
        int faceIndex;
        String result = "";

        if (c != Color.BLACK){
            faceIndex = getFullFaceSide();
            while (this.fullCube.getCube()[faceIndex].checkSameColor(c) == false){
                this.fullCube.up(true);
                result += "u";
            }
        }

        return result;
    }

    public boolean isFirstAlgorithm(){
        if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,0) == Color.RED){
            return true;
        }
        else if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,0) == Color.BLUE){
            return true;
        }
        else if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,0) == Color.ORANGE){
            return true;
        }
        else if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,0) == Color.GREEN){
            return true;
        }
        return false;
    }

    public String doFirstAlgorithm(){
        String result = "";
        while (isFirstAlgorithm() == false){
            this.fullCube.up(true);
            result += "u";
        }
        if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,0) == Color.RED){
            result += firstAlgorithm("bo");
        }
        else if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,0) == Color.BLUE){
            result += firstAlgorithm("og");
        }
        else if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,0) == Color.ORANGE){
            result += firstAlgorithm("gr");
        }
        else{ // GREEN
            result += firstAlgorithm("rb");
        }
        return result;
    }
}