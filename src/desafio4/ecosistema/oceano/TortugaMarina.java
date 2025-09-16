package desafio4.ecosistema.oceano;
/**
 *
 * @author Ceciia
 */
public class TortugaMarina {
public class TortugaMarina extends Animal implements HabitatOceano{
     // ATRIBUTO
    private boolean caparazonEscondido; 

    // CONSTRUCTOR
    public TortugaMarina(String nombre) {
        super(nombre, 150, 120);
        this.caparazonEscondido = false;
}

     // METODOS ABSTRACTOS
    @Override
    public void moverse() {
        System.out.println(getNombre() + " se desliza elegantemente por el agua con sus aletas.");
        setEnergia(getEnergia() - 10);
    }

    @Override
    public String emitirSonido() {
        return "... (sonido de respiración profunda)";
    }

     // METODOS HABITAT
    @Override
    public void nadar() {
        System.out.println(getNombre() + " viaja grandes distancias nadando con calma.");
        setEnergia(getEnergia() - 12);
    }

    @Override
    public void bucear(int metros) {
        System.out.println(getNombre() + " bucea hasta " + metros + " metros para buscar alimento.");
        setEnergia(getEnergia() - 15);
    }

    @Override
    public void flotar() {
        System.out.println(getNombre() + " descansa en la superficie, tomando el sol.");
        setEnergia(getEnergia() + 20); // Recupera bastante energía.
    }


    // METODOS PROPIOS
    public void defenderse() {
        if (getEnergia() >= 15) {
            setEnergia(getEnergia() - 15);
            this.caparazonEscondido = true;
            System.out.println(getNombre() + " se esconde en su caparazón impenetrable.");
        } else {
            System.out.println(getNombre() + " no tiene suficiente energía para esconderse.");
        }
    }

    /**
     * Sobrescribe el método de recibir daño para aplicar la defensa del caparazón.
     */
    @Override
    public void recibirDanio(int danio) {
        if (caparazonEscondido) {
            int danioReducido = (int) (danio * 0.1); // Solo recibe el 10% del daño.
            System.out.println(getNombre() + " resiste el ataque gracias a su caparazón.");
            super.recibirDanio(danioReducido); // Llama al método padre con el daño reducido.
            this.caparazonEscondido = false; // Sale de su caparazón después del ataque.
        } else {
            super.recibirDanio(danio); // Recibe el daño completo.
        }
    }
}
