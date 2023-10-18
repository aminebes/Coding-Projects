#Exercice 1
def verifiechif(l, n):
    '''(list, int) -> bool
    Vérifie si la liste l est comprise chiffres uniquement, n est la taille de la liste
    '''
    if 0<=l[n-1]<=9 :
       if  n == 1 :
            chiffre = True
       else:
            chiffre = verifiechif(l, n-1)
    else:
       chiffre = False

    return chiffre


print(verifiechif([1,1,3,4,5,6,7,5,9,1],10))
print(verifiechif([1,1,3,4,7,5,100],7))


