package supnum_api.supnum.Services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import supnum_api.supnum.Models.Etudiant;

@Service
public class EtudiantService {
    private final Map<Long, Etudiant> etudiants = new HashMap<>();
    private long nextId = 1;

    // Initialisation avec quelques données
    public EtudiantService() {
        ajouterEtudiant(new Etudiant(null, "Elhassen", "Sidi mahmoud",
                "elhassen@supnum.mr", "Informatique", 3));
        ajouterEtudiant(new Etudiant(null, "Ahmed", "Mohamed",
                "ahmed@supnum.mr", "Mathématiques", 2));
    }

    // Récupérer tous les étudiants
    public List<Etudiant> getAllEtudiants() {
        return new ArrayList<>(etudiants.values());
    }

    // Récupérer un étudiant par ID
    public Etudiant getEtudiantById(Long id) {
        return etudiants.get(id);
    }

    // Ajouter un nouvel étudiant
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        etudiant.setId(nextId++);
        etudiants.put(etudiant.getId(), etudiant);
        return etudiant;
    }

    // Modifier un étudiant
    public Etudiant modifierEtudiant(Long id, Etudiant etudiant) {
        if (!etudiants.containsKey(id)) {
            return null;
        }
        etudiant.setId(id);
        etudiants.put(id, etudiant);
        return etudiant;
    }

    // Supprimer un étudiant
    public boolean supprimerEtudiant(Long id) {
        return etudiants.remove(id) != null;
    }
}
