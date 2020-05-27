package oope2017ht;
import oope2017ht.logiikka.*;

/**
  * Main-metodin sisältävä ajoluokka, joka suorittaa ohjelman.
  * <p>
  * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2017.
  * <p>
  * @author Toni Kuikka (Kuikka.Toni.M@student.uta.fi),
  */

public class Oope2017HT {

   /** Main-metodi, joka luo käyttöliittymä-olion ja kutsuu sen operaatiota. */
   public static void main(String[] args) {
         Kayttoliittyma harjoitustyo = new Kayttoliittyma();
         harjoitustyo.suoritaOhjelma();
   }
}