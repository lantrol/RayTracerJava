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
    public Vector3 position;
    public Vector3 normal;

    public Plane(Vector3 position, Vector3 normal, Vector3 ambient, Vector3 diffuse, Vector3 specular, Float shininess, float reflection) {
        super(ambient, diffuse, specular, shininess, reflection);
        this.position = position;
        this.normal = normal;
    }
    
    public Float intersect(Vector3 ray_origin, Vector3 ray_direction){
        if (Vector3.dotProd(this.normal, ray_direction) == 0){ return null;}
        
        Float a = Vector3.dotProd(this.normal, Vector3.sub(ray_origin, this.position));
        Float b = Vector3.dotProd(this.normal, ray_direction);
        Float t = a/-b;
        
        if (t > 0){
            return t;
        }
        else {
            return null;
        }
    }
}
