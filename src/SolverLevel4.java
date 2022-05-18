import java.awt.*;

public class SolverLevel4 {
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
//        System.out.println(faces);
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
//            System.out.println("solveThirdLayer!");
            Color completeRow = isAndWhichCompleteRow();
            if(completeRow != Color.BLACK) {
//                System.out.println("full row!!!!!!!!!!!!!");
                result += moveToSecondAlgorithm();
                if (isSecondAlgorithm()) {
                    if (completeRow == Color.ORANGE) {
                        result += secondAlgorithm("o");
                    }
                    else if (completeRow == Color.GREEN) {
                        result += secondAlgorithm("g");
                    }
                    else if (completeRow == Color.RED) {
                        result += secondAlgorithm("r");
                    }
                    else { // BLUE
                        result += secondAlgorithm("b");
                    }
                }
                else{
//                    System.out.println("only row!!");
                    if (completeRow == Color.ORANGE) {
                        result += firstAlgorithm("gr"); // FIRST ALGORITHM
                    }
                    else if (completeRow == Color.GREEN) {
                        result += firstAlgorithm("rb"); // FIRST ALGORITHM
                    }
                    else if (completeRow == Color.RED) {
                        result += firstAlgorithm("bo"); // FIRST ALGORITHM
                    }
                    else { // BLUE
                        result += firstAlgorithm("og"); // FIRST ALGORITHM
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
        for (int i = 1; i < 5; i++){
            Color c = this.fullCube.getCube()[i].checkSameLastRow();
            if (c != Color.BLACK){
                return c;
            }
        }
        return Color.BLACK;
    }

    public Color isAndWhichZebraRow(){
        if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0, 0) == this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0, this.sizeOfCube.getSizeOfCube() - 1)){
            return this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0, 0);
        }
        else if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0, 0) == this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0, this.sizeOfCube.getSizeOfCube() - 1)){
            return this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0, 0);
        }
        else if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0, 0) == this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0, this.sizeOfCube.getSizeOfCube() - 1)){
            return this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0, 0);
        }
        else if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0, 0) == this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0, this.sizeOfCube.getSizeOfCube() - 1)){
            return this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0, 0);
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

    public boolean isFaceSameColor(){
        if(this.fullCube.getCube()[SIDES.RED.ordinal()].checkSameColor(Color.RED)){
            return true;
        }
        else if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].checkSameColor(Color.BLUE)){
            return true;
        }
        else if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].checkSameColor(Color.ORANGE)){
            return true;
        }
        else if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].checkSameColor(Color.GREEN)){
            return true;
        }
        return false;
    }

    public String moveToSecondAlgorithm(){
        String result = "";
        int i = 0;

        while (isFaceSameColor() == false){
            this.fullCube.up(true);
            result += "u";
            i++;
            if (i > 4){
                break;
            }

        }
//        System.out.println("full cube face______________");
        return result;
    }

    public boolean isFirstAlgorithm(){
        if(isAndWhichZebraRow() != Color.black){
            return true;
        }
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

    public String moveToZebra(Color zebraColor){
        String result = "";
        if (zebraColor == Color.RED){
            while (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,0) != Color.RED || this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) != Color.RED){
                this.fullCube.up(true);
                result += "u";
            }
        }
        else if (zebraColor == Color.BLUE){
            while (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,0) != Color.BLUE || this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) != Color.BLUE){
                this.fullCube.up(true);
                result += "u";
            }
        }
        else if (zebraColor == Color.ORANGE){
            while (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,0) != Color.ORANGE || this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) != Color.ORANGE){
                this.fullCube.up(true);
                result += "u";
            }
        }
        else { //GREEN
            while (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,0) != Color.GREEN || this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) != Color.GREEN){
                this.fullCube.up(true);
                result += "u";
            }
        }
        if (isOnlyZebras()){
            this.fullCube.up(true);
            result += "u";
        }
        System.out.println("_______________________moveToZebra!______________________");
        test.printCube(this.fullCube, test.colorsDictionary);
        return result;
    }

    public String solveZebraState(Color zebraColor){
        String result = "";
        result += moveToZebra(zebraColor);
        if (zebraColor == Color.RED){
//            while(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0, 0) != Color.RED && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0, this.sizeOfCube.getSizeOfCube() - 1) != Color.RED){
//                this.fullCube.up(true);
//                result += "u";
//            }
//            System.out.println("zebraaaaaaaaaa");
            result += firstAlgorithm("bo");
        }
        else if (zebraColor == Color.BLUE){
//            while(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0, 0) != Color.BLUE && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0, this.sizeOfCube.getSizeOfCube() - 1) != Color.BLUE){
//                this.fullCube.up(true);
//                result += "u";
//            }
            result += firstAlgorithm("og");
        }
        else if (zebraColor == Color.ORANGE){
//            while(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0, 0) != Color.ORANGE && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0, this.sizeOfCube.getSizeOfCube() - 1) != Color.ORANGE){
//                this.fullCube.up(true);
//                result += "u";
//            }
            result += firstAlgorithm("gr");
        }
        else { // GREEN
//            while(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0, 0) != Color.GREEN && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0, this.sizeOfCube.getSizeOfCube() - 1) != Color.GREEN){
//                this.fullCube.up(true);
//                result += "u";
//            }
            result += firstAlgorithm("rb");
        }
        return result;
    }

    public String doFirstAlgorithm(){
        String result = "";
        while (isFirstAlgorithm() == false){
            this.fullCube.up(true);
            result += "u";
        }
        Color isZebra = isAndWhichZebraRow();
        if (isZebra != Color.BLACK){
            result += solveZebraState(isZebra);
        }
        else if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,0) == Color.RED){
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

    public boolean isOnlyZebras(){
        if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,0) != this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1)){
            return false;
        }
        else if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,0) != this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1)){
            return false;
        }
        else if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,0) != this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1)){
            return false;
        }
        else if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,0) != this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1)){
            return false;
        }
        return true;
    }
}