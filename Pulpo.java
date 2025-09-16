/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafio4.ecosistema.oceano;

/**
 *
 * @author usuario
 */
public class Pulpo extends Animal implements HabitatOceano {
    // ATRIBUTO
    private boolean estaCamuflado; 

    // CONSTRUCTOR
    public Pulpo(String nombre) {
        super(nombre, 80, 100); // Salud , energía .
        this.estaCamuflado = false; // Empieza sin camuflarse.
    }

    // METODO CLASE ABSTRACTA
    @Override
    public void moverse() {
        // El movimiento del pulpo es diferente si está camuflado.
        if (estaCamuflado) {
            System.out.println(getNombre() + " se desliza lentamente por el fondo marino, imperceptible.");
            setEnergia(getEnergia() - 5);
        } else {
            System.out.println(getNombre() + " se impulsa con sus tentáculos.");
            setEnergia(getEnergia() - 10);
        }
    }

    @Override
    public String emitirSonido() {
        return "... (burbujas silenciosas)";
    }
    
    @Override
    public void recibirDanio(int danio) {
        if (estaCamuflado) {
            // Si está camuflado, tiene un 80% de probabilidad de esquivar el ataque.
            if (Math.random() < 0.8) {
                System.out.println("¡El ataque falla! " + getNombre() + " era indetectable gracias a su camuflaje.");
                this.estaCamuflado = false; // Se revela después de esquivar.
                return; // No recibe daño.
            } else {
                 System.out.println(getNombre() + " fue descubierto a pesar de su camuflaje.");
            }
        }
        // Llama al método original de la clase padre si no esquiva.
        super.recibirDanio(danio);
        this.estaCamuflado = false; // El daño rompe el camuflaje.
    }
    // METODOS HABITAT
    @Override
    public void nadar() {
        System.out.println(getNombre() + " usa su sifón para propulsarse a chorro.");
        setEnergia(getEnergia() - 15);
    }

    @Override
    public void bucear(int metros) {
        System.out.println(getNombre() + " se arrastra por el lecho marino, explorando a " + metros + " metros.");
        setEnergia(getEnergia() - 8);
    }

    @Override
    public void flotar() {
        System.out.println(getNombre() + " deja que la corriente lo meza suavemente.");
        setEnergia(getEnergia() + 10); // Recupera energía al descansar.
    }

    // METODOS PROPIOS
    public void camuflarse() {
        if (getEnergia() >= 20) {
            setEnergia(getEnergia() - 20);
            this.estaCamuflado = true;
            System.out.println(getNombre() + " cambia de color y textura, ¡ahora está camuflado!");
        } else {
            System.out.println(getNombre() + " está demasiado cansado para camuflarse.");
        }
    }
}
