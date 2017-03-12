package org.cmg.jresp.philosophers;

public class PhilosophersDinner {
public static void main(String[] args) throws InterruptedException{
	TableSpace table=new TableSpace();
	Philosophers[] phil = new Philosophers[5];
	for(int i=0;i<5;i++){
		phil[i]=new Philosophers(table, i);
	}
	for(int i=0;i<5;i++){
		phil[i].start();
	}
}
}
