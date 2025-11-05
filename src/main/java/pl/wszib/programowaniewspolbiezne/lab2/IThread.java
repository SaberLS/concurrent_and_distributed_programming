package pl.wszib.programowaniewspolbiezne.lab2;

class IThread extends RaceThread {
  private final Counter _cnt;

  public IThread(Counter c) {
    _cnt = c;
  }

  public IThread(Counter c, int runs) {
    super(runs);
    _cnt = c;
  }

  @Override
  public void criticalSection() {
    _cnt.inc();
  }
}
