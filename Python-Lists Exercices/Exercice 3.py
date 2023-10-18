#Exercice 3
def compte_m(M,v):
    nbo=0
    nPas=0
    for i in range(len(M)):
        for j in range(len(M[i])):
            if M[i][j]==v:
                nbo+=1
            nPas+=1
    print("Le nombre de pas est: ",nPas)
    return nbo

#Programme principal
M= [[1,2,10],[7,5,6],[8,8,9,10]]
print(compte_m(M,1))
