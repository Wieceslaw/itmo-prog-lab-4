public enum Work {
    UNEMPLOYED("Безработный"),
    DOORMAN("Швейцар"),
    BELLBOY("Рассыльный"),
    CHAIRMAN("Председатель"),
    TREASURER("Казначей");

    public final String name;

    Work(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
