.. image:: ../../_static/BHSawesomeLogo.png
    :width: 350
    :align: center

Expressions
:::::::::::

As we discussed in the section “What is programming?” our job as Java
programmers is to write text that can be translated into instructions for a
computer. In other words, everything we write needs to have a *meaning* as
defined by Java. When we learn a human language we need to learn a bunch of
words and then how to create meaning by combining them in different ways.
Similarly, to learn Java we need to learn the basic building blocks and then how
to combine them. In this unit we’ll learn about the most basic building blocks
of meaning in Java: expressions.

Expressions are anything that can be thought of as expressing (thus the name) a
**value**. While it may not be obvious when you use your pocket super computer
to play music or watch videos, the fundamental things computers deal with are
pretty simple: basically numbers and a special kind of number that can be
interpreted as logical values. Everything else is built up from those simple
foundations.

You may have heard people say everything in a comuter is “zeros and ones”.
That’s because with just the digits zero and one, also known as **bits**, you
can express any number in a system called **binary** and once you can express
numbers you can express anything else. For instance this text that you are
reading is represented in the computer by a series of numbers that happen to
follow an agreed upon mapping between numbers and letters in the alphabet. The
music you listen to is also represented as numbers using a more complex mapping
that, after many calculations, eventually get turned into electrical signals to
your headphones that you hear as music.

The most basic expressions in Java are expressions that directly represent in
our program specific values that the computer will operate on when the program
runs: numbers like ``1``, ``1.14``, and ``238000000``; logical values called
``booleans`` which have the values ``true`` and ``false``, and also ``Strings``
which represent text like ``"hello, world"``. (As we just discussed, ``Strings``
are actually made up of numbers but they are built into Java deeply enough in
ways we’ll see throughout this book that we can treat them as atomic values even
though they really aren’t.)

More complex expressions are made, as in human languages, by combining
expressions. In Java we combine values using **operators** which *operate* on
values to produce new values. You already know about a bunch of Java’s operators
because they are the same as the mathematical operators you learned about in
elementary school: addition, subtraction, multiplication, and division. In this
chapter we will learn how to write those operators in Java, some details about
how they work on Java’s numbers, and some other operators that you probably
didn’t learn about in 3rd grade.

.. toctree::
   :caption Expressions Table of Contents
   :maxdepth: 3

   topic-numbers.rst
   topic-booleans.rst
   topic-strings.rst
   topic-summary.rst
