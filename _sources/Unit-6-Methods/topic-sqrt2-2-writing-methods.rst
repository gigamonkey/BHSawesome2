.. include:: ../common.rst

.. qnum::
   :prefix: √2-2-
   :start: 1

|Time45|

Writing Methods
===============

Using existing methods, as we did in the previous section, can be very powerful
and Java comes with a rich library of methods for you to use which have been
implemented very carefully and extensively tested. You should use them when you
can.

But you will also spend a lot of your time as a Java programmer writing your own
methods in order to create your own abstractions. Writing methods lets us break
programs up into understandable chunks whose details we don't have to keep in
mind all the time. This is incredible important because the human mind has a
limited amount of working memory; if we try to keep too many details in mind all
at once, we quickly become overwhelmed.

The Method Signature
-------------------------

As you may recall from Unit 1, when we define a variable we need to provide the
type of the variable and give the variable a name. We can also initialize the
variable when we declare it by assigning it a value. To review, here are two
variable declarations. One with and one without an initialization:

.. code-block:: java

   int count = 0;  // Declaring and initializing a variable of type int named count
   String message; // Declaring a variable of type String named message

Defining a method is similar except that we have to both **declare** the method,
specifying its type and name and define it by providing the code that says what
the method does. However the type of a method is more complicated than the type
of a variable. It includes both the type of value the method returns (or
``void`` if it returns no value) and the types of arguments it takes.

Thus the basic structure of a method definition consists of two parts: the
**method signature** that tells us what we need to know to call the method and
the **method body** which contains the code that runs when the method is called.

The main parts of the method signature are return type, the name, the parameter
list.

.. code-block:: java

   double sqrt(double n)

The actual ``sqrt`` method in ``Math`` is a public method which means it can be
invoked from any code and—as we discussed in the previous section—also a static
method, which allows us to reference it as ``Math.sqrt``. So the actual
signature of ``sqrt`` would look like this:

.. code-block:: java

   public static double sqrt(double n)

Reading the signature from left to right, the ``public static`` are called
**modifiers** and they tell us that the method can be called from any class and
that it is static so we can call it like ``Math.sqrt(2)``.

Then, the first ``double`` is the **return type**, which tells both the compiler
and humans reading this code what kind of value this method produces. Then comes
the name of the method: ``sqrt``. The names of methods have to follow the same
rules as for the names of variables: they must consist of just letters and
numbers and must start with a letter.

Following the name is a **parameter list** enclosed in parentheses (``()``).
Each element of this list is a variable declaration, i.e. a type name and then a
name for the parameter. In this method there is only one parameter, a ``double``
parameter named ``n`` which presumably stands for “number”.

For now all the methods you will be asked to write will be public static methods
so you will mark them with ``public static`` before the return type.

Writing Methods that Compute Values
------------------------------------

Now, in order to see how the body fits in, let’s look at a simple method that
takes an ``int`` value and returns an ``int`` whose value is twice the argument.

.. code-block:: java

   public static int doubled(int n)
   {
       return n * 2;
   }

The method signature is similar to the signature for ``sqrt`` except the
method name is obviously different and the return type and argument type is
``int`` instead of ``double``. (Note, however, that the rules for variable and
method names also say that they cannot be any of Java’s special **keywords**.
Since the names of primitive types are keywords we can't call this method
``double`` since that’s the name of a type.)

Finally we get to the **body** of the method, which is always enclosed in a pair
of curly braces (``{}``). In the body we can write whatever code we want and can
refer to the variables defined in the parameter list. The only requirement is
that the body return a value of the correct type using a ``return`` statement.

In this case that means we need to return an ``int``. To return a value we use a
**return statement** which consists of the word ``return`` followed by an
expression that will produce the value to be returned. As you can see in this
method, the code in the method body can refer to the variables defined in the
method’s parameter list. The expression in the return statement ``n * 2`` means,
multiply the value passed to this method by 2. Since ``n`` was declared to be an
``int`` and ``2`` is an ``int`` and multiplying two ``int``\ s gives us another
``int``, this clearly satisfies the requirement to return an ``int``. (Phew,
that’s a lot of ``int``\ s.)

Note that when we say “compute”, that doesn’t have to mean math. As you saw in
the previous unit, we can also compute with strings of text. And we can write
methods that compute with strings just as easily as we can write mathematical
methods. For instance this method computes the value of a greeting given a name.

.. code-block:: java

   public static String greeting(String name)
   {
       return "Hello, " + name + ".";
   }

This method tells you how many of some kind of item you have:

.. code-block:: java

   public static String howMany(int count, String what)
   {
       return "I have " + count + " " + what + "s.";
   }

(This method will produce funny output of the value of the ``what`` parameter is
not a word pluralized by adding “s” or if ``count`` is 1. Later, when you learn
about ``if`` statements, you’ll be able to write a better version of this
method.)

|CodingEx| **Coding Exercises**
------------------------------

.. activecode:: bhsawesome-doubled
   :language: java

   To actually be able to call a method, we need to put it in a class. Until now
   the only method we’ve written is ``main`` which is called for you when you
   run your program.

   Add the definition of ``doubled`` from above to this class and then run the
   program. Look at the output; do you notice that there is no sign in the
   output of the call to ``doubled(4)``. Can you change the program to have it
   print out the result of that call?

   ~~~~
   public class Doubler
   {

       // TODO: Add definition of doubled here

       public static void main(String[] argv)
       {
           System.out.println("Twice 2 is: " + doubled(2));
           doubled(4); // Notice that this has no effect when you run the program.
       }
   }
   ====
   import org.junit.Test;

   public class RunestoneTests extends CodeTestHelper {

       private void check(int n) {
         expect(n * 2, Doubler.doubled(n), "doubled(" + n + ")");
       }

       @Test
       public void testDoubledPositiveNumber() {
         check(10);
       }

       @Test
       public void testDoubledNegativeNumber() {
         check(-5);
       }

       @Test
       public void testDoubledZero() {
         check(0);
       }

       @Test
       public void testDoubledLargeNumber() {
         check(Integer.MAX_VALUE / 2);
       }
   }

.. activecode:: bhsawesome-greeting
   :language: java

   This class contains a call to the ``greeting`` method shown above. Add the
   definition of ``greeting`` to this class. Once the code runs and prints
   ``Hello, World.`` add another line to ``main`` that prints something like,
   ``Hello, Pat. Nice to meet you!``.

   ~~~~
   public class HelloWorld
   {

       // TODO: Add definition of greeting here

       public static void main(String[] argv)
       {
           System.out.println(greeting("world"));
           // TODO
       }
   }
   ====
   import org.junit.Test;

   public class RunestoneTests extends CodeTestHelper
   {

       private void check(String arg)
       {
           expect("Hello, " + arg + ".", HelloWorld.greeting(arg), "greeting(\"" + arg + "\")");
       }

       @Test
       public void testHelloWorld()
       {
           check("world");
       }

       @Test
       public void testHelloFred()
       {
           check("Fred");
       }

       @Test
       public void testLong()
       {
           check("it is very nice to meet you!");
       }

   }

.. activecode:: bhsawesome-distance
   :language: java

   The distance between two numbers, as we discussed in a problem in the
   previous section, is defined as the absolute value of their difference.
   (Their difference is just what you get when you subtract one from the other.)

   The code below contains a method signature and empty body for a method
   ``distance`` which is called from ``main``. Fill in the body so it correctly
   computes the distance between ``a`` and ``b``.

   ~~~~
   public class DistanceCalculator
   {

       public static double distance(double a, double b)
       {
           // TODO: implement distance here
       }

       public static void main(String[] argv)
       {
           System.out.println("distance(13.5, 26.2) = " + distance(13.5, 26.2));
           System.out.println("distance(26.2, 13.5) = " + distance(26.2, 13.5));
           System.out.println(distance(13.5, 26.2) == distance(13.5, 26.2));
       }
   }
   ====
   import org.junit.Test;
   import java.io.IOException;

   public class RunestoneTests extends CodeTestHelper
   {
       @Test
       public void testNearToFar() throws IOException
       {
         expectExact(12.7, DistanceCalculator.distance(13.5, 26.2), "distance(26.2, 13.5)");
       }

       @Test
       public void testFarToNear() throws IOException
       {
         expectExact(12.7, DistanceCalculator.distance(26.2, 13.5), "distance(13.5, 26.2)");
       }

       @Test
       public void testZeroDistance() throws IOException
       {
         expectExact(0, DistanceCalculator.distance(26.2, 26.2), "distance(26.2, 26.2)");
       }
   }

.. activecode:: bhsawesome-hypotenuse
   :language: java

   .. image:: Figures/ladder.png
      :width: 100px
      :align: left
      :alt: Ladder on tower

   As we discussed in a problem in the previous section, the Pythagorean theorem
   tells us that the length of the hypotenuse (the side opposite the right angle
   in a right triangle) is the square root of the sum of the squares of the
   lengths of the other two sides, also called the “legs” of the triangle. In
   other words :math:`c = \sqrt{a^{2} + b^{2}}` where :math:`a` and :math:`b`
   are the lengths of the legs and :math:`c` is the length of the hypotenuse.

   One common use for the Pythagorean theorem is to calculate the length of
   ladder you will need to reach the window of your beloved, given that their
   cruel parents have locked them in a tower surrounded by a moat. The ladder
   will be the hypotenuse of a triangle whose legs are the height of the window
   of your beloved’s room in the tower and the width of the moat since you have
   to place the base of the ladder on the edge of the moat.

   Add a ``ladderSizeNeeded`` method to the class below that takes two
   ``double``\ s representing the height of the window and the width of the moat
   and returns the length  of the ladder needed as ``double``.

   ~~~~
   public class LadderHelper
   {

       // TODO: write a ladderSizeNeeded method here

       public static void main(String[] argv)
       {
           double size = ladderSizeNeeded(30, 40);

           System.out.println("Beloved, I need a " + size + " foot ladder!");
       }
   }
   ====
   import org.junit.Test;
   import java.io.IOException;

   public class RunestoneTests extends CodeTestHelper
   {
       private void check(double height, double width)
       {
           double expected = Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));
           double got = LadderHelper.ladderSizeNeeded(height, width);
           String label = "ladderSizeNeeded(" + height + ", " + width + ")";
           expectExact(expected, got, label);
       }

       @Test
       public void testMain() throws IOException
       {
           String expected = "Beloved, I need a 50.0 foot ladder!";
           expect(expected, getMethodOutput("main"), "Expected output from main");
       }

       @Test
       public void testShort() {
         check(3, 4);
       }
       @Test
       public void testTall() {
         check(30, 40);
       }

       @Test
       public void testRandom() {
         check(Math.random() * 100, Math.random() * 50);
       }



   }

Inside the Method During the Call
---------------------------------

When we call a method the execution of our program jumps to the body of the
method. Inside the body the parameters, such as ``n``, have been initialized to
the value of the argument passed in the call. So when we call ``double(2 + 3)``,
the expression ``2 + 3`` is first evaluated to produce 5. Just before we jump to
the first line of the body of ``doubled``, the parameter ``n`` is initialized
to 5. Then the code in the body runs, multiplying 5 times 2, producing 10 which
is returned.

The variable ``n`` only exists within the body of the method and it can take on
different values for different calls. There can be other variables named ``n``
elsewhere in a program but they do not interfere with the ``n`` in ``doubled``.
Which is good news—if that wasn’t true we’d have to keep track of all the
variable names we had used anywhere in our program which would be a huge pain!

This is the key to using methods as an abstraction. The details that we care
about inside the method—what names the method uses for its parameters and how it
computes its result—are hidden inside the method. Code that calls the method
such as this line:

.. code-block:: java

   System.out.println("Twice 2 is: " + doubled(2));

isn’t affected at all by those details. We could change the definition of
``doubled`` to this slightly different, but still correct, definition and
code that calls ``doubled`` would not be affected at all:

.. code-block:: java

   public static int doubled(int value)
   {
       return value + value;
   }

Note that both the parameter name has changed, from ``n`` to ``value`` and the
way the result is computed, using addition rather than multiplication. Those are
the details that have been abstracted away by writing the method.

Writing Methods with Effects
----------------------------

You can also write your own methods that have effects rather than computing
values. For instance, if you often wanted to abstract the pattern of printing
out “Twice <something> is: <something>” you could write a method that does that:

.. code-block:: java

   public static void showTwice(int n)
   {
       System.out.println("Twice " + n + " is: " + doubled(n));
   }

This method will work with any ``int`` value and if you decide you want to
change the message from “Twice <something> is: <something>” to “<something>
doubled is: <something>” you only have to change this method. Notice also that
the return type of ``showTwice`` is ``void`` meaning it does not return any
value.

|CodingEx| **Coding Exercise**

.. activecode:: bhsawesome-doubled-and-twice
   :language: java

   This code contains a call to ``showTwice`` from ``main``. Add the definition
   given above to this class so it will compile and run.

   After running this code, add two new methods to this class:

   - ``tripled`` that takes an ``int`` and return an ``int`` which is three
     times the argument.

   - ``showThrice`` that takes an ``int`` and will print out a message similar
     to the one in ``showTwice`` except showing what the argument tripled is.

   ~~~~
   public class Doubler {

       // TODO: Add showTwice method

       // TODO: Implement tripled method

       // TODO: Implement showThrice method that calls tripled

       public static int doubled(int n)
       {
           return n * 2;
       }

       public static void main(String[] argv)
       {
           showTwice(2);
           showTwice(4);

           // TODO: Add calls to showThrice
       }
   }

Getting Good at Methods
-----------------------

This unit has just covered the mechanics of calling existing methods and writing
and calling your own methods. Actually learning to use methods well is a big
part of learning Java so we can't expect to cover it all here.

However even from these small examples, you can maybe start to get a glimpse of
how we can use methods to break our programs into meaningful chunks. Look at the
``main`` method from the last coding exercise. While some details are abstracted
away in the definition of ``showTwice``, if we at least remember that it prints
something about the value we can see at a glance what ``main`` does: it does
that, once for the value 2 and once for 4.

If we care about the details we can look at the definition of ``showTwice``.
There we can see what it prints though exactly how the doubled value is computed
is abstracted away in the ``doubled`` method.

Obviously this is a tiny program and none of these abstractions is hiding very
much. But consider a million line program, like the ones mentioned at the
beginning of this unit. Suppose you broke what that program does into ten main
pieces and wrote each piece as a separate method. Each method would still be
100,000 lines. But at least at the top level you could understand what the
program does in terms of only ten separate parts. Ten things you might be able
to fit in your working memory.

And each of those ten methods could be further broken down into ten smaller
pieces, and so on. If you kept going it would only take six levels until your
whole program consisted of 10-line methods. You'd still have a million lines of
code and you'd have written a lot of methods. But you could read each method and
understand—at a certain level of abstraction—what it does while only having to
think about ten things at a time.

There’s no silver bullet to making a million-line program trivial to understand
but with good abstractions, including well-designed methods, it’s possible.


Summary
-------------------

- **Abstraction** means hiding details. **Procedural abstraction** means hiding
  the details of how a procedure is performed and so we can focus on what it
  achieves.

- A **method** in Java either computes a value or has some effect, such as
  printing to the screen.

- The **type** of a method is determined by its **return type** and the types of
  its **parameters**.

- **Parameters** are variables whose values are the values passed as arguments
  passed when a method is **called**.
