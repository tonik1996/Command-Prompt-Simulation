package oope2017ht;
import oope2017ht.logiikka.*;

/**
  * Main-metodin sis�lt�v� ajoluokka, joka suorittaa ohjelman.
  * <p>
  * Harjoitusty�, Olio-ohjelmoinnin perusteet, kev�t 2017.
  * <p>
  * @author Toni Kuikka (Kuikka.Toni.M@student.uta.fi),
  */

public class Oope2017HT {

   /** Main-metodi, joka luo k�ytt�liittym�-olion ja kutsuu sen operaatiota. */
   public static void main(String[] args) {
         Kayttoliittyma harjoitustyo = new Kayttoliittyma();
         harjoitustyo.suoritaOhjelma();
   }
}