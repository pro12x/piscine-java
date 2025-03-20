public class DeadCharacterException extends Exception {
    private final Character character;

    public DeadCharacterException(Character character) {
        this.character = character;
    }

    public String getMessage() {
        String type = "monster";
        if (character instanceof Sorcerer) {
            type = "sorcerer";
        } else if (character instanceof Templar) {
            type = "templar";
        }

        return String.format("The %s %s is dead.", type, character.getName());
    }
}
