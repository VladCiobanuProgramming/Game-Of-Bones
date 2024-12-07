public enum Monsters {
    OPAL("Opal", "Scratch", "Linux Binary Attack"),
    EMICA("Emica", "Power Chord", "Hurtful Musical Notes"),
    SWIFT("Swift", "Speed Of Light", "Rapid Clones"),
    MARK_THE_IMPALER("Mark The Impaler", "The Strike Of Compressed Idiocy", "Weaponized Ambivalence");
    public final String name;
    public final String attack1;
    public final String attack2;
    Monsters(final String name,final String attack1, final String attack2){
        this.name=name;
        this.attack1=attack1;
        this.attack2=attack2;
    }
}
