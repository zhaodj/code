#include <stdio.h>
#include <string.h>

int main ()
{
    char str[] ="This is a line";
    char *p;

    p = strstr (str, "is");
    strncpy (p, "sample",5 );
    puts (str);

    int w,h;
    sscanf("400x300","%dx%d",&w,&h);
    printf("%d %d\n",w,h);
    return 0;
}
