// package com.supnum.soap_etudiant.service;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import org.springframework.stereotype.Service;

// import com.supnum.etudiant.Etudiant;

// @Service
// public class EtudiantService {

//     private final Map<Long, Etudiant> etudiants = new HashMap<>();

//     public EtudiantService() {
//         // Initialisation avec des données de test

//         Etudiant etudiant1 = new Etudiant();
//         etudiant1.setId(1L);
//         etudiant1.setNom("Elhassen");
//         etudiant1.setPrenom("Sidi mahmoud");
//         etudiant1.setEmail("elhassen@supnum.mr");
//         etudiant1.setFiliere("Informatique");
//         etudiant1.setAnnee(3);
//         etudiants.put(etudiant1.getId(), etudiant1);

//         Etudiant etudiant2 = new Etudiant();
//         etudiant2.setId(2L);
//         etudiant2.setNom("Ahmed");
//         etudiant2.setPrenom("Mohamed");
//         etudiant2.setEmail("ahme@supnum.mr");
//         etudiant2.setFiliere("Mathématiques");
//         etudiant2.setAnnee(2);
//         etudiants.put(etudiant2.getId(), etudiant2);
//     }

//     public Etudiant getEtudiantById(Long id) {
//         return etudiants.get(id);
//     }

//     public List<Etudiant> getAllEtudiants() {
//         return new ArrayList<>(etudiants.values());
//     }
// }
