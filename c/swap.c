#include <stdio.h>

void inplace_swap(int *x,int *y){
    if(x==y){
        return;
    }
    *y = *x ^ *y;
    *x = *x ^ *y;
    *y = *x ^ *y;
}

void reverse_array(int arr[],int len){
    int first,last;
    for(first=0,last=len-1;first<=last;first++,last--){
        inplace_swap(&arr[first],&arr[last]);
    }
}

void print_array(int arr[],int len){
    for(int i=0;i<len;i++){
        printf("%d ",arr[i]);
    }
}

int main(){
    int arr[5]={1,2,3,4,5};
    reverse_array(arr,5);
    print_array(arr,5);
}
