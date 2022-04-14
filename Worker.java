import java.util.Objects;

public class Worker extends Person {
    public Work work;
    int money;
    Office workingPlace;
    static class NegativeSalaryException extends RuntimeException {
        public NegativeSalaryException() {
        }

        public NegativeSalaryException(String message) {
            super(message);
        }
    }

    public Worker(String name) {
        super(name);
        this.work = Work.UNEMPLOYED;
        this.money = 0;
    }

    public void pay(int salary) throws NegativeSalaryException {
        if (salary > 0) {
            this.money += salary;
        } else {
            throw new NegativeSalaryException();
        }
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public void offerWorkForWorker(Work work, Worker offeredWorker) {
        System.out.println(this + " предложил/а вакансию " + work + " для " + offeredWorker);
    }

    public void offerWorkForWorker(Work work, Worker offeredWorker, String reason) {
        System.out.println(this + " предложил/а вакансию " + work + " для " + offeredWorker + " по причине: " + reason);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return money == worker.money && work == worker.work && Objects.equals(workingPlace, worker.workingPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(work, money, workingPlace);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
