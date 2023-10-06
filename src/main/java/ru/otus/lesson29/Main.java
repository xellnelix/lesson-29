package ru.otus.lesson29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		MultiThread mt = new MultiThread();
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(() -> mt.printA());
		service.execute(() -> mt.printB());
		service.execute(() -> mt.printC());
		service.shutdown();
	}
}