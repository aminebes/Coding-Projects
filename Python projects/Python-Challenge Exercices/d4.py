#Question 1
def transl(d,t):
    ''' Contrat de type: (dict,str) -> str
    La fonction transl retourne la traduction de la chaine t soit en francais soit en anglais
    '''
    if t in d.keys():
        return d[t] #Si t est en francais, la fonction transl retourne la traduction en anglais
    elif t in d.values():
        for key in d.keys():
            if d[key]==t:
                return key #Si t est en anglais, la fonction transl retourne la traduction en francais
    else:
        return "Unknown"

#Programme principal
d = {"apple":"pomme", "banana":"banane", "pear": "poire", "plum":"prune"}

#Question 2
def setOp(liste1,liste2):
    ''' Contrat de type: (list,list) -> set
    La fonction setOp retourne un set avec tous les éléments de deux listes sans répétitions
    '''
    #Transformation des listes en sets
    set1=set(liste1)
    set2=set(liste2)
    #Union des deux sets
    resultat = set1.union(set2)
    return resultat

#Question 3
def matrixMinMax(m):
    ''' Contrat de type: (list) -> tuple (C'est une matrice mais en python son type est toujours une liste)
    La fonction matrixMinMax retourne un tuple qui contient le minimum et le maximum d'une matrice (Liste 2D)
    '''
    #Initialisation
    maximum=m[0][0]
    minimum=m[0][0]
    for liste in m:
        for elem in liste:
            if elem<minimum: #Recherche du minimum
                minimum=elem
            if elem>maximum: #Recherche du maximum
                maximum=elem
    return (minimum,maximum) #Tuple qui contient les résultats: le minimum et le maximum



