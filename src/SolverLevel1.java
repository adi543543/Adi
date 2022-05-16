import java.awt.*;
import java.util.Arrays;

public class SolverLevel1 {
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

    public SolverLevel1(Face[] fullCube, int sizeOfCube) {
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

    private boolean isCross(){
        int count = 0;
        if(this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(0,1) == Color.WHITE && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.BLUE)
        {
            count += 1;
        }
        if(this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.RED)
        {
            count += 1;
        }
        if(this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.WHITE && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.GREEN)
        {
            count += 1;
        }
        if(this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(1,0) == Color.WHITE && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.ORANGE)
        {
            count += 1;
        }
        return count == 4;
    }

    private boolean checkWhiteFace(){
        if(this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(0,1) == Color.WHITE && this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) != Color.BLUE)
        {
            return false;
        }
        if(this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE && this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) != Color.RED)
        {
            return false;
        }
        if(this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.WHITE && this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) != Color.GREEN)
        {
            return false;
        }
        if(this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(1,0) == Color.WHITE && this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) != Color.ORANGE)
        {
            return false;
        }
        return true;
    }

    private boolean checkIndexFace(int index){
        if(this.fullCube.getCube()[index].getCubie(0,1) == Color.WHITE)
        {
            return false;
        }
        if(this.fullCube.getCube()[index].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE)
        {
            return false;
        }
        if(this.fullCube.getCube()[index].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.WHITE)
        {
            return false;
        }
        if(this.fullCube.getCube()[index].getCubie(1,0) == Color.WHITE)
        {
            return false;
        }
        return true;
    }

    public String crossLevelWhiteFace(){
        String res = "";
        while (checkWhiteFace() == false){
            // if near blue
            System.out.println("crossLevelWhiteFace");
            if(this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(0,1) == Color.WHITE)
            {
                if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) != Color.BLUE){
                    this.fullCube.back(true);
                    this.fullCube.back(true);
                    res += "bb";
                    if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) == Color.ORANGE){
                        this.fullCube.up(true);
                        res += "u";
                        this.fullCube.right(true);
                        this.fullCube.right(true);
                        res += "rr";
                    }
                    else if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) == Color.RED){
                        this.fullCube.up(false);
                        res += "U";
                        this.fullCube.left(true);
                        this.fullCube.left(true);
                        res += "ll";
                    }
                    else {
                        this.fullCube.up(true);
                        this.fullCube.up(true);
                        res += "uu";
                        this.fullCube.front(true);
                        this.fullCube.front(true);
                        res += "ff";
                    }
                }
            }

            // if near red
            if(this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE)
            {
                if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) != Color.RED){
                    this.fullCube.left(true);
                    this.fullCube.left(true);
                    res += "ll";
                    if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) == Color.BLUE){
                        this.fullCube.up(true);
                        res += "u";
                        this.fullCube.back(true);
                        this.fullCube.back(true);
                        res += "bb";
                    }
                    else if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) == Color.GREEN){
                        this.fullCube.up(false);
                        res += "U";
                        this.fullCube.front(true);
                        this.fullCube.front(true);
                        res += "ff";
                    }
                    else {
                        this.fullCube.up(true);
                        this.fullCube.up(true);
                        res += "uu";
                        this.fullCube.right(true);
                        this.fullCube.right(true);
                        res += "rr";
                    }
                }
            }

            // if near green
            if(this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.WHITE)
            {
                if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) != Color.GREEN){
                    this.fullCube.front(true);
                    this.fullCube.front(true);
                    res += "ff";
                    if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) == Color.ORANGE){
                        this.fullCube.up(false);
                        res += "U";
                        this.fullCube.right(true);
                        this.fullCube.right(true);
                        res += "rr";
                    }
                    else if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) == Color.RED){
                        this.fullCube.up(true);
                        res += "u";
                        this.fullCube.left(true);
                        this.fullCube.left(true);
                        res += "ll";
                    }
                    else {
                        this.fullCube.up(true);
                        this.fullCube.up(true);
                        res += "uu";
                        this.fullCube.back(true);
                        this.fullCube.back(true);
                        res += "bb";
                    }
                }
            }

            // if near orange
            if(this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(1,0) == Color.WHITE)
            {
                if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) != Color.ORANGE){
                    this.fullCube.right(true);
                    this.fullCube.right(true);
                    res += "rr";
                    if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) == Color.BLUE){
                        this.fullCube.up(false);
                        res += "U";
                        this.fullCube.back(true);
                        this.fullCube.back(true);
                        res += "bb";
                    }
                    else if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) == Color.GREEN){
                        this.fullCube.up(true);
                        res += "u";
                        this.fullCube.front(true);
                        this.fullCube.front(true);
                        res += "ff";
                    }
                    else {
                        this.fullCube.up(true);
                        this.fullCube.up(true);
                        res += "uu";
                        this.fullCube.right(true);
                        this.fullCube.right(true);
                        res += "rr";
                    }
                }
            }
        }
        return res;
    }

    public String crossLevelYellowFace(){
        String res = "";
        System.out.println("crossLevelYellowFace");
        // if near blue
        if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,1) == Color.WHITE)
        {
            if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) != Color.BLUE){
                    if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) == Color.ORANGE){
                        this.fullCube.up(true);
                        res += "u";
                        this.fullCube.right(true);
                        this.fullCube.right(true);
                        res += "rr";
                        this.fullCube.up(false);
                        res += "U";
                    }
                    else if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,1) == Color.RED){
                        this.fullCube.up(false);
                        res += "U";
                        this.fullCube.left(true);
                        this.fullCube.left(true);
                        res += "ll";
                        this.fullCube.up(true);
                        res += "u";
                    }
                    else {
                        this.fullCube.up(true);
                        this.fullCube.up(true);
                        res += "uu";
                        this.fullCube.front(true);
                        this.fullCube.front(true);
                        res += "ff";
                        this.fullCube.up(false);
                        this.fullCube.up(false);
                        res += "UU";
                    }
                }
            else{
                    this.fullCube.back(true);
                    this.fullCube.back(true);
                    res += "bb";
                }
        }

        // if near red
        if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,0) == Color.WHITE)
        {
            if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) != Color.RED){
                    if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) == Color.BLUE){
                        this.fullCube.up(true);
                        res += "u";
                        this.fullCube.back(true);
                        this.fullCube.back(true);
                        res += "bb";
                        this.fullCube.up(false);
                        res += "U";
                    }
                    else if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,1) == Color.GREEN){
                        this.fullCube.up(false);
                        res += "U";
                        this.fullCube.front(true);
                        this.fullCube.front(true);
                        res += "ff";
                        this.fullCube.up(true);
                        res += "u";
                    }
                    else {
                        this.fullCube.up(true);
                        this.fullCube.up(true);
                        res += "uu";
                        this.fullCube.right(true);
                        this.fullCube.right(true);
                        res += "rr";
                        this.fullCube.up(false);
                        this.fullCube.up(false);
                        res += "UU";
                    }
                }
            else{
                    this.fullCube.left(true);
                    this.fullCube.left(true);
                    res += "ll";
                }
            }

        // if near green
        if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,1) == Color.WHITE)
        {
            if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) != Color.GREEN){
                    if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) == Color.ORANGE){
                        this.fullCube.up(false);
                        res += "U";
                        this.fullCube.right(true);
                        this.fullCube.right(true);
                        res += "rr";
                        this.fullCube.up(true);
                        res += "u";
                    }
                    else if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,1) == Color.RED){
                        this.fullCube.up(true);
                        res += "u";
                        this.fullCube.left(true);
                        this.fullCube.left(true);
                        res += "ll";
                        this.fullCube.up(false);
                        res += "U";
                    }
                    else {
                        this.fullCube.up(true);
                        this.fullCube.up(true);
                        res += "uu";
                        this.fullCube.back(true);
                        this.fullCube.back(true);
                        res += "bb";
                        this.fullCube.up(false);
                        this.fullCube.up(false);
                        res += "UU";
                    }
                }
            else{
                    this.fullCube.front(true);
                    this.fullCube.front(true);
                    res += "ff";
                }
            }

        // if near orange
        if(this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE)
        {
            if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) != Color.ORANGE){
                    if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) == Color.BLUE){
                        this.fullCube.up(false);
                        res += "U";
                        this.fullCube.back(true);
                        this.fullCube.back(true);
                        res += "bb";
                        this.fullCube.up(true);
                        res += "u";
                    }
                    else if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,1) == Color.GREEN){
                        this.fullCube.up(true);
                        res += "u";
                        this.fullCube.front(true);
                        this.fullCube.front(true);
                        res += "ff";
                        this.fullCube.up(false);
                        res += "U";
                    }
                    else {
                        this.fullCube.up(true);
                        this.fullCube.up(true);
                        res += "uu";
                        this.fullCube.right(true);
                        this.fullCube.right(true);
                        res += "rr";
                        this.fullCube.up(false);
                        this.fullCube.up(false);
                        res += "UU";
                    }
                }
            else{
                    this.fullCube.right(true);
                    this.fullCube.right(true);
                    res += "rr";
                }
            }
        return res;
    }

    public String crossLevelRedFaces(){
        String res = "";

        while (checkIndexFace(SIDES.RED.ordinal()) == false) {
            System.out.println("crossLevelRedFaces");
            if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0, 1) == Color.WHITE) {
                this.fullCube.left(false);
                res += "L";
                if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, 0) == Color.WHITE) {
                    if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.RED) {
                        this.fullCube.down(false);
                        this.fullCube.back(true);
                        this.fullCube.down(true);
                        res += "Dbd";
                    } else if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE) {
                        this.fullCube.down(true);
                        this.fullCube.back(true);
                        this.fullCube.down(false);
                        res += "dbD";
                    } else if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE) {
                        this.fullCube.back(true);
                        res += "b";
                    } else {
                        this.fullCube.down(true);
                        this.fullCube.down(true);
                        this.fullCube.back(true);
                        this.fullCube.down(false);
                        this.fullCube.down(false);
                        res += "ddbDD";
                    }

                }
                this.fullCube.left(true);
                res += "l";

            }

            if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, 0) == Color.WHITE) {
                if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.RED) {
                    this.fullCube.down(false);
                    this.fullCube.back(true);
                    this.fullCube.down(true);
                    res += "Dbd";
                } else if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE) {
                    this.fullCube.down(true);
                    this.fullCube.back(true);
                    this.fullCube.down(false);
                    res += "dbD";
                } else if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE) {
                    this.fullCube.back(true);
                    res += "b";
                } else {
                    this.fullCube.down(true);
                    this.fullCube.down(true);
                    this.fullCube.back(true);
                    this.fullCube.down(false);
                    this.fullCube.down(false);
                    res += "ddbDD";
                }

            }

            if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE) {
                if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.RED) {
                    this.fullCube.down(true);
                    this.fullCube.front(false);
                    this.fullCube.down(false);
                    res += "dFD";
                } else if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE) {
                    this.fullCube.down(false);
                    this.fullCube.front(false);
                    this.fullCube.down(true);
                    res += "DFd";
                } else if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE) {
                    this.fullCube.down(true);
                    this.fullCube.down(true);
                    this.fullCube.front(false);
                    this.fullCube.down(false);
                    this.fullCube.down(false);
                    res += "ddFDD";
                } else {
                    this.fullCube.front(false);
                    res += "F";
                }
            }

            if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1, 1) == Color.WHITE) {
                this.fullCube.left(false);
                res += "L";
                if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE) {
                    if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.RED) {
                        this.fullCube.down(true);
                        this.fullCube.front(false);
                        this.fullCube.down(false);
                        res += "dFD";
                    } else if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE) {
                        this.fullCube.down(false);
                        this.fullCube.front(false);
                        this.fullCube.down(true);
                        res += "DFd";
                    } else if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE) {
                        this.fullCube.down(true);
                        this.fullCube.down(true);
                        this.fullCube.front(false);
                        this.fullCube.down(false);
                        this.fullCube.down(false);
                        res += "ddFDD";
                    } else {
                        this.fullCube.front(false);
                        res += "F";
                    }
                }

            }
        }

        return res;
    }

    public String crossLevelOrangeFaces(){
        String res = "";

        while (checkIndexFace(SIDES.ORANGE.ordinal()) == false) {
            System.out.println("crossLevelOrangeFaces");
            if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0, 1) == Color.WHITE) {
                this.fullCube.right(false);
                res += "R";
                if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, 0) == Color.WHITE) {
                    if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE) {
                        this.fullCube.down(false);
                        this.fullCube.front(true);
                        this.fullCube.down(true);
                        res += "Dfd";
                    } else if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.RED) {
                        this.fullCube.down(true);
                        this.fullCube.front(true);
                        this.fullCube.down(false);
                        res += "dfD";
                    } else if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN) {
                        this.fullCube.front(true);
                        res += "f";
                    } else {
                        this.fullCube.down(true);
                        this.fullCube.down(true);
                        this.fullCube.front(true);
                        this.fullCube.down(false);
                        this.fullCube.down(false);
                        res += "ddfDD";
                    }

                }
                this.fullCube.right(true);
                res += "r";

            }

            if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, 0) == Color.WHITE) {
                if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE) {
                    this.fullCube.down(false);
                    this.fullCube.front(true);
                    this.fullCube.down(true);
                    res += "Dfd";
                } else if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.RED) {
                    this.fullCube.down(true);
                    this.fullCube.front(true);
                    this.fullCube.down(false);
                    res += "dfD";
                } else if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN) {
                    this.fullCube.front(true);
                    res += "f";
                } else {
                    this.fullCube.down(true);
                    this.fullCube.down(true);
                    this.fullCube.front(true);
                    this.fullCube.down(false);
                    this.fullCube.down(false);
                    res += "ddfDD";
                }

            }

            if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE) {
                if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE) {
                    this.fullCube.down(false);
                    this.fullCube.back(false);
                    this.fullCube.down(true);
                    res += "DBd";
                } else if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.RED) {
                    this.fullCube.down(false);
                    this.fullCube.back(false);
                    this.fullCube.down(true);
                    res += "DBd";
                } else if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN) {
                    this.fullCube.down(true);
                    this.fullCube.down(true);
                    this.fullCube.back(false);
                    this.fullCube.down(false);
                    this.fullCube.down(false);
                    res += "ddBDD";
                } else {
                    this.fullCube.back(false);
                    res += "B";
                }
            }

            if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1, 1) == Color.WHITE) {
                this.fullCube.right(false);
                res += "R";
                if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE) {
                    if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE) {
                        this.fullCube.down(false);
                        this.fullCube.back(false);
                        this.fullCube.down(true);
                        res += "DBd";
                    } else if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.RED) {
                        this.fullCube.down(false);
                        this.fullCube.back(false);
                        this.fullCube.down(true);
                        res += "DBd";
                    } else if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN) {
                        this.fullCube.down(true);
                        this.fullCube.down(true);
                        this.fullCube.back(false);
                        this.fullCube.down(false);
                        this.fullCube.down(false);
                        res += "ddBDD";
                    } else {
                        this.fullCube.back(false);
                        res += "B";
                    }
                }

            }
        }
        return res;
    }

    public String crossLevelGreenFaces(){
        String res = "";

        while (checkIndexFace(SIDES.GREEN.ordinal()) == false) {
            System.out.println("crossLevelGreenFaces");
            if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0, 1) == Color.WHITE) {
                this.fullCube.front(false);
                res += "F";
                if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, 0) == Color.WHITE) {
                    if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN) {
                        this.fullCube.down(false);
                        this.fullCube.left(true);
                        this.fullCube.down(true);
                        res += "Dld";
                    } else if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE) {
                        this.fullCube.down(true);
                        this.fullCube.left(true);
                        this.fullCube.down(false);
                        res += "dlD";
                    } else if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.RED) {
                        this.fullCube.left(true);
                        res += "l";
                    } else {
                        this.fullCube.down(true);
                        this.fullCube.down(true);
                        this.fullCube.left(true);
                        this.fullCube.down(false);
                        this.fullCube.down(false);
                        res += "ddlDD";
                    }

                }
                this.fullCube.front(true);
                res += "f";

            }

            if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, 0) == Color.WHITE) {
                if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN) {
                    this.fullCube.down(false);
                    this.fullCube.left(true);
                    this.fullCube.down(true);
                    res += "Dld";
                } else if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE) {
                    this.fullCube.down(true);
                    this.fullCube.left(true);
                    this.fullCube.down(false);
                    res += "dlD";
                } else if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.RED) {
                    this.fullCube.left(true);
                    res += "l";
                } else {
                    this.fullCube.down(true);
                    this.fullCube.down(true);
                    this.fullCube.left(true);
                    this.fullCube.down(false);
                    this.fullCube.down(false);
                    res += "ddlDD";
                }

            }

            if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE) {
                if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN) {
                    this.fullCube.down(true);
                    this.fullCube.right(false);
                    this.fullCube.down(false);
                    res += "dRD";
                } else if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE) {
                    this.fullCube.down(false);
                    this.fullCube.right(false);
                    this.fullCube.down(true);
                    res += "DRd";
                } else if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.RED) {
                    this.fullCube.down(true);
                    this.fullCube.down(true);
                    this.fullCube.right(false);
                    this.fullCube.down(false);
                    this.fullCube.down(false);
                    res += "ddRDD";
                } else {
                    this.fullCube.right(false);
                    res += "R";
                }
            }

            if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1, 1) == Color.WHITE) {
                this.fullCube.front(false);
                res += "F";
                if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE) {
                    if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN) {
                        this.fullCube.down(true);
                        this.fullCube.right(false);
                        this.fullCube.down(false);
                        res += "dRD";
                    } else if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE) {
                        this.fullCube.down(false);
                        this.fullCube.right(false);
                        this.fullCube.down(true);
                        res += "DRd";
                    } else if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.RED) {
                        this.fullCube.down(true);
                        this.fullCube.down(true);
                        this.fullCube.right(false);
                        this.fullCube.down(false);
                        this.fullCube.down(false);
                        res += "ddRDD";
                    } else {
                        this.fullCube.right(false);
                        res += "R";
                    }
                }

            }
        }
        return res;
    }

    public String crossLevelBlueFaces(){
        String res = "";

        while (checkIndexFace(SIDES.BLUE.ordinal()) == false) {
            System.out.println("crossLevelBlueFaces");
            if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0, 1) == Color.WHITE) {
                this.fullCube.back(false);
                res += "B";
                if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, 0) == Color.WHITE) {
                    if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE) {
                        this.fullCube.down(false);
                        this.fullCube.right(true);
                        this.fullCube.down(true);
                        res += "Drd";
                    } else if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN) {
                        this.fullCube.down(true);
                        this.fullCube.right(true);
                        this.fullCube.down(false);
                        res += "drD";
                    } else if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE) {
                        this.fullCube.right(true);
                        res += "r";
                    } else {
                        this.fullCube.down(true);
                        this.fullCube.down(true);
                        this.fullCube.right(true);
                        this.fullCube.down(false);
                        this.fullCube.down(false);
                        res += "ddrDD";
                    }

                }
                this.fullCube.back(true);
                res += "b";

            }

            if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, 0) == Color.WHITE) {
                if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE) {
                    this.fullCube.down(false);
                    this.fullCube.right(true);
                    this.fullCube.down(true);
                    res += "Drd";
                } else if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN) {
                    this.fullCube.down(true);
                    this.fullCube.right(true);
                    this.fullCube.down(false);
                    res += "drD";
                } else if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE) {
                    this.fullCube.right(true);
                    res += "r";
                } else {
                    this.fullCube.down(true);
                    this.fullCube.down(true);
                    this.fullCube.right(true);
                    this.fullCube.down(false);
                    this.fullCube.down(false);
                    res += "ddrDD";
                }

            }

            if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE) {
                if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE) {
                    this.fullCube.down(true);
                    this.fullCube.left(false);
                    this.fullCube.down(false);
                    res += "dLD";
                } else if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN) {
                    this.fullCube.down(false);
                    this.fullCube.left(false);
                    this.fullCube.down(true);
                    res += "DLd";
                } else if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE) {
                    this.fullCube.down(true);
                    this.fullCube.down(true);
                    this.fullCube.left(false);
                    this.fullCube.down(false);
                    this.fullCube.down(false);
                    res += "ddLDD";
                } else {
                    this.fullCube.left(false);
                    res += "L";
                }
            }

            if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1, 1) == Color.WHITE) {
                this.fullCube.back(false);
                res += "B";
                if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE) {
                    if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE) {
                        this.fullCube.down(true);
                        this.fullCube.left(false);
                        this.fullCube.down(false);
                        res += "dLD";
                    } else if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN) {
                        this.fullCube.down(false);
                        this.fullCube.left(false);
                        this.fullCube.down(true);
                        res += "DLd";
                    } else if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(1, this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE) {
                        this.fullCube.down(true);
                        this.fullCube.down(true);
                        this.fullCube.left(false);
                        this.fullCube.down(false);
                        this.fullCube.down(false);
                        res += "ddLDD";
                    } else {
                        this.fullCube.left(false);
                        res += "L";
                    }
                }

            }
        }
        return res;
    }

    public String createCross(){
        String result = "";
        while (isCross() == false) {
            System.out.println("createCross");
            if (isCross() == false) { // check white
                result += crossLevelWhiteFace();
            }
            if (isCross() == false) { // check yellow
                result += crossLevelYellowFace();
            }
            if (isCross() == false) { // check green
                result += crossLevelGreenFaces();
            }
            if (isCross() == false) { // check yellow
                result += crossLevelYellowFace();
            }
            if (isCross() == false) { // check blue
                result += crossLevelBlueFaces();
            }
            if (isCross() == false) { // check yellow
                result += crossLevelYellowFace();
            }
            if (isCross() == false) { // check orange
                result += crossLevelOrangeFaces();
            }
            if (isCross() == false) { // check yellow
                result += crossLevelYellowFace();
            }
            if (isCross() == false) { // check red
                result += crossLevelRedFaces();
            }
            if (isCross() == false) { // check yellow
                result += crossLevelYellowFace();
            }
        }
        return result;
    }

    public String createWhiteFaceWhiteFace(){
        String result = "";
        int createWhiteFaceWhiteFaceCounter = 0;
        while (checkWhiteFaceWithoutCorners() == false){
            System.out.println("createWhiteFaceWhiteFace runs " + createWhiteFaceWhiteFaceCounter + " times!");
            createWhiteFaceWhiteFaceCounter++;
            if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(0,0) == Color.WHITE){
                this.fullCube.back(true);
                this.fullCube.up(true);
                this.fullCube.back(false);
                result += "buB";

            }
            if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
                this.fullCube.left(true);
                this.fullCube.up(true);
                this.fullCube.left(false);
                result += "luL";
            }
            if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.WHITE){
                this.fullCube.right(true);
                this.fullCube.up(true);
                this.fullCube.right(false);
                result += "ruR";
            }
            if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
                this.fullCube.front(true);
                this.fullCube.up(true);
                this.fullCube.front(false);
                result += "fuF";
            }
        }

        return result;
    }

    private boolean checkWhiteFaceWithoutCorners(){
        if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(0,0) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
            return false;
        }
        return true;
    }

    public String createWhiteFaceYellowFace(){
        String result = "";
        int createWhiteFaceYellowFaceCounter = 0;
        while (checkYellowFaceWithoutCorners() == false){
            System.out.println("createWhiteFaceYellowFace runs " + createWhiteFaceYellowFaceCounter + " times!");
            createWhiteFaceYellowFaceCounter++;
            // Blue face
            if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,0) == Color.WHITE){
                if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN){
                    this.fullCube.up(true);
                    this.fullCube.up(true);
                    this.fullCube.front(false);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    result += "uuFuf";
                }
                else if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE){
                    this.fullCube.up(true);
                    this.fullCube.right(false);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    result += "uRur";
                }
                else if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.RED){
                    this.fullCube.up(false);
                    this.fullCube.left(false);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    result += "ULul";
                }
                else {
                    this.fullCube.back(false);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    result += "Bub";
                }
            }

            // Orange face
            if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
                if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.RED){
                    this.fullCube.up(true);
                    this.fullCube.up(true);
                    this.fullCube.left(false);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    result += "uuLul";
                }
                else if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN){
                    this.fullCube.up(true);
                    this.fullCube.front(false);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    result += "uFuf";
                }
                else if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE){
                    this.fullCube.up(false);
                    this.fullCube.back(false);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    result += "UBub";
                }
                else {
                    this.fullCube.right(false);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    result += "Rur";
                }
            }

            // Red face
            if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.WHITE){
                if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE){
                    this.fullCube.up(true);
                    this.fullCube.up(true);
                    this.fullCube.right(false);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    result += "uuRur";
                }
                else if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE){
                    this.fullCube.up(true);
                    this.fullCube.back(false);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    result += "uBub";
                }
                else if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN){
                    this.fullCube.up(false);
                    this.fullCube.front(false);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    result += "UFuf";
                }
                else {
                    this.fullCube.left(false);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    result += "Lul";
                }
            }

            // Green face
            if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
                if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE){
                    this.fullCube.up(true);
                    this.fullCube.up(true);
                    this.fullCube.back(false);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    result += "uuBub";
                }
                else if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.RED){
                    this.fullCube.up(true);
                    this.fullCube.left(false);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    result += "uLul";
                }
                else if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE){
                    this.fullCube.up(false);
                    this.fullCube.right(false);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    result += "URur";
                }
                else {
                    this.fullCube.front(false);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    result += "Fuf";
                }
                System.out.println("result- " + result);
            }
        }

        return result;
    }

    private boolean checkYellowFaceWithoutCorners(){
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,0) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.YELLOW.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
            return false;
        }
        return true;
    }

    public String createWhiteFaceSideFaces(){
        String result = "";
        int createWhiteFaceSideFacesCounter = 0;
        while (checkSideFacesWithoutCorners() == false){
            System.out.println("createWhiteFaceSideFaces runs " + createWhiteFaceSideFacesCounter + " times!");
            createWhiteFaceSideFacesCounter++;
            // Red face
            if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.WHITE){
                this.fullCube.left(true);
                this.fullCube.up(true);
                this.fullCube.left(false);
                result += "luL";
            }
            if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
                this.fullCube.left(false);
                this.fullCube.up(false);
                this.fullCube.left(true);
                result += "LUl";
            }

            // Blue face
            if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.WHITE){
                this.fullCube.back(true);
                this.fullCube.up(true);
                this.fullCube.back(false);
                result += "buB";
            }
            if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
                this.fullCube.back(false);
                this.fullCube.up(false);
                this.fullCube.back(true);
                result += "BUb";
            }

            // Orange face
            if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.WHITE){
                this.fullCube.right(true);
                this.fullCube.up(true);
                this.fullCube.right(false);
                result += "ruR";
            }
            if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
                this.fullCube.right(false);
                this.fullCube.up(false);
                this.fullCube.right(true);
                result += "RUr";
            }

            // Green face
            if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.WHITE){
                this.fullCube.front(true);
                this.fullCube.up(true);
                this.fullCube.front(false);
                result += "fuF";
            }
            if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
                this.fullCube.front(false);
                this.fullCube.up(false);
                this.fullCube.front(true);
                result += "FUf";
            }
        }

        return result;
    }

    private boolean checkSideFacesWithoutCorners(){
        if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,0) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(this.sizeOfCube.getSizeOfCube() - 1,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
            return false;
        }
        return true;
    }

    public String createWhiteFaceBringUp(){
        String result = "";
        int createWhiteFaceBringUpCounter = 0;
        while (checkAllUpWithoutCorners() == false){
            System.out.println("createWhiteFaceBringUp runs " + createWhiteFaceBringUpCounter + " times!");
            createWhiteFaceBringUpCounter++;
            // Red face
            if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,0) == Color.WHITE){
                if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE){
                    this.fullCube.right(false);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    result += "Rur";
                }
                else if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE){
                    this.fullCube.up(false);
                    this.fullCube.back(false);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    result += "UBub";
                }
                else if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN){
                    this.fullCube.front(false);
                    this.fullCube.up(true);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    result += "Fuuf";
                }
                else {
                    this.fullCube.up(true);
                    this.fullCube.right(false);
                    this.fullCube.up(false);
                    this.fullCube.up(false);
                    this.fullCube.right(true);
                    result += "uRUUr";
                }
            }
            if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
                if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,0) == Color.ORANGE){
                    this.fullCube.right(true);
                    this.fullCube.up(false);
                    this.fullCube.right(false);
                    result += "rUR";
                }
                else if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,0) == Color.BLUE){
                    this.fullCube.back(true);
                    this.fullCube.up(false);
                    this.fullCube.up(false);
                    this.fullCube.back(false);
                    result += "bUUB";
                }
                else if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,0) == Color.GREEN){
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    this.fullCube.up(false);
                    this.fullCube.front(false);
                    result += "ufUF";
                }
                else {
                    this.fullCube.up(false);
                    this.fullCube.left(true);
                    this.fullCube.up(false);
                    this.fullCube.up(false);
                    this.fullCube.left(false);
                    result += "UlUUL";
                }
            }

            // Blue face
            if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,0) == Color.WHITE){
                if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN){
                    this.fullCube.front(false);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    result += "Fuf";
                }
                else if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE){
                    this.fullCube.up(false);
                    this.fullCube.right(false);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    result += "URur";
                }
                else if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.RED){
                    this.fullCube.left(false);
                    this.fullCube.up(true);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    result += "Luul";
                }
                else {
                    this.fullCube.up(true);
                    this.fullCube.back(false);
                    this.fullCube.up(false);
                    this.fullCube.up(false);
                    this.fullCube.back(true);
                    result += "uBUUb";
                }
            }
            if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
                if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,0) == Color.GREEN){
                    this.fullCube.front(true);
                    this.fullCube.up(false);
                    this.fullCube.front(false);
                    result += "fUF";
                }
                else if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,0) == Color.ORANGE){
                    this.fullCube.right(true);
                    this.fullCube.up(false);
                    this.fullCube.up(false);
                    this.fullCube.right(false);
                    result += "rUUR";
                }
                else if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,0) == Color.RED){
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    this.fullCube.up(false);
                    this.fullCube.left(false);
                    result += "ulUL";
                }
                else {
                    this.fullCube.up(false);
                    this.fullCube.back(true);
                    this.fullCube.up(false);
                    this.fullCube.up(false);
                    this.fullCube.back(false);
                    result += "UbUUB";
                }
            }

            // Orange face
            if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,0) == Color.WHITE){
                if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.RED){
                    this.fullCube.left(false);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    result += "Lul";
                }
                else if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.GREEN){
                    this.fullCube.up(false);
                    this.fullCube.front(false);
                    this.fullCube.up(true);
                    this.fullCube.front(true);
                    result += "UFuf";
                }
                else if(this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE){
                    this.fullCube.back(false);
                    this.fullCube.up(true);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    result += "Buub";
                }
                else {
                    this.fullCube.up(true);
                    this.fullCube.left(false);
                    this.fullCube.up(false);
                    this.fullCube.up(false);
                    this.fullCube.left(true);
                    result += "uLUUl";
                }
            }
            if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
                if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,0) == Color.RED){
                    this.fullCube.left(true);
                    this.fullCube.up(false);
                    this.fullCube.left(false);
                    result += "lUL";
                }
                else if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,0) == Color.GREEN){
                    this.fullCube.front(true);
                    this.fullCube.up(false);
                    this.fullCube.up(false);
                    this.fullCube.front(false);
                    result += "fUUF";
                }
                else if(this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,0) == Color.BLUE){
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    this.fullCube.up(false);
                    this.fullCube.back(false);
                    result += "ubUB";
                }
                else {
                    this.fullCube.up(false);
                    this.fullCube.right(true);
                    this.fullCube.up(false);
                    this.fullCube.up(false);
                    this.fullCube.right(false);
                    result += "UrUUR";
                }
            }

            // Green face
            if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,0) == Color.WHITE){
                if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.BLUE){
                    this.fullCube.back(false);
                    this.fullCube.up(true);
                    this.fullCube.back(true);
                    result += "Bub";
                }
                else if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.RED){
                    this.fullCube.up(false);
                    this.fullCube.left(false);
                    this.fullCube.up(true);
                    this.fullCube.left(true);
                    result += "ULul";
                }
                else if(this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.ORANGE){
                    this.fullCube.right(false);
                    this.fullCube.up(true);
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    result += "Ruur";
                }
                else {
                    this.fullCube.up(true);
                    this.fullCube.front(false);
                    this.fullCube.up(false);
                    this.fullCube.up(false);
                    this.fullCube.front(true);
                    result += "uFUUf";
                }
            }
            if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
                if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,0) == Color.BLUE){
                    this.fullCube.back(true);
                    this.fullCube.up(false);
                    this.fullCube.back(false);
                    result += "bUB";
                }
                else if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,0) == Color.RED){
                    this.fullCube.left(true);
                    this.fullCube.up(false);
                    this.fullCube.up(false);
                    this.fullCube.left(false);
                    result += "lUUL";
                }
                else if(this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,0) == Color.ORANGE){
                    this.fullCube.up(true);
                    this.fullCube.right(true);
                    this.fullCube.up(false);
                    this.fullCube.right(false);
                    result += "urUR";
                }
                else {
                    this.fullCube.up(false);
                    this.fullCube.front(true);
                    this.fullCube.up(false);
                    this.fullCube.up(false);
                    this.fullCube.front(false);
                    result += "UfUUF";
                }
            }
        }

        return result;
    }

    private boolean checkAllUpWithoutCorners(){
        if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,0) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.RED.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
            return false;
        }

        if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,0) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.BLUE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
            return false;
        }

        if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,0) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.ORANGE.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
            return false;
        }

        if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,0) == Color.WHITE){
            return false;
        }
        if (this.fullCube.getCube()[SIDES.GREEN.ordinal()].getCubie(0,this.sizeOfCube.getSizeOfCube() - 1) == Color.WHITE){
            return false;
        }
        return true;
    }

    public String createWhiteFace(){
        String result = "";
        int createWhiteFaceCounter = 0;
        while (this.fullCube.getCube()[SIDES.WHITE.ordinal()].checkSameColor(Color.WHITE) == false || this.fullCube.checkRows(1) == false) {
            System.out.println("createWhiteFace runs " + createWhiteFaceCounter + " times!");
            createWhiteFaceCounter++;
            // up all the white corner from bottom
            // down all white corners from White face
            // up all the white corner from bottom
            // up all white corners from yellow face
            // up all the white corner from bottom
            // down all white cornres from up
            // up all the white corner from bottom
            // loop

            if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].checkSameColor(Color.WHITE) == false && this.fullCube.checkRows(1) == false) {
                result += createWhiteFaceBringUp();
            }

            if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].checkSameColor(Color.WHITE) == false && this.fullCube.checkRows(1) == false) {
                result += createWhiteFaceWhiteFace();
            }

            if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].checkSameColor(Color.WHITE) == false && this.fullCube.checkRows(1) == false) {
                result += createWhiteFaceBringUp();
            }

            if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].checkSameColor(Color.WHITE) == false && this.fullCube.checkRows(1) == false) {
                result += createWhiteFaceYellowFace();
            }

            if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].checkSameColor(Color.WHITE) == false && this.fullCube.checkRows(1) == false) {
                result += createWhiteFaceBringUp();
            }

            if (this.fullCube.getCube()[SIDES.WHITE.ordinal()].checkSameColor(Color.WHITE) == false && this.fullCube.checkRows(1) == false) {
                result += createWhiteFaceSideFaces();
            }
        }
        return result;
    }
}
