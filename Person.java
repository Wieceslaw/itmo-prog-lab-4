public abstract class Person implements MovingObject {
    public String name;
    public String location;

    public Person(String name) {
        this.name = name;
    }

    public void say(String message) {
        System.out.println(this + " сказал/а: " + message);
    }

    public void sayLoudly(String message) {
        System.out.println(this + " крикнул/а: " + message.toUpperCase());
    }

    public void hit(SoundableObject obj) {
        System.out.println(this + " ударил/а по " + obj);
        obj.makeSound();
    }

    @Override
    public void moveTo(SoundableObject obj) {
        System.out.println(this.name + " подошел к " + obj);
    }
}