import java.awt.*;

public class SolverLevel2 {
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

    public SolverLevel2(Face[] fullCube, int sizeOfCube) {
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

    public String createSecondRowYellowFace(){
        String result = "";
//        int createSecondRowYellowFaceC = 0;
        while (checkYellowFace() == false)
        {
//            System.out.println("createSecondRowYellowFace runs- " + createSecondRowYellowFaceC + " times!");
//            createSecondRowYellowFaceC++;
            if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) != Color.YELLOW && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) != Color.YELLOW)
            {
//                System.out.println("1");
                if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) == Color.BLUE && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) == Color.RED)
                {
//                    System.out.println("blue + red");
                    this.fullCube.up(true);
                    this.fullCube.up(true);
                    this.fullCube.back(false);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    this.fullCube.up(false);
                    this.fullCube.left(false);
                    result += "uuBubulUL";
                }
                else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) == Color.RED && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) == Color.GREEN)
                {
//                    System.out.println("red + green");
                    this.fullCube.up(true);
                    this.fullCube.left(false);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    this.fullCube.up(false);
                    this.fullCube.front(false);
                    result += "uLulufUF";
                }
                else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) == Color.GREEN && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) == Color.ORANGE)
                {
//                    System.out.println("green + orange");
                    this.fullCube.front(false);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    this.fullCube.up(false);
                    this.fullCube.right(false);
                    result += "FufurUR";
                }
                else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) == Color.ORANGE && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) == Color.BLUE)
                {
//                    System.out.println("orange + blue");
                    this.fullCube.up(false);
                    this.fullCube.right(false);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    this.fullCube.up(false);
                    this.fullCube.back(false);
                    result += "URurubUB";
                }
                else {
                    if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) == Color.RED && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) == Color.BLUE)
                    {
//                        System.out.println("blue + red");
                        this.fullCube.up(true);
                        this.fullCube.up(true);
                        this.fullCube.back(false);
                        this.fullCube.up(true);
                        this.fullCube.back(true);
                        this.fullCube.up(true);
                        this.fullCube.left(true);
                        this.fullCube.up(false);
                        this.fullCube.left(false);
                        result += "uuBubulUL";
                    }
                    else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) == Color.GREEN && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) == Color.RED)
                    {
//                        System.out.println("red + green");
                        this.fullCube.up(true);
                        this.fullCube.left(false);
                        this.fullCube.up(true);
                        this.fullCube.left(true);
                        this.fullCube.up(true);
                        this.fullCube.front(true);
                        this.fullCube.up(false);
                        this.fullCube.front(false);
                        result += "uLulufUF";
                    }
                    else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) == Color.ORANGE && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) == Color.GREEN)
                    {
//                        System.out.println("green + orange");
                        this.fullCube.front(false);
                        this.fullCube.up(true);
                        this.fullCube.front(true);
                        this.fullCube.up(true);
                        this.fullCube.right(true);
                        this.fullCube.up(false);
                        this.fullCube.right(false);
                        result += "FufurUR";
                    }
                    else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) == Color.BLUE && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) == Color.ORANGE)
                    {
//                        System.out.println("orange + blue");
                        this.fullCube.up(false);
                        this.fullCube.right(false);
                        this.fullCube.up(true);
                        this.fullCube.right(true);
                        this.fullCube.up(true);
                        this.fullCube.back(true);
                        this.fullCube.up(false);
                        this.fullCube.back(false);
                        result += "URurubUB";
                    }
                }
            }
            if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) != Color.YELLOW && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) != Color.YELLOW)
            {
//                System.out.println("2");
                if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) == Color.BLUE && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) == Color.RED)
                {
                    this.fullCube.up(false);
                    this.fullCube.back(false);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    this.fullCube.up(false);
                    this.fullCube.left(false);
                    result += "UBubulUL";
                }
                else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) == Color.RED && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) == Color.GREEN)
                {
                    this.fullCube.up(true);
                    this.fullCube.up(true);
                    this.fullCube.left(false);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    this.fullCube.up(false);
                    this.fullCube.front(false);
                    result += "uuLulufUF";
                }
                else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) == Color.GREEN && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) == Color.ORANGE)
                {
                    this.fullCube.up(true);
                    this.fullCube.front(false);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    this.fullCube.up(false);
                    this.fullCube.right(false);
                    result += "uFufurUR";
                }
                else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) == Color.ORANGE && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) == Color.BLUE)
                {
                    this.fullCube.right(false);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    this.fullCube.up(false);
                    this.fullCube.back(false);
                    result += "RurubUB";
                }
                else {
                    if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) == Color.RED && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) == Color.BLUE)
                    {
                        this.fullCube.up(false);
                        this.fullCube.back(false);
                        this.fullCube.up(true);
                        this.fullCube.back(true);
                        this.fullCube.up(true);
                        this.fullCube.left(true);
                        this.fullCube.up(false);
                        this.fullCube.left(false);
                        result += "UBubulUL";
                    }
                    else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) == Color.GREEN && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) == Color.RED)
                    {
                        this.fullCube.up(true);
                        this.fullCube.up(true);
                        this.fullCube.left(false);
                        this.fullCube.up(true);
                        this.fullCube.left(true);
                        this.fullCube.up(true);
                        this.fullCube.front(true);
                        this.fullCube.up(false);
                        this.fullCube.front(false);
                        result += "uuLulufUF";
                    }
                    else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) == Color.ORANGE && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) == Color.GREEN)
                    {
                        this.fullCube.up(true);
                        this.fullCube.front(false);
                        this.fullCube.up(true);
                        this.fullCube.front(true);
                        this.fullCube.up(true);
                        this.fullCube.right(true);
                        this.fullCube.up(false);
                        this.fullCube.right(false);
                        result += "uFufurUR";
                    }
                    else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) == Color.BLUE && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) == Color.ORANGE)
                    {
                        this.fullCube.right(false);
                        this.fullCube.up(true);
                        this.fullCube.right(true);
                        this.fullCube.up(true);
                        this.fullCube.back(true);
                        this.fullCube.up(false);
                        this.fullCube.back(false);
                        result += "RurubUB";
                    }
                }
            }
            if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) != Color.YELLOW && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) != Color.YELLOW)
            {
//                System.out.println("3");
                if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.BLUE && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) == Color.RED)
                {
//                    System.out.println("blue + red");
                    this.fullCube.back(false);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    this.fullCube.up(false);
                    this.fullCube.left(false);
                    result += "BubulUL";
                }
                else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.RED && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) == Color.GREEN)
                {
//                    System.out.println("red + green");
                    this.fullCube.up(false);
                    this.fullCube.left(false);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    this.fullCube.up(false);
                    this.fullCube.front(false);
                    result += "ULulufUF";
                }
                else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.GREEN && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) == Color.ORANGE)
                {
//                    System.out.println("green + orange");
                    this.fullCube.up(true);
                    this.fullCube.up(true);
                    this.fullCube.front(false);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    this.fullCube.up(false);
                    this.fullCube.right(false);
                    result += "uuFufurUR";
                }
                else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.ORANGE && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) == Color.BLUE)
                {
//                    System.out.println("orange + blue");
                    this.fullCube.up(true);
                    this.fullCube.right(false);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    this.fullCube.up(false);
                    this.fullCube.back(false);
                    result += "uRurubUB";
                }
                else {
                    if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.RED && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) == Color.BLUE)
                    {
//                        System.out.println("blue + red");
                        this.fullCube.back(false);
                        this.fullCube.up(true);
                        this.fullCube.back(true);
                        this.fullCube.up(true);
                        this.fullCube.left(true);
                        this.fullCube.up(false);
                        this.fullCube.left(false);
                        result += "BubulUL";
                    }
                    else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.GREEN && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) == Color.RED)
                    {
//                        System.out.println("red + green");
                        this.fullCube.up(false);
                        this.fullCube.left(false);
                        this.fullCube.up(true);
                        this.fullCube.left(true);
                        this.fullCube.up(true);
                        this.fullCube.front(true);
                        this.fullCube.up(false);
                        this.fullCube.front(false);
                        result += "ULulufUF";
                    }
                    else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.ORANGE && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) == Color.GREEN)
                    {
//                        System.out.println("green + orange");
                        this.fullCube.up(true);
                        this.fullCube.up(true);
                        this.fullCube.front(false);
                        this.fullCube.up(true);
                        this.fullCube.front(true);
                        this.fullCube.up(true);
                        this.fullCube.right(true);
                        this.fullCube.up(false);
                        this.fullCube.right(false);
                        result += "uuFufurUR";
                    }
                    else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.BLUE && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) == Color.ORANGE)
                    {
//                        System.out.println("orange + blue");
                        this.fullCube.up(true);
                        this.fullCube.right(false);
                        this.fullCube.up(true);
                        this.fullCube.right(true);
                        this.fullCube.up(true);
                        this.fullCube.back(true);
                        this.fullCube.up(false);
                        this.fullCube.back(false);
                        result += "uRurubUB";
                    }
                }
            }
            if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) != Color.YELLOW && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) != Color.YELLOW)
            {

//                System.out.println("4");
                if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) == Color.RED)
                {
//                    System.out.println("blue + red");
                    this.fullCube.up(true);
                    this.fullCube.back(false);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    this.fullCube.up(false);
                    this.fullCube.left(false);
                    result += "uBubulUL";
                }
                else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.RED && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) == Color.GREEN)
                {
//                    System.out.println("red + green");
                    this.fullCube.left(false);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    this.fullCube.up(false);
                    this.fullCube.front(false);
                    result += "LulufUF";
                }
                else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) == Color.ORANGE)
                {
//                    System.out.println("green + orange");
                    this.fullCube.up(false);
                    this.fullCube.front(false);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    this.fullCube.up(false);
                    this.fullCube.right(false);
                    result += "UFufurUR";
                }
                else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) == Color.BLUE)
                {
//                    System.out.println("orange + blue");
                    this.fullCube.up(true);
                    this.fullCube.up(true);
                    this.fullCube.right(false);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    this.fullCube.up(false);
                    this.fullCube.back(false);
                    result += "uuRurubUB";
                }
                else {
                    if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.RED && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) == Color.BLUE)
                    {
//                        System.out.println("blue + red");
                        this.fullCube.up(true);
                        this.fullCube.back(false);
                        this.fullCube.up(true);
                        this.fullCube.back(true);
                        this.fullCube.up(true);
                        this.fullCube.left(true);
                        this.fullCube.up(false);
                        this.fullCube.left(false);
                        result += "uBubulUL";
                    }
                    else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) == Color.RED)
                    {
//                        System.out.println("red + green");
                        this.fullCube.left(false);
                        this.fullCube.up(true);
                        this.fullCube.left(true);
                        this.fullCube.up(true);
                        this.fullCube.front(true);
                        this.fullCube.up(false);
                        this.fullCube.front(false);
                        result += "LulufUF";
                    }
                    else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) == Color.GREEN)
                    {
//                        System.out.println("green + orange");
                        this.fullCube.up(false);
                        this.fullCube.front(false);
                        this.fullCube.up(true);
                        this.fullCube.front(true);
                        this.fullCube.up(true);
                        this.fullCube.right(true);
                        this.fullCube.up(false);
                        this.fullCube.right(false);
                        result += "UFufurUR";
                    }
                    else if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) == Color.ORANGE)
                    {
//                        System.out.println("orange + blue");
                        this.fullCube.up(true);
                        this.fullCube.up(true);
                        this.fullCube.right(false);
                        this.fullCube.up(true);
                        this.fullCube.right(true);
                        this.fullCube.up(true);
                        this.fullCube.back(true);
                        this.fullCube.up(false);
                        this.fullCube.back(false);
                        result += "uuRurubUB";
                    }
                }

            }
        }
        return result;
    }

    public boolean checkYellowFace(){
        if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) != Color.YELLOW && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) != Color.YELLOW)
        {
            return false;
        }
        if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) != Color.YELLOW && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) != Color.YELLOW)
        {
            return false;
        }
        if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) != Color.YELLOW && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) != Color.YELLOW)
        {
            return false;
        }
        if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) != Color.YELLOW && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) != Color.YELLOW)
        {
            return false;
        }
        return true;
    }

    // not in use!
    public String createSecondRowSecondRows(){
        String result = "";
//        int createSecondRowSecondRowsC = 0;
        while (checkSecondRows() == false)
        {
//            System.out.println("createSecondRowSecondRows runs- " + createSecondRowSecondRowsC + " times!");
//            createSecondRowSecondRowsC++;
            // red - green
            if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW || this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1,0) == Color.YELLOW){
//                System.out.println("1");
                this.fullCube.left(false);
                this.fullCube.up(true);
                this.fullCube.left(true);
                this.fullCube.up(true);
                this.fullCube.front(true);
                this.fullCube.up(false);
                this.fullCube.front(false);
                result += "LulufUF";
            }
            // green - orange
            if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW || this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1,0) == Color.YELLOW){
//                System.out.println("2");
                this.fullCube.front(false);
                this.fullCube.up(true);
                this.fullCube.front(true);
                this.fullCube.up(true);
                this.fullCube.right(true);
                this.fullCube.up(false);
                this.fullCube.right(false);
                result += "FufurUR";
            }
            // orange - blue
            if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW || this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1,0) == Color.YELLOW){
//                System.out.println("3");
                this.fullCube.right(false);
                this.fullCube.up(true);
                this.fullCube.right(true);
                this.fullCube.up(true);
                this.fullCube.back(true);
                this.fullCube.up(false);
                this.fullCube.back(false);
                result += "RurubUB";
            }
            // blue - red
            if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW || this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1,0) == Color.YELLOW){
//                System.out.println("4");
                this.fullCube.back(false);
                this.fullCube.up(true);
                this.fullCube.back(true);
                this.fullCube.up(true);
                this.fullCube.left(true);
                this.fullCube.up(false);
                this.fullCube.left(false);
                result += "BubulUL";
            }

            // Fix second row
            if (this.fullCube.checkRows(2) == false && checkSecondRows() == false){
                result += fixSecondRows();
            }
        }
        return result;
    }

    // not in use!
    public boolean checkSecondRows(){
        boolean redGreenFlag = this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.RED && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1,0) == Color.GREEN;
        boolean greenOrangeFlag = this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1,0) == Color.ORANGE;
        boolean orangeBlueFlag = this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1,0) == Color.BLUE;
        boolean blueRedFlag = this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1,0) == Color.RED;
        return redGreenFlag && greenOrangeFlag && orangeBlueFlag && blueRedFlag;
    }

    public String fixSecondRows(){
        String result = "";
//        System.out.println("fixSecondRows");
        // red - green
        if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) != Color.RED || this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1,0) != Color.GREEN){
//            System.out.println("fixSecondRows- 1");
            this.fullCube.left(false);
            this.fullCube.up(true);
            this.fullCube.left(true);
            this.fullCube.up(true);
            this.fullCube.front(true);
            this.fullCube.up(false);
            this.fullCube.front(false);
            result += "LulufUF";
        }
        // green - orange
        if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) != Color.GREEN || this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1,0) != Color.ORANGE){
//            System.out.println("fixSecondRows- 2");
            this.fullCube.front(false);
            this.fullCube.up(true);
            this.fullCube.front(true);
            this.fullCube.up(true);
            this.fullCube.right(true);
            this.fullCube.up(false);
            this.fullCube.right(false);
            result += "FufurUR";
        }
        // orange - blue
        if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) != Color.ORANGE || this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1,0) != Color.BLUE){
//            System.out.println("fixSecondRows- 3");
            this.fullCube.right(false);
            this.fullCube.up(true);
            this.fullCube.right(true);
            this.fullCube.up(true);
            this.fullCube.back(true);
            this.fullCube.up(false);
            this.fullCube.back(false);
            result += "RurubUB";
        }
        // blue - red
        if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) != Color.BLUE || this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1,0) != Color.RED){
//            System.out.println("fixSecondRows- 4");
            this.fullCube.back(false);
            this.fullCube.up(true);
            this.fullCube.back(true);
            this.fullCube.up(true);
            this.fullCube.left(true);
            this.fullCube.up(false);
            this.fullCube.left(false);
            result += "BubulUL";

        }
        return result;
    }

    public String createSecondRow(){
        String result = "";
//        int createSecondRowSecondRowsC = 0;
        while (this.fullCube.checkRows(2) == false)
        {

//            System.out.println("createSecondRowSecondRows runs- " + createSecondRowSecondRowsC + " times!");
//            createSecondRowSecondRowsC++;
            // red - green
            if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW || this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1,0) == Color.YELLOW){
//                System.out.println("1- 1");
                this.fullCube.left(false);
                this.fullCube.up(true);
                this.fullCube.left(true);
                this.fullCube.up(true);
                this.fullCube.front(true);
                this.fullCube.up(false);
                this.fullCube.front(false);
                result += "LulufUF";
            }
            // green - orange
            if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW || this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1,0) == Color.YELLOW){
//                System.out.println("2 - 1");
                this.fullCube.front(false);
                this.fullCube.up(true);
                this.fullCube.front(true);
                this.fullCube.up(true);
                this.fullCube.right(true);
                this.fullCube.up(false);
                this.fullCube.right(false);
                result += "FufurUR";
            }
            // orange - blue
            if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW || this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1,0) == Color.YELLOW){
//                System.out.println("3 - 1");
                this.fullCube.right(false);
                this.fullCube.up(true);
                this.fullCube.right(true);
                this.fullCube.up(true);
                this.fullCube.back(true);
                this.fullCube.up(false);
                this.fullCube.back(false);
                result += "RurubUB";
            }
            // blue - red
            if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.YELLOW || this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1,0) == Color.YELLOW){
//                System.out.println("4 - 1");
                this.fullCube.back(false);
                this.fullCube.up(true);
                this.fullCube.back(true);
                this.fullCube.up(true);
                this.fullCube.left(true);
                this.fullCube.up(false);
                this.fullCube.left(false);
                result += "BubulUL";
            }


            // Yellow face
            if (this.fullCube.checkRows(2) == false){
                result += createSecondRowYellowFace();
            }


//            System.out.println("before-------------");
//            System.out.println();
            // Fix second row
            if (this.fullCube.checkRows(2) == false){
                result += fixSecondRows();
            }

//            System.out.println("after-------------");
            // Yellow face
            if (this.fullCube.checkRows(2) == false){
                result += createSecondRowYellowFace();
            }

        }

        System.out.println("_______________________second row!______________________");
        test.printCube(this.fullCube, test.colorsDictionary);
        return result;
    }

}
