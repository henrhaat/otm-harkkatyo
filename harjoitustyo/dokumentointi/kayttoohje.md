# Käyttöohje

## Ohjelman lataaminen tietokoneelle

Lataa *otm-harkkatyo-master.zip* [tältä sivulta](https://github.com/henrhaat/otm-harkkatyo) oikeasta reunasta vihreästä napista `Clone or download` ja painamalla `Download ZIP.`

Pura lataamasi tiedosto tietokoneellasi tyhjään hakemistoon.

## Ohjelman käynnistäminen

Mene hakemistoon, mihin purit *otm-harkkatyo-master.zip* tiedoston ja mene alihakemistoon *harjoitustyo*. Suorita komentorivillä komento
```
mvn compile exec:java -Dexec.mainClass=sudoku.ui.SudokuUi
```
Sovellus käynnistyy kirjautumisnäkymään, jossa voit kirjautua sisään valitsemallasi käyttäjätunnuksella. Kirjauduttuasi sisään avautuu päävalikko, jossa on napit 1-5. Painamalla nappeja pääset viiteen eri sudokuun, joita voit yrittää ratkaista pelin sääntöjen mukaisesti. Kun olet omasta mielestäsi valmis jonkin sudokun kanssa, paina "Ready"-nappia. Jos sudoku on täytetty oikein, niin saat onnitteluikkunan ja voit siirtyä takaisin päävalikkoon painamalla "Main menu"-nappia ja voit yrittää seuraavaa sudokua.

## Pelin säännöt

Täytä jokainen solu luvuilla 1-9 siten, että jokaisella pysty- ja vaakarivillä, sekä jokaisella tummempireunaisella 3x3 ruudukolla on kaikki luvut 1-9 tasan kerran. Jokaiseen soluun tulee tasan yksi luku.
