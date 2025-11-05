package pl.wszib.programowaniewspolbiezne.lab2;

class DThread extends RaceThread {
  private final Counter _cnt;

  public DThread(Counter c) {
    _cnt = c;
  }

  public DThread(Counter c, int runs) {
    super(runs);
    _cnt = c;
  }

  @Override
  public void criticalSection() {
    _cnt.dec();
  }
}
