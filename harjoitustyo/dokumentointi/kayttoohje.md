# Käyttöohje

## Ohjelman lataaminen tietokoneelle

Lataa tiedostot [sudoku.jar](https://github.com/henrhaat/otm-harkkatyo/releases/tag/loppupalautus/sudoku.jar) ja [database.db](https://github.com/henrhaat/otm-harkkatyo/releases/tag/loppupalautus/database.db) ja aseta ne samaan hakemistoon.

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla
```
java -jar sudoku.jar
```
## Kirjautuminen

Sovellus käynnistyy kirjautumisnäkymään:

![login](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/kuvat/5.PNG)

Kirjautuminen onnistuu kirjoittamalla olemassaoleva tai uusi käyttäjätunnus syötekenttään ja painamalla _login_.

## Päävalikko
Kirjautumisen jälkeen aukeaa päävalikko:

![menu](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/kuvat/6.PNG)

Päävalikossa on suoritetut tasot vihreällä ja suorittamatta olevat tasot sini-harmaina. Tasoa klikkaamalla pääsee sudokunäkymään.

## Sudokunäkymä

![sudoku](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/kuvat/7.PNG)

Sudokunäkymässä ruutuja voi täyttää alla olevien [pelin sääntöjen](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/kayttoohje.md#pelin-s%C3%A4%C3%A4nn%C3%B6t) mukaisesti. Kun käyttäjä on omasta mielestään valmis, voi hän klikata "Ready"-nappia. Ruudulle ilmestyvä ikkuna kertoo, onko ruudukko täytetty oikein vai ei.

"Reset"-napista voi tyhjentää täytetyt ruudut, jos käyttäjä haluaa aloittaa täysin alusta.

"Main menu"-napista pääsee takaisin päävalikkoon.

"Hint"-nappia painamalla väärin täytetyt ruudut korostetaan punaisella värillä.


## Pelin säännöt

Täytä jokainen solu luvuilla 1-9 siten, että jokaisella pysty- ja vaakarivillä, sekä jokaisella tummempireunaisella 3x3 ruudukolla on kaikki luvut 1-9 tasan kerran. Jokaiseen soluun tulee tasan yksi luku.
