package org.cmg.jresp.writerreader;

import org.cmg.jresp.knowledge2.IterativeTupleSpace;
import org.cmg.jresp.knowledge2.Knowledge;

public class Bibliotheque {
	public static void main(String[] args) throws InterruptedException {
		WriterReaderLock lock = new WriterReaderLock();
		Knowledge ts = new IterativeTupleSpace(lock);
		Writer1[] writers1 = new Writer1[100];
		Writer2[] writers2 = new Writer2[100];
		Reader[] readers = new Reader[100];

		for (int i=0;i<100;i++){
			writers1[i] = new Writer1(ts);
		}
		for (int i=0;i<100;i++){
			writers2[i] = new Writer2(ts);
		}
		for (int i=0;i<100;i++){
			readers[i]= new Reader(ts);
		}
		Thread[] threads = new Thread[300];
		for (int i=0;i<100;i++){
			threads[i] = new Thread(writers1[i]);
		}
		for (int i=0;i<100;i++){
			threads[i+100] = new Thread(writers2[i]);
		}
		for (int i=0;i<100;i++){
			threads[i+200] = new Thread(readers[i]);

		}
		for(int i=0;i<100;i++){
			threads[i].start();
			threads[i+100].start();
			threads[i+200].start();
		}
		for(int i=0;i<100;i++){
			threads[i].join();
			threads[i+100].join();
			threads[i+200].join();
		}
//		for (Thread th: threads){
//			th.start();
//		}
//		for (Thread th: threads){
//			th.join();
//		}
	}
//Dovrei iterare tutto?
}
