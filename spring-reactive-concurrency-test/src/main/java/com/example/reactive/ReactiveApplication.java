package com.example.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) throws InterruptedException {

		SpringApplication.run(ReactiveApplication.class, args);
		ExecutorService service = Executors.newFixedThreadPool(10);
		CountDownLatch latch = new CountDownLatch(300);
		long start = System.currentTimeMillis();
		for(int i=0;i<300;i++){
			final int taskNum = i;
			service.submit(()-> {
				try {
					/*HttpClient client = HttpClient.newHttpClient();
					HttpRequest request = HttpRequest.newBuilder()
							.uri(URI.create("http://localhost:8080/blocking-results"))
							.build();
					client.send(request, HttpResponse.BodyHandlers.ofString());*/
					HttpClient client = HttpClient.newHttpClient();
					HttpRequest request = HttpRequest.newBuilder()
							.uri(URI.create("http://localhost:8080/reactive-results"))
							.build();
					client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
				} catch (Exception e) {

				} finally {
					latch.countDown();
				}
			});
		}
		System.out.println("Number of threads " + Thread.activeCount());
		latch.await();
		long duration = System.currentTimeMillis() - start;
		System.out.println("Total duration: " + duration + "ms");
	}

}
