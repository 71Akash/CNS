package diffie;

public class Bob {
    private final int b;
    private int x, g, p;

    public final void setBase(int g) {
        this.g = g;
    }

    public final void setPrime(int p) {
        this.p = p;
    }

    public Bob(int b) {
        this.b = b;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int calculateKey() {
        return (int) (Math.pow(x, b) % p);
    }

    public int calculateY() {
        return (int) (Math.pow(g, b) % p);
    }
}
