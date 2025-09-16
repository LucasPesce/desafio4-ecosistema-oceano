package desafio4.ecosistema.oceano;

// IMPORTACIONES
import java.util.ArrayList;
import java.util.List;

public class Desafio4EcosistemaOceano {

    public static void main(String[] args) {
        System.out.println(" Iniciando simulacion del Ecosistema Oceanico... ");

        // LISTA DE ANIMALES
        List<Animal> habitantes = new ArrayList<>();

        // SE INSTANCIA LOS ANIMALES
        Tiburon tiburonBlanco = new Tiburon("Willy el Tiburon");
        Pez nemo = new Pez("Nemo");
        TortugaMarina crush = new TortugaMarina("Crush");
        Pulpo hank = new Pulpo("Hank");
        
        // SUMAR ANIMALES A LA LISTA
        habitantes.add(tiburonBlanco);
        habitantes.add(nemo);
        habitantes.add(crush);
        habitantes.add(hank);

        System.out.println("\n--- Habitantes del Oceano ---");
        for (Animal habitante : habitantes) {
             System.out.println("- " + habitante.getNombre() + " (Salud: " + habitante.getSalud() + ", Energia: " + habitante.getEnergia() + ")");
        }

        System.out.println("\n--- Dia 1: Un dia tranquilo  ---");
        
        for (Animal habitante : habitantes) {
            habitante.moverse();            
            // Verificamos si el animal implementa la interfaz para llamar a sus métodos.
            if (habitante instanceof HabitatOceano) {
                // Hacemos un "casting" para tratar al Animal como un HabitatOceano.
                ((HabitatOceano) habitante).nadar();
            }
        }
        
        System.out.println("\n--- Dia 2: ¡El peligro acecha! ---");
               
        System.out.println("\n*** Interaccion 1: Tiburon vs. Pez  ***");
        if (tiburonBlanco.estaVivo() && nemo.estaVivo()) {
            tiburonBlanco.cazar(nemo); // El método cazar del tiburón internamente probará la habilidad de esconderse de Nemo.
        }

        System.out.println("\n*** Interaccion 2: Tiburon vs. Pulpo ***");
        if (tiburonBlanco.estaVivo() && hank.estaVivo()) {
            System.out.println(hank.getNombre() + " detecta el peligro...");
            hank.camuflarse(); // El pulpo usa su habilidad ANTES del ataque.
            tiburonBlanco.cazar(hank); // El método recibirDanio del pulpo determinará si el ataque acierta.
        }

        System.out.println("\n*** Interaccion 3: Tiburon vs. Tortuga Marina ***");
        if (tiburonBlanco.estaVivo() && crush.estaVivo()) {
             System.out.println(crush.getNombre() + " ve venir al tiburon...");
            crush.defenderse(); // La tortuga usa su habilidad ANTES del ataque.
            tiburonBlanco.cazar(crush); // El método recibirDanio de la tortuga reducirá el daño.
        }
        
        // --- ESTADO FINAL DE SALUD DE LOS ANIMALES---
        System.out.println("\n--- Estado final de los habitantes ---");
        for (Animal habitante : habitantes) {
            String estado = habitante.estaVivo() ? "Vivo" : "Derrotado";
            System.out.println("- " + habitante.getNombre() + 
                               " | Salud: " + habitante.getSalud() +
                               " | Energia: " + habitante.getEnergia() +
                               " | Estado: " + estado);
        }
        
        System.out.println("\n Fin de la simulaciOn.");
    }
}