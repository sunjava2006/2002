package com.thzhima.advance.thread;

public class Bank {

	static class Account{
		int amount ;
		Account(int amount){
			this.amount = amount;
		}
	}
	
	public  int get(Account a, int money) {
		synchronized(a) {
			System.out.println("------开始取钱-----");
			int ok = 0;
			if(a.amount>=money) {
				ok = money;
				a.amount-=money;
			}
			System.out.println("------取钱结束 -------");
			return ok;
		}
		
	}
	
	public   void save(Account a, int money)  {
		synchronized(a) {
			System.out.println("=======开始存钱========");
			int v = a.amount;
			v = v+money;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a.amount = v;
			System.out.println("========存钱结束==========");
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Bank bank = new Bank();
		Bank bank2 = new Bank();
		Account myAccount = new Account(1000);
		
		Thread t = new Thread(()->{
			bank.save(myAccount, 1000);
		});
//		Thread t2 = new Thread(()->{
//			bank2.save(myAccount, 200);
//		});
		
		Thread t3 = new Thread(()->{
			int get = bank2.get(myAccount, 1000);
			System.out.println("get:" + get);
		}) ;
		
//		t2.start();
		t.start();
		t3.start();
		t.join();
		t3.join();
//		t2.join();
		
		System.out.println("remain:"+myAccount.amount);
	}
}
