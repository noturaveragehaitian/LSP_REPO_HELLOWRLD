package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test class for ShapeFactory implementation
 */
public class ShapeFactoryTest {
    private ShapeFactory factory = ShapeFactory.getInstance();
    
    /**
     * Tests circle creation
     */
    @Test
    void testCreateCircle() {
        Shape shape = factory.createShape("circle");
        assertTrue(shape instanceof Circle);
    }
    
    /**
     * Tests rectangle creation
     */
    @Test
    void testCreateRectangle() {
        Shape shape = factory.createShape("rectangle");
        assertTrue(shape instanceof Rectangle);
        
    }
    
    /**
     * Tests triangle creation
     */
    @Test
    void testCreateTriangle() {
        Shape shape = factory.createShape("triangle");
        assertTrue(shape instanceof Triangle);
    }
    
    /**
     * Tests invalid shape creation
     */
    @Test
    void testInvalidShape() {
        assertThrows(IllegalArgumentException.class, () -> {
            factory.createShape("hexagon");
        });
    }
    
    /**
     * Tests singleton pattern implementation
     */
    @Test
    void testSingletonInstance() {
        ShapeFactory factory1 = ShapeFactory.getInstance();
        ShapeFactory factory2 = ShapeFactory.getInstance();
        assertSame(factory1, factory2);
    }
}