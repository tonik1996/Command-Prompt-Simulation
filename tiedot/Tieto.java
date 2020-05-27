package oope2017ht.tiedot;
import apulaiset.*;

/**
  * Abstrakti Tieto-luokka, joka sis‰lt‰‰ tiedoille yhteiset piirteet.
  * <p>
  * Harjoitustyˆ, Olio-ohjelmoinnin perusteet, kev‰t 2017.
  * <p>
  * @author Toni Kuikka (Kuikka.Toni.M@student.uta.fi),
  */

public abstract class Tieto implements Comparable<Tieto> {

   /*==============================================================================================
    *
    * Attribuutit.
    *
    */

   /** Tiedon nimi. */
   private StringBuilder nimi;

   /*==============================================================================================
    *
    * Rakentajat.
    *
    */

   public Tieto(StringBuilder n) throws IllegalArgumentException {
      int pLkm = 0;
      try {
         nimi(n);
      }
      catch (IllegalArgumentException e) {
         throw new IllegalArgumentException();
      }
   }

   /*
    * Kopiorakentaja, joka heitt‰‰ poikkeuksen, jos kopioitava tieto ei ole tiedosto.
    *
    */
   public Tieto(Tieto kopioitava) throws IllegalArgumentException {
      if (kopioitava instanceof Tiedosto) {
         StringBuilder kopionimi = new StringBuilder(kopioitava.nimi());
         nimi(kopionimi);
      }
      else
         throw new IllegalArgumentException();
   }

   /*==============================================================================================
    *
    * Aksessorit.
    *
    */

   /* Palauttaa tiedon nimen. */
   public StringBuilder nimi() {
      return nimi;
   }

   /* Asettaa tiedolle nimen. Heitt‰‰ poikkeuksen, jos nimi on virheellinen. */
   public void nimi(StringBuilder n) throws IllegalArgumentException {
      int pLkm = 0;
      for (int i = 0; i < n.length(); i++) {
         if ((n.charAt(i) < '.') || (n.charAt(i) > '.' && n.charAt(i) < '0') || 
         (n.charAt(i) > '9' && n.charAt(i) < 'A') || (n.charAt(i) > 'Z' && n.charAt(i) < '_')
         || (n.charAt(i) > '_' && n.charAt(i) < 'a') || (n.charAt(i) > 'z')) {
            throw new IllegalArgumentException();
         }
         if (n.charAt(i) == '.') {
            pLkm++;
            if (pLkm > 1)
               throw new IllegalArgumentException();
         } 
      }
      nimi = n;
   }

   /*==============================================================================================
    * 
    * Yliluokan ja rajapinnan operaatioiden korvaukset.
    *
    */

   /** Yliluokan toString-metodin korvaus.
     *
     * @return luokan merkkijonoesitys.
     */
   public String toString() {
      String nimi1 = String.valueOf(nimi);
      return nimi1;
   }

   /** Comparable-rajapinnan metodin toteutus. Geneerinen tyyppi T kiinnitetty Tieto-tyypiksi.
     * 
     * @param o vertailtava tieto.
     * @return vertailtavien merkkijonojen v‰linen et‰isyys.
     */
   public int compareTo(Tieto o) {
      String nimi1 = String.valueOf(nimi);
      String nimi2 = String.valueOf(o.nimi());
      if (nimi1.compareTo(nimi2) < 0)
         return nimi1.compareTo(nimi2);
      else if (nimi1.compareTo(nimi2) > 0)
         return nimi1.compareTo(nimi2);
      else
         return 0;
   }

   /** Object-luokan equals-metodin korvaus. Vertaillaan tietoja niiden nimien perusteella.
    * 
    * @param obj vertailtava tieto.
    * @return true, jos tiedot ovat samat, false, jos eiv‰t ole.
    */
   public boolean equals(Object obj) {
      boolean onSamat = false;
      try {
         Tieto t = (Tieto)obj;
         String nimi1 = String.valueOf(nimi);
         String nimi2 = String.valueOf(t.nimi());
         if (nimi1.equals(nimi2)) 
            onSamat = true; 
      }  
      catch (Exception e) {
         onSamat = false;
      }
      return onSamat;     
   }
}