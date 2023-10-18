#Exercice 1
class Temps:
  '''classe temporelle'''

  def __init__(self, h=12, m=0, s=0):
    '''(Temps)-> None'''
    n1=0
    while s>=60:
      s=s-60
      n1+=1
    m+=n1
    n2=0
    while m>=60:
      m=m-60
      n2+=1
    h+=n2
    while h>=24:
      h=h-24
    self.heure = h
    self.minute = m
    self.seconde = s

  def setTemps(self, h, m=0, s=0):
    '''(Temps)-> None'''
    n1=0
    while s>=60:
      s=s-60
      n1+=1
    m+=n1
    n2=0
    while m>=60:
      m=m-60
      n2+=1
    h+=n2
    while h>=24:
      h=h-24
    
    self.heure = h 
    self.minute = m
    self.seconde = s

  def affiche_heure(self):
    '''(Temps)-> None'''
    print("{0}:{1}:{2}".format(self.heure, self.minute, self.seconde)) 

  def __repr__(self):
    '''(Temps)-> str'''
    return (str(self.heure) +":" +str(self.minute) +":" +str(self.seconde))

  def __eq__(self, autre):
    '''(Temps)-> bool'''
    return self.heure == autre.heure and self.minute == autre.minute and self.seconde == autre.seconde
  def estAvant(self,autre):
    '''(Temps)-> bool'''
    if self.heure<autre.heure:
      test=True
    elif self.heure==autre.heure:
      if self.minute<autre.minute:
        test=True
      elif self.minute==autre.minute:
        if self.seconde<autre.seconde:
          test=True
        else:
          test=False
      
      else:
        test=False
      
    else:
      test=False
    return test
  def durée(self,autre):
    '''(Temps)-> Temps'''
    res=Temps()
    if not(self.estAvant(autre)):
      res.heure=self.heure-autre.heure
      res.minute=self.minute-autre.minute
      res.seconde=self.seconde-autre.seconde
    else:
      res.heure=autre.heure-self.heure
      res.minute=autre.minute-self.minute
      res.seconde=autre.seconde-self.seconde
      
    n1=0
    while not(res.seconde in range(0,60)):
      if res.seconde>59:
        res.seconde=res.seconde-60
        n1+=1
      elif res.seconde<0:
        res.seconde=res.seconde+60
        n1-=1

    res.minute+=n1
    n2=0
    while not(res.minute in range(0,60)):
      if res.minute>59:
        res.minute=res.minute-60
        n2+=1
      elif res.minute<0:
        res.minute=res.minute+60
        n2-=1
    while not(res.minute in range(0,60)):
      if res.minute>59:
        res.minute=res.minute-60
        n2+=1
      elif res.minute<0:
        res.minute=res.minute+60
        n2-=1
    res.heure+=n2
    return res
  
    
#Programme principal
t1 = Temps(12,4,0)
t2 = Temps(10,2,1)
print(t1.estAvant(t2))
print(t2.estAvant(t1))
print(print(t2.setTemps(12,45,2)))
print(t1.estAvant(t2))
print(t1.durée(t2))
t3= Temps(12,5,35)
t4= Temps(13,4,25)
print(t3.durée(t4))






















    
