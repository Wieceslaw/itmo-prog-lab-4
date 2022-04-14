import java.util.ArrayList;
import java.util.Objects;

public class Office implements SoundableObject {
    int prestige;
    int account;
    ArrayList<Worker> workers = new ArrayList<>();

    public Office(int prestige, int account) {
        this.prestige = prestige;
        this.account = account;
    }

    @Override
    public void makeSound() {
        System.out.println("*звук активной работы*");
    }

    public void paySalary(Worker worker, int salary) throws Exception {
        class StrangerWorkerException extends Exception {
            public StrangerWorkerException() {
            }

            public StrangerWorkerException(String message) {
                super(message);
            }
        }
        if (!workers.contains(worker)) throw new StrangerWorkerException();
        if (salary <= this.account) {
            this.account -= salary;
            worker.pay(salary);
        }
    }

    public void setWork(Work work, Worker worker) {
        if (worker.work != Work.DOORMAN && work == Work.DOORMAN) {
            this.prestige += 100;
        } else if (worker.work == Work.DOORMAN && work != Work.DOORMAN) {
            this.prestige -= 100;
        }
        worker.setWork(work);
    }

    public void addWorker(Worker worker) {
        this.workers.add(worker);
        worker.workingPlace = this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return prestige == office.prestige && account == office.account && Objects.equals(workers, office.workers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prestige, account, workers);
    }

    @Override
    public String toString() {
        return "Office{" +
                "prestige=" + prestige +
                ", account=" + account +
                ", workers=" + workers +
                '}';
    }
}