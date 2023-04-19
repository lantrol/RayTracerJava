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
public class Sphere {
    public Vector3 center;
    public Float radius;
    public Vector3 ambient;
    public Vector3 diffuse;
    public Vector3 specular;
    public Float shininess;
    public Float reflection;

    public Sphere(Vector3 center, Float radius, Vector3 ambient, Vector3 diffuse, Vector3 specular, Float shininess, float reflection){
        this.center = center;
        this.radius = radius;
        this.ambient = ambient;
        this.diffuse = diffuse;
        this.specular = specular;
        this.shininess = shininess;
        this.reflection = reflection;
    }
    
    public static Float sphere_intersect(Sphere s, Vector3 ray_origin, Vector3 ray_direction){
        Vector3 originMinusCenter = new Vector3();
        originMinusCenter.copy(ray_origin);
        originMinusCenter.sub(s.center);
        //System.out.println(originMinusCenter.x + " " + originMinusCenter.y + " " + originMinusCenter.z);
        
        Float b = 2 * Vector3.dotProd(ray_direction, originMinusCenter);
        Float c = Vector3.norm(originMinusCenter)*Vector3.norm(originMinusCenter) - s.radius*s.radius;
        Float delta = b*b - 4*c;
        
        if (delta > 0){
            Float t1 = (float)(-b + Math.sqrt(delta))/2;
            Float t2 = (float)(-b - Math.sqrt(delta))/2;
            if (t1 > 0 && t2 > 0){
                return Math.min(t1, t2);
            }
        }
        return null;
    }
    
    public static NIOReturn nearest_intersected_object(List<Sphere> objects, Vector3 ray_origin, Vector3 ray_direction){
        List<Float> distances = new ArrayList<Float>();
        for (Sphere obj: objects){
            distances.add(Sphere.sphere_intersect(obj, ray_origin, ray_direction));
        }
        
        Sphere nearest_obj = null;
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
