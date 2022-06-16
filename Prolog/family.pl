male(valjibhai).
male(muljibhai).
male(arjanbhai).
male(ravjibhai).
male(naranbhai).
male(vijay).
male(vivek).


female(amratben).
female(kantaben).
female(amrutben).
female(premilaben).
female(jasuben).


parent(valjibhai,muljibhai).
parent(amratben,muljibhai).

parent(muljibhai,naranbhai).
parent(kantaben,naranbhai).

parent(muljibhai,ravjibhai).
parent(kantaben,ravjibhai).

parent(arjanbhai,premilaben).
parent(amrutben,premilaben).

parent(arjanbhai,jasuben).
parent(amrutben,jasuben).

parent(ravjibhai,vijay).
parent(premilaben,vijay).


parent(ravjibhai,vivek).
parent(premilaben,vivek).

pitashree(X,Y):-parent(X,Y),male(X).
matashree(X,Y):-parent(X,Y),female(X).

bhrata(X,Y):-parent(Z,X),parent(Z,Y),male(X),X\==Y.
bhagini(X,Y):-parent(Z,X),parent(Z,Y),female(X),X\==Y.

takshree(X,Y):-father(Z,Y),bhrata(Z,X),male(X).
