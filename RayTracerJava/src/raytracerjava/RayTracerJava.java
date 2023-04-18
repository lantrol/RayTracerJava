/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package raytracerjava;

import java.awt.Color;
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
        objects.add(new Sphere(new Vector3(-0.2f, 0f, -1f), 0.7f, new Float[] {0.1f, 0f, 0f}, new Float[] {0.7f, 0f, 0f}, new Float[] {1f, 1f, 1f}, 100f, 0.5f));
        
        Integer max_depth = 2;
        
        //Float[] p = Camera.linspace(camera.screen[1], camera.screen[3], camera.height);
        BufferedImage image = new BufferedImage(camera.height,camera.width,BufferedImage.TYPE_INT_RGB);
        
        
        Float[] pVer = Camera.linspace(1f,2f,3);
        Float[] pHor = Camera.linspace(1f,2f,3);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Vector3 pixel = new Vector3(pHor[j], pVer[i], 0f);
                Vector3 origin = new Vector3();
                origin.copy(camera.position);
                
                Color color = new Color(0f,0f, 0f);
                Integer reflection = 1;
                
                for (int k = 0; k < max_depth; k++) {
                    
                }
            }
        }
    }
}
