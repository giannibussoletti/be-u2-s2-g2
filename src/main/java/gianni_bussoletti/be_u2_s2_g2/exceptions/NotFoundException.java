package gianni_bussoletti.be_u2_s2_g2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("La risorsa con id " + id + " non è stata trovata");
    }
}
