package fi.uta.csjola.oope.lista;

/**
  * Yhteen suuntaan linkitetyn listan solmu.
  * <p>
  * Olio-ohjelmoinnin perusteet.
  * <p>
  * Viimeksi muutettu 5.2.2012 13.03.
  * <p>
  * @author Jorma Laurikkala (jorma.laurikkala@uta.fi),
  * Informaatiotieteiden yksikkˆ, Tampereen yliopisto.
  */

public class Solmu {

   /*
    * Attribuutit.
    *
    */

   /** Solmun sis‰lt‰m‰ tieto, joka voi olla mit‰ tahansa luokkatyyppi‰. */
   private Object alkio;

   /** Viite seuraavaan solmuun. */
   private Solmu seuraava;

   /*
    * Rakentaja
    *
    */

   public Solmu(Object uusi) {
      // Hyv‰ksyt‰‰n, ett‰ voidaan rakentaa null-arvoisella alkiolla.
      alkio = uusi;
      seuraava = null;
   }

   /*
    * Aksessorit
    *
    */

   public void alkio(Object uusi) {
      // Solmun voi tyhjent‰‰ null-arvolla.
      alkio = uusi;
   }

   public Object alkio() { return alkio; }

   public void seuraava(Solmu s) {
      seuraava = s;
   }

   public Solmu seuraava() { return seuraava; }

   /*
    * Object-luokan korvatut metodit.
    *
    */

   /** Korvataan Object-luokan metodi siten, ett‰ kutsutaan alkion metodia.
     * Jos t‰m‰ ei ole mahdollista, niin k‰ytet‰‰n sittenkin kiltisti
     * Object-luokan metodia.
     */
   public String toString() {
      if (alkio != null)
         return alkio.toString();
      else
         return super.toString();
   }
}
