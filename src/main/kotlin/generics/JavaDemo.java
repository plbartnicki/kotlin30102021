package generics;

/*  J A V A - jesli jest na to czas! */
interface Producer<T>
{
	T produce( );
}

class A
{
	void demo( Producer<String> strs )
	{
//		Producer<Object> objects = strs; // !!! Not allowed in Java
		Producer<? extends Object> objects = strs; // wiec trzeba zrobic tak
		//na objects mozna wywolac te same metody co na strs
	}
}