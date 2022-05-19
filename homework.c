#include <stdio.h>
void fib(int n, int *result)
{
    int temp1;
    int temp2;
    if (n < 2)
    {
        *result = n;
    }
    else
    {

        fib(n - 1, &temp1);
        fib(n - 2, &temp2);
        *result = temp1 + temp2;
    }
}

int main()
{
    int result;
    fib(3, &result);
    printf("Result = %d\n", result);
}
