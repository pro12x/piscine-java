public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
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
    public String toString() {
        return (super.getCurrentHealth() == 0) ?
                String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", super.getName(), getHealCapacity()) :
                String.format("%s is a sorcerer with %d HP. It can heal %d HP.", super.getName(), super.getCurrentHealth(), getHealCapacity());
    }
}