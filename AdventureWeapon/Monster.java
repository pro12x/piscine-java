public class Monster extends Character {
    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    public void takeDamage(int damage) {
        int percent = (int) Math.floor(damage * 0.8);
        setCurrentHealth(Math.max(0, getCurrentHealth() - percent));
    }

    @Override
    public void attack(Character target) {
        if (getWeapon() == null) {
            target.takeDamage(7);
        } else {
            target.takeDamage(getWeapon().getDamage());
        }
        // target.takeDamage(7);
    }

    @Override
    public String toString() {
        return (getCurrentHealth() == 0) ?
                String.format("%s is a monster and is dead. He has the weapon %s", getName(), getWeapon().toString()) :
                String.format("%s is a monster with %d HP. He has the weapon %s", getName(), getCurrentHealth(), getWeapon().toString());
    }
}
