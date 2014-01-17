package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sources.*;
import specification.*;

public class TestCursor
{

	// Pour pouvoir connecter cette classe de tests à n'importe quelle implémentation.
	// Il vous suffit de remplacer l'instanciation ici par celle de votre classe point.
	private InterfacePoint getPoint()
	{
		return new ImplementPoint();
	}
	
	private InterfacePoint getPoint(int abs, int ord)
	{
		InterfacePoint p = getPoint();
		p.setAbs(abs);
		p.setOrd(ord);
		return p;
	}
	
	private InterfaceCursor getCursor()
	{
		return new ImplementCursor();
	}
	
	private InterfaceCursor getCursor(InterfacePoint pos, InterfacePoint dir)
	{
		InterfaceCursor i = getCursor(); 
		i.setPosition(pos);
		i.setDirection(dir);
		return i;
	}
	
	private boolean equals(InterfaceCursor c, InterfaceCursor d)
	{
		return c.getPosition().equals(d.getPosition()) && c.getDirection().equals(d.getDirection());
	}
	
	@Test
	public void testCursorInterfacePointInterfacePoint()
	{
		InterfaceCursor c = getCursor(getPoint(1, 2), getPoint(5, 4));
		assertTrue(equals(c, getCursor(getPoint(1, 2), getPoint(5, 4))));		
	}

	@Test
	public void testGetPosition()
	{
		InterfaceCursor c = getCursor();
		c.setPosition(getPoint(1, 5));
		assertTrue(c.getPosition().equals(getPoint(1, 5)));
		c.setDirection(getPoint(3, 4));
		assertTrue(c.getPosition().equals(getPoint(1, 5)));
		c.setPosition(getPoint(1, 5));
		assertTrue(c.getPosition().equals(getPoint(1, 5)));
	}

	@Test
	public void testGetDirection()
	{
		InterfaceCursor c = getCursor();
		c.setDirection(getPoint(1, 5));
		assertTrue(c.getDirection().equals(getPoint(1, 5)));
		c.setPosition(getPoint(3, 4));
		assertTrue(c.getDirection().equals(getPoint(1, 5)));
		c.setDirection(getPoint(1, 5));
		assertTrue(c.getDirection().equals(getPoint(1, 5)));
	}

	@Test
	public void testReset()
	{
		InterfaceCursor c = getCursor();
		c.stepStraigth();
		c.turnLeft();
		c.reset();
		assertTrue(equals(c, getCursor(getPoint(0, 0), getPoint(1, 0))));
	}

	@Test
	public void testStepStraigth()
	{
		InterfaceCursor c = getCursor(getPoint(0, 0), getPoint(1, 1));
		c.stepStraigth();
		c.stepStraigth();
		assertTrue(c.getPosition().equals(getPoint(2, 2)));
	}

	@Test
	public void testTurnLeft()
	{
		InterfaceCursor c = getCursor(getPoint(0, 0), getPoint(1, 0));
		c.turnLeft();
		assertTrue(c.getDirection().equals(getPoint(0, 1)));
		c.turnLeft();
		assertTrue(c.getDirection().equals(getPoint(-1, 0)));
		c.turnLeft();
		assertTrue(c.getDirection().equals(getPoint(0, -1)));
		c.turnLeft();
		assertTrue(c.getDirection().equals(getPoint(1, 0)));
	}

	@Test
	public void testTurnRight()
	{
		InterfaceCursor c = getCursor(getPoint(0, 0), getPoint(1, 0));
		c.turnRight();
		assertTrue(c.getDirection().equals(getPoint(0, -1)));
		c.turnRight();
		assertTrue(c.getDirection().equals(getPoint(-1, 0)));
		c.turnRight();
		assertTrue(c.getDirection().equals(getPoint(0, 1)));
		c.turnRight();
		assertTrue(c.getDirection().equals(getPoint(1, 0)));
	}

}
