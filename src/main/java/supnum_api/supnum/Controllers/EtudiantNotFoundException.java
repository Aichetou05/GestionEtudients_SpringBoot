package supnum_api.supnum.Controllers;

public class EtudiantNotFoundException extends RuntimeException {
    public EtudiantNotFoundException(Long id) {
        super("Étudiant introuvable avec id=" + id);
    }
}

