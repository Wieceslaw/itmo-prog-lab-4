public class Main {
    public static void main(String[] args) {
        Office office = new Office(0, 1000);

        Table oakTable = new Table("Дуб");

        Worker Dunno = new Worker("Незнайка");
        Worker Miga = new Worker("Мига");
        Worker Julio = new Worker("Джулио");
        Worker Kozlik = new Worker("Козлик");

        office.addWorker(Julio);
        office.addWorker(Miga);
        office.addWorker(Dunno);
        office.addWorker(Kozlik);

        office.setWork(Work.CHAIRMAN, Julio);
        office.setWork(Work.TREASURER, Miga);

        Miga.offerWorkForWorker(Work.DOORMAN, Kozlik);
        Julio.offerWorkForWorker(Work.BELLBOY, Kozlik);
        Miga.offerWorkForWorker(Work.DOORMAN, Kozlik, "швейцар нужен для престижа");
        Julio.offerWorkForWorker(Work.BELLBOY, Kozlik, "можно послать за покупками или доставить акцию");

        Julio.moveTo(oakTable);
        Julio.hit(new SoundableObject() {
            @Override
            public void makeSound() {
                System.out.println("*что-то разбилось*");
            }
        });
        Miga.sayLoudly("Я выйду из акционерного общества!");
    }
}
