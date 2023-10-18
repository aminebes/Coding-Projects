#Exercice 2
def somme_matrices(m1,m2):
    M=[]
    taille=len(m1[0])
    for i in range(len(m1)):
        m=[]
        for j in range(taille):
            m.append(m1[i][j]+m2[i][j])
        M.append(m)
    return M


