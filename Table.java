import java.util.Objects;

public class Table implements SoundableObject {
    String material;

    public Table(String material) {
        this.material = material;
    }

    @Override
    public void makeSound() {
        System.out.println("*звук стола*");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equals(material, table.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material);
    }

    @Override
    public String toString() {
        return "стол из " + material;
    }
}