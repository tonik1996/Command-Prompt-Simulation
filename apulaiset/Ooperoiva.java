package apulaiset;

/**
  * Pakolliset uudet listaoperaatiot määritelevä rajapinta.
  * <p>
  * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2017.
  * <p>
  * @author Jorma Laurikkala (jorma.laurikkala@uta.fi), Luonnontieteiden tiedekunta,
  * Tampereen yliopisto.
  *
  */

public interface Ooperoiva {

   /** Tutkii onko listalla haettavaa oliota equals-mielessä vastaava alkio,
     * joita oletetaan olevan korkeintaan yksi kappale.
     *
     * Jos parametri liittyy esimerkiksi merkkijonoon "ab" ja listan tietoalkiot
     * ovat [ "AB, "Ab", "aB", "ab" ], palauttaa operaatio viitteen viimeiseen
     * tietoalkioon, koska "ab".equals("ab") == true.
     *
     * @param haettava listalta haettava alkio, jonka luokan tai luokan esivanhemman
     * oletetaan korvanneen Object-luokan equals-metodin.
     * @return viite löydettyyn alkioon. Paluuarvo on null, jos vastaavaa
     * alkiota ei löydy, parametri on null-arvoinen tai lista on tyhjä.
     */
   public abstract Object hae(Object haettava);

   /** Listan alkioiden välille muodostuu kasvava suuruusjärjestys, jos lisäys
     * tehdään vain tällä operaatiolla, koska uusi alkion lisätään listalle siten,
     * että alkio sijoittuu kaikkien itseään pienempien tai yhtä suurien alkioiden
     * jälkeen ja ennen kaikkia itseään suurempia alkioita. Alkioiden suuruusjärjestys
     * selvitetään Comparable-rajapinnan compareTo-metodilla.
     * 
     * Jos parametri liittyy esimerkiksi kokonaislukuun 2 ja listan tietoalkiot
     * ovat [ 0, 3 ], on listan sisältö lisäyksen jälkeen [ 0, 2, 3 ],
     * koska 0 < 2 < 3.
     *
     * @param uusi viite olioon, jonka luokan tai luokan esivanhemman oletetaan
     * toteuttaneen Comparable-rajapinnan.
     * @return true, jos lisäys onnistui ja false, jos uutta alkiota ei voitu
     * vertailla. Vertailu epäonnistuu, kun parametri on null-arvoinen
     * tai sillä ei ole vastoin oletuksia Comparable-rajapinnan toteutusta.
     */
   public abstract boolean lisaa(Object uusi);
   
   /** Poistaa listalta annettua oliota equals-mielessä vastaavan alkion,
     * joita oletetaan olevan korkeintaan yksi kappale.
     * 
     * Jos parametri liittyy esimerkiksi merkkijonoon "aB" ja listan tietoalkiot
     * ovat [ "AB, "Ab", "aB", "ab" ], on listan sisältö poiston jälkeen
     * [ "AB, "Ab", "ab" ] ja operaatio palauttaa viitteen alkuperäisen listan
     * kolmanteen tietoalkioon, koska "aB".equals("aB") == true.
     *     
     * @param poistettava viite poistettavaan tietoalkioon, jonka luokan
     * tai luokan esivanhemman oletetaan korvanneen Object-luokan equals-metodin.
     * @return viite poistettuun tietoalkioon. Paluuarvo on null, jos poistettavaa
     * alkiota ei löydy, parametri on null-arvoinen tai lista on tyhjä.
     */
   public abstract Object poista(Object poistettava);
}
