/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raytracerjava;

/**
 *
 * @author landa
 */
public class Plane extends Geometry{
    public Vector3 normal;
    public Vector3 position;

    public Plane(Vector3 position, Vector3 normal, Vector3 ambient, Vector3 diffuse, Vector3 specular, Float shininess, float reflection) {
        super(ambient, diffuse, specular, shininess, reflection);
        this.normal = normal;
        this.position = position;
    }
    
    public static Float intersect(Plane plane, Vector3 ray_origin, Vector3 ray_direction){
        if (Vector3.dotProd(plane.normal, ray_direction) == 0){ return null;}
        
        Float a = Vector3.dotProd(plane.normal, Vector3.sub(ray_origin, plane.position));
        Float b = Vector3.dotProd(plane.normal, ray_direction);
        Float t = -a/b;
        
        if (t > 0){
            return t;
        }
        else {
            return null;
        }
    }
}
