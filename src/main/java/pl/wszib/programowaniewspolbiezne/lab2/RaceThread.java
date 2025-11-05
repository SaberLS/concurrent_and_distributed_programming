package pl.wszib.programowaniewspolbiezne.lab2;

public abstract class RaceThread extends Thread {
  private final int runs;
  private static final Semafor sem = new Semafor(); // WSPÓLNY dla wszystkich RaceThread

  public RaceThread(int runs) {
    this.runs = runs;
  }

  public RaceThread() {
    this.runs = 1_000_000;
  }

  @Override
  public void run() {
    for (int i = 0; i < this.runs; ++i) {
      sem.P();
      this.criticalSection();
      sem.V();
    }
  }

  public abstract void criticalSection();
}
