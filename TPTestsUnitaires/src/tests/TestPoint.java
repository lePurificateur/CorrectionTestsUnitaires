package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import specification.InterfacePoint;
import sources.ImplementPoint;

public class TestPoint
{

	@Test
	public void testPointIntInt()
	{
		InterfacePoint p = new ImplementPoint(3, 2);
		assertTrue(p.getAbs() == 3 && p.getOrd() == 2);
	}

	@Test
	public void testGetOrd()
	{
		InterfacePoint p = new ImplementPoint();
		p.setOrd(5);
		assertTrue(p.getOrd() == 5);
		p.setOrd(-1);
		assertTrue(p.getOrd() == -1);
		p.setAbs(4);
		assertTrue(p.getOrd() == -1);
	}

	@Test
	public void testGetAbs()
	{
		InterfacePoint p = new ImplementPoint();
		p.setAbs(5);
		assertTrue(p.getAbs() == 5);
		p.setAbs(-1);
		assertTrue(p.getAbs() == -1);
		p.setOrd(4);
		assertTrue(p.getAbs() == -1);
	}

	@Test
	public void testEquals()
	{
		InterfacePoint p = new ImplementPoint(3, 5);
		assertTrue(p.equals(p));
		InterfacePoint q = new ImplementPoint(3, 5);
		assertTrue(p.equals(q) && q.equals(p));
		assertTrue(!p.equals(new ImplementPoint(5, 3)));
		assertTrue(!p.equals(new ImplementPoint(3, 6)));
		assertTrue(!p.equals(new ImplementPoint(4, 5)));
	}

	@Test
	public void testAdd()
	{
		InterfacePoint p = new ImplementPoint(3, 5), q = new ImplementPoint(2, 3);
		assertTrue(p.add(p).equals(new ImplementPoint(6, 10)));
		assertTrue(p.add(p).equals(new ImplementPoint(6, 10)));
		assertTrue(p.add(q).equals(new ImplementPoint(5, 8)));
		assertTrue(p.add(q).equals(q.add(p)));
	}

}
