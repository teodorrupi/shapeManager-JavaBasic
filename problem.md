#Java Inheritance, Polymorphism, and Abstract Classes
___

##Problem Statement

Ne nje siperfaqe me madhesi 25x80 duhet te menaxhohen drejtkendesha, katrore si edhe „rruge“ (Mund te perkthehet edhe „linja“ apo „zgjatime“) 
horizontale apo vertikale. 

```Kjo sjell idene se na duhen klasat Line(Linja) | Rectangle(Drejtkendeshat) | Square(Katrore)```

Te gjitha keto objekte kane per pozition nje numer te plote (dmth jo me presje),
 
```Nese e kam kuptuar ne rregull, kjo do te thote qe cdo element do kete koordinata me numra te plote???```

```Per shembull: Linja do ket si pozicion 2 pika me koordinata, katrori dhe drejtkendeshi do kene 4 pika secili```

mund te zhvendosen dhe atyre u eshte percaktuar nje shenje per vizatimin e konturit (e kufijve).
 
```Kjo pjese na trego se duhet te kemi nje metode qe merr nje shape dhe e zhvendos, nese pozicioni nuk eshte i zene ose 
 jasht kufijve```
 
```Gjithashtu do kemi dhe nje parameter per te vizatuar konture apo jo???``` 

Per drejkendesha dhe katrore mund te specifikohet nese duhet te mbushen. Per mbushjen do te perdoret nje tjeter shenje, qe mund te jepet 
per cdo drejtkendesh dhe katror vec e vec. 

```Kjo pjese na trego se per Rectangle dhe Square duhet te kemi fusha per te vendosur nese duhet mbushje apo jo, dhe ngjyra??? e mbushjes
se figures```

a) hartoni dhe zbatoni nje hierarki klasash f per drejkendesha, kuadrate dhe „linja“. Parashikoni per kete Oberklassen te pergjithshme.

Si pjese e hierarkise kemi klasen Area2D qe inicializon siperfaqen qe do menaxhojme, si dhe superklasen Shape.
Superklasa Shape ka si nenklasa Rectangle, Square dhe Line. 
Klasa Main eshte TestProgram qe do te menaxhoje inicializimin e siperfaqes 2D si dhe gjithe veprimet e nevojshme.

b) Shkruani nje Testprogram per menaxhimin dhe paraqitjen per drejkendesha, kuandrate dhe „linja“. Me kete testprogramm duhet te 
jete e mundur te krijohen drejkendesha, kuandrate dhe „linja“, te zhvendosen, te ndryshohen karakteristikat e tyre dhe 
objektet te perfshihen ne siperfaqen me madhesi 25x80

```Cdo te thote PARAQITJEN E Drejkendeshave, Kuadrateve dhe Linjave???```