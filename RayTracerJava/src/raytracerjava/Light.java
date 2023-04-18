/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raytracerjava;

/**
 *
 * @author landa
 */
public class Light {
    public Float[] position;
    public Float[] ambient;
    public Float[] diffuse;
    public Float[] specular;

    public Light(Float[] position, Float[] ambient, Float[] diffuse, Float[] specular) {
        this.position = position;
        this.ambient = ambient;
        this.diffuse = diffuse;
        this.specular = specular;
    }
}
