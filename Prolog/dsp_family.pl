narah(dahyalal).
narah(haribhai).
narah(naranbhai).
narah(manshukhbhai).
narah(nishantbhai).
narah(himanshu).
narah(ashokbhai).
narah(devshibhai).
narah(zaverilal).
narah(darshan).
narah(amrutbhai).
narah(raj).
narah(vishanjibhai).
narah(rajeshbhai).
narah(chirag).
narah(kapilbhai).
narah(kush).
narah(nanjibhai).
narah(rameshbhai).

naari(naanbai).
naari(gomtiben).
naari(narmadaben).
naari(nirmalaben).
naari(bhavnaben).
naari(triveniben).
naari(pratha).
naari(dhruvi).
naari(kankuben).
naari(parvatiben).
naari(hemandri).
naari(ushaben).
naari(ramilaben).
naari(daxaben).
naari(urmilaben).
naari(champaben).
naari(sarojben_r).
naari(sarojben_k).
naari(punamben).
naari(kantaben).
naari(premilaben).

matapitarau(dahyalal,haribhai).
matapitarau(naanbai,haribhai).

matapitarau(dahyalal,naranbhai).
matapitarau(naanbai,naranbhai).

matapitarau(dahyalal,devshibhai).
matapitarau(naanbai,devshibhai).

matapitarau(dahyalal,vishanjibhai).
matapitarau(naanbai,vishanjibhai).

matapitarau(naranbhai,narmadaben).
matapitarau(gomtiben,narmadaben).

matapitarau(naranbhai,nirmalaben).
matapitarau(gomtiben,nirmalaben).

matapitarau(naranbhai,manshukhbhai).
matapitarau(gomtiben,manshukhbhai).

matapitarau(naranbhai,ashokbhai).
matapitarau(gomtiben,ashokbhai).

matapitarau(devshibhai,zaverilal).
matapitarau(kankuben,zaverilal).

matapitarau(nanjibhai,rameshbhai).
matapitarau(kantaben,rameshbhai).

matapitarau(nanjibhai,premilaben).
matapitarau(kantaben,premilaben).

matapitarau(nanjibhai,parvatiben).
matapitarau(kantaben,parvatiben).

matapitarau(devshibhai,ramilaben).
matapitarau(kankuben,ramilaben).

matapitarau(devshibhai,daxaben).
matapitarau(kankuben,daxaben).

matapitarau(devshibhai,urmilaben).
matapitarau(kankuben,urmilaben).

matapitarau(devshibhai,amrutbhai).
matapitarau(kankuben,amrutbhai).

matapitarau(vishanjibhai,rajeshbhai).
matapitarau(champaben,rajeshbhai).

matapitarau(vishanjibhai,kapilbhai).
matapitarau(champaben,kapilbhai).

matapitarau(vishanjibhai,punamben).
matapitarau(champaben,punamben).


matapitarau(manshukhbhai, nishant).
matapitarau(bhavnaben, nishant).

matapitarau(manshukhbhai, himanshu).
matapitarau(bhavnaben, himanshu).

matapitarau(zaverilal, darshan).
matapitarau(parvatiben, darshan).

matapitarau(zaverilal, hemandri).
matapitarau(parvatiben, hemandri).

matapitarau(amrutbhai, raj).
matapitarau(ushaben, raj).

matapitarau(ashokbhai,pratha).
matapitarau(triveniben,pratha).

matapitarau(ashokbhai,dhruvi).
matapitarau(triveniben,dhruvi).

matapitarau(kapilbhai, kush).
matapitarau(sarojben_k, kush).

matapitarau(rajeshbhai, chirag).
matapitarau(sarojben_r, chirag).

janak(Z,D):-matapitarau(Z,D),narah(Z),Z\==D.

janani(P,D):-matapitarau(P,D), naari(P), P\==D.

bhrata(D,H):-janak(Z,D), janak(Z,H), narah(D), D\==H.

bhagini(H,D):-janak(Z,H), janak(Z,D), naari(H), D\==H.

taakshree(A,D):-janak(Z,D), bhrata(A,Z).

pitrubhagini(R,D):-janak(Z,D), bhagini(R,Z).

matul(R,D):-janani(P,D), bhrata(R,P).

matulaa(P,D):-janani(X,D), bhagini(P,X).

pitamah(D,H):-janak(D,Z), janak(Z,H).

pitamahi(K,D):-janani(K,Z), janak(Z,D).

matamah(N,D):-janak(N,P), janani(P,D).

matamahi(K,D):-janani(K,P), janani(P,D).
