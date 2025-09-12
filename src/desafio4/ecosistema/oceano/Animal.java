package desafio4.ecosistema.oceano;
/**
 *
 * @author LucBaquero
 */
public abstract class Animal {
    // ATRIBUTOS
    private String nombre;
    private int salud;
    private int energia;
    
    // CONSTRUCTOR    
    public Animal(String nombre, int saludInicial, int energiaInicial) {
        this.nombre = nombre;
        this.salud = saludInicial;
        this.energia = energiaInicial;
    }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getEnergia() { return energia; }
    
    // SETTERS
    public void setSalud(int salud) {
        this.salud = Math.max(0, salud); // La salud no puede ser negativa.
    }

    public void setEnergia(int energia) {
        this.energia = Math.max(0, energia); // La energía no puede ser negativa.
    }  
    
    // METODOS    
    public void comer(int cantidadEnergia, int cantidadSalud) {
        this.setEnergia(this.energia + cantidadEnergia);
        System.out.println(this.nombre + " come y recupera " + cantidadEnergia + cantidadSalud +" de energía y vida.");
    }
    
    public void recibirDanio(int danio) {
        this.setSalud(this.salud - danio);
        System.out.println(this.nombre + " recibe " + danio + " de daño. Salud restante: " + this.salud);
    }
    
    public boolean estaVivo() {
        return this.salud > 0;
    }
    
    // METODOS ABSTRACTOS
    public abstract void moverse();
    public abstract String emitirSonido();
    
}
