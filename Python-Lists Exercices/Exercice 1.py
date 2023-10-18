#Exercice 1
def cherche(l,v):
    test=False
    i=0
    while i<len(l) and test==False:
        if l[i]==v:
            test=True
        i+=1
    if test==False:
        return False
    else:
        print("Le nombre de pas est:",i)
        return True

#Programme principal
import random
N=int(input("Veuillez saisir la taille de la liste: "))
l = []
for i in range(N):
    v = random.randrange(1,N+1)
    l.append(v)
print(l)
print(cherche(l,50))
