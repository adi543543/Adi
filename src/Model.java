import java.util.Random;

public class Model {
    private static char moves[] = {'u', 'U', 'd', 'D', 'r', 'R', 'l', 'L', 'f', 'F', 'b', 'B'};
    private Cube fullCube;
    private CubeSize sizeOfCube;
    private SolverLevel1 al1;

    public Model(Cube fullCube, int sizeOfCube) {
        this.fullCube = fullCube;
        this.sizeOfCube = new CubeSize(sizeOfCube);
        this.al1 = new SolverLevel1(this.fullCube.getCube(), sizeOfCube);
    }

    public Model(int sizeOfCube) {
        this.fullCube = new Cube(sizeOfCube);
        this.sizeOfCube = new CubeSize(sizeOfCube);
    }

    public SolverLevel1 getAl1() {
        return al1;
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
        solution += this.al1.createWhiteFace();
        return solution;
    }

}
