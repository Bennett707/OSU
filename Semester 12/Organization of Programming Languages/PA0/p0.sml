(*

Program 0
CS 3363, Spring 2023
Richard Churchill
Saturday, 28 Jan, 11:59 PM
Saturday, 28 Jan
Roger Bennett, robenne

This program is taking a list a real numbers from the user and repeadily calls the function
to pass the input one by one into the function and outputs the ending product of the function.

*)

fun epoly [] _ = 0.0
| epoly (h::T) x = h + (x * epoly T,x))