package ru.otus.lesson29;

public class MultiThread {
	private final Object mon = new Object();
	private char value = 'C';

	public void printA() {
		synchronized (mon) {
			try {
				for (int i = 0; i < 5; i++) {
					while (value != 'C') {
						mon.wait();
					}
					value = 'A';
					System.out.println('A');
					mon.notifyAll();
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void printB() {
		synchronized (mon) {
			try {
				for (int i = 0; i < 5; i++) {
					while (value != 'A') {
						mon.wait();
					}
					value = 'B';
					System.out.println('B');
					mon.notifyAll();
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void printC() {
		synchronized (mon) {
			try {
				for (int i = 0; i < 5; i++) {
					while (value != 'B') {
						mon.wait();
					}
					value = 'C';
					System.out.println('C');
					mon.notifyAll();
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}