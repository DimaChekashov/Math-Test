package com.foxsay.mathtest.model;

/**
 * @author roman
 * @since 15.04.2016
 */
public class Section {
    public final static String MATH = "math";
    public final static String PHYSICS = "physics";
    public static class SubSection {
        public final static String Geometry = "geometry";
        public final static String Algebra = "algebra";
    }
    public static class Group {
        public final static String Cylinder = "cylinder";
        public final static String Sphere = "sphere";
    }
}
