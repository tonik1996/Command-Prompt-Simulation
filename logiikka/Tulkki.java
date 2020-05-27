package oope2017ht.logiikka;
import oope2017ht.tiedot.*;
import oope2017ht.omalista.*;

/**
  * Tulkki-luokka, joka vastaa ohjelman toimintojen toteuttamisesta.
  * <p>
  * Harjoitustyˆ, Olio-ohjelmoinnin perusteet, kev‰t 2017.
  * <p>
  * @author Toni Kuikka (Kuikka.Toni.M@student.uta.fi),
  */

public class Tulkki {

   /*==============================================================================================
    *
    * Attribuutit.
    *
    */

   /** K‰sitelt‰v‰n hakemistopuun juuri. */
   protected Hakemisto juurihakemisto = new Hakemisto(new StringBuilder(""), null);


   /** Attribuutti nykyiselle hakemistolle, joka alustetaan juureksi. */
   protected Hakemisto nykyinenHakemisto = juurihakemisto;

   /*==============================================================================================
    *
    * Luokkametodit.
    *
    */

   /** Metodi, joka muodostaa hakemistopolun lis‰‰m‰ll‰ parametrinaan saamansa nykyisen hakemiston
     * ylihakemistot merkkijonoon, jonka se palauttaa lopuksi.
     *
     * @param hakemisto nykyinen hakemisto, jonka polku muodostetaan.
     * @return muodostettu hakemistopolku
     */
   public String muodostaHakemistopolku(Hakemisto hakemisto) {
      String hakemistopolku = new String();
      hakemistopolku = String.valueOf(hakemisto.nimi());
      Hakemisto apuHakemisto = hakemisto;

      if (apuHakemisto.ylihakemisto() != null) {
         while (apuHakemisto.ylihakemisto() != null) {
            hakemistopolku = String.valueOf(apuHakemisto.ylihakemisto().nimi()) + "/" + hakemistopolku;
            apuHakemisto = apuHakemisto.ylihakemisto();
         }
      }
      return hakemistopolku;
   }

   /** Metodi, joka luo nykyiseen hakemistoon uuden alihakemiston, ja nime‰‰ sen parametrinaan saamansa
     * nimen mukaan. 
     *
     * @param komento jonka toisena osana on nimi luotavalle hakemistolle.
     * @throws IllegalArgumentException jos nykyhakemistossa on jo samanniminen alihakemisto tai 
     * parametri on muuten virheellinen.
     */
   public void luoHakemisto(String komento) throws IllegalArgumentException {
      String[] osat = komento.split("[ ]");
      if (osat.length == 2) {
         String nimi = new String(osat[1]);
         Tieto samanNiminen = nykyinenHakemisto.hae(nimi);
         if (samanNiminen != null)
            System.out.println("Error!");
         else {
            Hakemisto luotuHakemisto = new Hakemisto(new StringBuilder(nimi), nykyinenHakemisto);
            nykyinenHakemisto.lisaa(luotuHakemisto);
         }
      }
      else
         throw new IllegalArgumentException();
   }

   /** Metodi, joka vaihtaa hakemistoa parametrinaan saamansa komennon perusteella.
     *
     * @param komento jonka parametri m‰‰ritt‰‰, mihin hakemistoon vaihdetaan.
     * @throws IllegalArgumentException jos alihakemistoa ei lˆydet‰, jos juurihakemistosta yritet‰‰n 
     * siirty‰ ylihakemistoon tai jos parametri on muuten virheellinen.
     */
   public void vaihdaHakemistoa(String komento) throws IllegalArgumentException {
      String[] osat = komento.split("[ ]");
      if (osat.length < 3) {
         if (osat.length < 2) {
            if (osat[0].equals("cd"))
               nykyinenHakemisto = juurihakemisto;
            else
               throw new IllegalArgumentException();
         }
         else {
            String nimi = new String(osat[1]);
            if (nimi.equals("..")) {
               if (nykyinenHakemisto.ylihakemisto() != null) 
                  nykyinenHakemisto = nykyinenHakemisto.ylihakemisto();
               else
                  throw new IllegalArgumentException();
            }  
            else {
               if (nykyinenHakemisto.hae(nimi) != null)
                  nykyinenHakemisto = (Hakemisto)nykyinenHakemisto.hae(nimi);
               else
                  throw new IllegalArgumentException();
            }
         }
      }
      else
         throw new IllegalArgumentException();
   }

   /** Metodi, joka luo nykyiseen hakemistoon uuden tiedoston, ja nime‰‰ sek‰ m‰‰ritt‰‰ tiedoston koon
     * saamiensa parametrien perusteella
     *
     * @param komento jonka toinen osa m‰‰ritt‰‰ tiedoston nimen ja kolmas osa koon.
     * @throws IllegalArgumentException jos hakemistossa on jo samanniminen
     * tiedosto tai jos parametri on muuten virheellinen.
     */
   public void luoTiedosto(String komento) throws IllegalArgumentException {
      String[] osat = komento.split("[ ]");
      if (osat.length == 3) {
         String nimi = new String(osat[1]);
         int koko = Integer.parseInt(osat[2]);
         Tieto samanNiminen = nykyinenHakemisto.hae(nimi);
         if (samanNiminen != null)
            throw new IllegalArgumentException();
         else {
            Tiedosto luotuTiedosto = new Tiedosto(new StringBuilder(nimi), koko);
            nykyinenHakemisto.lisaa(luotuTiedosto);
         }
      }
      else
         throw new IllegalArgumentException();
   }

   /** Metodi, joka nime‰‰ tiedoston tai hakemiston uudelleen saamiensa parametrien perusteella.
     *
     * @param komento jonka toisessa osassa on uudelleennimett‰v‰n tiedon nimi ja kolmannessa osassa
     * uusi nimi t‰lle tiedolle.
     * @throws IllegalArgumentException jos nykyisess‰ hakemistossa ei ole ensimm‰isell‰ parametrilla
     * m‰‰ritellyn nimist‰ tiedostoa, jos hakemistossa on jo toisen parametrin m‰‰rittelem‰ tiedosto
     * tai jos parametri on muuten virheellinen.
     */
   public void nimeaUudelleen(String komento) throws IllegalArgumentException {
      String[] osat = komento.split("[ ]");
      if (osat.length == 3) {
         String nimi = new String(osat[1]);
         String uusiNimi = new String(osat[2]);
         Tieto samanNiminen = nykyinenHakemisto.hae(uusiNimi);
         Tieto uudelleenNimettava = nykyinenHakemisto.hae(nimi);
         if (uudelleenNimettava != null && samanNiminen == null) {
            uudelleenNimettava = (Tieto)nykyinenHakemisto.sisalto.poista(uudelleenNimettava);
            uudelleenNimettava.nimi(new StringBuilder(uusiNimi));
            boolean nimeaminenOnnistui = nykyinenHakemisto.sisalto.lisaa(uudelleenNimettava);
         }
         else
            throw new IllegalArgumentException();
      }
      else
         throw new IllegalArgumentException();
   }

   /** Metodi, joka listaa nykyisen hakemiston koko sis‰llˆn nousevassa aakkosj‰rjestyksess‰, kun
     * parametreja ei ole annettu tai tulostaa parametrina saamansa tiedon merkkijonoesityksen.
     *
     * @param komento jonka toisessa osassa on mahdollisesti sen tiedon nimi, jonka merkkijonoesitys
     * halutaan tulostaa.
     * @throws IllegalArgumentException jos parametrina saatua tietoa ei lˆydy hakemistosta tai jos
     * parametri on muuten virheellinen.
     */
   public void listaaHakemisto(String komento) throws IllegalArgumentException {
      String[] osat = komento.split("[ ]");
      if (osat.length < 3) {
         if (osat.length < 2) {
            if (osat[0].equals("ls")) {
               int koko = nykyinenHakemisto.sisalto.koko();
               for (int i = 0; i < koko; i++) {
                  Object alkio = nykyinenHakemisto.sisalto.alkio(i);
                  System.out.println(alkio);
               }
            }
            else
               throw new IllegalArgumentException();
         }
         else {
            String nimi = new String(osat[1]);
            Tieto tulostettava = nykyinenHakemisto.hae(nimi);
            if (tulostettava != null)
               System.out.println(tulostettava);
            else
               throw new IllegalArgumentException();
         }
      }
      else
         throw new IllegalArgumentException();
   }

   /** Metodi, joka kopioi parametrinaan saamansa tiedoston ja nime‰‰ sen toisena parametrina saamansa
     * merkkijonon mukaan.
     *
     * @param komento jonka toisena osana on kopioitavan tiedoston nimi ja kolmantena osana uusi nimi
     * kopiolle.
     * @throws IllegalArgumentException jos kopioitavaa tiedostoa ei lˆydet‰ nykyhakemistosta,
     * jos nykyhakemistossa on jo j‰lkimm‰isen‰ parametrina m‰‰ritelty tiedosto, jos kopioitava tieto on 
     * hakemisto tai jos parametri on muuten virheellinen.
     */
   public void kopioiTiedosto(String komento) throws IllegalArgumentException {
      String[] osat = komento.split("[ ]");
      if (osat.length == 3) {
         String kopioitavanNimi = new String(osat[1]);
         String kopionNimi = new String(osat[2]);
         Tiedosto kopioitava = (Tiedosto)nykyinenHakemisto.hae(kopioitavanNimi);
         Tieto samanNiminen = nykyinenHakemisto.hae(kopionNimi);

         if (kopioitava != null && samanNiminen == null) {
            Tiedosto kopioTiedosto = new Tiedosto(kopioitava);
            kopioTiedosto.nimi(new StringBuilder(kopionNimi));
            nykyinenHakemisto.lisaa(kopioTiedosto);
         }
         else
            throw new IllegalArgumentException();
      }
      else
         throw new IllegalArgumentException();
   }

   /** Metodi, joka poistaa parametrinaan saamansa tiedoston tai hakemiston nykyhakemistosta. 
     *
     * @param komento jonka toisena osana on poistettavan tiedon nimi.
     * @throws IllegalArgumentException jos parametrina annetulla nimell‰ ei lˆydet‰ tietoa tai jos
     * parametri on muuten virheellinen.
     */
   public void poistaTieto(String komento) throws IllegalArgumentException {
      String[] osat = komento.split("[ ]");
      if (osat.length == 2) {
         String poistettavanNimi = new String(osat[1]);
         Tieto poistettu = nykyinenHakemisto.poista(poistettavanNimi);
         if (poistettu == null)
            throw new IllegalArgumentException();
      }
      else
         throw new IllegalArgumentException();
   }

   /** Metodi, joka listaa parametrinaan saamansa nykyhakemiston alihakemistoineen esij‰rjestyksess‰. 
     *
     * @param nykyinenHakemisto jonka sis‰ltˆ halutaan listata rekursiivisesti.
     */
   public void listaaRekursiivisesti(Hakemisto nykyinenHakemisto) {
      OmaLista sisalto = (OmaLista)nykyinenHakemisto.sisalto();
      int i = 0;
      Hakemisto apuHakemisto = nykyinenHakemisto;

      while (i < sisalto.koko()) {
         Tieto tieto = (Tieto)sisalto.alkio(i);
         System.out.print(muodostaHakemistopolku(apuHakemisto));
         System.out.print("/");
         System.out.println(tieto);
         if (tieto instanceof Hakemisto) {
            Hakemisto hakemisto = (Hakemisto)tieto;
            listaaRekursiivisesti(hakemisto);
         }
         i++;
      }
   }

   /** Metodi, joka vastaa k‰yttˆliittym‰n silmukan pys‰ytt‰misest‰ ja ohjelman lopettamisesta
     * muuttamalla lippumuuttujan arvon. 
     *
     * @return lippumuuttuja false-arvoiseksi muutettuna.
     */
   public boolean lopetaOhjelma() {
      System.out.println("Shell terminated.");
      boolean jatketaan = false;
      return jatketaan;
   }
} 