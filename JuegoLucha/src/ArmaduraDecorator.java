public class ArmaduraDecorator extends PersonajeDecorator {

    private static final int REDUCCION = 5;

    public ArmaduraDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public void recibirDano(int dano) {
        int danoReducido = Math.max(0, dano - REDUCCION);
        System.out.println("  [Armadura] reduce " + REDUCCION + " puntos → daño efectivo: " + danoReducido);
        personaje.recibirDano(danoReducido);
    }

    @Override
    public String getNombre() {
        return personaje.getNombre() + " [Armadura]";
    }
}