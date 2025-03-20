import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>();
    private Weapon weapon;

    public Character(String name, int maxHealth, Weapon weapon) {
        this.currentHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.name = name;
        allCharacters.add(this);
        this.weapon = weapon;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    protected void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return (getCurrentHealth() == 0) ?
                String.format("%s : KO", getName()) :
                String.format("%s : %d/%d", getName(), getCurrentHealth(), getMaxHealth());
    }

    public abstract void takeDamage(int damage);

    public abstract void attack(Character target);

    public static String printStatus() {
        StringBuilder sb = new StringBuilder();

        sb.append("------------------------------------------\n");
        if (allCharacters.isEmpty()) {
            sb.append("Nobody's fighting right now !\n");
        } else {
            sb.append("Characters currently fighting :\n");
            for (Character character : allCharacters) {
                sb.append(String.format(" - %s", character.toString())).append("\n");
            }
        }
        sb.append("------------------------------------------\n");

        return sb.toString();
    }

    public static Character fight(Character character1, Character character2) {
        while (character1.getCurrentHealth() > 0 && character2.getCurrentHealth() > 0) {
            character1.attack(character2);
            if (character2.getCurrentHealth() == 0) {
                return character1;
            }
            character2.attack(character1);
            if (character1.getCurrentHealth() == 0) {
                return character2;
            }
        }
        return null;
    }
}
