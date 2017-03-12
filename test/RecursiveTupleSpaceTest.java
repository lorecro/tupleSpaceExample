package org.cmg.jresp.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.cmg.jresp.knowledge2.ActualTemplateField;
import org.cmg.jresp.knowledge2.FormalTemplateField;
import org.cmg.jresp.knowledge2.Knowledge;
import org.cmg.jresp.knowledge2.RecursiveTupleSpace;
import org.cmg.jresp.knowledge2.Template;
import org.cmg.jresp.knowledge2.Tuple;
import org.junit.Test;

public class RecursiveTupleSpaceTest {
	
	@Test
	public void testPut() throws InterruptedException {
		Knowledge ts = new RecursiveTupleSpace();
		assertTrue(ts.put(new Tuple("PONG")));
	}

	@Test
	public void testPutIndexed() throws InterruptedException {
		Knowledge ts = new RecursiveTupleSpace();
		assertTrue(ts.put(new Tuple("PONG")));
	}
	
	@Test
	public void testPutGetActualTemplate() throws Exception {
		Knowledge ts = new RecursiveTupleSpace();
		Tuple t = new Tuple("PONG");
		ts.put(t);
		Template temp = new Template(new ActualTemplateField("PONG"));
		Tuple t2 = ts.get(temp);
		assertEquals(t, t2);
	}
	
	@Test
	public void testPutGetFormalTemplate() throws Exception {
		Knowledge ts = new RecursiveTupleSpace();
		Tuple t = new Tuple("PONG");
		ts.put(t);
		Template temp = new Template(new FormalTemplateField(String.class));
		Tuple t2 = ts.get(temp);
		assertEquals(t, t2);
	}

	@Test
	public void testPutGetFormalTemplateFalse() throws Exception {
		Knowledge ts = new RecursiveTupleSpace();
		Tuple t = new Tuple("PONG");
		ts.put(t);
		Template temp = new Template(new FormalTemplateField(Integer.class));
		Tuple t2 = ts.getp(temp);
		assertEquals(null, t2);
	}
	@Test
	public void test2PutGetActualTemplate() throws Exception {
		Knowledge ts = new RecursiveTupleSpace();
		Tuple t = new Tuple("PONG");
		Tuple t1 = new Tuple("PING");
		ts.put(t);
		ts.put(t);
		ts.put(t1);
		ts.put(t1);
		Template temp = new Template(new ActualTemplateField("PING"));
		Tuple t2 = ts.get(temp);
		assertEquals(t1, t2);
	}
	@Test
	public void testGetAllActualTemplate() throws Exception {
		Knowledge ts = new RecursiveTupleSpace();
		Tuple t = new Tuple("PONG");
		Tuple t1 = new Tuple("PING");
		ts.put(t);
		ts.put(t1);
		Template temp = new Template(new ActualTemplateField("PONG"));
		LinkedList<Tuple> list1 = ts.getAll(temp);
		LinkedList<Tuple> list2 = new LinkedList<Tuple>();
		list2.add(t);
		assertEquals(list2, list1);
	}
	@Test
	public void testGetAllFormalTemplate() throws Exception {
		Knowledge ts = new RecursiveTupleSpace();
		Tuple t = new Tuple("PONG");
		Tuple t1 = new Tuple("PING");
		ts.put(t);
		ts.put(t1);
		Template temp = new Template(new FormalTemplateField(String.class));
		LinkedList<Tuple> list1 = ts.getAll(temp);
		LinkedList<Tuple> list2 = new LinkedList<Tuple>();
		list2.add(t1);
		list2.add(t);
		assertEquals(list2, list1);
	}
	@Test
	public void testQueryAllFormalTemplate() throws Exception {
		Knowledge ts = new RecursiveTupleSpace();
		Tuple t = new Tuple("PONG");
		Tuple t1 = new Tuple("PING");
		ts.put(t);
		ts.put(t1);
		Template temp = new Template(new FormalTemplateField(String.class));
		LinkedList<Tuple> list1 = ts.queryAll(temp);
		LinkedList<Tuple> list2 = new LinkedList<Tuple>();
		list2.add(t1);
		list2.add(t);
		assertEquals(list2, list1);
	}
	@Test
	public void testQueryAll() throws Exception {
		Knowledge ts = new RecursiveTupleSpace();
		Tuple t = new Tuple("PONG");
		Tuple t1 = new Tuple("PING");
		ts.put(t);
		ts.put(t1);
		LinkedList<Tuple> list1 = ts.queryAll();
		LinkedList<Tuple> list2 = new LinkedList<Tuple>();
		list2.add(t1);
		list2.add(t);
		assertEquals(list2, list1);
	}
}
