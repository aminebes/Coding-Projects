#Exercice 3
def pgcd(n, m):
    '''(int, int) -> int
    Retourne le pgcd des deux entiers n et m.
    '''
    if n>=m and n%m==0:
        res=m
    else:
        res=pgcd(m,n%m)
    return res

#Programme principal
print(pgcd(1234,4321))
print(pgcd(8192,192))
print(pgcd(3,3))

