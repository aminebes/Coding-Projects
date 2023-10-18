#Exercice 3
class CompteBancaire:
    def __init__(self, nom = 'Dupont', solde = 1000):
        '''(CompteBancaire)-> None'''
        self.nom = nom
        self.solde=solde
    def depot(self,montant):
        '''(float)-> None '''
        self.solde+=montant
    def retrait(self,montant):
        '''(float)-> None '''
        self.solde-=montant
    def affiche(self):
        print("Le solde du compte bancaire de {} est de {} dollars.".format(self.nom,self.solde)
)
    def __repr__(self):
        '''(CompteBancaire)-> str'''
        return ("Titulaire du compte : "+self.nom+'\n'+"Solde du compte : "+str(self.solde))

    def __eq__(self, autre):
        '''(CompteBancaire)-> bool'''
        return self.nom == autre.nom and self.solde == autre.solde 

class CompteEpargne(CompteBancaire):
    def __init__(self, nom="Duvivier",solde=1000):
        CompteBancaire.__init__(self, nom, solde)
        self.taux = 0.3
    def changeTaux(self,valeur):
        '''(float)-> None'''
        self.taux=valeur
    def capitalisation(self,nbm):
        '''(int)-> str '''
        for i in range(nbm):
            self.solde=self.solde*(100+self.taux)/100
        return "Capitalisation sur {} mois au taux mensuel de {} %.".format(nbm,self.taux)
    
    

