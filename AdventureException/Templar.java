public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    public void takeDamage(int damage) {
        setCurrentHealth(Math.max(0, getCurrentHealth() - Math.max(0, damage - this.shield)));
    }

    @Override
    public void attack(Character target) {
        if (getWeapon() == null) {
            this.heal(this);
            target.takeDamage(6);
            // target.takeDamage(7);
        } else {
            target.takeDamage(getWeapon().getDamage());
        }
    }

    @Override
    public void heal(Character character) {
        character.setCurrentHealth(Math.min(character.getMaxHealth(), character.getCurrentHealth() + this.healCapacity));
    }

    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public int getShield() {
        return this.shield;
    }

    @Override
    public String toString() {
        return (super.getCurrentHealth() == 0) ?
                String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP. He has the weapon %s", super.getName(), this.getShield(), this.getHealCapacity(), getWeapon().toString()) :
                String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d. He has the weapon %s", super.getName(), super.getCurrentHealth(), this.getHealCapacity(), this.getShield(), getWeapon().toString());
    }
}
