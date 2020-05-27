package oope2017ht.tiedot;
import apulaiset.*;

/**
  * Tieto-luokasta peritty tiedostoa mallintava luokka.
  * <p>
  * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2017.
  * <p>
  * @author Toni Kuikka (Kuikka.Toni.M@student.uta.fi),
  */

public class Tiedosto extends Tieto {

   /*==============================================================================================
    *
    * Attribuutit.
    *
    */

   /** Tiedoston koko. */
   private int koko;

   /*==============================================================================================
    *
    * Rakentajat.
    *
    */

   public Tiedosto(StringBuilder n, int k) throws IllegalArgumentException {
      super(n);
      try {
         koko(k);
      }
      catch (IllegalArgumentException e) {
         throw new IllegalArgumentException();
      }
   }

   /*
    * Kopiorakentaja, joka heittää poikkeuksen, kopioitava tieto ei ole tiedosto.
    *
    */
   public Tiedosto(Tiedosto kopioitava) throws IllegalArgumentException {
      super(kopioitava);
      if (kopioitava instanceof Tiedosto)
         koko = kopioitava.koko();
      else
         throw new IllegalArgumentException();
   }

   /*==============================================================================================
    *
    * Aksessorit.
    *
    */

   /* Palauttaa tiedoston koon. */
   public int koko() {
      return koko;
   }

   /* Asettaa tiedostolle koon. Heittää poikkeuksen, jos koko on virheellinen. */
   public void koko(int k) throws IllegalArgumentException {
      if (k < 0)
         throw new IllegalArgumentException();
      else
         koko = k;
   }

   /*==============================================================================================
    * 
    * Yliluokan operaatioiden korvaukset.
    *
    */

   /** {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
   public String toString() {
      return super.toString() + " " + koko;
   }
}