//
//  logic.c
//  study
//
//  Created by zhaodaojun on 13-6-1.
//  Copyright (c) 2013年 zhaodaojun. All rights reserved.
//

#include <stdio.h>

#define ngx_align(d, a)     (((d) + (a - 1)) & ~(a - 1))

int main(){
    printf("%x %x %x\n",(68+64-1),(~(64-1)),(131&~(64-1)));
    printf("%x %x %x\n",ngx_align(2, 64),ngx_align(68, 64),ngx_align(68, 128));
}
