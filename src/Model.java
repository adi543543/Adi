import java.util.Random;

public class Model {
    private static char moves[] = {'u', 'U', 'd', 'D', 'r', 'R', 'l', 'L', 'f', 'F', 'b', 'B'};
    private Cube fullCube;
    private CubeSize sizeOfCube;
    private SolverLevel1 al1;
    private SolverLevel2 al2;
    private SolverLevel3 al3;
    private SolverLevel4 al4;

    public Model(Cube fullCube, int sizeOfCube) {
        this.fullCube = fullCube;
        this.sizeOfCube = new CubeSize(sizeOfCube);
        this.al1 = new SolverLevel1(this.fullCube.getCube(), sizeOfCube);
        this.al2 = new SolverLevel2(this.fullCube.getCube(), sizeOfCube);
        this.al3 = new SolverLevel3(this.fullCube.getCube(), sizeOfCube);
        this.al4 = new SolverLevel4(this.fullCube.getCube(), sizeOfCube);
    }

    public Model(int sizeOfCube) {
        this.fullCube = new Cube(sizeOfCube);
        this.sizeOfCube = new CubeSize(sizeOfCube);
    }

    public SolverLevel1 getAl1() {
        return this.al1;
    }
    public SolverLevel2 getAl2() {
        return this.al2;
    }
    public SolverLevel3 getAl3() {
        return this.al3;
    }
    public SolverLevel4 getAl4() {
        return this.al4;
    }

    public String randomScramble(int numOfMoves){
        if (numOfMoves == 0){
            return "";
        }

        Random rand = new Random();
        String movesString = "";
        int randNum1, randNum2;

        randNum1 = rand.nextInt(12);
        movesString += moves[randNum1];
        while (movesString.length() != numOfMoves){
            randNum2 = rand.nextInt(12);
            if (randNum1 != randNum2){
                movesString += moves[randNum2];
            }
            randNum1 = randNum2;
        }
        return movesString;
    }

    public String scrambleSolution(String randomScramble){
        String res = randomScramble;

        for (int i = randomScramble.length() - 1; i >= 0; i--){
            if (Character.isUpperCase(randomScramble.charAt(i))){
                res += Character.toLowerCase(randomScramble.charAt(i));
            }
            else {
                res += Character.toUpperCase(randomScramble.charAt(i));
            }
        }
        return res;
    }

    public Cube getFullCube() {
        return this.fullCube;
    }

    public void doMoves(String sMoves){
        for(int i = 0; i < sMoves.length(); i++){
            switch(sMoves.charAt(i)) {
                case 'u':
                    this.fullCube.up(true);
                    break;
                case 'U':
                    this.fullCube.up(false);
                    break;
                case 'd':
                    this.fullCube.down(true);
                    break;
                case 'D':
                    this.fullCube.down(false);
                    break;
                case 'l':
                    this.fullCube.left(true);
                    break;
                case 'L':
                    this.fullCube.left(false);
                    break;
                case 'r':
                    this.fullCube.right(true);
                    break;
                case 'R':
                    this.fullCube.right(false);
                    break;
                case 'f':
                    this.fullCube.front(true);
                    break;
                case 'F':
                    this.fullCube.front(false);
                    break;
                case 'b':
                    this.fullCube.back(true);
                    break;
                default:
                    this.fullCube.back(false);
            }
        }
    }

    public String tryAl(){
        this.al1 = new SolverLevel1(this.fullCube.getCube(), this.sizeOfCube.getSizeOfCube());
        String solution = this.al1.createCross();
        String solver = this.al1.createCross();
        if (solver.length() != 0){
            solution += solver;
        }

        doMoves(solution);
        System.out.println();
        System.out.println("compareCubes createCross-" + compareCubes(this.al1.getFullCube(), this.fullCube));
        System.out.println();

        solver = this.al1.createWhiteFace();
        if (solver.length() != 0){
            solution += solver;
        }

        doMoves(solution);
        System.out.println();
        System.out.println("compareCubes createWhiteFace-" + compareCubes(this.al1.getFullCube(), this.fullCube));
        System.out.println();

        this.al2 = new SolverLevel2(this.al1.getFullCube().getCube(), this.sizeOfCube.getSizeOfCube());
        solver = this.al2.createSecondRow();
        if (solver.length() != 0){
            solution += solver;
        }


        doMoves(solution);
        System.out.println();
        System.out.println("compareCubes createSecondRow-" + compareCubes(this.al2.getFullCube(), this.fullCube));
        System.out.println();

        this.al3 = new SolverLevel3(this.al2.getFullCube().getCube(), this.sizeOfCube.getSizeOfCube());
        solver = this.al3.createYellowCross();
        if (solver.length() != 0){
            solution += solver;
        }

        doMoves(solution);
        System.out.println();
        System.out.println("compareCubes createYellowCross-" + compareCubes(this.al3.getFullCube(), this.fullCube));
        System.out.println();

        solver = this.al3.createYellowFace();
        if (solver.length() != 0){
            solution += solver;
        }

        doMoves(solution);
        System.out.println();
        System.out.println("compareCubes createYellowFace-" + compareCubes(this.al3.getFullCube(), this.fullCube));
        System.out.println();

        this.al4 = new SolverLevel4(this.al3.getFullCube().getCube(), this.sizeOfCube.getSizeOfCube());
        solver = this.al4.solveThirdLayer();
        if (solver.length() != 0){
            solution += solver;
        }

        doMoves(solution);
        System.out.println();
        System.out.println("compareCubes createYellowCross-" + compareCubes(this.al4.getFullCube(), this.fullCube));
        System.out.println();

        System.out.println("____________________End algorithm in Model____________________");
        return solution;
    }

    public void makeMove(char singleMove){
        switch(singleMove) {
            case 'u':
                this.fullCube.up(true);
                break;
            case 'U':
                this.fullCube.up(false);
                break;
            case 'd':
                this.fullCube.down(true);
                break;
            case 'D':
                this.fullCube.down(false);
                break;
            case 'l':
                this.fullCube.left(true);
                break;
            case 'L':
                this.fullCube.left(false);
                break;
            case 'r':
                this.fullCube.right(true);
                break;
            case 'R':
                this.fullCube.right(false);
                break;
            case 'f':
                this.fullCube.front(true);
                break;
            case 'F':
                this.fullCube.front(false);
                break;
            case 'b':
                this.fullCube.back(true);
                break;
            default:
                this.fullCube.back(false);
        }
    }

    public boolean compareCubes(Cube modelCube, Cube solverCube){
        for (int f = 0; f < 6; f++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (modelCube.getCube()[f].getCubie(i, j) != solverCube.getCube()[f].getCubie(i, j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
