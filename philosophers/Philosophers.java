package org.cmg.jresp.philosophers;

import java.lang.*;

public class Philosophers extends Thread{
	TableSpace table;
	int id;
	public Philosophers(TableSpace table, int id) {
		this.table = table;
		this.id= id;
	}
	
	@Override
	public void run() {
		try{
			while(true){
				System.out.println("filosofo "+id+" sta pensando");
				table.getFork(id);
				System.out.println("filosofo "+id+" sta mangiando");
				Thread.sleep(8);
				table.releaseForks(id);
				Thread.sleep(100);
			}
		}catch (InterruptedException e) {}
	}

}
