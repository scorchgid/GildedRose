/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author u6021997
 */
public class TestCounter {
   static int testCase = 0;
   public static void increaseTestCase()
   {
        testCase++;
        System.out.println("");
        System.out.println("Test Case: "+ testCase+"-- :");
   }
}
