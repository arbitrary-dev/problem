Problem
======

A collection of programming problems.

### ticket

You're trying to escape your totalitarian country and to move your stuff
in several trips. What you've got is an array t[0..30] of month dates t[i] = [1..30]
when you're planning to move and 3 different types of tickets: 1-day-ticket ($2);
7-days-ticket ($7); 30-days-ticket ($25). Your task is to answer what minimum
you should pay to get all your stuff safely moved.

Example: [1, 2, 4, 5, 7, 29, 30] → 11

### lift

There is a queue F[0..1,000,000] of office plankton to get on their floors F[i] = [1..1,000]
and start drinking coffee with cookies. And only one lift to facilitate their needs.
Lift has weight limit of L = [1..200] kg. There is also a corresponding array of
weights of queue people W[0..1,000,000] = [1..L]. Find lift stops while in service,
assuming that people should enter strongly in order of their queue
and counting lift return on the first floor.

Example: F = [2, 1, 2, 3, 3, 3, 5], W = [50, 70, 80, 120, 120, 60, 30], L = 200 → 9
