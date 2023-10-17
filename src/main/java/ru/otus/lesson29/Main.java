package ru.otus.lesson29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		MultiThread mt = new MultiThread();
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(() -> mt.printSymbol('C', 'A'));
		service.execute(() -> mt.printSymbol('A', 'B'));
		service.execute(() -> mt.printSymbol('B', 'C'));
		service.shutdown();
	}
}