package pl.wszib.programowaniewspolbiezne.lab2;

/**
 * Implementacja klasycznego semafora binarnego (0/1)
 * z synchronizacją metod P() i V() przy pomocy monitorów Javy.
 *
 * Semafor zapewnia wzajemne wykluczanie (ang. mutual exclusion),
 * tak aby tylko jeden wątek mógł znajdować się w sekcji krytycznej w danym
 * momencie.
 */
class Semafor {

  // true = semafor wolny (S == 1)
  // false = semafor zajęty (S == 0)
  private boolean stan = true;

  // liczba wątków aktualnie oczekujących w kolejce semafora
  private int _czeka = 0;

  /**
   * Operacja opuszczenia (P)
   *
   * Jeśli semafor jest wolny (stan == true):
   * zajmuje go (ustawia stan na false) i wchodzi do sekcji krytycznej.
   *
   * Jeśli semafor jest zajęty (stan == false):
   * wątek zostaje wstrzymany (wait) i czeka, aż inny wątek wykona V().
   */
  public synchronized void P() {
    // Zgłaszamy, że wątek próbuje wejść do sekcji krytycznej
    _czeka++;

    // Jeśli semafor zajęty — czekaj aż zostanie zwolniony
    while (!stan) {
      try {
        wait(); // czekaj, aż ktoś wywoła notify() w metodzie V()
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); // zachowaj stan przerwania
      }
    }

    // Wątek został dopuszczony — aktualizujemy stan
    _czeka--; // już nie czeka
    stan = false; // zajmuje semafor (S = 0)
  }

  /**
   * Operacja podniesienia (V)
   *
   * Jeśli jakieś wątki czekają:
   * ustaw semafor jako wolny i obudź jeden z nich.
   *
   * Jeśli nikt nie czeka:
   * po prostu oznacz semafor jako wolny.
   */
  public synchronized void V() {
    // Zwalniamy semafor
    stan = true;

    // Jeśli ktoś czeka, obudź jeden wątek z kolejki
    if (_czeka > 0) {
      notify(); // budzimy dokładnie jeden oczekujący wątek
    }
  }
}
