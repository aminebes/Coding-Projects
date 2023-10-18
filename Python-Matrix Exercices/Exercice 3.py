#Exercice 3
def produit_matrices(m1,m2):
    M=[]
    lignes=len(m1)
    colonnes=len(m2[0])
    for i in range(lignes):
        M.append([])
        for j in range(colonnes):
            k=0
            c=0
            res=0
            while k<len(m1[0]) and c<len(m2):
                res=res+(m1[i][k]*m2[c][j])
                k+=1
                c+=1
            m=M[i]
            m.append(res)
    return M
print(produit_matrices([[1,2,3],[4,5,6]],[[1,2],[3,4],[5,6]]))

                
    
