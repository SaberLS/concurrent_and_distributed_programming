package pl.wszib.programowaniewspolbiezne.lab2;

public class Race {
  Counter cnt;
  IThread it;
  DThread dt;

  public Race() {
    this.cnt = new Counter(0);
    this.it = new IThread(this.cnt);
    this.dt = new DThread(this.cnt);
  }

  public Race(Counter cnt) {
    this.cnt = cnt;
    this.it = new IThread(this.cnt);
    this.dt = new DThread(this.cnt);
  }

  public Race(Counter cnt, int runs) {
    this.cnt = cnt;
    this.it = new IThread(this.cnt, runs);
    this.dt = new DThread(this.cnt, runs);
  }

  public Race(int runs) {
    this.cnt = new Counter(0);
    this.it = new IThread(this.cnt, runs);
    this.dt = new DThread(this.cnt, runs);
  }

  public int start() {
    it.start();
    dt.start();

    try {
      it.join();
      dt.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return this.cnt.value();
  }
}
