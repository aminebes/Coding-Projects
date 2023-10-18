import unittest
from d3 import *

class d3_Tests(unittest.TestCase):

    def test_q1(self):
        print("Test de la  question 1")
        print("Q1_1")
        n=compte100([1,102,-3.5, 104])
        self.assertEqual(n,2)
        print("Q1_2")
        n=compte100([1,99,-3.5,-7])
        self.assertEqual(n,0)
        print("Q1_3")
        n=compte100([])
        self.assertEqual(n,0)
      

    def test_q2(self):
        print("\nTest de la  question 2")
        print("Q2_1")
        n=sommeListeDiv2([1,4,3,8,5])
        self.assertEqual(n,12)
        print("Q2_2")
        n=sommeListeDiv2([])
        self.assertEqual(n,0)
        print("Q2_3")
        n=sommeListeDiv2([4,-10,7])
        self.assertEqual(n,-6)
      

    def test_q3(self):
        print("\nTest de la  question 3")
        print("Q3_1")
        n=triples("abc")
        self.assertEqual(n,False)
        print("Q3_2")
        n=triples("abbbcdeeggggg")
        self.assertEqual(n,True)
        print("Q3_3")
        n=triples("abc2eee")
        self.assertEqual(n,True)
        print("Q3_4")
        n=triples("a23xxxxx")
        self.assertEqual(n,True)
        print("Q3_5")
        n=triples("abaacd")
        self.assertEqual(n,False)

    def test_q4(self):
       print("\nTest de la  question 4")
       print("Q4_1")
       n=momo("a")
       self.assertEqual(n,"a1")
       print("Q4_2")
       n=momo("aabbbccccx")
       self.assertEqual(n,"a2b3c4x1")
       print("Q4_3")
       n=momo("aaa1111")
       self.assertEqual(n,"a314")
       print("Q4_4")
       n=momo("aaabcaax")
       self.assertEqual(n,"a3b1c1a2x1")
        


if __name__ == '__main__':
    unittest.main()

