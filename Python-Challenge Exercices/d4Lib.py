def effaceTableau (tab):
   '''
   (list) -> None
   Cette fonction prepare le tableau de jeu (la matrice) 
   en mettant '-' dans tous les elements.
   Elle ne crée pas une nouvelle matrice
   Preconditions: tab est une reference a une matrice n x n qui contient '-', 'X' ou 'O'
   '''
   
   # à completer
   for rg in range(len(tab)):
      for col in range(len(tab[rg])):
         tab[rg][col]="-"
          
    # retourne rien

      
def verifieGagner(tab):  
    '''(list) ->  bool
    * Preconditions: tab est une reference a une matrice n x n qui contient '-', 'X' ou 'O'
    * Verifie s'il y a un gagnant.
    * Cherche pour 3 X's et O's dans une ligne, colonne, et diagonal.
    * Si on a trouvé, affiche le gagnant (le message "Joueur X a gagné!" 
    * ou "Joueur O a gagné!") et retourne True.
    * S'il y a un match nul (verifie ca avec la fonction testMatchNul),
    * affiche "Match nul" et retourne True.
    * Si le jeu n'est pas fini, retourne False.
    * La fonction appelle les fonctions testLignes, testCols, testDiags
    * pour verifier s'il y a un gagnant.
    * Ces fonctions retournent le gagnant 'X' ou 'O', ou '-' s'il n'y a pas de gagnant
    '''

    # à completer
    gagner=False
    L=testLignes(tab)
    col=testCols(tab)
    dia=testDiags(tab)
    nul=testMatchNul(tab)
    if L=="X" or col=="X" or dia=="X":
       print("Joueur X a gagné!")
       gagner= True
    elif L=="O" or col=="O" or dia=="O":
       print("Joueur O a gagné!")
       gagner= True
    elif nul==True:
       print("Match nul")
       gagner=True
    return gagner
       
      


 
def testLignes(tab):
   ''' (list) ->  str
   * verifie s’il y a une ligne gagnante.
   * cherche trois 'X' ou trois 'O' dans une ligne.  
   * Si on trouve, le caractere 'X' ou 'O' et retourné, sinon '-' est retourné.
   * Preconditions: tab est une reference a une matrice n x n qui contient '-', 'X' ou 'O'
   '''

   # à completer
   test=False
   gagnant=""
   l=0
   while l<len(tab) and test==False:
      if tab[l][0]==tab[l][1]==tab[l][2]:
         test=True
         gagnant+=tab[l][0]
      else:
         l+=1
   if test==True:
      res=gagnant
   else:
      res="-"
   return res
         


  
  
def testCols(tab):
   ''' (list) ->  str
   * verifie s’il y a une colonne gagnante.
   * cherche trois 'X' ou trois 'O' dans une colonne.  
   * Si on trouve, le caractere 'X' ou 'O' et retourné, sinon '-' est retourné.
   * Preconditions: tab est une reference a une matrice n x n qui contient '-', 'X' ou 'O'
   '''
    
   # à completer
   test=False
   gagnant=""
   c=0
   while c<len(tab) and test==False:
      if tab[0][c]==tab[1][c]==tab[2][c]:
         test=True
         gagnant+=tab[0][c]
      else:
         c+=1
   if test==True:
      res=gagnant
   else:
      res="-"
   return res


   
def testDiags(tab):
   ''' (list) ->  str
   * cherche trois 'X' ou trois 'O' dans une diagonale.  
   * Si on trouve, le caractere 'X' ou 'O' et retourné
   * sinon '-' est retourné.
   * Preconditions: tab est une reference a une matrice n x n qui contient '-', 'X' ou 'O'
   '''

   # à completer
   test1=False
   test2=False
   gagnant=""
   if tab[0][0]==tab[1][1]==tab[2][2]:
      test1=True
      gagnant+=tab[0][0]
   elif tab[2][0]==tab[1][1]==tab[0][2]:
      test2=True
      gagnant+=tab[2][0]
   if test1 or test2:
      res=gagnant
   else:
      res="-"
      
   return res 

  
  
def testMatchNul(tab):
   ''' (list) ->  bool
   * verifie s’il y a un match nul
   * verifie si tous les elements de la matrice contiennent X ou O, pas '-'.  
   * Si on ne trouve pas de '-' dans la matrice, retourne True. 
   * S'il y a de '-', retourne false.
   * Preconditions: tab est une reference a une matrice n x n qui contient '-', 'X' ou 'O'
   '''
    
   # à completer
   test=True
   i=0
   while test==True and i<len(tab):
      j=0
      while test==True and j<len(tab):
         if tab[i][j]=="-":
            test=False
         j+=1
      i+=1
      
   return test

