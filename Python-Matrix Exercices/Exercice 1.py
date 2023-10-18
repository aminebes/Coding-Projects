#Exercice 1
def transpose():
    l = int(input("Entrez le nombre de rangées: "))
    m = []
    i = 0
    while (i < l):
        print("Entrez la rangée "+str(i+1)+" (les entiers separés par des espaces)")
        rangee = [int(val) for val in input().split()]
        m.append(rangee)
        i = i + 1
    M=[]
    taille=len(m[0])
    for i in range(0,taille):
        k=[]
        for j in range(0,len(m)):
            k.append(m[j][i])
        M.append(k)
    return M

print(transpose())


    
