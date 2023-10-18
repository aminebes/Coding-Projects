def triangle(n):
  if (n != 0):  
    triangle(n-1)
    for i in range(n):
      print('*', end='') 
    print()
   

   
def prodListePos_rec(l, n):
  if (n == 0): 
      s = 1
  else:
      if l[n-1] > 0:
        s = prodListePos_rec(l, n-1) * l[n-1]
      else:
        s = prodListePos_rec(l, n-1)
        
  return s


def prodLRec1(l):
  if (len(l) == 0): 
      s = 1
  else:
      if l[0] > 0:
        s = prodLRec1(l[1:]) * l[0]
      else:
        s = prodLRec1(l[1:])
  return s

triangle(5)


l = [1,-2,5,0,6,-5]
print(prodListePos_rec(l, len(l)))
print(prodLRec1(l))
l = []
print(prodListePos_rec(l, len(l)))
print(prodLRec1(l))
