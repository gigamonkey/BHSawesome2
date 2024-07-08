.. include:: ../common.rst


Operators
=========


.. index::
    single: operators
    pair: math; operators
    pair: operators; addition
    pair: operators; subtraction
    pair: operators; multiplication
    pair: operators; division
    pair: operators; equality
    pair: operators; inequality

Java uses the standard mathematical operators for addition (``+``), subtraction
(``-``), and division (``/``). The multiplication operator is written ``*``, as
it is in most programming languages, since the character sets used until
relatively recently didn’t have a character for a real multiplication sign,
``×``, and keyboards still don’t have a key for it. Likewise no ``÷``.

.. note::

   You may be used to using ``^`` for exponentiation, either from a graphing
   calculator or tools like Desmos. Confusingly ``^`` *is* an operator in Java
   but it has a completely different meaning than exponentiation and isn’t even
   exactly an arithmetic operator. However you may recall ``Math.pow`` from Unit
   √2 that lets us do exponentiation.

Arithmetic expressions can be of type ``int`` or ``double``. An arithmetic
expression consisting only of ``int`` values will evaluate to an ``int`` value.
An arithmetic expression that uses at least one ``double`` value will evaluate
to a ``double`` value. (You may have noticed that ``+`` was also used to combine
``String`` and other values into new ``String``\ s. More on this when we talk
about ``String``\ s more fully in Unit 2.)

Java uses the operator ``==`` to test if the value on the left is equal to the
value on the right and ``!=`` to test if two items are not equal. Don't get one
equal sign ``=`` confused with two equal signs ``==``. They mean very different
things in Java. One equal sign is used to assign a value to a variable. Two
equal signs are used to test a variable to see if it is a certain value and that
returns true or false as you'll see below. Also note that using ``==`` and
``!=`` with ``double`` values can produce surprising results. Because ``double``
values are only an approximation of the real numbers even things that should be
mathematically equivalent might not be represented by the exactly same
``double`` value and thus will not be ``==``. To see this for yourself, write a
line of code below to print the value of the expression ``0.3 == 0.1 + 0.2``; it
will be ``false``!

|CodingEx| **Coding Exercise:**

.. activecode:: lcop1
   :language: java
   :autograde: unittest

   Run the code below to see all the operators in action. Do all of those operators do what you expected?  What about 2 / 3? Isn't it surprising that it prints 0?  See the note below.
   ~~~~
   public class Test1
   {
       public static void main(String[] args)
       {
           System.out.println(2 + 3);
           System.out.println(2 - 3);
           System.out.println(2 * 3);
           System.out.println(2 / 3);
           // == is to test while = is to assign
           System.out.println(2 == 3);
           System.out.println(2 != 3);
       }
   }

   ====
   // Test Code for Lesson 1.4 Expressions - iccv1
   import static org.junit.Assert.*;

   import org.junit.Test;

   import java.io.*;

   public class RunestoneTests extends CodeTestHelper
   {
       @Test
       public void test1()
       {
           String output = getMethodOutput("main");
           String expect = "5\n-1\n6\n0\nfalse\ntrue";
           boolean passed =
                   getResults(expect, output, "Expected output from main", true);
           assertTrue(passed);
       }
   }

.. note::

   When Java sees you doing integer division (or any operation with integers) it
   assumes you want an integer result so it throws away anything after the
   decimal point in the answer. This is called **truncating division**. If you
   need a double answer, you should make at least one of the values in the
   expression a double like 2.0.


With division, another thing to watch out for is dividing by 0. An attempt to divide an integer by zero will result in an **ArithmeticException** error message. Try it in one of the active code windows above.

Operators can be used to create compound expressions with more than one operator. You can either use a literal value which is a fixed value like 2, or variables in them.  When compound expressions are evaluated, **operator precedence** rules are used, just like when we do math (remember PEMDAS?), so that ``*``, ``/``, and ``%`` are done before ``+`` and ``-``. However, anything in parentheses is done first. It doesn't hurt to put in extra parentheses if you are unsure as to what will be done first or just to make it more clear.

|CodingEx| **Coding Exercise:**



.. activecode:: compound1
   :language: java
   :autograde: unittest

   In the example below, try to guess what it will print out and then run it to see if you are right. Remember to consider **operator precedence**. How do the parentheses change the precedence?
   ~~~~
   public class TestCompound
   {
       public static void main(String[] args)
       {
           System.out.println(2 + 3 * 2);
           System.out.println((2 + 3) * 2);
           System.out.println(2 + (3 * 2));
       }
   }

   ====
   // Test Code for Lesson 1.4 Expressions - compounds
   import static org.junit.Assert.*;

   import org.junit.Test;

   import java.io.*;

   public class RunestoneTests extends CodeTestHelper
   {
       @Test
       public void test1()
       {
           String output = getMethodOutput("main");
           String expect = "8\n10\n8";
           boolean passed =
                   getResults(expect, output, "Expected output from main", true);
           assertTrue(passed);
       }
   }

The Remainder Operator
----------------------

The percent sign (``%``) is also an arithmetic operator, though one you may not
have learned yet in math. It is the **remainder** operator. Like the other
arithmetic operators is takes two operands. Mathematically it returns the
remainder after performing a truncating integer division of the first number by
the second. For instance, ``5 % 2`` evaluates to 1 since 2 goes into 5 two times
with a remainder of 1.

While you may not have heard of remainder as an operator, think back to
elementary school math. Remember when you first learned long division, before
they taught you about decimals, how when you did a long division that didn’t
divide evenly, you gave the answer as the number of even divisions and the
remainder. That remainder is what is returned by this operator. In the figures
below, the remainders are the same values that would be returned by ``2 % 3``
and ``5 % 2``.

.. figure:: Figures/mod-py.png
    :width: 150px
    :align: center
    :figclass: align-center

    Figure 1: Long division showing the integer result and the remainder

.. note::

   Sometimes people—including Professor Lewis in the next video—will call ``%``
   the **modulo**, or **mod**, operator. That is not actually correct though the
   difference between remainder and modulo only matters when the signs of the
   operands differ, so often it doesn’t matter. Having ``%`` mean remainder is
   quite common in programming languages. In some languages, however, ``%``
   actually *is* modulo. To compute ``a`` *modulo* ``b`` in Java, or any other
   language where ``%`` is remainder, you need to write ``(a % b) + b) % b`` or,
   better yet, use the method ``Math.floorMod`` from the ``Math`` class. But on
   the AP exam, all the uses of ``%`` will be ones where this distinction
   doesn’t matter.

.. |video2| raw:: html

   <a href="https://www.youtube.com/watch?v=jp-T9lFISlI&ab_channel=colleenlewis" target="_blank">video</a>

Here’s the |video2|.

.. youtube:: jp-T9lFISlI
    :width: 700
    :height: 415
    :align: center


|CodingEx| **Coding Exercise:**

.. activecode:: lcop2
   :language: java
   :autograde: unittest

   In the example below, try to guess what it will print out and then run it to see if you are right.
   ~~~~
   public class Test1
   {
       public static void main(String[] args)
       {
           System.out.println(11 % 10);
           System.out.println(3 % 4);
           System.out.println(8 % 2);
           System.out.println(9 % 2);
       }
   }

   ====
   // Test Code for Lesson 1.4 Expressions - lcop2
   import static org.junit.Assert.*;

   import org.junit.Test;

   import java.io.*;

   public class RunestoneTests extends CodeTestHelper
   {
       @Test
       public void test1()
       {
           String output = getMethodOutput("main");
           String expect = "1\n3\n0\n1";
           boolean passed =
                   getResults(expect, output, "Expected output from main", true);
           assertTrue(passed);
       }
   }

.. note::
   The result of x % y when x is smaller than y is always x.  The value y can't go into x at all (goes in 0 times), since x is smaller than y, so the result is just x.  So if you see 2 % 3 the result is 2.

.. index::
   single: modulo
   single: remainder
   pair: operators; modulo
   pair: operators; remainder

|Exercise| **Check Your Understanding**

.. mchoice:: q3_4_1
   :practice: T
   :answer_a: 15
   :answer_b: 16
   :answer_c: 8
   :correct: c
   :feedback_a: This would be the result of 158 divided by 10.  % gives you the remainder.
   :feedback_b: % gives you the remainder after the division.
   :feedback_c: When you divide 158 by 10 you get a remainder of 8.

   What is the result of 158 % 10?

.. mchoice:: q3_4_2
   :practice: T
   :answer_a: 3
   :answer_b: 2
   :answer_c: 8
   :correct: a
   :feedback_a: 8 goes into 3 no times so the remainder is 3.  The remainder of a smaller number divided by a larger number is always the smaller number!
   :feedback_b: This would be the remainder if the question was 8 % 3 but here we are asking for the reminder after we divide 3 by 8.
   :feedback_c: What is the remainder after you divide 3 by 8?

   What is the result of 3 % 8?






|Groupwork| Programming Challenge : Dog Years
------------------------------------------------

.. image:: Figures/dog-free.png
    :width: 150
    :align: left
    :alt: dog

In this programming challenge, you will calculate your age, and your pet's age from your birthdates, and your pet's age in dog years.   In the code below, type in the current year, the year you were born, the year your dog or cat was born (if you don't have one, make one up!) in the variables below. Then write formulas in assignment statements to calculate how old you are, how old your dog or cat is, and how old they are in dog years which is 7 times a human year.  Finally, print it all out. If you are pair programming, switch drivers (who has control of the keyboard in pair programming) after every line of code.

.. activecode:: challenge1-4
   :language: java
   :autograde: unittest
   :practice: T

   Calculate your age and your pet's age from the birthdates, and then your pet's age in dog years.
   ~~~~
   public class Challenge1_4
   {
       public static void main(String[] args)
       {
           // Fill in values for these variables
           int currentYear =
           int birthYear =
           int dogBirthYear =

           // Write a formula to calculate your age from the currentYear and
           // your birthYear variables
           int age =

           // Write a formula to calculate your dog's age from the currentYear
           // and dogBirthYear variables
           int dogAge =

           // Calculate the age of your dog in dogYears (7 times your dog's age
           // in human years)
           int dogYearsAge =

           // Print out your age, your dog's age, and your dog's age in dog
           // years. Make sure you print out text too so that the user knows what
           // is being printed out.

      }
   }
   ====
   import static org.junit.Assert.*;
   import org.junit.*;

   //import jdk.jfr.Timestamp;

   import java.io.*;

   /* Do NOT change Main or CodeTestHelper.java.
      Put the active code exercise in a file like ForLoop.java.
      Put your Junit test in the file RunestoneTests.java.
      Run. Test by changing ForLoop.java (student code).
      */
   public class RunestoneTests extends CodeTestHelper {
      @Test
      public void checkVariables() throws IOException {
         String code = removeSpaces(getCode());
         code = code.replaceAll("\\(", "").replaceAll("\\)", "");

         boolean passed1 = code.matches(".*intcurrentYear=[0-9]{2,4};.*");
         boolean passed2 = code.matches(".*intbirthYear=[0-9]{2,4};.*");
         boolean passed3 = code.matches(".*intbirthYear=[0-9]{1,4};.*");

         boolean passed = passed1 && passed2 && passed3;

         getResults("true", "" + passed, "Checking that you initialized the three variables");
         assertTrue(passed);
      }

      @Test
      public void checkOutput() throws IOException {
         String output = getMethodOutput("main");
         int num = output.length();
         boolean passed = num >= 5;
         getResults("1+ characters", "" + num, "Checking that you have some output", passed);
         assertTrue(passed);
      }

      @Test
      public void checkPrintlines() throws IOException {
         String code = removeSpaces(getCode());
         int num = countOccurences(code, "System.out.print");

         boolean passed = num >= 1;
         getResults("At least one", "" + num, "Checking that you have at least one print statement", passed);
         assertTrue(passed);
      }

      @Test
      public void testAsgn1() throws IOException {
         /*
          * String target = "age = currentYear - birthYear"; boolean passed =
          * checkCodeContains("formula for age", target); assertTrue(passed);
          */
         String target = removeSpaces("age = currentYear - birthYear");
         String code = removeSpaces(getCode());
         code = code.replaceAll("\\(", "").replaceAll("\\)", "");

         boolean passed = code.contains(target);
         getResults("true", "" + passed, "Checking that code contains formula for age", passed);
         assertTrue(passed);
      }

      @Test
      public void testAsgn2() throws IOException {
         String target = removeSpaces("dogAge = currentYear - dogBirthYear");
         String code = removeSpaces(getCode());
         code = code.replaceAll("\\(", "").replaceAll("\\)", "");

         boolean passed = code.contains(target);
         getResults("true", "" + passed, "Checking that code contains formula for dogAge", passed);
         assertTrue(passed);
      }

      @Test
      public void testAsgn3() throws IOException {
         String target1 = removeSpaces("dogYearsAge = dogAge * 7");
         String target2 = removeSpaces("dogYearsAge = 7 * dogAge");
         String code = removeSpaces(getCode());
         code = code.replaceAll("\\(", "").replaceAll("\\)", "");

         boolean passed1 = code.contains(target1);
         boolean passed2 = code.contains(target2);
         boolean passed = passed1 || passed2;
         getResults("true", "" + passed, "Checking that code contains formula for dogYearsAge using dogAge", passed);
         assertTrue(passed);
      }
   }


.. |repl| raw:: html

   <a href="https://repl.it" target="_blank">repl.it</a>


.. |Scanner| raw:: html

   <a href="https://www.w3schools.com/java/java_user_input.asp" target="_blank">Scanner class</a>

.. |repl template| raw:: html

   <a href="https://firewalledreplit.com/@BerylHoffman/Challenge1-4-Dog-Years-Template" target="_blank">repl template</a>

Your teacher may suggest that you use a Java IDE like |repl| for this challenge so that you can use input to get these values using the |Scanner|. Here is a |repl template| that you can use to get started if you want to try the challenge with input.

Summary
-------------------

- Arithmetic expressions include expressions of type ``int`` and ``double``.

- The arithmetic operators consist of ``+``, ``-``, ``*`` , ``/``, and ``%``
  also known as addition, subtraction, multiplication, division, and remainder.

- An arithmetic operation that uses two ``int`` values will evaluate to an
  ``int`` value. With integer division, any decimal part in the result will be
  thrown away.

- An arithmetic operation that uses at least one ``double`` value will evaluate
  to a ``double`` value.

- Operators can be used to construct compound expressions.

- During evaluation, operands are associated with operators according to
  **operator precedence** to determine how they are grouped. (``*``, ``/``,
  ``%`` have precedence over ``+`` and ``-``, unless parentheses are used to
  group those.)

- An attempt to divide an integer by zero will result in an ``ArithmeticException``.

- The assignment operator (``=``) allows a program to initialize or change the
  value stored in a variable. The value of the expression on the right is stored
  in the variable on the left.

- During execution, expressions are evaluated to produce a single value.

- The value of an expression has a type based on the types of the values and
  operators used in the expression.
