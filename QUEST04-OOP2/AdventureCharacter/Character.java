public class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;

    public Character(String name, int maxHealth) {
        this.currentHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return (getCurrentHealth() == 0) ?
                String.format("%s : KO", getName()) :
                String.format("%s : %d/%d", getName(), getCurrentHealth(), getMaxHealth());
    }

    public void takeDamage(int damage) {
        this.currentHealth = Math.max(0, getCurrentHealth() - damage);
    }

    public void attack(Character target) {
        target.takeDamage(9);
    }

    public static void main(String[] args) {
        Character aragorn = new Character("Aragorn", 20);
        Character uruk = new Character("Uruk", 5);

        System.out.println(aragorn.toString());
        System.out.println(uruk.toString());

        aragorn.attack(uruk);

        System.out.println(uruk.toString());

        aragorn.takeDamage(12);

        System.out.println(aragorn.toString());
    }
}
