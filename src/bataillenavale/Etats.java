/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataillenavale;

/**
 *
 * @author Utilisateur
 */
public enum Etats {
    MER,//Case vide sur laquelle aucun tir n'a été effectué.
    TOUCHE,//Case contenant un bateau sur lequel un tir a été effectué.
    COULE,//Case contenant un bateau dont les pdv sont à 0.
    BATEAU,//Case où un bateau est présent. Qu'il soit visible ou non sur le graphique.
    MERVIDE;//Case où un tir a eu lieu, mais pas de bateau présent.
}
