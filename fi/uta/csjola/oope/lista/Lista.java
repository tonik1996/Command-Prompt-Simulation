package fi.uta.csjola.oope.lista;

/**
  * M‰‰rittelee liittym‰n abstraktille tietotyypille lista.
  * <p>
  * null-arvoiset alkiot voivat olla joko sallittuja tai kiellettyj‰
  * rajapinnan toteuttavan luokan tarpeiden mukaan.
  * <p>
  * Olio-ohjelmoinnin perusteet.
  * <p>
  * Viimeksi muutettu 5.2.2012 13:02.
  * <p>
  * @author Jorma Laurikkala (jorma.laurikkala@uta.fi),
  * Informaatiotieteiden yksikkˆ, Tampereen yliopisto.
  */

public interface Lista {

   /*
    * Listan operaatiot.
    *
    */

   /** Lis‰‰ uuden solmun linkitetyn listan alkuun.
     *
     * @param alkio lis‰tt‰v‰ tieto.
     */
   public abstract void lisaaAlkuun(Object alkio);

   /** Lis‰‰ uuden solmun linkitetyn listan loppuun.
     *
     * @param alkio lis‰tt‰v‰ tieto.
     */
   public abstract void lisaaLoppuun(Object alkio);

   /** Lis‰‰ annettuun linkitetyn listan kohtaan uuden solmun.
     * Paikan vanha solmu ja vanhaa solmua seuraavat solmut
     * siirtyv‰t yhden paikan h‰nn‰n suuntaan.
     *
     * @param paikka lis‰yspaikka.
     * @param alkio lis‰tt‰v‰ tieto.
     * @return totuusarvo, joka ilmaisee lis‰yksen onnistumisen.
     */
   public abstract boolean lisaa(int paikka, Object alkio);

   /** Poistetaan linkitetyn listan p‰‰.
     *
     * @return listan p‰‰n tietoalkio tai null-arvo (tyhj‰ lista).
     */
   public abstract Object poistaAlusta();

   /** Poistetaan linkitetyn listan h‰nt‰.
     *
     * @return listan h‰nn‰n tietoalkio tai null-arvo (tyhj‰ lista).
     */
   public abstract Object poistaLopusta();

   /** Poistaa annetusta paikasta solmun ja palauttaa poistetun
     * solmun alkion. Paluuarvo on null, mik‰li paikka oli virheelinen.
     *
     * @param paikka poistopaikka.
     * @return solmun tietoalkio tai null-arvo.
     */
   public abstract Object poista(int paikka);

   /** Palauttaa annetussa paikassa olevan solmun alkion.
     * Mik‰li paikka on virheellinen, paluuarvo on null.
     *
     * @param paikka solmun paikka listassa.
     * @return alkio tai null.
     */
   public abstract Object alkio(int paikka);

   /** Korvaa annetussa paikassa olevan solmun tietoalkion parametrina
     * annetulla uudella tietoalkiolla. Palauttaa korvatun (eli solmun
     * vanhan) tietoalkion, jos paikka on kunnollinen. Paluuarvo on null,
     * jos paikka on virheellinen.
     *
     * @param paikka solmun paikka listassa.
     * @param alkio uusi tietoalkio.
     * @return korvattu tietoalkio tai null.
     */
   public abstract Object korvaa(int paikka, Object alkio);

   /** Palauttaa listan solmujen lukum‰‰r‰n.
     *
     * @return solmujen lkm.
     */
   public abstract int koko();

   /** Onko lista tyhj‰?
     *
     * @return true, mik‰li listassa ei ole solmuja, false muussa tapauksessa.
     */
   public abstract boolean onkoTyhja();
}
