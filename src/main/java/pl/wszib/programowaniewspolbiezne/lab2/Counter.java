package pl.wszib.programowaniewspolbiezne.lab2;

public class Counter {
  private int _val;

  public Counter(int n) {
    _val = n;
  }

  public void inc() {
    int n;
    n = _val;
    n = n + 1;
    _val = n;
  }

  public void dec() {
    int n;
    n = _val;
    n = n - 1;
    _val = n;
  }

  public int value() {
    return _val;
  }
}
