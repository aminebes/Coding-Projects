import unittest
from d2 import *

class d2_Tests(unittest.TestCase):

    def test_q1(self):
        print("Test de la  question 1")
        print("Q1_1")
        n=patinage(30, -10)
        self.assertEqual(n,True)
        print("Q1_2")
        n=patinage(25.4, -15)
        self.assertEqual(n,False)
        print("Q1_3")
        n=patinage(33, -15)
        self.assertEqual(n,True)
        print("Q1_4")
        n=patinage(33, -5)
        self.assertEqual(n,False)
      

    def test_q2(self):
        print("\nTest de la  question 2")
        print("Q2_1")
        n=alphaNote(100)
        self.assertEqual(n,'A+')
        print("Q2_2")
        n=alphaNote(89)
        self.assertEqual(n,'A')
        print("Q2_3")
        n=alphaNote(56)
        self.assertEqual(n,'D+')
        print("Q2_4")
        n=alphaNote(30)
        self.assertEqual(n,'F')
      

    # pas de unit test pour Q3 parce qu'elle ne retourne rien

    # pas de unit test pour Q4 parce qu'elle ne retourne rien

    def test_q5(self):
        print("\nTest de la  question 5")
        print("Q5_1")
        n =facteursDeN(12)
        self.assertEqual(n,False)
        print("Q5_2")
        n =facteursDeN(9)
        self.assertEqual(n,True)
        print("Q5_3")
        n =facteursDeN(5)
        self.assertEqual(n,True)       
        

    def test_q6(self):
        print("\nTest de la  question 6")
        print("Q6_1")
        n =carreParfait(16)
        self.assertEqual(n,True)
        print("Q6_2")
        n =carreParfait(15)
        self.assertEqual(n,False)  
   
   

if __name__ == '__main__':
    unittest.main()

