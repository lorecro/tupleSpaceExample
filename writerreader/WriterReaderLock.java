package org.cmg.jresp.writerreader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.cmg.jresp.knowledge2.TupleSpaceLock;

//pochi scrittori che possono fare get e put
//tanti lettori
//se c'è lo scrittore, lettore non entra
public class WriterReaderLock implements TupleSpaceLock {
	private ReentrantLock lock;
	private ReentrantLock lockWait;
	private ReentrantReadWriteLock esternalLock;
	private Lock wEsternalLock;
	private Lock rEsternalLock;
	private Condition waitTuple;

	public WriterReaderLock() {
		lock = new ReentrantLock();
		lockWait = new ReentrantLock();
		esternalLock = new ReentrantReadWriteLock();
		wEsternalLock = esternalLock.writeLock();
		rEsternalLock = esternalLock.readLock();
		waitTuple = lockWait.newCondition();
	}

	public void readLock() throws InterruptedException {
		rEsternalLock.lock();
		lock.lock();
	}

	public void inLock() throws InterruptedException {
		wEsternalLock.lock();
		lock.lock();
	}

	public void outLock() throws InterruptedException {
		wEsternalLock.lock();
		lock.lock();
	}

	public void readUnlock() {
		lock.unlock();
		rEsternalLock.unlock();		
	}

	public void inUnlock() {
		lock.unlock();
		wEsternalLock.unlock();		
	}

	public void outUnlock() {
		lock.unlock();
		lockWait.lock();
		waitTuple.signalAll();
		lockWait.unlock();
		wEsternalLock.unlock();
	}

	public void readWaitTuple() throws InterruptedException {
		lock.unlock();
		lockWait.lock();
		rEsternalLock.unlock();
		waitTuple.await();
		lockWait.unlock();
		rEsternalLock.lock();
		lock.lock();
	}
	public void getWaitTuple() throws InterruptedException {
		lock.unlock();
		lockWait.lock();
		wEsternalLock.unlock();
		waitTuple.await();
		lockWait.unlock();
		wEsternalLock.lock();
		lock.lock();
	}
}
