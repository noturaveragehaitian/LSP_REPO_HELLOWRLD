package org.howard.edu.lsp.finalexam.question3;

/**
 * Class responsible for rendering shapes using the ShapeFactory
 * 
 * References by Claude AI
 */
public class ShapeRenderer {
    private ShapeFactory factory;
    
    /**
     * Constructor that initializes the renderer with the ShapeFactory instance
     */
    public ShapeRenderer() {
        this.factory = ShapeFactory.getInstance();
    }
    
    /**
     * Renders a shape of the specified type
     * 
     * @param shapeType The type of shape to render
     */
    public void renderShape(String shapeType) {
        try {
            Shape shape = factory.createShape(shapeType);
            shape.draw();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}