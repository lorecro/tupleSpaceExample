package org.cmg.jresp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.cmg.jresp.knowledge2.ActualTemplateField;
import org.cmg.jresp.knowledge2.FormalTemplateField;
import org.cmg.jresp.knowledge2.Knowledge;
import org.cmg.jresp.knowledge2.Template;
import org.cmg.jresp.knowledge2.TemplateIndexedTupleSpace;
import org.cmg.jresp.knowledge2.Tuple;
import org.junit.Test;

public class TemplateTupleSpaceTest {
	
	@Test
	public void testPut() throws InterruptedException {
		Knowledge ts = new TemplateIndexedTupleSpace();
		assertTrue(ts.put(new Tuple("PONG")));
	}

	
	@Test
	public void testPutGetActualTemplate() throws Exception {
		Knowledge ts = new TemplateIndexedTupleSpace();
		Tuple t = new Tuple("PONG");
		ts.put(t);
		Template temp = new Template(new ActualTemplateField("PONG"));
		Tuple t2 = ts.get(temp);
		assertEquals(t, t2);
	}
	
	@Test
	public void testPutGetFormalTemplate() throws Exception {
		Knowledge ts = new TemplateIndexedTupleSpace();
		Tuple t = new Tuple("PONG");
		ts.put(t);
		Template temp = new Template(new FormalTemplateField(String.class));
		Tuple t2 = ts.get(temp);
		assertEquals(t, t2);
	}

	@Test
	public void test2PutGetActualTemplateIndexed() throws Exception {
		Knowledge ts = new TemplateIndexedTupleSpace();
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
	public void testGetAllActualTemplateIndexed() throws Exception {
		Knowledge ts = new TemplateIndexedTupleSpace();
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
	public void testGetAllFormalTemplateIndexed() throws Exception {
		Knowledge ts = new TemplateIndexedTupleSpace();
		Tuple t = new Tuple("PONG");
		Tuple t1 = new Tuple("PING");
		ts.put(t);
		ts.put(t1);
		Template temp = new Template(new FormalTemplateField(String.class));
		LinkedList<Tuple> list1 = ts.getAll(temp);
		LinkedList<Tuple> list2 = new LinkedList<Tuple>();
		list2.add(t);
		list2.add(t1);
		assertEquals(list2, list1);
	}
	@Test
	public void testGetFalse() throws Exception {
		Knowledge ts = new TemplateIndexedTupleSpace();
		Template temp = new Template(new ActualTemplateField("PONG"));
		Tuple t2 = ts.queryp(temp);
		assertEquals(null, t2);
	}
}
