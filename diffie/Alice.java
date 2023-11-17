package diffie;

public class Alice {
    private final int a, g, p;
    private int y;

    public Alice(int a, int g, int p) {
        this.a = a;
        this.g = g;
        this.p = p;
    }

    public int getBase() {
        return g;
    }

    public int getPrime() {
        return p;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int calculateX() {
        return (int) (Math.pow(g, a) % p);
    }

    public int calculateKey() {
        return (int) (Math.pow(y, a) % p);
    }
}
