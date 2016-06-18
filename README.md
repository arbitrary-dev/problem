Problem
======

A collection of programming problems.

### ticket

You're trying to escape your totalitarian country and to move your stuff
in several trips. What you've got is an array t[0..30] of month dates t[i] = [1..30]
when you're planning to move and 3 different types of tickets: 1-day-ticket ($2);
7-days-ticket ($7); 30-days-ticket ($25). Your task is to answer what minimum
you should pay to get all your stuff safely moved.

Example: [1, 2, 4, 5, 7, 29, 30] >>> 11

### lift

There is a queue F[0..1,000,000] of office plankton to get on their floors F[i] = [1..1,000]
and start drinking coffee with cookies. And only one lift to facilitate their needs.
Lift has weight limit of L = [1..200] kg. There is also a corresponding array of
weights of queue people W[0..1,000,000] = [1..L]. Find lift stops while in service,
assuming that people should enter strongly in order of their queue
and counting lift return on the first floor.

Example: F = [2, 1, 2, 3, 3, 3, 5], W = [50, 70, 80, 120, 120, 60, 30], L = 200 >>> 9

### family

Batya in your family achieved a skill of converting currency in your banking account.
Convertion is performed by exchanging digits in account value by means of Firebug.
Now you need to know maximum profits you can get from an account with known value N = [0..10,000].

Example: N = 213 >>> 321

### abs-divide

Living in a poor ghetto everyday you participate in wall-to-wall fighting encounters.
Tired of boring fights when powers are somewhat equal, you write a program to divide people
in 2 groups to maximize FUN.
There's an array of people and their corresponding power A[N] = [-1kkk..1kkk],
where N = [2..100k].
Get maximum value of abs(max(A[0], ..., A[k]) - max(A[k], ..., A[N - 1])).

Example: A = [4, 3, 2, 5, 1, 1] >>> abs(5 - 1) = 4

### coin

An autistic child counts adjacent pairs of coins showing the same face.
He has an array C[1..1k] of coins, where C[i] = 0 represents a coin with heads up, 1 – tails up.
Suffering from an overwhelming need to reverse exacly one coin, he needs to calm down and
write code which will return maximal adjacency rating after change.

Example: C = [1, 1, 0, 1, 0, 0], AR = 2 >>> AR = 4 (after reversing C[2])
