/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boiteajeux;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author bryancurt
 */
public class Serialisation {

    //sauvegarde une arraylist dans un fichier appellé serial
    public static void ecriture(ArrayList u) {
        // Ouverture du flux d'écriture
        try (ObjectOutputStream objOStrm
                = new ObjectOutputStream(new FileOutputStream("serial"))) {

            // Ecriture de l'objet dans le flux
            objOStrm.writeObject(u);

        } catch (IOException e) {
            System.out.println("Exception during serialization: " + e);
        }
    }

    //récupère et renvoie l'objet récupéré dans le fichier serial
    public static ArrayList lecture() {
        // Ouverture du flux en lecture 
        try (ObjectInputStream objIStrm
                = new ObjectInputStream(new FileInputStream("serial"))) {

            // Lecture de l'objet du flux
            ArrayList liste = (ArrayList) objIStrm.readObject();
            return liste;

        } catch (Exception e) {
            System.out.println("Exception during deserialization: " + e);
            return null;
        }

    }
}
