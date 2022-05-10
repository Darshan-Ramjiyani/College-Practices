male(Valjibhai).
male(Muljibhai).
male(Arjanbhai).
male(Ravjibhai).
male(Naranbhai).
male(Vijay).
male(Vivek).


female(Amratben).
female(Kantaben).
female(Amrutben).
female(Premilaben).
female(Jasuben).


parent(Valjibhai,Muljibhai).
parent(Amratben,Muljibhai).

parent(Muljibhai,Naranbhai).
parent(Kantaben,Naranbhai).

parent(Muljibhai,Ravjibhai).
parent(Kantaben,Ravjibhai).

parent(Arjanbhai,Premilaben).
parent(Amrutben,Premilaben).

parent(Arjanbhai,Jasuben).
parent(Amrutben,Jasuben).

parent(Ravjibhai,Vijay).
parent(Premilaben,Vijay).


parent(Ravjibhai,Vivek).
parent(Premilaben,Vivek).

father(X,Y):-parent(X,Y),male(X).
mother(X,Y):-parent(X,Y),female(X).

bhrata(X,Y):-parent(Z,X),parent(Z,Y),male(X),X\==Y.
bhagini(X,Y):-parent(Z,X),parent(Z,Y),female(X),X\==Y.

takshree(X,Y):-father(Z,Y),bhrata(Z,X),male(X).
