package org.cmg.jresp.philosophers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Table {
private final int NF=5; //numero forchette/filosofi
private int[] forks = new int[NF]; //forchette disponibili per ogni filosofo
private Lock lock = new ReentrantLock(); 
private Condition[] codaF = new Condition[NF]; //1 coda per ogni filosofo

public Table(){
	for(int i=0; i<NF;i++){
		codaF[i]=lock.newCondition();
		forks[i]=2;
	}
}
public void getFork(int i) throws InterruptedException{
	lock.lock();
	try
	{
		while (forks[i]!=2){
			codaF[i].await();
		}
		forks[left(i)]--;
		forks[right(i)]--;
	}finally{ 
		lock.unlock();
		}
}
private int left(int i){
	int ret;
	ret=(i==0?NF-1:(i-1));
	return ret;
}
private int right(int i){
	int ret;
	ret=(i+1)%NF;
	return ret;
}
public void releaseForks(int i) throws InterruptedException{
	lock.lock();
	try{
		forks[left(i)]++;
		forks[right(i)]++;
		if (forks[left(i)]==2){
			codaF[i].signal();
		}
		if(forks[i]==2){
			codaF[i].signal();
		}
	}finally{
		lock.unlock();
	}
}
}
