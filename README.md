# Työntekijäntietojen tallennusohjelma

## Tarkoitus ja käyttöliittymä

Tässä on simppeli työntekijäntietojen tallennusohjelma, joka on luotu JavaFX:lla.
Käyttöliittymässä on valintalaatikko, mistä voi valita japanin, persian tai englannin kielen käyttökieleksi.
Ohjelmassa on kolme tekstikenttää mihin käyttäjän tulee kirjoittaa etunimi, sukunimi ja sähköposti.
Kun käyttäjä on kirjoittanut kenttiin oikeat tiedot, tallenna painike lähettää tiedot tietokantaan.
Jos jokin laatikko jää täyttämättä, tai sähköpostista puuttuu @-merkki, tietokantaan ei lähde tietoa.

## Tietokanta
Jos ohjelmaa haluaa testata, tulee MariaDbConnection-luokasta vaihtaa tietokantaosoite.

## Lokalisointi
Käyttöliittymä on lokalisoitu Javan ResourceBundlella.

## Käyttöönotto/Testaus
Ohjelma käynnistyy kun suoritat Main-luokan. (Muista muuttaa tietokantaosoite haluamaksesi osoitteeksi, muuten ohjelma ei toimi.)


