public class Monster extends Character {
    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    public void takeDamage(int damage) throws DeadCharacterException {
        if (isDead()) {
            throw new DeadCharacterException(this);
        }

        int percent = (int) Math.floor(damage * 0.8);
        setCurrentHealth(Math.max(0, getCurrentHealth() - percent));
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (isDead()) {
            throw new DeadCharacterException(this);
        }

        if (getWeapon() == null) {
            target.takeDamage(7);
        } else {
            target.takeDamage(getWeapon().getDamage());
        }
        // target.takeDamage(7);
    }

    @Override
    public void heal(Character target) throws DeadCharacterException {
        if (isDead()) {
            throw new DeadCharacterException(this);
        }
        target.setCurrentHealth(Math.min(getCurrentHealth(), getMaxHealth()));
    }

    @Override
    public String toString() {
        return (getCurrentHealth() == 0) ?
                String.format("%s is a monster and is dead. He has the weapon %s", getName(), getWeapon().toString()) :
                String.format("%s is a monster with %d HP. He has the weapon %s", getName(), getCurrentHealth(), getWeapon().toString());
    }
}
