//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.0 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2025.11.20 à 11:07:48 PM CET 
//


package com.supnum.etudiant;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.supnum.etudiant package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.supnum.etudiant
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetEtudiantRequest }
     * 
     */
    public GetEtudiantRequest createGetEtudiantRequest() {
        return new GetEtudiantRequest();
    }

    /**
     * Create an instance of {@link GetEtudiantResponse }
     * 
     */
    public GetEtudiantResponse createGetEtudiantResponse() {
        return new GetEtudiantResponse();
    }

    /**
     * Create an instance of {@link Etudiant }
     * 
     */
    public Etudiant createEtudiant() {
        return new Etudiant();
    }

    /**
     * Create an instance of {@link GetAllEtudiantsRequest }
     * 
     */
    public GetAllEtudiantsRequest createGetAllEtudiantsRequest() {
        return new GetAllEtudiantsRequest();
    }

    /**
     * Create an instance of {@link GetAllEtudiantsResponse }
     * 
     */
    public GetAllEtudiantsResponse createGetAllEtudiantsResponse() {
        return new GetAllEtudiantsResponse();
    }

}
