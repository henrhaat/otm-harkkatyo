# Vaativuusmäärittely

## Sovelluksen tarkoitus

Sovellus tulee olemaan Sudoku-peli, jossa on muutamia tasoja helposta vaikeaan

## Toiminnallisuus

* Käyttäjä kirjautuu sovellukseen valitsemallaan käyttäjätunnuksella
  * Käyttäjätunnuksen pitää olla pituudeltaan vähintään kolme merkkiä
  * Jos käyttäjätunnus on jo olemassa, kirjautuu käyttäjä sille tunnukselle
  * Jos käyttäjätunnusta ei ole vielä olemassa, syntyy uusi käyttäjätunnus ja käyttäjä kirjautuu sille
* Käyttjänä näkee valikossa viisi tasoa joita käyttäjä voi klikata valitsemassaan järjestyksessä
  * Käyttäjän edellisiltä pelaamiskerroilta jo oikein täytetyt tasot näkyvät vihreänä, muut sini-harmaana.
  * Tasot ovat osin valmiiksi täytettyjä sudoku-taulukoita, jotka käyttäjä täyttää loppuun
  
  
### Tason valitsemisen jälkeen
* Käyttäjä voi täyttää sudokua valisemillaan numeroilla
* Käyttäjä voi palauttaa sudokun alkuperäiseksi klikkaamalla "Reset"-nappia
  * Tämä pitää vahvistaa uudestaan uudessa "Oletko varma"-ikkunassa
* Käyttäjä klikkaa "Ready"-nappia, kun on mielestään täyttänyt sudokun oikein
  * Jos sudoku on täytetty oikein, sovellus näyttää onnitteluikkunan ja valikossa kyseisen sudokun nappi muuttuu vihreäksi
  * Jos sudoku on täytetty väärin, sovellus näyttää siihen liittyvän ikkunan ja käyttäjä voi jatkaa yrittämistä
* Käyttäjä voi klikata "Hint"-nappia, jolloin sudokun väärin täytetyt solut muuttuvat punaisiksi
* Käyttäjä voi palata takaisin valikkoon klikkaamalla "Main menu"-nappia

