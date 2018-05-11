# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

![pakkaukset](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/kuvat/1.png)

Pakkaus _sudoku.ui_ sisältää Swing:llä toteutetun käyttöliittymän. Pakkaus _sudoku.domain_ sisältää sovelluslogiikan ja pakkaus _sudoku.dao_ vastaa tietojen pysyväistallennuksesta.

Ohjelman luokkien suhdetta kuvaava luokkakaavio:

![luokkakaavio](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/kuvat/2.png)

## Päätoiminnallisuudet

### Ensimmäisen sudokun luominen

![sekvenssi1](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/kuvat/3.png)

## Käyttöliittymä

Käyttöliittymä sisältää kolme erillistä päänäkymää:
* kirjautuminen
* päävalikko
* sudoku-näkymä

Käyttöliittymä on rakennettu [sudoku.ui.SudokuUi](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/src/main/java/sudoku/ui/SudokuUi.java) luokassa.

## Tietojen pysyväistallennus

Pakkauksen sudoku.dao luokka _SudokuDao_ huolehtii tietojen tallentamisesta tiedostoon _database.db_.

Tiedostoon tallennetaan käyttäjänimet ja kyseisten käyttäjänimien suorittamat sudokut.
