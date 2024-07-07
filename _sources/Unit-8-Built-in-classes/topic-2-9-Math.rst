.. include:: ../common.rst

.. qnum::
   :prefix: 2-9-
   :start: 1

|Time45|

Using the Math Class
====================

.. index::
    single: Math methods
    single: random method
    pair: Math; random method

We covered how to use the methods of the ``Math`` class back in unit √2
including how to generate random numbers in various ranges. You may want to look
back at that Unit before attempting these programming challenges.

|Groupwork| Programming Challenge : Random Numbers
--------------------------------------------------

.. image:: Figures/lock.jpg
    :width: 100
    :align: left
    :alt: lock

You may have a combination lock on your locker at school where you have to spin
the dial to 3 separate numbers from 0 to 39. What if you forgot your
combination? Would you be able to guess it?

1. Write code that will generate 3 random integers from 0 to 39 using
   ``Math.random()`` in the Active Code window below. Run it a couple times to
   see it generate different numbers.

2. How many times would you need to run it to guess your combination correctly?
   Let's have the code compute the number of permutations possible in your
   combination lock using ``Math.pow(number, exponent)``. For example, if you had
   2 dials on your combination lock where each dial can be set to a digit from
   0-9 (10 digits), there are 10\ :sup:`2` possible permutations. In Java, this
   would be written as ``Math.pow(10, 2)`` which means 10 to the power of 2. If
   you start listing all the permutations possible, you can tell that there are
   10\ :sup:`2` or 100 possible permutations for a 2 dial lock from 0-9.

.. raw:: html

    <pre>
    00, 01, 02, 03, 04, 05, 06, 07, 08, 09
    10, 11, 12, 13, 14, 15, 16, 17, 18, 19
    ...
    90, 91, 92, 93, 94, 95, 96, 97, 98, 99
    </pre>

Now what about the combination lock for this challenge? You have to spin the
dial to one of 40 possible numbers (0 to 39) three times. In general, the
formula to use is NumbersOnDial\ :sup:`numbersInCombination`. Write this using
the **Math.pow()** method in your code and save it into a variable and print
out.

.. activecode:: challenge2-9-random-math
   :language: java
   :autograde: unittest

   Complete the combination lock challenge below.
   ~~~~
   public class CombinationGuesser
   {
       public static void main(String[] args)
       {
           // TODO 1. Use Math.random() to generate 3 integers from 0-39 and
           // print them out.

           // TODO 2. Use Math.pow to calculate the number of possible
           // combinations given a three-nummer combination with each number in
           // the range 0-39 using Math.pow() and print it out. For example,
           // Math.pow(10, 2) is 10^2 which gives us the number of possible
           // combinations if combination consisted of only two numbers, each a
           // number from 0 to 9.
       }
   }

   ====
   import static org.junit.Assert.*;
   import org.junit.*;
   import java.io.*;
   
   public class RunestoneTests extends CodeTestHelper {
       @Test
       public void test1() {
           String output = getMethodOutput("main");
           String[] lines = output.split("\\s+");
   
           boolean passed = lines.length >= 2;
   
           passed = getResults(
                   "2+ lines of output",
                   lines.length + " lines of output",
                   "Expected output",
                   passed);
           assertTrue(passed);
       }
   
       @Test
       public void test2() {
           String output = getMethodOutput("main");
           boolean passed = output.contains("64000");
           passed = getResults("true", "" + passed, "Prints result of 40^3", passed);
           assertTrue(passed);
       }
   
       @Test
       public void test3() {
           String[] code = getCode().split("\n");
           String expected = "Possible answers:\n(int) (Math.random() * 40)\n(int) (40 * Math.random())";
           String actual = "";
           int num = 0;
   
           for (int i = 0; i < code.length; i++) {
               if (code[i].contains("Math.random()") && code[i].contains("40")) {
                   actual += code[i].trim() + "\n";
                   if (code[i].contains("(int)"))
                       num++;
               }
           }
   
           boolean passed = num >= 3;
           passed = getResults(
                   expected,
                   actual,
                   "Creates 3 random numbers from 0 to 40 (not inclusive)",
                   passed);
           assertTrue(passed);
       }
   
       @Test
       public void test4() {
           String code = getCode();
           int num = countOccurences(code, "Math.pow(");
   
           boolean passed = num >= 1;
           passed = getResults("1 or more", "" + num, "Calls to Math.pow(...)", passed);
           assertTrue(passed);
       }
   }

Here's another challenge that is a lot of fun! Can you use random numbers to
make dancing turtles? This idea was suggested by CSA teacher Zac Martin.

.. activecode:: challenge-2-9b-dancing-turtles
    :language: java
    :autograde: unittest
    :datafile: turtleClasses.jar

    Complete the random numbers using Math.random() in the correct ranges to
    choose x, y coordinates and random color in the range of 0-255 for the
    turtle. Put on some music and watch your turtle dance!

    ~~~~
    import java.util.*;
    import java.awt.*;

    public class DancingTurtles
    {
        public static void main(String[] args)
        {

            World world = new World(500,400);
            Turtle yertle = new Turtle(world);

            // This is a loop that runs 10 times (you will learn to write loops in
            // Unit 4)
            for (int i = 1; i <= 10; i++)
            {
             // Can you choose a randomX between 0-500?
             // Can you adjust for the 20 pixel width of the turtle,
             // so it doesn't get cut off at the edges?
             // Move the range from 20 to 480.
             int randomX = 0;

             // Can you choose a randomY between 0-400?
             // Can you adjust for the 20 pixel height of the turtle,
             // so it doesn't get cut off at the edges?
             int randomY = 0;

             yertle.moveTo(randomX, randomY);
             yertle.turnRight();

             // Can you choose a random red, green, and blue value between 0-255?
             int randomR = 0;
             int randomG = 0;
             int randomB = 0;

             yertle.setColor(new Color(randomR, randomG, randomB));

            } // end of loop
            world.show(true);
        }
    }
    ====
    import static org.junit.Assert.*;

    import org.junit.*;

    import java.io.*;

    public class RunestoneTests extends CodeTestHelper
    {
        public RunestoneTests()
        {
            super("DancingTurtles");
        }

        @Test
        public void test1()
        {
            String code = getCode();
            int numRandom = countOccurences(code, "Math.random()");

            boolean passed = numRandom >= 5;
            passed = getResults("5+", "" + numRandom, "5+ calls to Math.random()", passed);
            assertTrue(passed);
        }

        @Test
        public void test2()
        {
            boolean passed =
                    checkCodeContainsNoRegex(
                            "Random numbers for 0-255 colors (256 values)", "Math.random() * 256");
            assertTrue(passed);
        }
    }

Summary
-------------------
