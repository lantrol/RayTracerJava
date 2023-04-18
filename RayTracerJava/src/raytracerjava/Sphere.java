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
    public Float[] center = new Float[3];
    public Float radius;
    public Float[] ambient = new Float[3];
    public Float[] diffuse = new Float[3];
    public Float[] specular = new Float[3];
    public Float shininess;
    public Float reflection;

    public Sphere(Float[] center, Float radius, Float[] ambient, Float[] diffuse, Float[] specular, Float shininess, float reflection){
        this.center = center;
        this.radius = radius;
        this.ambient = ambient;
        this.diffuse = diffuse;
        this.specular = specular;
        this.shininess = shininess;
        this.reflection = reflection;
    }
}
