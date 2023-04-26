/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package raytracerjava;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author landa
 */
public class RayTracerJava{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Camera camera = new Camera(1920, 1080);
        List<Geometry> objects = new ArrayList<Geometry>();
        objects.add(new Sphere(new Vector3(-0.2f, 0f, -1.5f), 0.7f, new Vector3(0.1f, 0f, 0f), new Vector3(0.7f, 0f, 0f), new Vector3(1f, 1f, 1f), 100f, 0.5f));
        objects.add(new Sphere(new Vector3(0.2f, -0.3f, -0.5f), 0.2f, new Vector3(0.1f, 0f, 0.1f), new Vector3(0.3f, 0f, 0.4f), new Vector3(1f, 1f, 1f), 100f, 0.5f));
        objects.add(new Sphere(new Vector3(2.5f, 0f, -1.5f), 0.7f, new Vector3(0.1f, 0f, 0f), new Vector3(0.7f, 0f, 0f), new Vector3(1f, 1f, 1f), 100f, 0.5f));
        objects.add(new Sphere(new Vector3(-0.2f, -1001f, -1f), 1000f, new Vector3(0.1f, 0f, 0f), new Vector3(0.7f, 0f, 0f), new Vector3(1f, 1f, 1f), 100f, 0.5f));
        objects.add(new Plane(new Vector3(0f, -1f, 0f), new Vector3(0f, 1f, 0f),new Vector3(0.1f, 0f, 0f), new Vector3(0.7f, 0.7f, 0.7f), new Vector3(1f, 1f, 1f), 100f, 0.5f));
        //objects.add(new Plane(new Vector3(0f, 0f, -20f), new Vector3(0f, 0f, 1f),new Vector3(0.1f, 0f, 0f), new Vector3(0.7f, 0f, 0.7f), new Vector3(1f, 1f, 1f), 100f, 0.5f));
        //objects.add(new Circle(new Vector3(0f, 0f, -1.5f), new Vector3(1f, 0f, 1f), 0.5f, new Vector3(0.1f, 0f, 0f), new Vector3(0.7f, 0f, 0f), new Vector3(1f, 1f, 1f), 100f, 0.5f));
        Light light = new Light(new Vector3(3f,5f,5f), new Vector3(1f,1f,1f), new Vector3(1f,1f,1f), new Vector3(1f,1f,1f));
        
        Integer max_depth = 3;
        
        //Float[] p = Camera.linspace(camera.screen[1], camera.screen[3], camera.height);
        BufferedImage image = new BufferedImage(camera.width,camera.height,BufferedImage.TYPE_INT_RGB);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Intruce el nombre del archivo: ");
        String nomArchivo = sc.nextLine();
        
        Float[] pVer = Camera.linspace(camera.screen[1],camera.screen[3],camera.height);
        Float[] pHor = Camera.linspace(camera.screen[0],camera.screen[2],camera.width);
        for (int i = 0; i < pVer.length; i++) {
            for (int j = 0; j < pHor.length; j++) {
                Vector3 pixel = new Vector3(pHor[j], pVer[i], 0f);
                Vector3 origin = new Vector3();
                origin.copy(camera.position);
                Vector3 direction = new Vector3();
                direction.copy(pixel);
                direction.sub(origin);
                direction.normalize();
                
                //El color es inmutable, lo generamos en ejecucion de bucle
                //Color color = new Color(0f,0f, 0f);
                
                Float reflection = 1f;
                Vector3 sumaColores = new Vector3(0f, 0f, 0f);
                
                for (int k = 0; k < max_depth; k++) {
                    NIOReturn nior = Geometry.nearest_intersected_object(objects, origin, direction);
                    if (nior.geometry == null){ break;}
                    
                    //Inter = origin + min_dist*direction
                    Vector3 intersection = new Vector3();
                    intersection.copy(direction);
                    intersection.scale(nior.min_distance);
                    intersection.add(origin);
                    
                    Vector3 normal_to_surface = new Vector3();
                    
                    if (nior.geometry instanceof Plane){
                        normal_to_surface.copy(((Plane)nior.geometry).normal);
                        normal_to_surface.normalize();
                    }
                    else if(nior.geometry instanceof Sphere){
                        normal_to_surface.copy(intersection);
                        normal_to_surface.sub(((Sphere)nior.geometry).center);
                        normal_to_surface.normalize();
                    }
                    else if(nior.geometry instanceof Circle){
                        normal_to_surface.copy(((Circle)nior.geometry).normal);
                        normal_to_surface.normalize();
                    }
                    
                    
                    Vector3 shifted_point = new Vector3();
                    shifted_point.copy(normal_to_surface);
                    shifted_point.scale(0.00005f);
                    shifted_point.add(intersection);
                    
                    Vector3 intersection_to_light = new Vector3();
                    intersection_to_light.copy(light.position);
                    intersection_to_light.sub(shifted_point);
                    intersection_to_light.normalize();
                    
                    NIOReturn nior2 = Geometry.nearest_intersected_object(objects, shifted_point, intersection_to_light);
                    Vector3 interToLight = new Vector3();
                    interToLight.copy(light.position);
                    interToLight.sub(intersection);
                    Float intersection_to_light_distance = Vector3.norm(interToLight);
                    
                    Boolean is_shadowed = nior2.min_distance < intersection_to_light_distance;
                    
                    if (is_shadowed){
                        break;
                    }
                    
                    
                    Vector3 illumination = new Vector3();
                    // Ambient
                    illumination.add(Vector3.multiply(nior.geometry.ambient, light.ambient));
                    // Diffuse
                    illumination.add(Vector3.scale(Vector3.multiply(nior.geometry.diffuse, light.diffuse), Vector3.dotProd(intersection_to_light, normal_to_surface)));
                    
                    //Specular
                    Vector3 intersection_to_camera = new Vector3();
                    intersection_to_camera.copy(camera.position);
                    intersection_to_camera.sub(intersection);
                    intersection_to_camera.normalize();
                    Vector3 H = Vector3.normalize(Vector3.add(intersection_to_light, intersection_to_camera));
                    illumination.add(Vector3.multiply(nior.geometry.specular, Vector3.scale(light.specular, (float)Math.pow(Vector3.dotProd(normal_to_surface, H), nior.geometry.shininess/4))));
                    
                    //Reflection
                    illumination.scale(reflection);
                    sumaColores.add(illumination);
                    //Vector3 illuminationClip = Vector3.clip(illumination, 0f, 1f);
                    //Color color = new Color((float)illuminationClip.x,(float)illuminationClip.y, (float)illuminationClip.z);
                    reflection = nior.geometry.reflection;
                    
                    origin.copy(shifted_point);
                    direction.copy(Vector3.reflected(direction, normal_to_surface));
                }
                Vector3 colorClip = Vector3.clip(sumaColores, 0f, 1f);
                Color color = new Color((float)colorClip.x,(float)colorClip.y, (float)colorClip.z);
                image.setRGB(j, i, color.getRGB());
            }
            //print("%d/%d" % (i + 1, height))
            System.out.println(i);
        }
        File output = new File(String.format("../Renders/%s.png", nomArchivo));
        ImageIO.write(image, "png", output);
    }
}
