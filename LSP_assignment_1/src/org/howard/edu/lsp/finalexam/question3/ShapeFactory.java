package org.howard.edu.lsp.finalexam.question3;

/**
 * Factory class for creating shape instances
 * Implements singleton pattern to ensure only one factory exists
 * 
 * References by Claude AI
 */
public class ShapeFactory {
    private static ShapeFactory instance;
    
    /**
     * Private constructor to prevent instantiation
     */
    private ShapeFactory() {}
    
    /**
     * Returns the singleton instance of ShapeFactory
     * 
     * @return The singleton instance of ShapeFactory
     */
    public static ShapeFactory getInstance() {
        if (instance == null) {
            instance = new ShapeFactory();
        }
        return instance;
    }
    
    /**
     * Creates a shape based on the provided shape type
     * 
     * @param shapeType The type of shape to create
     * @return The created shape instance
     * @throws IllegalArgumentException if shape type is unknown
     */
    public Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "triangle":
                return new Triangle();
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}