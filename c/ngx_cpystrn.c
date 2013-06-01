//
//  main.c
//  study
//
//  Created by zhaodaojun on 13-5-30.
//  Copyright (c) 2013年 zhaodaojun. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

#define u_char unsigned char

static u_char *ngx_cpystrn(u_char *dst,u_char *src,size_t n);

int main(int argc, const char * argv[])
{

    int i=1,j=2;
    printf("%d %d\n",i,j);
    // insert code here...
    printf("Hello, World!\n");
    char arr[]="hello";
    char *p="hello";
    const char *cp="hello";
    char *const pc=arr;
    printf("%ld %ld %ld %ld\n",sizeof(arr),sizeof(p),sizeof(cp),sizeof(pc));
    u_char *src=(u_char *)"0123456789";
    u_char dst[5];
    u_char *res=ngx_cpystrn(dst, src, 5);
    printf("%s",dst);
    printf("%s",res);
    u_char *cmd=(u_char *)"ls -al\0";
    system((char *)cmd);
    return 0;
}

u_char *ngx_cpystrn(u_char *dst, u_char *src, size_t n)
{
    if (n == 0) {
        return dst;
    }
    
    while (--n) {
        *dst = *src;
        
        if (*dst == '\0') {
            return dst;
        }
        
        dst++;
        src++;
    }
    
    *dst = '\0';
    
    return dst;
}

