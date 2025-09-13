package desafio4.ecosistema.oceano;
/**
 *
 * @author LucBaquero
 */
public class Tiburon extends Animal implements HabitatOceano {
    // CONSTRUCTOR
    public Tiburon(String nombre) {
        super(nombre, 200, 150);    // (Especie, Salud, Energia)
    }
    
    // METODOS CLASE ABSTRACTA
    @Override
    public void moverse() {
        System.out.println(getNombre() + " se desplaza sigilosamente por el agua.");
        setEnergia(getEnergia() - 15);
    }

    @Override
    public String emitirSonido() {
        return "... (silencio depredador)";
    }
    
    // --- METODOS HABITAT 
    @Override
    public void nadar() {
        System.out.println(getNombre() + " nada a gran velocidad, buscando presas.");
        setEnergia(getEnergia() - 20);
    }

    @Override
    public void bucear(int metros) {
        System.out.println(getNombre() + " desciende " + metros + " metros hacia las profundidades.");
        setEnergia(getEnergia() - (metros / 10)); // Cuesta más energía bucear profundo.
    }

    @Override
    public void flotar() {
        System.out.println(getNombre() + " patrulla cerca de la superficie.");
        setEnergia(getEnergia() + 10); // Descansa.
    }
    
    // METODOS PROPIOS
    public void cazar(Animal presa) {
        System.out.println(getNombre() + " intenta cazar a " + presa.getNombre() + "!");
        // Si la presa es un PezPayaso y se esconde, la caza puede fallar.
        if (presa instanceof Pez) {
            Pez pez = (Pez) presa;
            if (pez.esconderse()) {
                System.out.println(presa.getNombre() + " se escondió en una anémona y escapó!");
                return; // La caza termina.
            }
        }
        presa.recibirDanio(80); // Causa  daño.
        comer(40, 20); // Recupera energía al cazar.
    }
}
