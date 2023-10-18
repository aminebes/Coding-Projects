#Partie 1

#Question 1
def compte100(liste):
    ''' Contrat de type: (list) -> int ''' 
    n=0
    for val in liste:
        if val>100:
            n+=1
    return n

#Question 2
def sommeListeDiv2(liste):
    ''' Contrat de type: (list) -> int '''
    n=0
    for val in liste:
        if val%2==0:
            n+=val
    return n

#Question 3
def triples(ch):
    ''' Contrat de type: (str) -> bool '''
    res=False
    i=0
    while res==False and i<(len(ch)-2):
        if ch[i]==ch[i+1] and ch[i]==ch[i+2]:
            res=True
        else:
            i+=1
    return res

#Question 4
def momo(ch):
    ''' Contrat de type: (str) -> str '''
    res=""
    for i in range(len(ch)):
        n=0
        if ch[i] not in res[len(res)-2:len(res)-1]:
            for j in range(i,len(ch)):
                if ch[i]==ch[j]:
                    n+=1
                else:
                    break
            res+=ch[i]+str(n)
    return res

                
            
        
    


        

    
