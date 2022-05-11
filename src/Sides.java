public class Sides {
    private int front;
    private int back;
    private int up;
    private int down;
    private int right;
    private int left;

    public Sides() {
        this.front = 0;
        this.back = 1;
        this.up = 2;
        this.down = 3;
        this.right = 4;
        this.left = 5;
    }

    public Sides(int front, int back, int up, int down, int right, int left) {
        this.front = front;
        this.back = back;
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
    }

    public void turnX(boolean dir){
        int temp = this.up;
        if (dir == true){
            this.up = this.back;
            this.back = this.down;
            this.down = this.front;
            this.front = temp;
        }
        else {
            this.up = this.front;
            this.front = this.down;
            this.down = this.back;
            this.back = temp;
        }
    }

    public void turnY(boolean dir){
        int temp = this.up;
        if (dir == true){
            this.up = this.back;
            this.back = this.down;
            this.down = this.front;
            this.front = temp;
        }
        else {
            this.up = this.front;
            this.front = this.down;
            this.down = this.back;
            this.back = temp;
        }
    }

    public void turnZ(boolean dir){

    }

    public int getFront() {
        return front;
    }

    public int getBack() {
        return back;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
    }
}
