1. Per què s'atura l'execució al cap d'un temps?

Perque quan no hi han places disponibles, els assistents que volen fer reserves es queden esperant. Eventualment, els que si tenen plaça, si intenten fer una altra reserva es queden esperant també i ja no la poden cancelar, deixant així a tots esperant.

---

2. Què passaria si en lloc de una probabilitat de 50%-50% fora de 70%(ferReserva)-30%(cancel·lar)? I si foren al revés les probabilitats? -> Mostra la porció de codi modificada i la sortida resultant en cada un dels 2 casos

### Cas 1:  70%(ferReserva)-30%(cancel·lar)

![imagen1](/img/Captura1.png)

```
Assistent-0 ha fet una reserva. Places disponibles: 4
Assistent-3 ha fet una reserva. Places disponibles: 3
Assistent-2 ha fet una reserva. Places disponibles: 2
Assistent-8 ha fet una reserva. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
```

El que passa amb una probablitat de 70%(ferReserva)-30%(cancel·lar) és que els assistents tenen més probabilitat de fer reserva i de quedar-se esperant, per tant, tarda menys en aturar-se l'execució.

### Cas 2:  30%(ferReserva)-70%(cancel·lar)

![imagen2](/img/Captura2.png)

```
Assistent-0 ha fet una reserva. Places disponibles: 4
Assistent-4 ha fet una reserva. Places disponibles: 3
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-5 ha fet una reserva. Places disponibles: 2
Assistent-3 ha fet una reserva. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 ha cancel·lat una reserva. Places disponibles: 2
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-9 ha fet una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
```

En aquest cas l'execució tarda més en aturar-se, ja que els assistents tenen més probabilitat de cancel·lar que de fer reserva, per tant, tardan més en quedar-se esperant per a fer la reserva.

---

3. Perquè creus que fa falta la llista i no valdria només amb una variable sencera de reserves?

Per a poder comprovar qui té reserva i qui no, de forma que algú que no tingui reserva no pugui cancel·lar.