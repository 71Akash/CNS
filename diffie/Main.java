package diffie;

public class Main {
    public static void main(String[] args) {
        Alice alice = new Alice(6, 5, 23);
        Bob bob = new Bob(15);
        bob.setBase(alice.getBase());
        bob.setPrime(alice.getPrime());
        bob.setX(alice.calculateX());
        int bobsKey = bob.calculateKey();
        alice.setY(bob.calculateY());
        int alicesKey = alice.calculateKey();
        System.out.format("Keys%nBob's key: %d%nAlice's key: %d%nMatch: %b%n", bobsKey, alicesKey,
                bobsKey == alicesKey);
    }

}
