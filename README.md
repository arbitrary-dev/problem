Problem
======

A collection of programming problems.

### ticket, ticket-scala

You're trying to escape your totalitarian country and to move your stuff
in several trips. What you've got is an array `t[0..30]` of month dates `t[i] = [1..30]`
when you're planning to move and 3 different types of tickets: 1-day-ticket ($2);
7-days-ticket ($7); 30-days-ticket ($25). Your task is to answer what minimum
you should pay to get all your stuff safely moved.

Example: `[1, 2, 4, 5, 7, 29, 30] >>> 11`

### lift

There is a queue `F[0..1,000,000]` of office plankton to get on their floors `F[i] = [1..1,000]`
and start drinking coffee with cookies. And only one lift to facilitate their needs.
Lift has weight limit of `L = [1..200] kg`. There is also a corresponding array of
weights of queue people `W[0..1,000,000] = [1..L]`. Find lift stops while in service,
assuming that people should enter strongly in order of their queue
and counting lift return on the first floor.

Example: `F = [2, 1, 2, 3, 3, 3, 5], W = [50, 70, 80, 120, 120, 60, 30], L = 200 >>> 9`

### family

Batya in your family achieved a skill of converting currency in your banking account.
Convertion is performed by exchanging digits in account value by means of Firebug.
Now you need to know maximum profits you can get from an account with known value `N = [0..10,000]`.

Example: `N = 213 >>> 321`

### abs-divide

Living in a poor ghetto everyday you participate in wall-to-wall fighting encounters.
Tired of boring fights when powers are somewhat equal, you write a program to divide people
in 2 groups to maximize FUN.
There's an array of people and their corresponding power `A[N] = [-1kkk..1kkk]`,
where `N = [2..100k]`.
Get maximum value of `abs(max(A[0], ..., A[k]) - max(A[k], ..., A[N - 1]))`.

Example: `A = [4, 3, 2, 5, 1, 1] >>> abs(5 - 1) = 4`

### coin

An autistic child counts adjacent pairs of coins showing the same face.
He has an array `C[1..1k]` of coins, where `C[i] = 0` represents a coin with heads up,
`1` – tails up. Suffering from an overwhelming need to reverse exacly one coin,
he needs to calm down and write code which will return maximal adjacency rating after change.

Example: `C = [1, 1, 0, 1, 0, 0], AR = 2 >>> AR = 4` (after reversing `C[2]`)

### phone, phone-scala

Pretty-format phone numbers consisting of digits, spaces and hyphens.
Resulting phone number must be grouped in blocks of sizes 3,
last 1-2 blocks can be of size 2.

Example: `0 - 22 1985--324 >>> 022-198-53-24`

### trip

Given array of trips to places `P`, `A[D] = P` for each day `D`,
find minimum size of a trip to visit all places.
Where `P = 0..N, D = 1..N` and `N = 1..100,000`.

Example: `A = [7, 3, 7, 3, 1, 3, 4, 1] >>> 5`

### hotel

You have a space-separated set of words which must be in the hotel reviews.
In next line you've got number of reviews M that follow and consist of 2 lines:
hotel ID and review text.

Output must consist of hotel IDs sorted in descending order, by how many words we seek are
specified in hotel reviews, if numbers are equal, smaller hotel ID has priority.

### delta

Encode input numbers using delta to previous number. First number is printed as-is.
If delta doesn't fit signed byte `[-127..127]`, print `-128` and then delta.

Example: `25757 24367 24267 >>> 25757 -128 -1390 -100`

### pair

With first line you get sum N, which you must find in any pair of following numbers.
Output `1` if such pair exists, otherwise `0`.

### polygon

Given a list of dimensions of 4-side polygon, you need to output numbers of different
figures in the list.

Output format: *`<squares> <rectangles> <other>`*

### password

You've just stolen long output from keygrabber of one of your victims.
Now you need to find out the length of longest password-like substring there.
For substring to be password-like it must contain only letters with
at least one of them in upper-case. But output from keygrabber may also
contain digits.

Example: `u1aBBa2bbccdd >>> 4 (aBBa)`
