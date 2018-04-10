# Käyttöohje

## Ohjelman lataaminen tietokoneelle

Lataa *otm-harkkatyo-master.zip* [tältä sivulta](https://github.com/henrhaat/otm-harkkatyo) oikeasta reunasta vihreästä napista `Clone or download` ja painamalla `Download ZIP.`

Pura lataamasi tiedosto tietokoneellasi tyhjään hakemistoon.

## Ohjelman käynnistäminen

Mene hakemistoon, mihin purit *otm-harkkatyo-master.zip* tiedoston ja mene alihakemistoon *harjoitustyo*. Suorita komentorivillä komento
```
mvn compile exec:java -Dexec.mainClass=sudoku.ui.SudokuUi
```
Sovellus käynnistyy sudokunäkymään, jossa voit pelata sudokua.

## Pelin säännöt

Täytä jokainen solu luvuilla 1-9 siten, että jokaisella pysty- ja vaakarivillä, sekä jokaisella tummempireunaisella 3x3 ruudukolla on kaikki luvut 1-9 tasan kerran. Jokaiseen soluun tulee tasan yksi luku.
