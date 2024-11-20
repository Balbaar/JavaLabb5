# Rekursion

## Uppgift 1
Hitta huvudprogrammet, kör det och bekanta dig med knapparna.
Det ritar inte upp något än.

## Uppgift 2
### Filer att ändra i
- `Koch.java`

Implementera det som saknas i `fractalLine` i `Koch.java`.
Nästan all kod finns i instruktionerna.

## Uppgift 3
### Filer att ändra i
- `FractalApplication.java`
- `Mountain.java` (Skapas)

Du får skriva tester om du vill, och skriva hjälpmetoder.
T ex går både punkten mellan två punkter,
och olika sätt att skapa trianglar,
att skriva test-drivet.
Om du skriver tester kan en `toString()` i `Point` hjälpa med felsökning.


## Uppgift 4
### Filer att ändra i
- `Mountain.java`

"Mittpunkten" avser punkten som delar varje sida i två.

## Uppgift 5
### Filer att ändra i
- `Mountain.java`

Det går att göra lösningar där sidorna behövs fler än två gånger, 
skriv optimeringen som tar bort sidor ur mappen när det behövs. 

Klassen `Sides` behöver en `public int hashCode()`,
kolla på den i `Point`.
Vet du varför?
Den behöver också en lämplig `public boolean equals(Object obj)`.
Minns du varför den måste ta just ett `Object`?
Finns det något annat sätt vi kunde gjort än att använda en egen klass här?