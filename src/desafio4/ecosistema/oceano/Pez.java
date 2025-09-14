/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafio4.ecosistema.oceano;

/**
 *
 * @author USUARIO
 */
public class Pez extends Animal implements HabitatOceano {

    public Pez(String nombre) {
        super(nombre, 50, 80); // salud, energía
    }
    
    @Override
    public void moverse() {
        System.out.println(getNombre() + " se mueve rápidamente entre los corales.");
        setEnergia(getEnergia() - 5);
    }

    @Override
    public String emitirSonido() {
        return "Glup, glup";
    }

    @Override
    public void nadar() {
        System.out.println(getNombre() + " nada en zig-zag.");
        setEnergia(getEnergia() - 10);
    }

    @Override
    public void bucear(int metros) {
        System.out.println(getNombre() + " no puede bucear muy profundo, desciende solo " + Math.min(metros, 20) + "m.");
        setEnergia(getEnergia() - 5);
    }
    
    @Override
    public void flotar() {
        System.out.println(getNombre() + " se mantiene cerca de su anémona.");
        setEnergia(getEnergia() + 15);
    }
    
    // --- Habilidad Especial del Animal ---
    public boolean esconderse() {
        // Tiene un 60% de probabilidad de esconderse con éxito
        if (Math.random() < 0.6) {
            setEnergia(getEnergia() - 15); // Energía al esconderse.
            return true;
        }
        return false;
    }
}
