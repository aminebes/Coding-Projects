# Jeu de cartes appelé "Pouilleux" 

# L'ordinateur est le donneur des cartes.

# Une carte est une chaine de 2 caractères. 
# Le premier caractère représente une valeur et le deuxième une couleur.
# Les valeurs sont des caractères comme '2','3','4','5','6','7','8','9','10','J','Q','K', et 'A'.
# Les couleurs sont des caractères comme : ♠, ♡, ♣, et ♢.
# On utilise 4 symboles Unicode pour représenter les 4 couleurs: pique, coeur, trèfle et carreau.
# Pour les cartes de 10 on utilise 3 caractères, parce que la valeur '10' utilise deux caractères.

import random

def attend_le_joueur():
    '''()->None
    Pause le programme jusqu'au l'usager appui Enter
    '''
    try:
         input("Appuyez Enter pour continuer. ")
    except SyntaxError:
         pass


def prepare_paquet():
    '''()->list of str
        Retourne une liste des chaines de caractères qui représente tous les cartes,
        sauf le valet noir.
    '''
    paquet=[]
    couleurs = ['\u2660', '\u2661', '\u2662', '\u2663']
    valeurs = ['2','3','4','5','6','7','8','9','10','J','Q','K','A']
    for val in valeurs:
        for couleur in couleurs:
            paquet.append(val+couleur)
    paquet.remove('J\u2663') # élimine le valet noir (le valet de trèfle)
    return paquet

def melange_paquet(p):
    '''(list of str)->None
       Melange la liste des chaines des caractères qui représente le paquet des cartes    
    '''
    random.shuffle(p)

def donne_cartes(p):
     '''(list of str)-> tuple of (list of str,list of str)

     Retournes deux listes qui représentent les deux mains des cartes.  
     Le donneur donne une carte à l'autre joueur, une à lui-même,
     et ça continue jusqu'à la fin du paquet p.
     '''
     
     donneur=[]
     autre=[]

     # COMPLETEZ CETTE FONCTION EN CONFORMITE AVEC LA DESCRIPTION CI-DESSUS
     # AJOUTEZ VOTRE CODE ICI
     
     i=0
     for carte in p:
         if i%2==0:
             autre.append(carte)
         else:
             donneur.append(carte)
         i+=1
     
     return (donneur, autre)

#Fonction ajoutée 1 (paires) appelée dans la fonction indexpaires:
def paires(c1,c2):
    if c1[0]==c2[0] and c1[0]=="1":
        return True
    elif (c1[0]==c2[0]):
        return True
    else:
        return False

#Fonction ajoutée 2 (indexpaires) appelée dans la fonction elimine_paires:
def indexpaires(l):
    for i in range(len(l)-1):
        for j in range(i+1,len(l)):
            if paires(l[i],l[j]):
                return (i,j)
                break
        
    
def elimine_paires(l):
    '''
     (list of str)->list of str

     Retourne une copy de la liste l avec tous les paires éliminées 
     et mélange les éléments qui restent.

     Test:
     (Notez que l’ordre des éléments dans le résultat pourrait être différent)
     
     >>> elimine_paires(['9♠', '5♠', 'K♢', 'A♣', 'K♣', 'K♡', '2♠', 'Q♠', 'K♠', 'Q♢', 'J♠', 'A♡', '4♣', '5♣', '7♡', 'A♠', '10♣', 'Q♡', '8♡', '9♢', '10♢', 'J♡', '10♡', 'J♣', '3♡'])
     ['10♣', '2♠', '3♡', '4♣', '7♡', '8♡', 'A♣', 'J♣', 'Q♢']
     >>> elimine_paires(['10♣', '2♣', '5♢', '6♣', '9♣', 'A♢', '10♢'])
     ['2♣', '5♢', '6♣', '9♣', 'A♢']
    '''

    resultat=[]

    # COMPLETEZ CETTE FONCTION EN CONFORMITE AVEC LA DESCRIPTION CI-DESSUS
    # AJOUTEZ VOTRE CODE ICI

    while indexpaires(l)!= None:
        index=indexpaires(l)
        l.remove(l[index[0]])
        l.remove(l[index[1]-1])
        
    resultat=l
    random.shuffle(resultat)
    return resultat


def affiche_cartes(p):
    '''
    (list)-None
    Affiche les éléments de la liste p séparées par d'espaces
    '''


    # COMPLETEZ CETTE FONCTION EN CONFORMITE AVEC LA DESCRIPTION CI-DESSUS
    # AJOUTEZ VOTRE CODE ICI
    for cartes in p:
        print(cartes,end=' ')
    

def entrez_position_valide(n):
     '''
     (int)->int
     Retourne un entier du clavier, de 1 à n (1 et n inclus).
     Continue à demander si l'usager entre un entier qui n'est pas dans l'intervalle [1,n]
     
     Précondition: n>=1
     '''

     # COMPLETEZ CETTE FONCTION EN CONFORMITE AVEC LA DESCRIPTION CI-DESSUS
     # AJOUTEZ VOTRE CODE ICI
     entier=int(input("Veuillez donner un entier de 1 à "+str(n)+" : "))
     while not (entier in range(1,n+1)):
         entier=int(input("Veuillez donner un entier valide de 1 à "+str(n)+" : "))
     return entier

def joue():
     '''()->None
     Cette fonction joue le jeu'''
    
     p=prepare_paquet()
     melange_paquet(p)
     tmp=donne_cartes(p)
     donneur=tmp[0]
     humain=tmp[1]

     print("Bonjour. Je m'appelle Robot et je distribue les cartes.")
     print("Votre main est:")
     affiche_cartes(humain)
     print('\n'+"Ne vous inquiétez pas, je ne peux pas voir vos cartes ni leur ordre.")
     print("Maintenant défaussez toutes les paires de votre main. Je vais le faire moi aussi.")
     attend_le_joueur()
     
     donneur=elimine_paires(donneur)
     humain=elimine_paires(humain)

     # COMPLETEZ CETTE FONCTION EN CONFORMITE AVEC LA DESCRIPTION CI-DESSUS
     # AJOUTEZ VOTRE CODE ICI
     while donneur!=[] and humain!=[]:
         print("***********************************************************")
         print("Votre tour.")
         print("Votre main de cartes est:")
         affiche_cartes(humain)
         nbcartes=str(len(donneur))
         print('\n'+"J'ai "+nbcartes+" cartes. Si 1 est la position de ma première carte et "+nbcartes+" la position de ma dernière carte, laquelle de mes cartes voulez-vous?")
         poscarte=entrez_position_valide(len(donneur))
         if poscarte==1:
             print("Vous avez demandé ma 1ère carte.")
         else:
             print("Vous avez demandé ma "+str(poscarte)+"ème carte.")
         carteajoute=donneur[poscarte-1]
         donneur.remove(carteajoute)
         print("La voilà. C'est un "+carteajoute)
         humain.append(carteajoute)
         print("Avec "+carteajoute+" ajouté, votre main est:")
         affiche_cartes(humain)
         humain=elimine_paires(humain)
         melange_paquet(humain)
         print('\n'+"Après avoir défaussé toutes les paires et mélangé les cartes, votre main est:")
         affiche_cartes(humain)
         print('\n')
         attend_le_joueur()
         if donneur!=[] and humain!=[]:
             print("***********************************************************")
             print("Mon tour.")
             rdmcarte=random.randint(1,len(humain))
             carte=humain[rdmcarte-1]
             humain.remove(carte)
             donneur.append(carte)
             if rdmcarte==1:
                 print("J'ai pris votre 1ère carte.")
             else:
                 print("J'ai pris votre "+str(rdmcarte)+"ème carte.")
             donneur=elimine_paires(donneur)
             melange_paquet(donneur)
             attend_le_joueur()
     if donneur==[]:
        print("J'ai terminé toutes les cartes."+'\n'+"Vous avez perdu! Moi, Robot, j'ai gagné.")
     elif humain==[]:
        print("Vous avez terminé toutes les cartes."+'\n'+"Félicitations! Vous, Humain, vous avez gagné.")
        
        
             
         

	 
# programme principale
joue()

