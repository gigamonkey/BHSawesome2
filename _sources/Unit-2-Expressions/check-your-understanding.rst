Check your understanding
========================

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
