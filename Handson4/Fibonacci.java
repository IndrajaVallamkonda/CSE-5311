class Fibonacci {

int fib (int n ){
  System.out.println(" N value : " + n );
  if (n == 0){
    return 0;
  }
  else if (n ==1){
    return 1;
  }
  else{
    return fib(n-1) + fib(n-2);
  }
}

public static void main(String[] args) {
        int k = 5;
        Fibonacci ob = new Fibonacci();
        ob.fib(k);

    }
}

// Output:-
// N value : 5
//  N value : 4
//  N value : 3
//  N value : 2
//  N value : 1
//  N value : 0
//  N value : 1
//  N value : 2
//  N value : 1
//  N value : 0
//  N value : 3
//  N value : 2
//  N value : 1
//  N value : 0
//  N value : 1
