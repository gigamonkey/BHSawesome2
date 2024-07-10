.. image:: ../../_static/BHSawesomeLogo.png
    :width: 350
    :align: center

Values and Expressions
::::::::::::::::::::::

As we discussed in the section “What is programming?” our job as Java
programmers is to write text that can be translated into instructions for a
computer. In other words, everything we write needs to have a *meaning* as
defined by Java.

When we learn a human language we first learn a bunch of words and then how to
create meaning by combining them in different ways. Similarly, to learn Java we
need to learn the basic building blocks and then how to combine them. In this
unit we’ll learn about the most basic building blocks of meaning in Java:
**values** and **expressions**.

In our analogy with human language, values are the words. While it may not be
obvious when you use your pocket super computer to play music or watch videos,
the fundamental things computers deal with are pretty simple: basically numbers
and a special kind of number that can be interpreted as logical values.
Everything else is built up from those simple foundations.

.. note::

   You may have heard people say everything in a comuter is “zeros and ones”.
   That’s because with just the digits zero and one, also known as **bits**, you
   can express any number in a system called **binary** and once you can express
   numbers you can express anything else. For instance this text that you are
   reading is represented in the computer by a series of numbers that happen to
   follow an agreed upon mapping between numbers and letters in the alphabet.
   Music you listen to on a computer is also represented as numbers using a more
   complex mapping that, after many calculations, eventually get turned into
   electrical signals to your headphones that you hear as music.

Values in Java, and most other programming languages, are organized into **data
types**. A data type has two aspects: it’s both a set of values and a set of
operations that operate on those values. For instance in the next section we’ll
learn about two of Java’s data types ``int`` and ``double`` which both represent
numbers. Both of those data types support the usual arithmetic operations of
addition, subtraction, multiplication.

Some data types—and all the ones we’ll cover in this unit—have a third aspect:
they can be written in our programs as **literal values**. For instance we can
write ``1`` in a Java program to represent the numeric value one. Most of the
time we don’t need to be too particular about distinguishing between “literal
values” and “values” because the point of a literal value is it stands for the
value it represents. But note that a literal value is something that can appear
in the text of a program while when we say “a value” we are referring to the
actual representation of the value in a computer when the program is running,
kind of like the difference between the word on the page of a book (a literal
value) and the meaning of the word in your mind when you read it (the actual
value).

If values are analogous to words, then expressions are analogous to phrases or
sentences: expressions are parts of our programs that express a computation that
produces a value. For instance ``1 + 2`` is a Java expression that represents
the computation of adding together the value one and the value two, to produce
the value three. Like literal values which are bits of program text that *mean*
particular values, expressions are bits of program text that *mean* a particular
computation and that computation, when run on a computer, will produce a value
in the computers memory. Because an expression produces a value, we can also
talk about the **type** of the expression. For instance the expression ``1 + 2``
produces the value three of type ``int`` so we can say the type of the
expression is ``int``.

More complex expressions are made, as in human languages, by combining
expressions. In Java we combine values using **operators** which *operate* on
values to produce new values. You already know about a bunch of Java’s operators
because they are the same as the mathematical operators you learned about in
elementary school: addition, subtraction, multiplication, and division. In this
chapter we will learn how to write those operators in Java, some details about
how they work on Java’s numbers, and some other operators that you probably
didn’t learn about in 3rd grade.

In the rest of this unit, we’ll learn about four basic data types that we’ll use
in almost all our Java programs: two kinds of numbers, ``int`` and ``double``;
the data type used to represent the logical values true and false, ``boolean``;
and ``String``, a data type used to represent text.

.. toctree::
   :caption Expressions Table of Contents
   :maxdepth: 3

   topic-numbers.rst
   topic-booleans.rst
   topic-strings.rst
   topic-summary.rst
   check-your-understanding.rst
