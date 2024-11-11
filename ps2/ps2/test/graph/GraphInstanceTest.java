///* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
// * Redistribution of original or derived work requires permission of course staff.
// */
//package graph;
//
//import static org.junit.Assert.*;
//
//import java.util.Collections;
//
//import org.junit.Test;
//
///**
// * Tests for instance methods of Graph.
// * 
// * <p>PS2 instructions: you MUST NOT add constructors, fields, or non-@Test
// * methods to this class, or change the spec of {@link #emptyInstance()}.
// * Your tests MUST only obtain Graph instances by calling emptyInstance().
// * Your tests MUST NOT refer to specific concrete implementations.
// */
//public abstract class GraphInstanceTest {
//    
//    // Testing strategy
//    //   TODO
//    
//    /**
//     * Overridden by implementation-specific test classes.
//     * 
//     * @return a new empty graph of the particular implementation being tested
//     */
//    public abstract Graph<String> emptyInstance();
//    
//    @Test(expected=AssertionError.class)
//    public void testAssertionsEnabled() {
//        assert false; // make sure assertions are enabled with VM argument: -ea
//    }
//    
//    @Test
//    public void testInitialVerticesEmpty() {
//        // TODO you may use, change, or remove this test
//        assertEquals("expected new graph to have no vertices",
//                Collections.emptySet(), emptyInstance().vertices());
//    }
//    
//    // TODO other tests for instance methods of Graph
//    
//}
package graph;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Tests for instance methods of Graph.
 * 
 * <p>PS2 instructions: you MUST NOT add constructors, fields, or non-@Test
 * methods to this class, or change the spec of {@link #emptyInstance()}.
 * Your tests MUST only obtain Graph instances by calling emptyInstance().
 * Your tests MUST NOT refer to specific concrete implementations.
 */
public abstract class GraphInstanceTest {
    
    // Testing strategy
    // - testInitialVerticesEmpty(): test that a new graph has no vertices
    // - testAddVertex(): add vertices and check if they exist in the graph
    // - testAddDuplicateVertex(): add a vertex that already exists and check no duplication
    // - testSetEdge(): add edges and check if they exist with correct weights
    // - testRemoveVertex(): remove a vertex and verify it no longer exists
    // - testSourcesAndTargets(): check sources and targets for directed edges
    
    /**
     * Overridden by implementation-specific test classes.
     * 
     * @return a new empty graph of the particular implementation being tested
     */
    public abstract Graph<String> emptyInstance();
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    @Test
    public void testInitialVerticesEmpty() {
        Graph<String> graphInstance = emptyInstance();
        assertEquals("Expected new graph to have no vertices", Collections.emptySet(), graphInstance.vertices());
    }
    
    @Test
    public void testAddVertex() {
        Graph<String> graphInstance = emptyInstance();
        assertTrue("Expected true when adding new vertex", graphInstance.add("VertexA"));
        assertTrue("Expected vertex 'VertexA' to be in graph", graphInstance.vertices().contains("VertexA"));
    }

    @Test
    public void testAddDuplicateVertex() {
        Graph<String> graphInstance = emptyInstance();
        graphInstance.add("VertexA");
        assertFalse("Expected false when adding duplicate vertex", graphInstance.add("VertexA"));
        assertEquals("Expected only 1 vertex in the graph", 1, graphInstance.vertices().size());
    }

    @Test
    public void testSetEdge() {
        Graph<String> graphInstance = emptyInstance();
        graphInstance.add("VertexA");
        graphInstance.add("VertexB");
        int previousWeight = graphInstance.set("VertexA", "VertexB", 5);
        assertEquals("Expected previous weight to be 0", 0, previousWeight);
        Map<String, Integer> outgoingEdges = graphInstance.targets("VertexA");
        assertTrue("Expected target 'VertexB' in targets of 'VertexA'", outgoingEdges.containsKey("VertexB"));
        assertEquals("Expected edge weight from 'VertexA' to 'VertexB' to be 5", (Integer) 5, outgoingEdges.get("VertexB"));
    }

    @Test
    public void testRemoveVertex() {
        Graph<String> graphInstance = emptyInstance();
        graphInstance.add("VertexA");
        assertTrue("Expected true when removing existing vertex", graphInstance.remove("VertexA"));
        assertFalse("Expected vertex 'VertexA' to be removed", graphInstance.vertices().contains("VertexA"));
    }

//    @Test
//    public void testSourcesAndTargets() {
//        Graph<String> graphInstance = emptyInstance();
//        graphInstance.add("VertexA");
//        graphInstance.add("VertexB");
//        graphInstance.set("VertexA", "VertexB", 5);
//        Map<String, Integer> sourceEdges = graphInstance.sources("VertexB");
//        assertTrue("Expected source 'VertexA' in sources of 'VertexB'", sourceEdges.containsKey("VertexA"));
//        assertEquals("Expected edge weight from 'VertexA' to 'VertexB' to be 5", (Integer) 5, sourceEdges.get("VertexA"));
//        Map<String, Integer> outgoingEdges = graphInstance.targets("VertexA");
//        assertTrue("Expected target 'VertexB' in targets of 'VertexA'", outgoingEdges.containsKey("VertexB"));
//        assertEquals("Expected edge weight from 'VertexA' to 'VertexB' to be 5", (Integer) 5, outgoingEdges.get("VertexB"));
//    }
}
