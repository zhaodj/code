#include <stdio.h>

int bit_width(unsigned int n){
    unsigned int i = 0;
    while ((n >> i)){
        i++;
    }
    return i;
}


int main(){
    int i;

    for (i = 0; i < 15; ++i)
        printf("%02d bit width is %d\n", i, bit_width(i));

    return 0;
}
