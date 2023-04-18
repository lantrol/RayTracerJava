/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raytracerjava;

/**
 *
 * @author landa
 */
public class Camera {
    public Integer width, height;
    public Integer[] posicion;
    public Float ratio;
    public Float[] screen;

    public Camera(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        posicion = new Integer[]{0,0,1};
        ratio = (float)width/height;
        screen = new Float[]{-1f, 1/ratio, 1f, -1/ratio};      
    }
    
    public static Float[] linspace(Float ini, Float fin, int n){
        Float[] lista = new Float[n];
        Float dif = (fin-ini)/(n-1);
        for (int i = 0; i < n; i++){
            lista[i] = ini + (dif*i);
        }
        return lista;
    }
}
