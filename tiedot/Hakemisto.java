package oope2017ht.tiedot;
import oope2017ht.omalista.OmaLista;
import fi.uta.csjola.oope.lista.*;
import apulaiset.*;

/**
  * Tieto-luokasta peritty hakemistoa mallintava luokka, joka toteuttaa Komennettava-rajapinnan.
  * <p>
  * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2017.
  * <p>
  * @author Toni Kuikka (Kuikka.Toni.M@student.uta.fi),
  */

public class Hakemisto extends Tieto implements Komennettava<Tieto> {

   /*==============================================================================================
    *
    * Attribuutit.
    *
    */

   /** Hakemiston sisältö. */
   public OmaLista sisalto;

   /** Hakemiston ylihakemisto. */
   private Hakemisto ylihakemisto;

   /*==============================================================================================
    *
    * Rakentajat.
    *
    */
   public Hakemisto(StringBuilder n, Hakemisto yh) {
      super(n);
      ylihakemisto(yh);
      sisalto = new OmaLista();
   }

   /*==============================================================================================
    *
    * Aksessorit.
    *
    */

   /* Palauttaa viitteen ylihakemistoon. */
   public Hakemisto ylihakemisto() {
      return ylihakemisto;
   }

   /* Asettaa hakemistolle ylihakemiston. */
   public void ylihakemisto(Hakemisto yh) {
      ylihakemisto = yh;
   }

   /*==============================================================================================
    * 
    * Yliluokan ja rajapinnan operaatioiden korvaukset.
    *
    */

   /*
    * Komennettava-rajapinnan metodien toteutus. Geneerinen tyyppi T kiinnitetty Tieto-tyypiksi.
    *
    */

   /** {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
   public LinkitettyLista sisalto() {
      return sisalto;
   }

   /** {@inheritDoc}
     *
     * @param nimi {@inheritDoc}
     * @return {@inheritDoc}
     */
   public Tieto hae(String nimi) {
      if (nimi != null) {
         Tieto haettava = new Tiedosto(new StringBuilder(nimi), 0);
         Tieto loydettyTieto = (Tieto)sisalto.hae(haettava);
         return loydettyTieto;
      }
      else
         return null;
   }

   /** {@inheritDoc}
     *
     * @param lisattava {@inheritDoc}
     * @return {@inheritDoc}
     */
   public boolean lisaa(Tieto lisattava) {
      boolean lisaaminenOnnistui;
      try {
         Tieto samanniminen = hae(String.valueOf(lisattava.nimi()));
         if (samanniminen == null)
            lisaaminenOnnistui = sisalto.lisaa(lisattava);
         else
            lisaaminenOnnistui = false;
      }
      catch (Exception e) {
         lisaaminenOnnistui = false;
      }
      return lisaaminenOnnistui;
   }
 
   /** {@inheritDoc}
     *
     * @param nimi {@inheritDoc}
     * @return {@inheritDoc}
     */
   public Tieto poista(String nimi) {
      if (nimi != null) {
         Tieto poistettava = new Tiedosto(new StringBuilder(nimi), 0);
         Tieto poistettuTieto = (Tieto)sisalto.poista(poistettava);
         return poistettuTieto;
      }
      else
         return null;
   }

   /** {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
   public String toString() {
      return super.toString() + "/" + " " + sisalto.koko();
   }
}