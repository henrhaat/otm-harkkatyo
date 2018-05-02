# Sudoku

Sovelluksella voi pelata sudokua. Sudoku on logiikkapeli, jossa tehtävänä on täyttää neliönmuotoinen ruudukko merkeillä niin että jokaisella vaakarivillä ja pystyrivillä sekä jokaisessa osaneliössä käytetään samaa merkkiä tasan yhden kerran. Ruudukossa on aluksi valmiina jo muutama merkki. Kaikissa sovelluksen viidessä eri sudokussa on 9 × 9 -ruudukko, jotka ovat jaettu yhdeksään 3 × 3 ruudun osaneliöön, ja merkkeinä käytetään numeroita 1–9.

## Dokumentaatio

[Käyttöohje](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/kayttoohje.md)

[Vaativuusmäärittely](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/vaativuusmaarittely.md)

[Työaikakirjanpito](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/arkkitehtuuri.md)

## Releaset

[Viikko 5](https://github.com/henrhaat/otm-harkkatyo/releases/tag/viikko5)
[Viikko 6](https://github.com/henrhaat/otm-harkkatyo/releases/tag/viikko6)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan hakemistossa *harjoitustyo* komennolla

```
mvn test 
```

Testikattavuusraportti suoritetaan hakemistossa *harjoitustyo* komennolla

```
mvn test jacoco:report 
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto *target/site/jacoco/index.html*

### Suoritettavan jarin generointi

Hakemistossa *harjoitustyo* komento

```
mvn package 
```

generoi hakemistoon *target*  suoritettavan jar-tiedoston *Sudoku-1.0-SNAPSHOT.jar*

### JavaDoc

JavaDoc generoidaan hakemistossa *harjoitustyo* komennolla

```
mvn javadoc:javadoc 
```

JavaDocia voi tarkastella avaamalla selaimella tiedoston *target/site/apidocs/index.html* 

### Checkstyle

Tiedoston [checkstyle.xml](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/checkstyle.xml) määrittelemät tarkistukset suoritetaan hakemistossa *harjoitustyo* komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto *target/site/checkstyle.html*

