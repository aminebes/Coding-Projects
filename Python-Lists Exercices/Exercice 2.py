#Exercice 2
def cherche_m(M,v):
    i=0
    test=False
    nbpas=0
    while i<len(M) and test==False:
        j=0
        while j<len(M[i]) and test==False:
            if M[i][j]==v:
                test=True
            j+=1
        nbpas+=j
        i+=1

    if test==True:
        print("Le nombre de pas est: ",nbpas)
        return True
    else:
        return False

#Programmme principal
M = [[1,2,10],[7,5,6], [8,8,9,10]]
print(cherche_m(M,5))
        
    
