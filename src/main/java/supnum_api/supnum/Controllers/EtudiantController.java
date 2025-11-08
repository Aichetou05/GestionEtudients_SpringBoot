package supnum_api.supnum.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import supnum_api.supnum.Models.Etudiant;
import supnum_api.supnum.Services.EtudiantService;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    // GET /api/etudiants - Liste tous les étudiants
    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    // GET /api/etudiants/{id} - Récupère un étudiant par ID
    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant == null) {
            throw new EtudiantNotFoundException(id);
        }
        return etudiant;
    }
    
    // POST /api/etudiants - Créer un nouvel étudiant
    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant nouvelEtudiant = etudiantService.ajouterEtudiant(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelEtudiant);
    }

    // PUT /api/etudiants/{id} - Modifier un étudiant
    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(
            @PathVariable Long id,
            @RequestBody Etudiant etudiant) {

        Etudiant etudiantModifie = etudiantService.modifierEtudiant(id, etudiant);
        if (etudiantModifie == null) {
            throw new EtudiantNotFoundException(id);
        }
        return ResponseEntity.ok(etudiantModifie);
    }

    // DELETE /api/etudiants/{id} - Supprimer un étudiant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        boolean supprime = etudiantService.supprimerEtudiant(id);
        if (!supprime) {
            throw new EtudiantNotFoundException(id);
        }
        return ResponseEntity.noContent().build();
    }
}
