package oope2017ht.omalista;
import fi.uta.csjola.oope.lista.*;
import apulaiset.*;

/**
  * LinkitettyLista-luokasta peritty OmaLista-luokka, joka toteuttaa Ooperoiva-rajapinnan.
  * <p>
  * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2017.
  * <p>
  * @author Toni Kuikka (Kuikka.Toni.M@student.uta.fi),
  */

public class OmaLista extends LinkitettyLista implements Ooperoiva {

   /*==============================================================================================
    *
    * Ooperoiva-rajapinnan metodien toteutukset.
    *
    */

   /** {@inheritDoc}
     *
     * @param haettava {@inheritDoc}
     * @return {@inheritDoc}
     */
   public Object hae(Object haettava) {
      int i = 0;
      boolean jatketaan = true;
      Object nykyinenAlkio = null;

      if (haettava != null && koko > 0) {
         while (i < koko && jatketaan) {
            nykyinenAlkio = alkio(i);
            if (nykyinenAlkio.equals(haettava))
               jatketaan = false;
            else {
               nykyinenAlkio = null;
               i++;
            }
         }
      }
      return nykyinenAlkio;
   }

   /** {@inheritDoc}
     *
     * @param uusi {@inheritDoc}
     * @return {@inheritDoc}
     */
   @SuppressWarnings("unchecked")
   public boolean lisaa(Object uusi) {
      int i = 0;
      boolean jatketaan = true;
      boolean onnistui = false;

      if (uusi != null) {
         if (koko > 0) {
            while (i < koko && jatketaan) {
               Comparable vertailtava = (Comparable)alkio(i);
               if (vertailtava.compareTo(uusi) > 0) {
                  lisaa(i, uusi);
                  jatketaan = false;
               }
               else if (i == koko-1) {
                  lisaaLoppuun(uusi);
                  jatketaan = false;
               }
               else
                  i++;
            } 
         }
         else
            lisaaLoppuun(uusi);
         onnistui = true;
      }
      return onnistui;
   }

   /** {@inheritDoc}
     *
     * @param poistettava {@inheritDoc}
     * @return {@inheritDoc}
     */
   public Object poista(Object poistettava) {
      int i = 0;
      boolean jatketaan = true;
      Object poistettu = null;

      if (poistettava != null && koko > 0) {
         while (i < koko && jatketaan) {
            Object alkio = alkio(i);
            if (poistettava.equals(alkio)) {
               poistettu = poista(i);
               jatketaan = false;
            }
            i++;
         }
      }
      return poistettu;
   }
}