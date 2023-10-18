#Exercice 2
class Voiture:
    def __init__(self, marque = 'Ford', couleur = 'rouge'):
        '''(Voiture)-> None'''
        self.marque = marque
        self.couleur = couleur
        self.pilote = 'personne'
        self.vitesse= 0
    def choix_conducteur(self,nom):
        '''(Voiture)-> None'''
        self.pilote=nom
    def accelerer(self,taux,duree):
        '''(float,float)-> None'''
        if not(self.pilote=='personne'):
            self.vitesse+=taux*duree
        else:
            print("Cette voiture n'a pas de conducteur !")
    def affiche_tout(self):
        print("{} {} pilotée par {}, vitesse = {} m/s.".format(self.marque,self.couleur,self.pilote,self.vitesse))
    def __repr__(self):
        '''(Temps)-> str'''
        return (self.marque+" "+self.couleur+" pilotée par "+self.pilote+", vitesse = "+str(self.vitesse)+" m/s.")

    def __eq__(self, autre):
        '''(Temps)-> bool'''
        return self.marque == autre.marque and self.couleur == autre.couleur 


#Programme principal
a1 = Voiture('Peugeot', 'bleue')
a2 = Voiture(couleur = 'verte')
a3 = Voiture('Mercedes')

a1.choix_conducteur('Roméo')
a2.choix_conducteur('Juliette')
a3.choix_conducteur('Durant')
a1.accelerer(1.5,10)
a2.accelerer(1.8, 12)
a3.accelerer(1.9, 11)
a1.affiche_tout()
a2.affiche_tout()
a3.affiche_tout()

