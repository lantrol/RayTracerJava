/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raytracerjava;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author landa
 */
public class Geometry {
    public Vector3 ambient;
    public Vector3 diffuse;
    public Vector3 specular;
    public Float shininess;
    public Float reflection;

    public Geometry(Vector3 ambient, Vector3 diffuse, Vector3 specular, Float shininess, Float reflection) {
        this.ambient = ambient;
        this.diffuse = diffuse;
        this.specular = specular;
        this.shininess = shininess;
        this.reflection = reflection;
    }
    
    
    public static NIOReturn nearest_intersected_object(List<Geometry> objects, Vector3 ray_origin, Vector3 ray_direction){
        List<Float> distances = new ArrayList<Float>();
        for (Geometry obj: objects){
            if (obj instanceof Sphere){
                distances.add(Sphere.intersect((Sphere)obj, ray_origin, ray_direction));
            }
            else if (obj instanceof Plane){
                distances.add(Plane.intersect((Plane)obj, ray_origin, ray_direction));
            }
        }
        
        Geometry nearest_obj = null;
        Float min_distance = Float.MAX_VALUE;
        
        ListIterator<Float> it = distances.listIterator();
        while(it.hasNext()){
            int index = it.nextIndex();
            Float dist = it.next();
            if (dist != null && dist < min_distance){
                min_distance = dist;
                nearest_obj = objects.get(index);
            }
        }
        NIOReturn ret = new NIOReturn(nearest_obj, min_distance);
        return ret;
    }
}
