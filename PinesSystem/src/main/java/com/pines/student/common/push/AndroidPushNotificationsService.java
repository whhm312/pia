package com.pines.student.common.push;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pines.student.config.HeaderRequestInterceptor;

@Service
public class AndroidPushNotificationsService {
	private static final String FIREBASE_SERVER_KEY = "AAAAPsKTBKA:APA91bHp95V8QX0uVtmVKEg-KkfhsfH4C8aFowmvpY_IWeYlE_ySZf-FcMF1uAXOBkNZ1LvNKVgFbyNvM2Aic6D28mCR7s00HeMfceSmpmpnK5fO-kML_WuEdgCyfGJ83MR0at4T0BnMCQO7dDG0tJPnLrfokgD9Xg";
	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";

	@Async
	public CompletableFuture<String> send(HttpEntity<String> entity) {
		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setInterceptors(interceptors);

		String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);
		return CompletableFuture.completedFuture(firebaseResponse);
	}
}
