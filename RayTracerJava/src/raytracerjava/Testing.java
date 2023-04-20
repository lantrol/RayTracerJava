/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raytracerjava;

/**
 *
 * @author landa
 */
public class Testing {
    public static void main(String[] args) {
        Vector3 origin = new Vector3(0f, 0f, -1f);
        Vector3 direction = new Vector3(0f, 0f, 1f);
        Plane plane = new Plane(new Vector3(0f, 0f, 1f), new Vector3(0f, 0f, -1f));
        
        System.out.println(plane.intersection(plane, origin, direction));
    }
}
