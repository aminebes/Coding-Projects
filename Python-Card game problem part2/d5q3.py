# Jeu de cartes appelé "Pouilleux" 

import random


#Q3
class Carte:
    '''represente une carte a jouer'''

    def __init__(self, valeur, couleur):
        '''(Carte,str,str)->None        
        initialise la valeur et la couleur de la carte'''
        self.valeur = valeur
        self.couleur = couleur  # pique, coeur, trefle ou carreau

    def __repr__(self):
        '''(Carte)->str
        retourne une representation de l'objet de class Carte'''
        return 'Carte('+self.valeur+', '+self.couleur+')'

    def __eq__(self, autre):
        '''(Carte,Carte)->bool
        self == autre si la valeur et la couleur sont les memes'''
        return self.valeur == autre.valeur and self.couleur == autre.couleur

    def __lt__(self, autre):
        '''(Carte,Carte)->bool
        self < autre si la valeur de self est inferieure a la valeur de l'objet autre'''
        return self.valeur < autre.valeur 
    
class JeuDeCartes:
    '''represente une jeu de 52 cartes'''
    # valeurs et couleurs sont des variables de classe
    valeurs = ['2','3','4','5','6','7','8','9','10','J','Q','K','A']
    couleurs = ['\u2660', '\u2661', '\u2662', '\u2663']
    # couleurs est un set de 4 symboles Unicode qui representent les 4 couleurs
    # pique, coeur, trefle ou carreau
    
    def __init__(self):
        '''
        (JeudeCartes)->None    
        constructeur qui initialise le paquet de 52 cartes
        '''
        self.paquet = []          # paquet vide au debut
        for couleur in JeuDeCartes.couleurs: 
            for valeur in JeuDeCartes.valeurs: # variables de classe
                if valeur == 'J' and couleur == '\u2663': # pas le valet noir (le valet de trèfle)
                 pass
                else: 
                 # ajoute une Carte de valeur et couleur
                 self.paquet.append(Carte(valeur,couleur))
        
    def attend_le_joueur(self):
        '''(JeuDeCartes)->None
        Pause le programme jusqu'au l'usager appui Enter
        '''
        try:
         input("Appuyez Enter pour continuer. ")
        except SyntaxError:
         pass

    def melange_paquet(self):
        '''(JeuDeCartes)->None
        Mélange la liste des chaines des caractères qui représente le paquet des cartes    
        '''
        random.shuffle(self.paquet)

    def __repr__(self):
        '''(JeuDeCartes)->str
        retourne une representation de l'objet JeuDeCartes'''
        return 'Paquet('+str(self.paquet)+')'

    def __eq__(self, autre):
        '''
        (JeudeCartes,JeuDeCartes)->bool
        retourne True si les paquets ont les meme cartes
        dans la meme ordre'''
        return self.paquet == autre.paquet

    def entrez_position_valide(self, n):
     '''
     (JeuDeCartes,int)->int
     Retourne un entier du clavier, de 1 à n (1 et n inclus).
     Continue a demander si l'usager entre un entier qui n'est pas dans l'interval [1,n]
     
     Precondition: n>=1
     '''
     print("J'ai", n, "cartes. Si 1 est la position de ma première carte et")
     print(n, "est la position de ma dernière carte, laquelle de mes cartes vous voulez?")
     position=int(input("SVP entrer un entier de 1 à "+str(n)+": ").strip())
     
     while not(position>=1 and position <=n):
          position=int(input("Position invalide. SVP enter un entier de 1 à "+str(n)+": ").strip())
     return position

    def donne_cartes(self):
     '''(JeuDeCartes)-> tuple of (list of Carte,list of Carte)
     Retournes deux listes qui représentent les deux mains des cartes.  
     Le donneur donne une carte à l'autre joueur, une à lui-même,
     et ça continue jusqu'à la fin du paquet p.
     '''  
     donneur=[]
     autre=[]
     p = self.paquet
     while len(p)>1:
          autre.append(p.pop())
          donneur.append(p.pop())
     autre.append(p.pop()) # donne la derniere carte
     return (donneur, autre)


class Joueur(object):
    '''represente une main des cartes a jouer'''
    def __init__(self, joueur):
        '''(Joueur, str)-> None
        constructeur qui initialise le nom du joueur avec la chaine des caracteres joueur
        et la liste de cartes avec liste vide'''
        self.nom = joueur
        self.main = []

    def ajoute_carte(self, carte):
        '''(Joueur, Carte) -> None
        ajoute une carte a la liste main'''
        self.main.append(carte)

    def affiche_cartes(self):
        '''
        (Joueur) -> None
        Affiche le nom et les éléments de la main du joueur séparées par d'espaces
        '''
        print(self.nom)
        for val in self.main:
            print(val, end=' ')
        print()

    def remove_carte(self, carte):
        '''(Joueur, Carte) -> None
        elimine une carte de la liste self.main'''
        i = 0
        while i < len(self.main):
            if self.main[i] == carte:
                del self.main[i]
                break
            i = i + 1
      
    def __eq__(self, autre):
        '''(Joueur,Joueur)->bool
        retourne True si les main ont les meme cartes
        dans la meme ordre'''
        return self.main == autre.main

    def __repr__(self):
        '''
        (Joueur) -> bool
        retourne une representation de l'objet de classe Joueur'''
        return str(self.main)

    def elimine_paires(self):
     '''
     (Joueur)->None

     Elimine les paires de la liste self.main
     Fait une copie de la liste avec tous les paires éliminées 
     et mis la nouvelle liste en self.main 
     L’ordre des éléments dans le résultat pourrait être différent, ils sont mélange.
     '''
     resultat=[]
     l = self.main
     l.sort()
     i=0
     while i<len(l)-1:
        carte1=l[i]
        carte2=l[i+1]
        if carte1.valeur==carte2.valeur: 
            i=i+1 # avance a la carte prochaine
        else:
            resultat.append(l[i])
        i=i+1
     if i==len(l)-1: # True si la derniere carte n'a pas une paire
        resultat.append(l[i])

     random.shuffle(resultat)
     self.main = resultat


def joue():
     '''(Joueur)->None
     Cette fonction joue le jeu'''
     d = JeuDeCartes()
     d.melange_paquet()

     donneur = Joueur('Robot')
     humain = Joueur('Humain')
     
     tmp=d.donne_cartes()
     donneur.main=tmp[0]
     humain.main=tmp[1]

     print("Bonjour. Je m'appelle Robot et je distribue les cartes.")
     print("Votre main est:")
     humain.affiche_cartes()
     print("Ne vous inquiétez pas, je ne peux pas voir vos cartes ni leur ordre.")
     print("Maintenant défaussez toutes les paires de votre main. Je vais le faire moi aussi.")
     d.attend_le_joueur()
     
     donneur.elimine_paires()
     humain.elimine_paires()

     ordinales=["ère", "ème"] # terminaisons pour les numérales ordinales en français

     tour=0
     
     while len(donneur.main)>0 and len(humain.main)>0:
          if tour==0: # donneur offres ses cartes
               print("***********************************************************")
               print("Votre tour.")
               print("Votre main est:")
               humain.affiche_cartes()
               
               position=d.entrez_position_valide(len(donneur.main))
               elem=donneur.main[position-1]
               donneur.remove_carte(elem) # ca marche parce que chaque carte est unique

               if position>1:
                   ord_index=1
               else:
                   ord_index=position-1
                   
               print("Vous avez demande ma "+str(position)+ordinales[ord_index]+" carte.")
               print("La voila. C'est un", elem)

               humain.ajoute_carte(elem)
               print("Avec", elem, "ajouté, votre main est:")
               humain.affiche_cartes()

               print("Après défaussé toutes les paires et mélanger les cartes, votre main est:")
               humain.elimine_paires()
               humain.affiche_cartes()

               d.attend_le_joueur()
               tour=1
          
          else:
               print("***********************************************************")
               print("Mon tour.")
               index=random.randint(0,len(humain.main)-1)
               elem=humain.main[index]
               humain.remove_carte(elem)
               donneur.ajoute_carte(elem)
               donneur.elimine_paires()

               if index>1:
                   ord_index=1
               else:
                   ord_index=index

               print("J'ai pris votre "+str(index+1)+ordinales[ord_index]+" carte.")
               d.attend_le_joueur()
               tour=0               
          
     if len(donneur.main)==0:
          print("J'ai terminé toutes les cartes.")
          print("Vous avez perdu! Moi, Robot, j'ai gagné.")
     else:
          print("***********************************************************")
          print("J'ai terminé toutes les cartes.")
          print("Felicitations! Vous, Humain, vous avez gagné.")


# programme principale
joue()
