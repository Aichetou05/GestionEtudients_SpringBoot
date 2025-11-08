package supnum_api.supnum.Models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Student entity representing a student in the system")
public class Etudiant {
    @Schema(description = "Unique identifier for the student", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    
    @Schema(description = "Last name of the student", example = "Aichetou", required = true)
    private String nom;
    
    @Schema(description = "First name of the student", example = "Mohameden Beida", required = true)
    private String prenom;
    
    @Schema(description = "Email address of the student", example = "23021@supnum.mr", required = true)
    private String email;
    
    @Schema(description = "Field of study", example = "RSS", required = true)
    private String filiere;
    
    @Schema(description = "Academic level/year", example = "3", required = true, minimum = "1", maximum = "5")
    private int niveau;

    public Etudiant() {}

    public Etudiant(Long id, String nom, String prenom, String email, String filiere, int niveau) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.filiere = filiere;
        this.niveau = niveau;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFiliere() { return filiere; }
    public void setFiliere(String filiere) { this.filiere = filiere; }

    public int getNiveau() { return niveau; }
    public void setNiveau(int niveau) { this.niveau = niveau; }
}
