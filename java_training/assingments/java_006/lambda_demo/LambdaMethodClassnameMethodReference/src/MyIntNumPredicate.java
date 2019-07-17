// Use an instance method reference to refer to any instance.
// A functional interface for numeric predicates that operate
// on an object of type MyIntNum and an integer value.
interface MyIntNumPredicate {
	boolean test(MyIntNum mv, int n);
}