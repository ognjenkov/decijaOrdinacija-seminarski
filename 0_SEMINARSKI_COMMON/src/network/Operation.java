/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package network;

import java.io.Serializable;

/**
 *
 * @author ognje
 */
public enum Operation implements Serializable {
    LOGIN, 
    UCITAJ_DECU, 
    OBRISI_DETE, 
    DODAJ_DETE, 
    IZMENI_DETE, 
    UCITAJ_RECEPTE, 
    UCITAJ_STAVKE, 
    DODAJ_PREDSKOLSKODETE, 
    IZMENI_PREDSKOLSKODETE, 
    DODAJ_SKOLSKODETE, 
    IZMENI_SKOLSKODETE, 
    UCITAJ_SKOLSKUDECU, 
    UCITAJ_PREDSKOLSKUDECU, 
    OBRISI_SKOLSKODETE, 
    OBRISI_PREDSKOLSKODETE, 
    LOGOUT, 
    OBRISI_STAVKURECEPTA, DODAJ_STAVKURECEPTA, OBRISI_RECEPT, DODAJ_RECEPT, UCITAJ_LEKOVE, IZMENI_RECEPT
}
