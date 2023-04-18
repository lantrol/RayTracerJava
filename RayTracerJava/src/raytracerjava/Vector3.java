/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raytracerjava;

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
    
    public static Float dotProd(Vector3 v1, Vector3 v2){
        Float prod;
        prod = v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
        return prod;
    }
}
