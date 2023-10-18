import unittest
import d4

class d4_Tests(unittest.TestCase):

    def test_q1(self):
        print("Test de la  question 1")
        d = {"apple":"pomme", "banana":"banane", "pear": "poire", "plum":"prune"}
        print("Q1_1")
        n= d4.transl(d,"pear")
        self.assertEqual(n, 'poire')
        print("Q1_2")
        n = d4.transl(d,"poire")
        self.assertEqual(n, 'pear')
        print("Q1_3")
        n = d4.transl(d,"appricot")
        self.assertEqual(n, 'Unknown')

    def test_q2(self):
        print("\nTest de la  question 2")
        print("Q2_1")
        n=d4.setOp([1,2,2,3],[2,-6,8,7])
        self.assertEqual(n,{1, 2, 3, 7, 8, -6})
        print("Q2_2")
        n=d4.setOp([],[1,4,2,4,6])
        self.assertEqual(n, {1, 2, 4, 6})
        print("Q2_3")
        n=d4.setOp([1,1,1,1],[])
        self.assertEqual(n, {1})
        print("Q2_4")
        n=d4.setOp([1],[2,3,2,2])
        self.assertEqual(n, {1, 2, 3})

    def test_q3(self):
        print("\nTest de la  question 3")
        print("Q3_1")
        n = d4.matrixMinMax([[1,5],[2,8]])
        self.assertEqual(n, (1,8))
        print("Q3_2")
        n = d4.matrixMinMax([[1,5,10],[2,8,-1]])
        self.assertEqual(n, (-1,10))
        print("Q3_3")
        n = d4.matrixMinMax([[2,8,-1]])
        self.assertEqual(n, (-1,8))
        print("Q3_4")
        n = d4.matrixMinMax([[1],[1]])
        self.assertEqual(n, (1,1))

if __name__ == '__main__':
    unittest.main()

        
