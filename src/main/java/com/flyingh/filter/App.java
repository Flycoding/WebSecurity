package com.flyingh.filter;

import java.util.concurrent.Semaphore;

public class App {
	private static final Semaphore SEMAPHORE = new Semaphore(3);

	public static Semaphore getSemaphore() {
		return SEMAPHORE;
	}
}
