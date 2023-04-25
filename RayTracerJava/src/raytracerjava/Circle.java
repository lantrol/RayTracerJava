/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raytracerjava;

/**
 *
 * @author landa
 */
public class Circle extends Geometry{
    public Vector3 position;
    public Vector3 normal;
    public Float radius;

    public Circle(Vector3 position, Vector3 normal, Float radius, Vector3 ambient, Vector3 diffuse, Vector3 specular, Float shininess, float reflection) {
        super(ambient, diffuse, specular, shininess, reflection);
        this.position = position;
        this.normal = normal;
        this.radius = radius;
    }
    
    public Float intersect(Vector3 ray_origin, Vector3 ray_direction){
        if (Vector3.dotProd(this.normal, ray_direction) == 0){ return null;}
        
        Float a = Vector3.dotProd(this.normal, Vector3.sub(ray_origin, this.position));
        Float b = Vector3.dotProd(this.normal, ray_direction);
        Float t = a/-b;
        
        if (t > 0){
            Vector3 intersection = new Vector3();
            intersection.copy(ray_direction);
            intersection.scale(t);
            intersection.add(ray_origin);
            
            Float distance = Vector3.norm(Vector3.sub(intersection, this.position));
            if (distance <= this.radius){
                return t;
            }
            else{
                return null;
            }
        }
        else {
            return null;
        }
    }
}
