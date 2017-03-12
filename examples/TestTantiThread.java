package org.cmg.jresp.examples;

import org.cmg.jresp.knowledge2.IterativeTupleNode;
import org.cmg.jresp.knowledge2.IterativeTupleSpace;
import org.cmg.jresp.knowledge2.Knowledge;
import org.cmg.jresp.knowledge2.RecursiveTupleSpace;
import org.cmg.jresp.knowledge2.TemplateIndexedTupleSpace;
import org.cmg.jresp.knowledge2.TupleSpace;

public class TestTantiThread {
	public static void main(String[] args) throws InterruptedException {
		int numPut = 30;
		int numGet = 30;
		int numQuery = 0;
		int numThread = numPut+numGet+numQuery;
		int times = 100;
			Knowledge ts = new TemplateIndexedTupleSpace();
			TestGet[] testget = new TestGet[numGet];
			for (int i = 0; i < numGet; i++) {
				testget[i] = new TestGet(ts);
			}
			TestPut[] testput = new TestPut[numPut];
			for (int i = 0; i < numPut; i++) {
				testput[i] = new TestPut(ts);
			}
			TestQuery[] testquery = new TestQuery[numQuery];
			for (int i = 0; i < numQuery; i++) {
				testquery[i] = new TestQuery(ts);
			}
			for (int j = 0; j < times; j++) {

			Thread[] tr = new Thread[numThread];

			for (int i = 0; i < numQuery; i++) {
				tr[i] = new Thread(testquery[i]);
			}
			for (int i = numQuery; i < numQuery + numPut; i++) {
				tr[i] = new Thread(testput[i - numQuery]);
			}
			for (int i = numQuery + numPut; i < numThread; i++) {
				tr[i] = new Thread(testget[i - (numQuery + numPut)]);
			}
			
			for (int i = 0; i <numThread; i++) {
				tr[i].start();
			}
			for (int i = 0; i <numThread; i++) {
				tr[i].join();
			}
			
//			// System.out.println("star query e put");
//			for (int i = 0; i < numQuery + numPut; i++) {
//				tr[i].start();
//			}
//			// System.out.println("join query e put");
//			for (int i = 0; i < numQuery + numPut; i++) {
//				tr[i].join();
//			}
//			// System.out.println("start get");
//			for (int i = numQuery + numPut; i < numThread; i++) {
//				tr[i].start();
//			}
//
//			for (int i = numQuery + numPut; i < numThread; i++) {
//				tr[i].join();
//			}
			System.out.println(ts.queryAll());
		}
	}
}
