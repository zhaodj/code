#include <stdio.h>

typedef struct st{
    char sex;
    int len;
    char name[10];
} St;

int main(){
    printf("%lu %lu %lu\n",sizeof(int),sizeof(char),sizeof(St));//内存对齐
    return 0;
}
