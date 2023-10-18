#Question 1: Création de la fonction patinage qui prends comme données l'épaisseur de la platforme de patinage (Glace) et la température moyenne (°C) et retourne si le canal est couvert ou non.
def patinage(ep,temp):
    ''' Contrat de type: (float, float) -> bool '''
    if (ep>=30) and (temp<=-10):
        return True
    else:
        return False
    
#Question 2: Création de la fonction alphaNote qui retourne la note alphabétique à partir de la note numérique.
def alphaNote(note):
    ''' Contrat de type: (float) -> str '''
    notealpha=""
    if 90<=note<=100:
        notealpha= "A+"
    elif 85<=note<90:
        notealpha= "A"
    elif 80<=note<85:
        notealpha= "A-"
    elif 75<=note<80:
        notealpha= "B+"
    elif 70<=note<75:
        notealpha= "B"
    elif 65<=note<70:
        notealpha= "C+"
    elif 60<=note<65:
        notealpha= "C"
    elif 55<=note<60:
        notealpha= "D+"
    elif 50<=note<55:
        notealpha= "D"
    elif 40<=note<50:
        notealpha= "E"
    elif 0<=note<40:
        notealpha= "F"

    return notealpha

#Question 3: Création de la fonction alphaNoteVerif qui retourne si un élève réussit ou échoue à partir de sa note.
def alphaNoteVerif():
    ''' Contrat de type: () -> None '''
    note=float(input("Veuillez introduire la note numérique (de 0 a 100):"))
    while not(0<=note<=100):
        note=float(input("Erreur! Veuillez réintroduire la note numérique (de 0 a 100):"))
    notealpha= alphaNote(note)
    res=""
    if notealpha in ["A+","A","A-","B+","B","C+","C","D+","D"]:
        res="Réussi"
    else:
        res="Echoue"

    print("Note: "+notealpha+" : "+res)

#Question 4: Création de la fonction boucles qui retourne chaque deuxième valeur d'un entier n.
def boucles(n):
    ''' Contrat de type: (int) -> None '''
    res1=""
    i=1
    while i<=n :
        res1=res1+str(i)+" "
        i=i+2
    res2=""
    j=n
    while j>=1 :
        res2=res2+str(j)+" "
        j=j-2
    res1=res1[0:(len(res1)-1)]
    res2=res2[0:(len(res2)-1)]    
    print(res1+'\n'+res2)

#Question 5: Création de la fonction facteursDeN qui imprime les facteurs d'un entier et vérifie si la somme des facteurs est supérieure ou inférieure à ce nombre.
def facteursDeN(n):
    ''' Contrat de type: (int) -> bool '''
    somme=0
    res=""
    i=2
    while i<n:
        if n%i==0:
            res=res+str(i)+" "
            somme=somme+i
            i=i+1
        else:
            i=i+1
    ok= (n>somme)       
    print("Facteurs de",n,": "+res,'\n'+"Somme des Facteurs:",somme)
    return ok

#Question 6: Création de la fonction carreParfait qui retourne si un nombre est un carré parfait ou pas.
from math import sqrt
def carreParfait(n):
    ''' Contrat de type: (int) -> bool '''
    racinen=sqrt(n)
    if racinen==int(racinen):
        print(n,"est un carré parfait et sa racine carrée est:",int(racinen))
        return True
    else:
        print(n,"n'est pas un carré parfait.")
        return False
        


    

            
    
    
    

        
    




        
    

    
