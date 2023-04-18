/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package raytracerjava;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author landa
 */
public class RayTracerJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Camera camera = new Camera(300, 200);
        List<Sphere> objects = new ArrayList<Sphere>();
        objects.add(new Sphere(new Float[] {-0.2f, 0f, -1f}, 0.7f, new Float[] {0.1f, 0f, 0f}, new Float[] {0.7f, 0f, 0f}, new Float[] {1f, 1f, 1f}, 100f, 0.5f));
        
        Integer max_profundidad = 2;
        
        //Float[] p = Camera.linspace(camera.screen[1], camera.screen[3], camera.height);
        BufferedImage image = new BufferedImage(camera.height,camera.width,BufferedImage.TYPE_INT_RGB);
        Float[] p = Camera.linspace(1f,2f,3);
    }
    
}
