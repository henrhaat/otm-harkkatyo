# Sudoku

## Dokumentaatio

[Käyttöohje](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/kayttoohje.md)

[Vaativuusmäärittely](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/vaativuusmaarittely.md)

[Työaikakirjanpito](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/henrhaat/otm-harkkatyo/blob/master/harjoitustyo/dokumentointi/arkkitehtuuri.md)

## Releaset

[Viikko 5](https://github.com/henrhaat/otm-harkkatyo/releases/tag/viikko5)

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

### Javadoc

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

