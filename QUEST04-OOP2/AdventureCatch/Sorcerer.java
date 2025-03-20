public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    public void takeDamage(int damage) throws DeadCharacterException {
        if (isDead()) {
            throw new DeadCharacterException(this);
        }
        setCurrentHealth(Math.max(0, getCurrentHealth() - damage));
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (isDead()) {
            throw new DeadCharacterException(this);
        }

        if (getWeapon() == null) {
            this.heal(this);
            target.takeDamage(10);
            // target.takeDamage(7);
        } else {
            target.takeDamage(getWeapon().getDamage());
        }
    }

    @Override
    public void heal(Character character) throws DeadCharacterException {
        if (isDead()) {
            throw new DeadCharacterException(this);
        }
        character.setCurrentHealth(Math.min(character.getMaxHealth(), character.getCurrentHealth() + this.healCapacity));
    }

    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public String toString() {
        return (super.getCurrentHealth() == 0) ?
                String.format("%s is a dead sorcerer. So bad, it could heal %d HP. He has the weapon %s", super.getName(), getHealCapacity(), getWeapon().toString()) :
                String.format("%s is a sorcerer with %d HP. It can heal %d HP. He has the weapon %s", super.getName(), super.getCurrentHealth(), getHealCapacity(), getWeapon().toString());
    }
}
