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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import supnum_api.supnum.Models.Etudiant;
import supnum_api.supnum.Services.EtudiantService;

@RestController
@RequestMapping("/api/etudiants")
@Tag(name = "Students", description = "Student management API endpoints")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @Operation(
            summary = "Get all students",
            description = "Retrieve a list of all students in the system"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved list of students",
            content = @Content(schema = @Schema(implementation = Etudiant.class))
    )
    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @Operation(
            summary = "Get student by ID",
            description = "Retrieve a specific student by their unique identifier"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Student found",
                    content = @Content(schema = @Schema(implementation = Etudiant.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Student not found",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    public Etudiant getEtudiantById(
            @Parameter(description = "ID of the student to retrieve", required = true)
            @PathVariable Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant == null) {
            throw new EtudiantNotFoundException(id);
        }
        return etudiant;
    }
    
    @Operation(
            summary = "Create a new student",
            description = "Add a new student to the system. The student ID will be auto-generated."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Student created successfully",
                    content = @Content(schema = @Schema(implementation = Etudiant.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input data",
                    content = @Content
            )
    })
    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(
            @Parameter(description = "Student object to be created", required = true)
            @RequestBody Etudiant etudiant) {
        Etudiant nouvelEtudiant = etudiantService.ajouterEtudiant(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelEtudiant);
    }

    @Operation(
            summary = "Update a student",
            description = "Update an existing student's information by their ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Student updated successfully",
                    content = @Content(schema = @Schema(implementation = Etudiant.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Student not found",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input data",
                    content = @Content
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(
            @Parameter(description = "ID of the student to update", required = true)
            @PathVariable Long id,
            @Parameter(description = "Updated student object", required = true)
            @RequestBody Etudiant etudiant) {

        Etudiant etudiantModifie = etudiantService.modifierEtudiant(id, etudiant);
        if (etudiantModifie == null) {
            throw new EtudiantNotFoundException(id);
        }
        return ResponseEntity.ok(etudiantModifie);
    }

    @Operation(
            summary = "Delete a student",
            description = "Remove a student from the system by their ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Student deleted successfully",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Student not found",
                    content = @Content
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(
            @Parameter(description = "ID of the student to delete", required = true)
            @PathVariable Long id) {
        boolean supprime = etudiantService.supprimerEtudiant(id);
        if (!supprime) {
            throw new EtudiantNotFoundException(id);
        }
        return ResponseEntity.noContent().build();
    }
}
