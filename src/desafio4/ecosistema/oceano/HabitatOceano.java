package desafio4.ecosistema.oceano;

/**
 *
 * @author LucBaquero
 */
public interface HabitatOceano {
    // Constante que define la salinidad del agua, una característica del hábitat.
    double SALINIDAD_PROMEDIO = 35.0;
    // nadar: Dependerá de la velocidad y la energia del animal
    void nadar();
    // bucear: Define la profundidad
    void bucear(int metros);
    // flotar: Permite recupera energía
    void flotar();

}
