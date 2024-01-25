package main;
public class Reddit
{
    //static int pickleX = 0;
    //static int pickleY = 0;
    static Location[] pickleArray;
    
    static {
        for (int i = 0; i < 6; i++) {
            pickleArray[i] = new Location(1, i);
        }
    }
    
    public static void main(String[] args) {
        int count = 0;
        while (pickleArray[0].y < 7) {
            if (branch(6, 6) == 840) {count++;}
            updatePickles();
        }
        System.out.println(count);
    }
    
    static void updatePickles() {
        for (int i = 0; i < 6; i++) {
            pickleArray[i].x++;
            if (pickleArray[i].x > 6) {pickleArray[i].y++;}
            if (pickleArray[i].y > 6) {pickleArray[i].y = 0;}
        }
    }
    
    static int branch(int x, int y) {
        if (valid(x, y)) {return 0;}
        if (x == 0 && y == 0) {return 1;}
        return branch(x, y - 1) + branch(x - 1, y);
    }
    
    static boolean valid(int inputX, int inputY) {
        return (inputX < 0 || inputY < 0) || (x == inputX && y == inputY);
    }
}

class Location {
    public int x;
    public int y;
    
    public Location(int x, int y) {
       this.x = x;
       this.y = y;
    }
    
    public boolean equals(Location otherLoc) {
        return otherLoc.x == x && otherLoc.y == y;
    }
}