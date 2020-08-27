package com.thzhima.advance.homework.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TicketStation {
	
	private static  List<Ticket> list = new ArrayList<>();
	
	TicketStation(){
		for(int i=0;i<20;i++) {
			list.add(new Ticket(i));
		}
	}
	
	public int remain() {
		 return this.list.size();
	}
	
	public   List<Ticket> buy(int count){
		synchronized (list) {
			List<Ticket> tickets = new ArrayList<>();
			if(this.list.size()>=count) {
				for(int i=1;i<=count;i++) {
					Ticket t = this.list.get(list.size()-1);
				    tickets.add(t);
				    this.list.remove(list.size()-1);
				}
			}
			return tickets;
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		TicketStation station = new TicketStation();
		CountDownLatch latch = new CountDownLatch(3);
		
		Runnable target = ()->{
			
			try {
				System.out.println(Thread.currentThread().getName()+"-----×¼±¸ÂòÆ±-------");
				latch.countDown();
				latch.await();
				List<Ticket> tickets = station.buy(6);
				System.out.println(tickets);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		};
		
		
		
	    Thread t = new Thread(target);
	    Thread t2 = new Thread(target);
	    Thread t3 = new Thread(target);
	    
	    t.start();
	    t2.start();
	    t3.start();
	    
	    t.join();
	    t2.join();
	    t3.join();
	    
	    System.out.println("remain: "+station.remain());
		
	}
	
}

class Ticket{
    private int ID;
    
    Ticket(int ID){
    	this.ID = ID;
    }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "Ticket [ID=" + ID + "]";
	}
    
}