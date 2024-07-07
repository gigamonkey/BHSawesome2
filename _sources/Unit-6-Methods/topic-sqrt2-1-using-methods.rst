.. include:: ../common.rst

.. qnum::
   :prefix: √2-1-
   :start: 1

|Time90|

Using Methods
=============

Computer programs, as you’ll discover, can get rather complex. Large programs
may consist of millions of lines of code, all of which have to connect to each
other in just the right way for the program to work. Compare that to a novel,
which might be only a few hundred thousand words and is still perfectly readable
even if the author misplaced a semicolon. Yet people manage to write those large
programs. How can human beings possibly deal with that kind of complexity?

**Abstraction** is the main tool we have to keep complexity under control.
Abstraction gets a bad rap in our culture, often being considered synonymous
with “hard to understand” as in abstract math or abstract theoretical physics.
But abstraction really just means “hiding details” and we use abstractions all
the time without even realizing it.

When you learn to drive, you learn how to use a steering wheel and the brake and
accelerator pedals. But your drivers ed instructor will almost certainly not
teach you about how a rack and pinion turns the wheels or how tiny explosions in
the car’s engine make it go. Most of the details are *abstracted* away. A car
mechanic needs to understand them but as a driver you can deal with the car in
terms of a much simpler set of concepts like press the gas to make the car go.

Abstraction is a powerful tool that will appear over and over as you learn to
program. In this chapter we are going to talk about **procedural abstraction**
which just means hiding the details of *how* something gets done so we can focus
instead on *what* the procedure achieves.

Procedures go by many names in different programming languages: functions,
subroutines, commands, or even procedures. In Java they are called **methods**,
as in a method of doing something.

In this section we are going to talk about using already existing methods as
useful abstractions. In the next section we'll learn how to write new methods
and create our own abstractions.

What is a Method?
-----------------

.. image:: Figures/Toaster.png
    :width: 100px
    :align: left
    :alt: Toaster

One way to think of a method is as a little machine that does something.
Consider a toaster. You put bread in the toaster and turn it on and a little
while later you get a piece of toast. Toasters don’t make toast without bread
but they can make toast out of any kind of bread that fits in the toaster.

And even a lowly toaster is a kind of abstraction. While you probably have some
rough idea of how a toaster works on the inside, as with a car you don't have to
know how it works to use it. All you have to know is, you put the bread in, you
press the button, and a little while later your toast pops out.

The other thing about a toaster is you only need one—you don’t need to get a new
toaster every time you want to make a piece of toast. Once you’ve got a toaster
you can use it to make all the toast you want.

Methods are similar. Most methods, like the toaster, require some inputs, which
we call **arguments**, and then either produce an effect in the world or compute
a value based on the arguments. Effects can be things like printing on the
screen and computed values can be anything a computer can represent, numbers,
booleans, images, videos, the text of a novel, models of the universe—pretty
much anything.

Methods also hide, i.e. abstract, the details of what exactly they are doing
which lets us write code without having to worry about those details. And once
you’ve got a method that does something useful, you can use that method whenever
you need to do that thing, rather than writing out the same code over and over.

Two methods we’ve used so far in this book are ``System.out.println`` and
``System.out.print``. Their job is to take a value and print it to the screen,
either with or without a new line at the end. They both abstract the actual
process of turning the value into a textual representation and then causing that
text to be displayed on the screen. There’s a lot of things that have to happen
under the covers to make that text come out on the screen but thankfully we
don’t have to know any more about that than we have to know about how pressing
on a car’s accelerator makes it go.

Now let’s consider the other kind of method, those that compute new values from
their arguments. We'll start with some methods from the ``Math`` class that
comes with Java but remember that methods are useful for all kinds of
computation, not just doing math.

A simple example of this kind of method from ``Math`` is the ``sqrt`` method.
``Math.sqrt`` takes a ``double`` argument and **returns** a ``double`` value
which is square root of the argument. We say that the **return type** of
``sqrt`` is ``double``. For example, the square root of 9 is 3 because 3 squared is 9.

.. note::

  ``Math.sqrt`` is a static method, sometimes called a class method. The name of
  the method is just ``sqrt`` but we refer to it with the name of the class
  where it is defined, ``Math``, followed by a dot (``.``) followed by the name.
  If you write a static method in your own class, as you will do later in this
  unit, you can call the method using just the name of the method.

Methods that return a value typically don’t have any observable effect when
they are called—nothing shows up on the screen; no lights blink, no bleeps or
bloops are emitted—they just produces a new value that you need to something
with like assigning it to a variable. For instance, we might use ``sqrt`` like
this:

.. code-block:: java

   double root = Math.sqrt(2);

After this assignment, ``root`` will have the value ``1.4142135623730951`` which
is the ``double`` value that most closely approximates the value of the square
root of 2. (If you remember your 8th grade math, you know that the square root
of 2 is a irrational number, meaning its decimal representation is infinite.
Since ``double``\ s have to be represented in a finite amount of memory we have
to live with the approximation. If you *don’t* remember that fact from 8th
grade, perhaps your 8th grade math teacher neglected to tell you that the Greek
mathematician who proved that the square root of 2 is irrational was, according
to legend, drowned at sea by a bunch of other Greek mathematicians who were
outraged at the notion that any numbers could not be represented using ratios.
That story probably would have stuck in your head.)

You could also use the value returned by a method as the argument to another
method. For instance, if you wanted to print the square root of two you could
write:

.. code-block:: java

   System.out.println("The square root of 2 is: " + Math.sqrt(2));

If ``System.out.println`` is a car, using all kinds of machinery under the hood
to make it go, ``Math.sqrt`` is maybe more like a toaster. It's not a total
mystery how it works but few of us probably know off the top of our head how to
compute arbitrary square roots efficiently. So it sure is convenient that Java
provides this method for us. (In fact, the source code for ``sqrt`` in the JDK
is over 100 lines of pretty hairy math code.)

Calling Methods
---------------

The main thing we can do with a method is **call** it. Calling a method is how
we get the code in the method to run, either to produce an effect or to compute
a value. There are several examples above of calling both ``println`` and
``sqrt`` but to spell it out, a call to a method is made up of the name of the
method followed by a pair of parentheses. In between the parentheses is a
comma-separated list of expressions, one for each parameter defined in the
method declaration.

Thus when we want to use a method that computes a value we need to know four
things:

- Its name.

- What arguments it expects.

- What type of value it returns.

- How the returned value is related to the arguments.

If you look back to the earlier description of ``Math.sqrt``, you’ll see it
includes exactly that information: “``Math.sqrt`` takes a ``double`` argument
and returns a ``double`` value which is square root of the argument.” (If you
look at the official documentation you’ll see they are even more precise: it is
documented to return the “correctly rounded positive square root of a double
value.”)

All the methods we’ve talked about so far only take one argument so the argument
lists only contain one expression. In a moment we’ll learn about some methods
that take more than one argument and also one that takes no arguments.

|Exercise| **Check Your Understanding**

.. mchoice:: correct-calls

   Knowing that ``Math.sqrt`` takes a single argument, Which of these are
   syntactically correct method calls to ``sqrt``?

   - ``Math.sqrt(2)``

     + ✅ This is a simple call to ``Math.sqrt`` with the argument 2.

   - ``Math.sqrt()``

     - ❌ ``Math.sqrt`` takes one argument. This would be a correct call if it took no arguments.

   - ``Math.sqrt(2, 4)``

     - ❌ ``Math.sqrt`` takes one argument. This would be a correct call if it took two arguments.

   - ``Math.sqrt(2 + 3)``

     + ✅ The argument passed to ``Math.sqrt`` is the value of the expression 2 + 3, namely 5.

   - ``Math.sqrt 2``

     - ❌ You must have parentheses around the arguments.

   - ``Math.sqrt(Math.sqrt(2))``

     + ✅ The argument passed to ``Math.sqrt`` is the value of *another* call to
       ``Math.sqrt`` which is perfectly fine.

Note that some methods take no arguments but when you call them you still need
an empty pair of parentheses. It's a common beginner mistake to leave the
parentheses off a method call that takes no arguments. ``System.out.println``
can, in fact be called with no arguments to just print a blank line. With that
in mind, compare these two lines of code:

.. code-block:: java

   System.out.println(); // ✅ Good - prints a blank line
   System.out.println;   // ❌ No good - will give you a compile error.

Other ``Math`` methods - ``abs`` and ``pow``
--------------------------------------------

.. image:: Figures/pow.png
    :width: 100px
    :align: left
    :alt: Pow!

``Math.sqrt`` is just one of many static methods in the ``Math`` class. Several
other ``Math`` methods are part of the AP subset in addition to ``sqrt``:
``abs``, ``pow``, and ``random``. And if you need to do complex mathematical
computations in a program you are writing, you should take a look at what else
is in ``Math``—it might have just what you need. You can read about all the
methods in the `Javadocs
<https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html>`_.

.. |AP CSA Reference Sheet| raw:: html

   <a href="https://apstudents.collegeboard.org/ap/pdf/ap-computer-science-a-java-quick-reference_0.pdf" target="_blank">AP CSA Java Quick Reference Sheet</a>

.. note::

   All the ``Math`` methods that you may need to use or understand on the AP
   exam are listed in the |AP CSA Reference Sheet| that you can use during the
   exam.

You may be able to guess what ``abs`` and ``pow`` do, if you can decipher the
abbreviations. ``Math.abs`` takes a single argument, either a ``double`` or an
``int`` and returns a value of the same type which is the absolute value of the
argument. The absolute value of a number is its positive value without its sign. You can also think of it as the  distance the number is from 0. So:

.. code-block:: java

   Math.abs(45);    // returns 45
   Math.abs(-45);   // returns 45
   Math.abs(33.3);  // returns 33.3
   Math.abs(-33.3); // returns 33.3

The next method ``Math.pow`` takes two arguments, both ``double``\ s, and
returns a ``double`` which is the first argument raised to the power of the
second argument.

.. code-block:: java

   Math.pow(2 , 3); // returns 8.0
   Math.pow(10, 6); // returns 1000000.0
   Math.pow(2, -3); // returns 0.125

|Exercise| **Check Your Understanding**

.. mchoice:: bhsawesome-distance-mc
   :multiple_answers:
   :random:

   The distance between two numbers on the number line is defined as the
   absolute value of their difference. Their difference is just what you get
   when you subtract one from the other. For example, the distance from 0 to 3
   is 3 because the difference is either 3 or -3 depending on whether we
   subtract 0 from 3 or 3 from 0. Similarly, the distance from -3 to 1 is 4,
   the absolute value of either -4 or 4.

   .. image:: Figures/number-line.svg
      :width: 500px
      :align: center
      :alt: number line

   Which of the following are correct expressions to compute the distance
   between the numbers ``a`` and ``b``.

   - ``Math.abs(a - b)``

     + ✅ ``a - b`` gives us the difference and ``Math.abs`` gives us the
       absolute value of that difference.

   - ``Math.abs(a) - Math.abs(b)``

     - ❌ Consider the distance between -2 and 3. It should be five. What value
       would this expression produce in that case?

   - ``Math.abs(a + b)``

     - ❌ We need to start with the difference between ``a`` and ``b``, not their sum.

.. mchoice:: bhsawesome-hypotenuse-mc
   :multiple_answers:
   :random:

   The Pythagorean theorem tells us that the length of the hypotenuse (the side
   opposite the right angle in a right triangle) is the square root of the sum
   of the squares of the lengths of the other two sides, also called the “legs”
   of the triangle. In other words :math:`c = \sqrt{a^{2} + b^{2}}` where
   :math:`a` and :math:`b` are the lengths of the legs and :math:`c` is the
   length of the hypotenuse. (Incidentally, the Pythagorean theorem is named for
   Pythagoras who was also the leader of the gang of Greek mathematicians who
   allegedly drowned their fellow mathematician for showing that
   :math:`\sqrt{2}` is irrational.)

   Which of the following are a correct expression to compute the hypotenuse of
   a triangle with legs ``a`` and ``b``?

   - ``Math.sqrt(a * a + b * b)``

     + ✅ ``a * a`` is a squared, likewise ``b * b``. Adding them with ``+``
       gives us the sum which is then passed to ``Math.sqrt``.

   - ``Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2))``

     + ✅ ``Math.pow(a, 2)`` is ``a`` squared, likewise ``Math.pow(b, 2)``.
       Adding them with ``+`` gives us the sum which is then passed to
       ``Math.sqrt``.

   - ``Math.sqrt(a + b)``

     - ❌ Close, but we need to square the lengths of the legs.

   - ``a * a + b * b``

     - ❌ This is the sum of the squares of the lengths of the legs which gives
       us the square of the hypotenuse. We need a ``Math.sqrt`` to get the
       length of the hypotenuse.

Other ``Math`` methods - ``random``
-----------------------------------

.. image:: Figures/dice.png
    :width: 100px
    :align: left
    :alt: Dice

The ``Math.random`` method is a bit of an odd duck. It takes no arguments and
each time it is called returns an essentially random ``double`` value that is
greater than or equal to 0 and less than 1. (Technically the numbers returned
are called “pseudo random numbers” since they are not actually truly random,
being generated by a deterministic computer program.) It’s not a method like
``println`` that is called purely for an effect, but it’s also not a method like
``sqrt`` or ``pow`` that returns a value computed purely from its arguments—it
doesn’t even take any arguments! Maybe rather than an odd duck it’s a platypus,
a mammal that lays eggs.

What’s going on is there a hidden value that is used to determine what number is
returned each time ``random`` is called and ``random`` changes that value each
time it is called so the next time it is called it will return a new
unpredictable number.

There are lots of uses for random numbers in programs. Games often use random
numbers to generate different possibilities and there are many kinds of
simulations that depend on randomly generating possible outcomes.

For some applications you may need to use other, more special purpose sources of
randomness but for simple cases, ``Math.random`` is just the thing, so it’s
handy to know a few recipes for generating various kinds of random numbers
starting from the random output of ``Math.random``.

Before we start, let’s introduce one very handy bit of terminology that you may
or may not have heard of before. When we talk about ranges of numbers sometimes
we need to be precise about whether the ends of the range are part of the range.
For example, ``Math.random`` returns a number between 0.0 and 1.0, but does that
mean it can return exactly 0.0? Or exactly 1.0? As it turns out it can return
0.0 but never returns 1.0.

When we need to be precise about this we’d say that it returns a number between
0.0, *inclusive*, and 1.0, *exclusive*, meaning *include* 0.0 but *exclude* 1.0.
Lots of ranges in Java are expressed this way, as you’ll see later on with an
inclusive bottom and an exclusive top.

With that out of the way, let’s take a look at the values we get from just
calling ``Math.random``:

|CodingEx| **Coding Exercise**

.. activecode:: bhsawesome-random-example
   :language: java
   :autograde: unittest

   Try out the following code. Run it several times to see what it prints each
   time.

   ~~~~
   public class JustRandom
   {
       public static void main(String[] args)
       {
           System.out.println(Math.random());
           System.out.println(Math.random());
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
           String expect = output;
           boolean passed = getResults(expect, output, "Expected output from main", true);
           assertTrue(passed);
       }
   }

Getting a number between 0.0, inclusive, and 1.0, exclusive, may not seem all
that useful. But we can expand the range easily enough. To see how, imagine you
had less than a dollar to your name and you wanted to be richer—you’d want to
find a way to **multiply** your money. If you could invest every penny you had
in something that would multiply your money by 1,000, then instead of having
somewhere between $0 and $1 you’d have somewhere between $0 (inclusive—if you
started with $0) and $1,000 (exclusive, since if you had even a fraction of a
penny less than $1 multiplying by 1,000 would still leave you just a bit shy of
$1,000.) If the investment multiplied your original money by a million, you’d
have between $0 and $1,000,000! (But never *quite* $1,000,000.)

Same trick applies to random numbers. The value ``Math.random`` returns is like
the initial amount of money in your pocket, always a bit less than $1. If you
multiply that value by any amount, it will stretch it into the range you want:

|CodingEx| **Coding Exercise**

.. activecode:: bhsawesome-random-example-stretched
   :language: java
   :autograde: unittest

   Try out the following code. Run it several times to see what it prints each
   time. Did you ever see 0.0? How about 10.0?

   ~~~~
   public class StretchedRandom
   {
       public static void main(String[] args)
       {
           System.out.println(Math.random() * 10);
           System.out.println(Math.random() * 10);
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
           String expect = output;
           boolean passed = getResults(expect, output, "Expected output from main", true);
           assertTrue(passed);
       }
   }

You may have noticed that while the numbers generated were always in the range
0.0 to 10.0, all the numbers probably had a lot a digits after the decimal
point. Often we want a random integer, with nothing after the decimal point.
Easy enough—recall that casting a ``double`` to an ``int`` will throw away any
values after the decimal point.

|CodingEx| **Coding Exercise**

.. activecode:: bhsawesome-random-example-stretched-and-cast
   :language: java
   :autograde: unittest

   Try out the following code. Run it several times to see what it prints each
   time.

   What happens if you take away the parentheses around ``(Math.random() *
   10)``? Does it change the kinds of numbers that are printed? Can you explain
   why?

   Also, does this program ever print ``10``? Why or why not?

   ~~~~
   public class StretchedRandomInt
   {
       public static void main(String[] args)
       {
           System.out.println((int)(Math.random() * 10));
           System.out.println((int)(Math.random() * 10));
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
           String expect = output;
           boolean passed = getResults(expect, output, "Expected output from main", true);
           assertTrue(passed);
       }
   }

Finally, what if we want a number in a range that doesn’t start with 0, say a
number from 1 to 10 (including 10) instead of from 0 to 9 (including 9)? Since
the size of the two ranges is the same, with ten numbers in each, all we need to
do is shift from the range we’ve generated into the range we want. In other
words, add the difference between the two ranges, 1 in this case.

|CodingEx| **Coding Exercise**

.. activecode:: bhsawesome-random-shifted-range
   :language: java
   :autograde: unittest

   The code below generates numbers in the same range as the previous, 0-9,
   inclusive.

   Run it several times to convince yourself that’s true.

   Then modify the code to change the range generated to be 1-10, inclusive. Run
   it enough times to convince yourself it never returns 0 and does return 10.

   ~~~~
   public class StretchedShiftedRandomInt
   {
       public static void main(String[] args)
       {
           System.out.println((int)(Math.random() * 10));
       }
   }

   ====
   import static org.junit.Assert.*;

   import org.junit.*;

   import java.io.*;

   public class RunestoneTests extends CodeTestHelper
   {
       @Test
       public void testContainsRange() throws IOException
       {
           String target = "+ 1";
           boolean passed = checkCodeContains("Math.random in range 1 to 10", target);
           assertTrue(passed);
       }
   }

So the general recipe for generating a random is to first stretch the value from
``Math.random()`` until it’s in the right size range by multiplying by the size
of the range. Then if you want an integer value, cast to ``int`` to discard the
part after the decimal point. Then shift the value up by adding the minimum
value. The table below shows some applications of that general recipe.

.. rst-class:: random-recipes

   .. list-table:: Random recipes
      :widths: 55 15 15 15
      :header-rows: 1

      * - Expression
        - Minimum (inclusive)
        - Maximum (exclusive)
        - Possible values
      * - ``Math.random()``
        - 0.0
        - 1.0
        - Over 9 quadrillion
      * - ``Math.random() * 100``
        - 0.0
        - 100.0
        - Over 9 quadrillion
      * - ``(int)(Math.random() * 100)``
        - 0
        - 100
        - 100
      * - ``(int)(Math.random() * 50) + 25``
        - 25
        - 75
        - 50
      * - ``(int)(Math.random() * 11) - 5``
        - -5
        - 5
        - 11
      * - ``(int)(Math.random() * max)``
        - 0
        - max
        - max
      * - ``(int)(Math.random() * range) + min``
        - min
        - min + range
        - range
      * - ``(int)(Math.random() * (max - min)) + min``
        - min
        - max
        - max - min


|Exercise| **Check your understanding**

.. mchoice:: bhsawesome-qrand_1
   :practice: T
   :answer_a: Math.random() < 0.4
   :answer_b: Math.random() >= 0.4
   :answer_c: Math.random() == 0.4
   :correct: a
   :feedback_a: This is true about 40% of the time since Math.random returns a value from 0 to not quite 1.
   :feedback_b: This will be true about 60% of the time.
   :feedback_c: Do not use == with double values!  Remember that Math.random can return any number between 0 and not quite 1 (about .99999999).

   Which of the following would be true about 40% of the time?

.. mchoice:: bhsawesome-qrand_2
   :practice: T
   :answer_a: ((int) (Math.random() * 5))
   :answer_b: ((int) (Math.random() * 6))
   :answer_c: ((int) (Math.random() * 5) + 1)
   :correct: c
   :feedback_a: This would be a number between 0 and 4.
   :feedback_b: This would be a number between 0 and 5.
   :feedback_c: The first part would return a number between 0 and 4 and when you add 1 you get a number from 1 to 5 inclusive.

   Which of the following would return a random number from 1 to 5 inclusive?

.. mchoice:: bhsawesome-qrand_3
   :practice: T
   :answer_a: ((int) (Math.random() * 10))
   :answer_b: ((int) (Math.random() * 11))
   :answer_c: ((int) (Math.random() * 10) + 1)
   :correct: b
   :feedback_a: This would be a number between 0 and 9.
   :feedback_b: This would be a number between 0 and 10.
   :feedback_c: The first part would return a number between 0 and 9 and when you add 1 you get a number from 1 to 10 inclusive.

   Which of the following would return a random number from 0 to 10 inclusive?

.. mchoice:: bhsawesome-qrand_4
   :practice: T
   :answer_a: Math.random() < 0.25
   :answer_b: Math.random() >= 0.25
   :answer_c: Math.random() == 0.25
   :correct: b
   :feedback_a: This is true about 25% of the time, since it will be a number from 0 to not quite 1.
   :feedback_b: This is true about 75% of the time, since it will be a number from 0 to not quite 1.
   :feedback_c: Do not use == with double values!  Remember that Math.random can return any number between 0 and not quite 1 (about .99999999).

   Which of the following would be true about 75% of the time?

|Exercise| **AP CSA Sample Problem**

.. mchoice:: bhsawesome-apcsa_sample3
   :practice: T
   :answer_a: int rn = (int) (Math.random() * 25) + 36;
   :answer_b: int rn = (int) (Math.random() * 25) + 60;
   :answer_c: int rn = (int) (Math.random() * 26) + 60;
   :answer_d: int rn = (int) (Math.random() * 36) + 25;
   :answer_e: int rn = (int) (Math.random() * 60) + 25;
   :correct: d
   :feedback_a: Remember that (int)(Math.random()*range) + min moves the random number into a range starting from a minimum number. We want the minimum number to be 25, but the minimum number here would be 36.
   :feedback_b: Remember that (int)(Math.random()*range) + min moves the random number into a range starting from a minimum number. We want the minimum number to be 25, but the minimum number here would be 60.
   :feedback_c: Remember that (int)(Math.random()*range) + min moves the random number into a range starting from a minimum number. Here the min is 25. We want the minimum number to be 25, but the minimum number here would be 60.
   :feedback_d: Yes, (int)(Math.random()*36) + 25 moves the random number into a range of 36 numbers starting from a minimum number 25 up to 60. The range is (max number - min number + 1) which is (60-25 +1) = 36.
   :feedback_e: This would give us random numbers from 25 to 85. Remember that you can compute the range you need with (max number - min number + 1).

   Which of the following statements assigns a random integer between 25 and 60, inclusive, to ``rn``?

Summary
-------------------

- **Abstraction** means hiding details. **Procedural abstraction** means hiding
  the details of how a procedure is performed and so we can focus on what it
  achieves.

- A **method** in Java either computes a value or has some effect, such as
  printing to the screen.

- **Static methods** can be referenced using the name of the class they are
  defined in, a dot, and the name of the method, e.g. ``Math.sqrt`` to reference
  the ``sqrt`` method defined in the class ``Math``.

- The following static ``Math`` methods are part of the |AP CSA Reference Sheet|:

  - ``int abs(int)``\ : Returns the absolute value of an int value (which means
    no negatives).

  - ``double abs(double)``\ : Returns the absolute value of a double value.

  - ``double pow(double, double)``\ : Returns the value of the first parameter
    raised to the power of the second parameter.

  - ``double sqrt(double)``\ :  Returns the positive square root of a double value.

  - ``double random()``\ : Returns a double value greater than or equal to 0.0
    and less than 1.0 (not including 1.0)!

- The values returned from ``Math.random`` can be manipulated to produce a
  random ``int`` or ``double`` in a desired range.
