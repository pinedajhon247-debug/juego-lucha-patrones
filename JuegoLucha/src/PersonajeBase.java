public class PersonajeBase implements Personaje {

    private final String nombre;
    private int vida;
    private final int danioBase;

    public PersonajeBase(String nombre, int vida, int danioBase) {
        this.nombre    = nombre;
        this.vida      = vida;
        this.danioBase = danioBase;
    }

    @Override
    public int atacar() {
        System.out.println(nombre + " ataca con " + danioBase + " de daño base.");
        return danioBase;
    }

    @Override
    public void recibirDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
        System.out.println(nombre + " recibe " + dano + " de daño. Vida restante: " + vida);
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}