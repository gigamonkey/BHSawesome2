Why two numeric types?
----------------------

You might wonder, why do we have two numeric types at all? Why not just use
``double``\ s all the time since they can represent values with and without a
fractional part. Some languages do make that choice. But the reason has to do
with making efficient use of the computer. ``int``\ s are represented very
simply and compactly in computer memory and the computer can perform ``int``
arithmetic very fast. And a lot of math in programs, such as counting things,
only needs integer math. Floating-point math, on the other hand, is quite a bit
slower. (Slower than integer math, that is; a computer can still do billions of
floating-point operation a second.)

These differences are rooted in how ``int``\ s and ``double``\ s are
represented. Most of the details are beyond what you need to know for the AP
Exam but there are a few things you do need to know.

First: ``int``\ s are represented in the computer memory using thirty-two bits,
i.e. thirty-two zeros or ones. That means there is a limit to how large a number
an ``int`` can represent.




We said before that all ``int``\ s can be converted to a mathematically
equivalent ``double``. To see why that’s true we need to n


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


.. index::
   pair: double; number of digits


What happens to repeating decimal numbers like 3.333333...? Java limits the
number of digits you can save for any ``double`` number to about 14-15 digits.
You should be aware that the accuracy of any calculation on a computer is
limited by the fact that computers can only hold a limited number of digits.

For example, int values are stored in 4 bytes of memory. There is an
``Integer.MAX_VALUE`` defined as 2147483647 and an ``Integer.MIN_VALUE`` defined
as -2147483648. If you try to store any number larger or smaller than these
numbers in an int variable, it will result in an **integer overflow** where an
incorrect value could be stored. Try it below.

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
