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
    public Vector3 position;
    public Vector3 ambient;
    public Vector3 diffuse;
    public Vector3 specular;

    public Light(Vector3 position, Vector3 ambient, Vector3 diffuse, Vector3 specular) {
        this.position = position;
        this.ambient = ambient;
        this.diffuse = diffuse;
        this.specular = specular;
    }
}
