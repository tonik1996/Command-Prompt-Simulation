package oope2017ht.logiikka;
import apulaiset.*;
import oope2017ht.tiedot.*;

/**
  * Kayttoliittyma-luokka, joka vastaa käyttäjän ja koneen vuorovaikutuksesta.
  * <p>
  * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2017.
  * <p>
  * @author Toni Kuikka (Kuikka.Toni.M@student.uta.fi),
  */

public class Kayttoliittyma {

   /*==============================================================================================
    *
    * Attribuutit.
    *
    */

   /** Luokkavakiot ohjelman tuntemille komennoille. */
   public static final String LUOHAKEMISTO = new String("md");
   public static final String VAIHDAHAKEMISTOA = new String("cd");
   public static final String LUOTIEDOSTO = new String("mf ");
   public static final String NIMEAUUDELLEEN = new String("mv ");
   public static final String LISTAAHAKEMISTO = new String("ls");
   public static final String KOPIOITIEDOSTO = new String("cp");
   public static final String POISTATIETO = new String("rm");
   public static final String LISTAAREKURSIIVISESTI = new String("find");
   public static final String LOPETAOHJELMA = new String("exit");

   /** Komentotulkki, joka vastaa komentojen toteuttamisesta. */
   private Tulkki komentotulkki;  
   
   /*==============================================================================================
    *
    * Luokkametodit.
    *
    */

   /** Metodi, joka vastaa ohjelman suorituksesta, lukee komentoja käyttäjältä ja kutsuu komentoja 
     * vastaavia metodeja.
     */
   public void suoritaOhjelma() {
      System.out.println("Welcome to SOS.");
      Tulkki komentotulkki = new Tulkki();
      String komento = new String();
      boolean jatketaan = true;
      Hakemisto nykyinenHakemisto = komentotulkki.juurihakemisto;

      while (jatketaan) {
         try {
            System.out.print(komentotulkki.muodostaHakemistopolku(komentotulkki.nykyinenHakemisto));
            System.out.print("/>");
            komento = In.readString();
 
            if (komento.startsWith(LUOHAKEMISTO)) {
               komentotulkki.luoHakemisto(komento);
            }
            else if (komento.startsWith(VAIHDAHAKEMISTOA)) {
               komentotulkki.vaihdaHakemistoa(komento);
               nykyinenHakemisto = komentotulkki.nykyinenHakemisto;
            }
            else if (komento.startsWith(LUOTIEDOSTO)) {
              komentotulkki.luoTiedosto(komento);
            }
            else if (komento.startsWith(NIMEAUUDELLEEN)) {
               komentotulkki.nimeaUudelleen(komento);
            }
            else if (komento.startsWith(LISTAAHAKEMISTO)) {
               komentotulkki.listaaHakemisto(komento);
            }
            else if (komento.startsWith(KOPIOITIEDOSTO)) {
               komentotulkki.kopioiTiedosto(komento);
            }
            else if (komento.startsWith(POISTATIETO)) {
               komentotulkki.poistaTieto(komento);
            }
            else if (komento.equals(LISTAAREKURSIIVISESTI)) {
               komentotulkki.listaaRekursiivisesti(komentotulkki.nykyinenHakemisto);
            }
            else if (komento.equals(LOPETAOHJELMA)) {
               jatketaan = komentotulkki.lopetaOhjelma();
            }  
            else 
               System.out.println("Error!");
         }  
         catch (Exception e) {
            System.out.println("Error!"); 
         }
      }
   }
}