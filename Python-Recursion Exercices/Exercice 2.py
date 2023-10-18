#Exercice 2
def creerliste(l, n):
    '''(list, int) -> list
    Crée une liste ayant comme éléments tous les nombres de 0 à n-1.
    '''
    if n>0:
        l=creerliste(l,n-1)
        l.append(n-1)
    return l

#Programme principal
n=int(input("Veuillez saisir n: "))
l=[]
print(creerliste(l,n))

