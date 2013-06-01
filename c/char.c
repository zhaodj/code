#include <stdio.h>
#include <string.h>

int parse_path(char *path,char *orig,int *width,int *height){
    char *last=strrchr(path,'.');
    char *i=last;
    while(*i){
        i--;
        if(*i=='.'){
            break;
        }
    }
    int len=i-path+1;
    strncpy(orig,path,len);
    orig[len-1]='\0';
    //orig=origarr;
    i++;
    len=last-i+1;
    char result[len];
    char *dest;
    strncpy(result,i,len-1);
    result[len-1]='\0';
    dest=result;
    //char *x=strstr(dest,"x");
    sscanf(dest,"%dx%d",width,height);
    return 0;
}

int main(){
    char s[]="hello world";
    char *ps="hello";
    printf("%s\n",s);
    printf("%p\n",s);
    printf("%s\n",ps);
    printf("%p\n",ps);
    char *path="http://127.0.0.1:9092/130523/64f0cbadd28748428d55c206361c285c.jpg.400x300.jpg";
    char *pp=strrchr(path,'.');
    printf("%s\n",pp);
    char orig[200];
    int width,height;
    if(parse_path(path,orig,&width,&height)==0){
        printf("%s %d %d\n",orig,width,height);
    }
}
