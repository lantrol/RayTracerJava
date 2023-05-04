/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raytracerjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author landa
 */
public class Vector3 {
    public Float x, y, z;
    
    public Vector3(){
        x = 0f;
        y = 0f;
        z = 0f;
    }

    public Vector3(Float x, Float y, Float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void normalize(){
        Float mod;
        mod = (float)Math.sqrt(x*x + y*y + z*z);
        x = x/mod;
        y = y/mod;
        z = z/mod;
    }
    
    @Override
    public String toString(){
        String text = String.format("[%.2f, %.2f, %.2f]", x, y, z);
        return text;
    }
    
    public void copy(Vector3 v){
        x=v.x;
        y=v.y;
        z=v.z;
    }
    
    public void add(Vector3 v){
        x+=v.x;
        y+=v.y;
        z+=v.z;
    }
    
    public void sub(Vector3 v){
        x-=v.x;
        y-=v.y;
        z-=v.z;
    }
    
    public void scale(Float s){
        x=x*s;
        y=y*s;
        z=z*s;
    }
    
    public void randomize(double min, double max){
        Random r = new Random();
        do{
            this.x = (float)(min + (max - min) * r.nextDouble());
            this.y = (float)(min + (max - min) * r.nextDouble());
            this.z = (float)(min + (max - min) * r.nextDouble());
        }while(Vector3.norm(this) == 0);
    }
    
    public static Float dotProd(Vector3 v1, Vector3 v2){
        Float prod;
        prod = v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
        return prod;
    }
    
    public static Float norm(Vector3 v){
        return (float)Math.sqrt(v.x*v.x + v.y*v.y + v.z*v.z);
    }
    
    public static Vector3 multiply(Vector3 v1, Vector3 v2){
        return new Vector3(v1.x*v2.x, v1.y*v2.y, v1.z*v2.z);
    }
    
    public static Vector3 scale(Vector3 v, Float s){
        Vector3 v2 = new Vector3();
        v2.copy(v);
        v2.x=v.x*s;
        v2.y=v.y*s;
        v2.z=v.z*s;
        return v2;
    }
    
    public static Vector3 add(Vector3 v, Vector3 v2){
        return new Vector3(v.x+v2.x, v.y+v2.y, v.z+v2.z);
    }
    
    public static Vector3 sub(Vector3 v, Vector3 v2){
        return new Vector3(v.x-v2.x, v.y-v2.y, v.z-v2.z);
    }
    
    public static Vector3 normalize(Vector3 v){
        Vector3 v2 = new Vector3();
        v2.copy(v);
        Float mod;
        mod = (float)Math.sqrt(v2.x*v2.x + v2.y*v2.y + v2.z*v2.z);
        v2.x = v2.x/mod;
        v2.y = v2.y/mod;
        v2.z = v2.z/mod;
        return v2;
    }
    
    public static Vector3 reflected(Vector3 v, Vector3 axis){
        return Vector3.sub(v, Vector3.scale(axis, 2*Vector3.dotProd(v, axis)));
    }
    
    public static Vector3 clip(Vector3 v, Float min, Float max){
        Float x = Math.max(min, Math.min(max, v.x));
        Float y = Math.max(min, Math.min(max, v.y));
        Float z = Math.max(min, Math.min(max, v.z));
        return new Vector3(x, y, z);
    }
    
    public static Vector3 randomDeviation(Vector3 v, Float angle){
        Vector3 v2 = new Vector3();
        v2.randomize(-1f, 1f);
        Vector3 P = new Vector3(v.y*v2.z-v.z*v2.y, -(v.x*v2.z-v.z*v2.x), v.x*v2.y-v.y*v2.x);
        P.scale(Vector3.norm(v2));
       
        Vector3 deviated = new Vector3();
        deviated.copy(Vector3.scale(v, (float)Math.cos(angle)));
        deviated.add(Vector3.scale(P, (float)Math.sin(angle)));
        
        return deviated;
    }
}
