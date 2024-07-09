.. include:: ../common.rst


Numbers
=======

.. index::
   single: integer
   single: int
   single: double
   single: boolean
   single: String
   pair: variable; types
   pair: variable; primitive type
   pair: variable; object type
   pair: variable; integer
   pair: variable; floating point
   pair: variable; Boolean
   pair: variable; String

There are two types of variables in Java: **primitive variables** that hold
primitive types and **object or reference variables** that hold a reference to
an object of a class. A reference is a way to find the object (like a UPS
tracking number helps you find your package). The primitive types on the
Advanced Placement Computer Science A exam are:

- ``int`` which can represent integers, i.e. numbers with no fractional part
  such as 3, 0, -76, and 20393.

- ``double`` which can represent non-integer numbers like 6.3 -0.9, and
  60293.93032. Computer people call these “floating point” numbers because the
  decimal point “floats” relative to the magnitude of the number, similar to the
  way it does in scientific notation like :math:`6.5 ✕ 10^8`. The name
  ``double`` comes from the fact that ``double``\s are represented using 64
  bits, double the 32 bits used for the type ``float`` which used to be the
  normal size floating point number when most computers did math in units of
  32-bits. (``float`` is rarely used these days and is not part of the AP
  curriculum.)

- ``boolean`` which can represent only two values: ``true`` and ``false``. (The
  data type is named for `George Boole
  <https://en.wikipedia.org/wiki/George_Boole>`_, a 19th century English
  mathematician who invented Boolean algebra, a system for dealing with
  statements made up of only true and false values.)

``String`` is one of the object types on the exam and is the name of a class in
Java. A ``String`` is written in a Java program as a sequence of characters
enclosed in a pair of double quotes - like ``"Hello"``. You will learn more
about ``String`` objects in Unit 2.

.. note::

   Some languages use 0 to represent false and 1 to represent true, but Java
   uses the keywords ``true`` and ``false`` in boolean variables.

A type is a set of values (a domain) and a set of operations on them. For
example, you can do addition operations with ``int``\s and ``double``\s but not
with ``boolean``\s and ``String``\s.

|Exercise| **Check your understanding**


.. mchoice:: q3_1_1
   :practice: T
   :answer_a: int
   :answer_b: double
   :answer_c: boolean
   :answer_d: String
   :correct: b
   :feedback_a: While you could use an int, this would throw away any digits after the decimal point, so it isn't the best choice.  You might want to round up a grade based on the average (89.5 or above is an A).
   :feedback_b: An average is calculated by summing all the values and dividing by the number of values.  To keep the most amount of information this should be done with decimal numbers so use a double.
   :feedback_c: Is an average true or false?
   :feedback_d: While you can use a string to represent a number, using a number type (int or double) is better for doing calculations.

   What type should you use to represent the average grade for a course?

.. mchoice:: q3_1_2
   :practice: T
   :answer_a: int
   :answer_b: double
   :answer_c: boolean
   :answer_d: String
   :correct: a
   :feedback_a: The number of people is a whole number so using an integer make sense.
   :feedback_b: Can you have 2.5 people in a household?
   :feedback_c: Is the number of people something that is either true or false?
   :feedback_d: While you can use a string, a number is better for doing calculations with (like finding the average number of people in a household).

   What type should you use to represent the number of people in a household?

.. mchoice:: q3_1_3
   :practice: T
   :answer_a: int
   :answer_b: double
   :answer_c: boolean
   :answer_d: String
   :correct: d
   :feedback_a: People don't usually have whole numbers like 7 as their first name.
   :feedback_b: People don't usually have decimal numbers like 3.5 as their first name.
   :feedback_c: This could only be used if the name was true or false.  People don't usually have those as first names.
   :feedback_d: Strings hold sequences of characters like you have in a person's name.

   What type should you use to hold the first name of a person?

.. mchoice:: q3_1_4
   :practice: T
   :answer_a: int
   :answer_b: double
   :answer_c: boolean
   :answer_d: String
   :correct: c
   :feedback_a: While you could use an int and use 0 for false and 1 for true this would waste 31 of the 32 bits an int uses. Java has a special type for things that are either true or false.
   :feedback_b: Java has a special type for variables that are either true or false.
   :feedback_c: Java uses boolean for values that are only true or false.
   :feedback_d: While you can use a string to represent "True" or "False", using a boolean variable would be better for making decisions.

   What type should you use to record if it is raining or not?

.. mchoice:: q3_1_5
   :practice: T
   :answer_a: int
   :answer_b: double
   :answer_c: boolean
   :answer_d: String
   :correct: b
   :feedback_a: The integer type (int) can't be used to represent decimal numbers so you couldn't use it if you had any cents.
   :feedback_b: The double type can be used to represent an amount of money.
   :feedback_c: Java uses boolean for values that are only true or false.
   :feedback_d: While you can use a string to represent the amount of money you have it is easier to do calculations on the numeric types (int or double).

   What type should you use to represent the amount of money you have?

Operators
---------


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


Casting and Ranges of Values
----------------------------

In Java, **type casting** is used to convert values from one type to another. By
**casting** we don't mean something to do with fishing, but it is a similar idea
to casting a bronze, without needing to heat anything to 913 degrees Celsius.
But like molten bronze is reshaped by melting it and pouring it into a mold, our
data is reshaped via a **cast** operator. In Java when you cast you are changing
the "shape" (or type) of the value.

.. figure:: Figures/bronze-casting.jpg
    :width: 300px
    :figclass: align-center

    Figure 1: Bronze casting changes the shape of the metal.


The **cast operator**, which looks like ``(int)`` and ``(double)`` placed before
any expression—a literal a number, a variable, or more complex expression in
parentheses—produces a value of the given type by converting the value of the
originial expression to the new type.

For example, ``(double) 1 / 3`` will evaluate to a ``double`` value instead of an
``int``. Run this code to find how Java handles division and what casting can do
to the results. Notice what happens when you divide an ``int`` by an ``int`` or
an ``int`` by a ``double`` or an ``int`` cast to a ``double`` divided by an
``int``.

.. activecode:: lcct1
   :language: java
   :autograde: unittest

   What happens when you divide an int by an int or with a double operand or
   with the type cast (double) on one of the operands?

   ~~~~
   public class OperatorTest
   {
       public static void main(String[] args)
       {
           System.out.println(1 / 3);          // int divided by int
           System.out.println(1.0 / 3);        // double divided by int
           System.out.println(1 / 3.0);        // int divided by double
           System.out.println((double) 1 / 3); // int cast to double, divided by int
       }
   }

   ====
   import static org.junit.Assert.*;

   import org.junit.*;

   import java.io.*;

   public class RunestoneTests extends CodeTestHelper
   {
       @Test
       public void testMain() throws IOException
       {
           String output = getMethodOutput("main");
           String expect =
                   "0\n"
                       + "0.3333333333333333\n"
                       + "0.3333333333333333\n"
                       + "0.3333333333333333\n";
           boolean passed =
                   getResults(expect, output, "Expected output from main");
           assertTrue(passed);
       }
   }

When Java divides two ``int``\ s, it produces an ``int`` result by truncating
the actual mathematical result, removing anything after the decimal point. Thus
``9 / 10`` evaluates to ``0``, not ``0.9``. It also does not evaluate to ``1``;
truncating is not the same as rounding!

But in any expression involving a ``double``, the ``double`` is “contagious” and
will cause the value of that expression to also be a ``double``. Thus the
expression ``9.0 / 10`` is evaluated as if it had been written ``9.0 / 10.0``
and produces the ``double`` value ``0.9``.

Casting an ``int`` to ``double``, as shown in the code above, produces a
``double`` value which will then causes any expression it is part of to produce
a ``double``. This is especially useful when you have ``int`` variables that you
want to do non-integer division with:

.. code-block:: java

   int total; // a variable containing the sum of a bunch of ints
   int count; // the number of ints that went into total

   // Compute the average of the bunch of ints summed into total.
   double average = (double) total / count;

A conversion from ``int`` to ``double`` is called a **widening conversion**
because a ``double`` can represent any ``int`` value but not vice versa; thus a
``double`` is considered a wider data type than an ``int``.

.. note::

   ``int``\ s in Java are always 32-bit signed values which mean they can
   represent values from :math:`-2^{31}` to :math:`2^{31} - 1`, inclusive, while
   the range of consecutive integer values that can be represented by a double
   is from :math:`-2^{53}` to :math:`2^{53}`, inclusive. (A ``double`` can also
   represent much larger values but with limited precision.) You can refer to
   the minimum and maximum ``int`` values with the constants
   ``Integer.MIN_VALUE`` and ``Integer.MAX_VALUE``.

Values of type ``double`` in the range that can be represented by an ``int`` can
be rounded to the nearest ``int`` by adding or subtracting 0.5 and then casting
the result with ``(int)``:

.. code-block:: java

    double number;    // positive value from somewhere
    double negNumber; // negative value from somewhere

    int nearestInt = (int)(number + 0.5);
    int nearestNegInt = (int)(negNumber – 0.5);

For example, if you divide ``7.0 / 4.0`` you get ``1.75``. If you cast that to
an ``int``, it will be truncated to ``1``. However if we want to round a
``double`` rather than truncating it, adding ``0.5`` will produce a number that
is above the next integer value if the decimal part is greater than ``0.5``, as
it is here. Then casting *that* value to an ``int`` will truncate down. So in
this case ``1.75 + 0.5`` gives us ``2.25`` which is then truncated to ``2``. On
the other hand adding ``0.5`` to the result of evaluating ``5.0 / 4.2``, namely
``1.25``, only gets us to ``1.75`` which truncates back to ``1`` which is the
nearest integer to ``1.25``.

.. activecode:: nearestInt
   :language: java
   :autograde: unittest

   Run the code below to see how the formula of adding or subtracting .5 and
   then casting with (int) rounds a positive or negative double number to the
   closest int.

   ~~~~
   public class NearestInt
   {
       public static void main(String[] args)
       {
           double number = 5.0 / 3;
           int nearestInt = (int) (number + 0.5);
           System.out.println("5.0/3 = " + number);
           System.out.println("5/3 truncated: " + (int) number);
           System.out.println("5.0/3 rounded to nearest int: " + nearestInt);
           double negNumber = -number;
           int nearestNegInt = (int) (negNumber - 0.5);
           System.out.println(
                   "-5.0/3 rounded to nearest negative int: " + nearestNegInt);
       }
   }

   ====
   import static org.junit.Assert.*;

   import org.junit.*;

   import java.io.*;

   public class RunestoneTests extends CodeTestHelper
   {
       @Test
       public void testMain() throws IOException
       {
           String output = getMethodOutput("main");
           String expect =
                   "5.0/3 = 1.6666666666666667\n"
                       + "5/3 truncated: 1\n"
                       + "5.0/3 rounded to nearest int: 2\n"
                       + "-5.0/3 rounded to nearest negative int: -2\n";

           boolean passed =
                   getResults(expect, output, "Expected output from main", true);
           assertTrue(passed);
       }
   }

.. index::
   pair: double; number of digits


What happens to repeating decimal numbers like 3.333333...?  Java limits the number of digits you can save for any ``double`` number to about 14-15 digits. You should be aware that the accuracy of any calculation on a computer is limited by the fact that computers can only hold a limited number of digits.

For example, int values are stored in 4 bytes of memory. There is an
``Integer.MAX_VALUE`` defined as 2147483647 and an ``Integer.MIN_VALUE`` defined
as -2147483648. If you try to store any number larger or smaller than these
numbers in an int variable, it will result in an **integer overflow** where an
incorrect value could be stored. Try it below.

.. activecode:: overfl
   :language: java
   :autograde: unittest

   Try the code below to see two integer overflows for a positive and negative number. An int cannot hold that many digits! Fix the integer overflow by deleting the last 0 in the numbers to store less digits.
   ~~~~
   public class TestOverflow
   {
       public static void main(String[] args)
       {
           int id = 2147483650; // overflow
           int negative = -2147483650; // overflow
       }
   }
   ====
   import static org.junit.Assert.*;

   import org.junit.*;

   import java.io.*;

   public class RunestoneTests extends CodeTestHelper
   {
       @Test
       public void testMain() throws IOException
       {
           String output = getMethodOutput("main");
           String expect = "214748365\n-214748365\n";

           boolean passed =
                   getResults(
                           expect, output, "Fixed Integer Overflow Error", true);
           assertTrue(passed);
       }
   }

.. index::
   pair: double; precision format

Although it's not on the AP exam, you can format long decimal numbers to just show 2 digits after the decimal point with the following code:

.. activecode:: double_precision
   :language: java
   :autograde: unittest

   Run the code below to see how a decimal number can be formatted to show 2 digits after the decimal point.
   ~~~~
   public class TestFormat
   {
       public static void main(String[] args)
       {
           double number = 10 / 3;
           System.out.println(number);
           System.out.println(String.format("%.02f", number));
       }
   }

   ====
   import static org.junit.Assert.*;

   import org.junit.*;

   import java.io.*;

   public class RunestoneTests extends CodeTestHelper
   {
       @Test
       public void testMain() throws IOException
       {
           String output = getMethodOutput("main");
           String expect = "3.0\n3.00\n";

           boolean passed =
                   getResults(expect, output, "Expected output from main", true);
           assertTrue(passed);
       }
   }

|Exercise| **Check your understanding**

.. mchoice:: q2_5
   :practice: T
   :answer_a: true
   :answer_b: false
   :correct: b
   :feedback_a: Did you try this out in Active Code?  Does it work that way?
   :feedback_b: Java throws away any values after the decimal point if you do integer division.  It does not round up automatically.

   True or false: Java rounds up automatically when you do integer division.

.. mchoice:: q2_6
   :practice: T
   :answer_a: true
   :answer_b: false
   :correct: b
   :feedback_a: Try casting to int instead of double.  What does that do?
   :feedback_b: Casting results in the type that you cast to. However, if you can't really cast the value to the specified type then you will get an error.

   True or false: casting always results in a double type.

.. mchoice:: q2_7
   :practice: T
   :answer_a: (double) (total / 3);
   :answer_b: total / 3;
   :answer_c: (double) total /  3;
   :correct: c
   :feedback_a: This does integer division before casting the result to double so it loses the fractional part.
   :feedback_b: When you divide an integer by an integer you get an integer result and lose the fractional part.
   :feedback_c: This will convert total to a double value and then divide by 3 to return a double result.

   Which of the following returns the correct average for a total that is the sum of 3 int values?

|Groupwork| Programming Challenge : Average 3 Numbers
------------------------------------------------------

This would be a good project to work together in pairs, and switch drivers (who has control of the keyboard in pair programming) after every line of code. In the code below, type in three made up int grades and then sum and average them. Use casting to report the result as a double. For example, if the grades are 90, 100, and 94, the sum of the three numbers is 90 + 100 + 94 = 284, and the average is the sum 284 divided by 3 which casted to a double is 94.666667. You should use your variables instead of the numbers in your formulas. Follow the pseudocode below.


.. activecode:: challenge1-6-average
   :language: java
   :autograde: unittest
   :practice: T

   Type in three made up int grades and then sum and average them. Use type casting to report the result as a double. If you do this challenge on repl.it (see template and links below), please paste your repl link here to turn it in.
   ~~~~
   public class Challenge1_6
   {
       public static void main(String[] args)
       {
           // 1. Declare 3 int variables called grade1, grade2, grade3
           // and initialize them to 3 values

           // 2. Declare an int variable called sum for the sum of the grades

           // 3. Declare a variable called average for the average of the grades

           // 4. Write a formula to calculate the sum of the 3 grades (add them
           // up).

           // 5. Write a formula to calculate the average of the 3 grades from
           // the sum using division and type casting.

           // 6. Print out the average

       }
   }

   ====
   import static org.junit.Assert.*;

   import org.junit.*;

   import java.io.*;
   import java.util.regex.MatchResult;
   import java.util.regex.Pattern;

   /* Do NOT change Main or CodeTestHelper.java.
   Put the active code exercise in a file like ForLoop.java.
   Put your Junit test in the file RunestoneTests.java.
   Run. Test by changing ForLoop.java (student code).
   */

   public class RunestoneTests extends CodeTestHelper
   {
       @Test
       public void test4() throws IOException
       {
           String actual = getMethodOutput("main");
           String expect = "double value";

           boolean passed = actual.matches("[\\s\\S]*[0-9]+.[0-9]+[\\s\\S]*");

           if (!passed)
           {
               getResults(
                       expect,
                       actual,
                       "Checking that output is a double value",
                       passed);
               assertTrue(passed);
               return;
           }

           String code = getCode();
           String regex = "grade[0-9]=[0-9]+";

           String[] matches =
                   Pattern.compile(regex)
                           .matcher(removeSpaces(code))
                           .results()
                           .map(MatchResult::group)
                           .toArray(String[]::new);

           int[] grades = new int[3];

           String hint = "";

           if (matches.length > 3)
           {
               hint = "\n(Did you declare too many grade variables?)";
           }
           else if (matches.length < 3)
           {
               hint = "\n(Did you declare too few grade variables?)";
           }

           for (int i = 0; i < grades.length && i < matches.length; i++)
           {
               String val = matches[i].substring(matches[i].indexOf("=") + 1);
               grades[i] = Integer.parseInt(val);
           }

           double exp =
                   (double) (grades[0] + grades[1] + grades[2]) / matches.length;

           passed =
                   getResults(
                           "" + exp,
                           actual,
                           "Checking that calculation is correct" + hint);
           assertTrue(passed);
       }

       @Test
       public void test1() throws IOException
       {
           String code = removeSpaces(getCode());

           String expect = "Declared grade1, grade2, grade3, and average";
           String actual = "";
           String hint = "";

           boolean passed = true;

           String regex = "grade[1-3]=[0-9]+";

           String[] matches =
                   Pattern.compile(regex)
                           .matcher(removeSpaces(code))
                           .results()
                           .map(MatchResult::group)
                           .toArray(String[]::new);

           if (matches.length != 3)
           {
               passed = false;
               actual += "Declared " + matches.length + " grade variables\n";
           }

           if (!code.contains("doubleaverage"))
           {
               passed = false;
               actual += "Did not declare average as a double";
           }

           if (!passed)
           {
               hint = "\n(Check spelling and capitalization)";
           }
           else
           {
               actual = expect;
           }

           getResults(
                   expect,
                   actual.trim(),
                   "Checking that variables have been declared properly" + hint,
                   passed);
           assertTrue(passed);
       }

       @Test
       public void test3() throws IOException
       {
           String code = getCode();
           String[] lines = code.split("\n");

           String expect = "(double)";
           String actual = "Cast expression as a double";

           boolean passed = false;

           if (!code.contains("(double)"))
           {
               passed = false;
               actual = "no (double)";
           }

           for (int i = 0; i < lines.length; i++)
           {
               String line = lines[i];

               if (line.contains("(double)"))
               {
                   passed = true;
                   actual = line.trim();
                   break;
               }
           }

           getResults(
                   expect,
                   actual,
                   "Checking that expression was cast as a double",
                   passed);
           assertTrue(passed);
       }

       @Test
       public void test2() throws IOException
       {
           String codeAll = getCode();
           String[] lines = codeAll.split("\n");

           String expect = "grade1 + grade2 + grade3\nsum / 3";
           String actual1 = "", actual2 = "";
           String hint = "";

           boolean passed = false;

           String regex = "grade[1-3]+\\+grade[1-3]+\\+grade[1-3]";

           for (int i = 0; i < lines.length; i++)
           {
               String code = lines[i];
               String noSpaces = removeSpaces(code);

               if (noSpaces.matches("[\\s\\S]*" + regex + "[\\s\\S]*"))
               {
                   passed = true;
                   actual1 = code.trim();
                   break;
               }
           }

           regex = "/3";

           for (int i = 0; i < lines.length; i++)
           {
               String code = lines[i];
               String noSpaces = removeSpaces(code);

               if (noSpaces.matches("[\\s\\S]*" + regex + "[\\s\\S]*"))
               {
                   passed = true;
                   actual2 = code.trim();
                   break;
               }
           }

           String actual = "No such expressions";

           if (actual1.length() > 0 || actual2.length() > 0)
           {
               actual = (actual1 + "\n" + actual2);
           }

           if (!passed)
           {
               hint = "\n(Check spelling and capitalization)";
           }

           getResults(
                   expect,
                   actual,
                   "Checking that grades have been added together and divided by"
                       + " 3"
                           + hint,
                   passed);
           assertTrue(passed);
       }
   }

.. |repl| raw:: html

   <a href="https://replit.com" target="_blank">replit</a>


.. |Scanner| raw:: html

   <a href="https://www.w3schools.com/java/java_user_input.asp" target="_blank">Scanner class</a>

.. |repl template| raw:: html

   <a href="https://firewalledreplit.com/@BerylHoffman/Challenge1-6-Average-Template#Main.java" target="_blank">repl template</a>

Your teacher may suggest that you use a Java IDE like |repl| for this challenge so that you can use input to get these values using the |Scanner|. Here is a |repl template| that you can use to get started if you want to try the challenge with input.


.. |Unicode| raw:: html

   <a href="https://en.wikipedia.org/wiki/List_of_Unicode_characters" target="_blank">Unicode</a>

.. |Chinese character| raw:: html

   <a href="https://unicodelookup.com/#cjk/1" target="_blank">Chinese character</a>

.. |Unicode Lookup| raw:: html

   <a href="https://unicodelookup.com/" target="_blank">Unicode Lookup</a>

.. |emoji| raw:: html

   <a href="http://unicode.org/emoji/charts/full-emoji-list.html" target="_blank">emoji</a>

Bonus Challenge : Unicode
-------------------------------------

If you get done early with the previous challenge, here's something else fun you
can do in Java, although it's not covered in the AP exam.

Java was one of the first programming languages to use |UNICODE| for its
characters rather than ASCII. While ASCII could represent 128 characters which
was plenty for English, Unicode is an international standard that tries to
assign a number (which they like to call a “codepoint”) to every character in
every language. Unicode codepoints are traditionally represented in hex code (a
base 16 code that uses the digits 0-9 and the letters A-F for 10-15), so you
might see things like ``U+1F600``. But they’re just numbers. That last one is
the same as ``128512``.

When Java was released in an 1996, Unicode had been around for five years and
the Unicode people had declared they would only ever need 2\ :sup:`16` or 65,536
code points to represent all the characters used in the world. So Java included
a ``char`` data type that can hold exactly 2\ :sup:`16` values. Then, seven
months later, the Unicode folks, said, “Ooops, that’s not enough”, and extended
their system to its current size of 1,112,064 possible codepoints. (As of
September 2022, 149,186 have actually been used.)

That made ``char`` kind of obsolete. But while not every Unicode codepoint can
be represented in a Java ``char``, you can use an ``int`` to represent a
codepoint and the method ``Character.toString`` to translate an ``int`` into a
``String`` containing the character for that codepoint. (You might see older
Java code that casts numbers to ``char``; for many codepoints that will work but
not on more recently added codepoints including, critically those for Emoji. 😞
So better to use ``Character.toString`` and ignore ``char``.)

Try the following program which prints out an English “A”, a
|Chinese character|, and an |emoji|. Then look up other characters at this
|Unicode Lookup| site and change the code to print them out. (Use the Dec column in site
to get the decimal number.) Can you print out letters from 3 different
languages?

.. activecode:: challenge1-6-unicode
   :language: java
   :autograde: unittest

   Can you print out a letter from 3 different languages using this |Unicode
   Lookup| site?

   ~~~~
   public class ChallengeUnicode
   {
       public static void main(String[] args)
       {
           System.out.println(
                   "'A' in ASCII and Unicode: " + Character.toString(65));
           System.out.println("Chinese for 'sun': " + Character.toString(11932));
           System.out.println("A smiley emoji: " + Character.toString(128512));

           // Old style. Doesn't work for all codepoints.
           System.out.println("This also works: " + (char) 65);
           System.out.println("But this doesn't: " + (char) 128512);
       }
   }

   ====
   import static org.junit.Assert.*;

   import org.junit.*;

   import java.io.*;

   public class RunestoneTests extends CodeTestHelper
   {
       @Test
       public void testCount()
       {
           String code = getCodeWithoutComments();
           int count = countOccurences(code, "Character.toString");
           boolean passed = count >= 4;
           passed =
                   getResults(
                           "4+",
                           "" + count,
                           "Counting number of Character.toString",
                           passed);
           assertTrue(passed);
       }
   }

Summary
-------------------

- **Type casting** is used to convert value from one type to another.

- The casting operators ``(int)`` and ``(double)`` can be used to create a
  temporary value converted to a different data type.

- Casting a ``double`` value to an ``int`` causes the digits to the right of the
  decimal point to be truncated (cut off and thrown away).

- In expressions involving ``double``\ s, the ``double`` values are contagious,
  causing ``int``\ s in the expression to be automatically converted to the
  equivalent ``double`` value so the result of the expression can be computed as
  a ``double``.

- Values of type ``double`` can be rounded to the nearest integer by (int)(x +
  0.5) or (int)(x – 0.5) for negative numbers.

- Integer values in Java are represented by values of type ``int``, which are
  stored using a finite amount (4 bytes) of memory. Therefore, an int value must
  be in the range from ``Integer.MIN_VALUE`` to ``Integer.MAX_VALUE``,
  inclusive.

- If an expression would evaluate to an int value outside of the allowed range,
  an integer overflow occurs. This could result in an incorrect value within the
  allowed range.
