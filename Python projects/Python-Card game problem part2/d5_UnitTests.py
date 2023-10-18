import unittest
import d5

class d5_Tests(unittest.TestCase):

    def test_q2(self):
        print("\nTest de la  question 2")
        print("Q2_1")
        n=d5.prodListePos_rec([1,-2,5,0,6,-5], len([1,-2,5,0,6,-5]))
        self.assertEqual(n,30)
        n=d5.prodLRec1([1,-2,5,0,6,-5])
        self.assertEqual(n,30)
        print("Q2_2")
        n=d5.prodListePos_rec([],len([]))
        self.assertEqual(n, 1)
        n=d5.prodLRec1([])
        self.assertEqual(n,1)


if __name__ == '__main__':
    unittest.main()

        
