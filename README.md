# Sudoku

## Dokumentaatio

[Vaativuusmäärittely](https://github.com/henrhaat/otm-harkkatyo/blob/master/dokumentointi/vaativuusmaarittely.md)

[Työaikakirjanpito](https://github.com/henrhaat/otm-harkkatyo/blob/master/dokumentointi/tuntikirjanpito.md)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan hakemistossa *harjoitustyo* komennolla

``` mvn test ```

Testikattavuusraportti suoritetaan hakemistossa *harjoitustyo* komennolla

``` mvn test jacoco:report ```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto *target/site/jacoco/index.html*

### Suoritettavan jarin generointi

Hakemistossa *harjoitustyo* komento

``` mvn package ```

generoi hakemistoon *target*  suoritettavan jar-tiedoston *Sudoku-1.0-SNAPSHOT.jar*

### Javadoc

JavaDoc generoidaan hakemistossa *harjoitustyo* komennolla

``` mvn javadoc:javadoc ```

JavaDocia voi tarkastella avaamalla selaimella tiedoston *target/site/apidocs/index.html* 

