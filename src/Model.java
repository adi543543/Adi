import java.util.Random;

public class Model {
    private Cube fullCube;
//    private static char moves[] = {'u', 'U', 'd', 'D', 'r', 'R', 'l', 'L', 'f', 'F', 'b', 'B'};
    private static char moves[] = {'u', 'U', 'd', 'D', 'r', 'R', 'l', 'L'};
    private CubeSize sizeOfCube;

    public Model(Cube fullCube, int sizeOfCube) {
        this.fullCube = fullCube;
        this.sizeOfCube = new CubeSize(sizeOfCube);
    }

    public Model(int sizeOfCube) {
        this.fullCube = new Cube(sizeOfCube);
        this.sizeOfCube = new CubeSize(sizeOfCube);
    }

    public String randomScramble(int numOfMoves){
        if (numOfMoves == 0){
            return "";
        }

        Random rand = new Random();
        String moves = "";
        int randNum1, randNum2;

        randNum1 = rand.nextInt(8);
        moves += this.moves[randNum1];
        while (moves.length() != numOfMoves){
            randNum2 = rand.nextInt(8);
            if (randNum1 != randNum2){
                moves += this.moves[randNum2];
            }
            randNum1 = randNum2;
        }
        return moves;
    }

    public Cube getFullCube() {
        return fullCube;
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
}
