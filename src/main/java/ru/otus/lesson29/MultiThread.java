package ru.otus.lesson29;

public class MultiThread {
	private final Object mon = new Object();
	private char value = 'C';

	public void printSymbol(char prev, char current) {
		synchronized (mon) {
			try {
				for (int i = 0; i < 5; i++) {
					while (value != prev) {
						mon.wait();
					}
					value = current;
					System.out.println(current);
					mon.notifyAll();
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}