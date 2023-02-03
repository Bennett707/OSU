fun a(x:int,y:int) = x + y;
val a = fn : int * int -> int

fun epoly(L:real list as h::T, x:real) = h + x *  epoly(T);

// Current Version to use
fun epoly([],x:real) = 0.0
|   epoly(L: real list as h::T, x:real) = h + x * epoly(T,x);

// If you want to print
val _ = print "hello"