/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raytracerjava;

/**
 *
 * @author landa
 */
public class Sphere {
    public Vector3 center;
    public Float radius;
    public Float[] ambient = new Float[3];
    public Float[] diffuse = new Float[3];
    public Float[] specular = new Float[3];
    public Float shininess;
    public Float reflection;

    public Sphere(Vector3 center, Float radius, Float[] ambient, Float[] diffuse, Float[] specular, Float shininess, float reflection){
        this.center = center;
        this.radius = radius;
        this.ambient = ambient;
        this.diffuse = diffuse;
        this.specular = specular;
        this.shininess = shininess;
        this.reflection = reflection;
    }
    
    public void sphere_intersect(Sphere s, Vector3 ray_origin, Vector3 ray_direction){
        Vector3 originMinusCenter = new Vector3();
        originMinusCenter.copy(ray_origin);
        originMinusCenter.sub(s.center);
        Float b = 2 * Vector3.dotProd(ray_direction, originMinusCenter);
    }
}
