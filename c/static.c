#include <stdio.h>

void siv(){
    static int i=0;
    i++;
    printf("%d\n", i);
}

int main(){
    for(int i=0;i<5;i++){
        siv();
    }
}
