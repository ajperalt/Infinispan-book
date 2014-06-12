package com.packtpub.infinispan.chapter3;

import java.util.UUID;

import model.Ticket;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

public class ExpiryCacheByConfig {

	public void start() {
		DefaultCacheManager m = null;
		try {
			m = new DefaultCacheManager("sample.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cache<Integer, Ticket> cache = m.getCache("evictionCache");
		int ticketid = 1;

		while (ticketid < 1500) {

			String name = UUID.randomUUID().toString();
			String show = UUID.randomUUID().toString();

			Ticket ticket = new Ticket(name, show);
			cache.put(ticketid, ticket);
			ticketid++;
		}
		log("Booked tickets:   " + ticketid);
		log("Tickets in Cache: " + cache.size());

	}

	public static void main(String[] args) {
		new ExpiryCacheByConfig().start();

	}

	public static void log(String s) {
		System.out.println(s);
	}
}
