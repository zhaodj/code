package main

import (
    "bufio"
    "errors"
    "fmt"
    "os"
    "strings"
)

func ReadLine(filename string) {
    f, err := os.Open(filename)
    if err != nil {
        println(err)
        return
    }
    defer f.Close()
    r := bufio.NewReaderSize(f, 4*1024)
    line, isPrefix, err := r.ReadLine()
    for err == nil && !isPrefix {
        s := string(line)
        println(s)
	arr := strings.Split(s,"\t")
	fmt.Printf("%q\n",arr)
        line, isPrefix, err = r.ReadLine()
    }
    if isPrefix {
        println(errors.New("buffer size to small"))
        return
    }
    if err != nil {
        println(err)
        return
    }
}

func ReadString(filename string) {
    f, err := os.Open(filename)
    if err != nil {
        println(err)
        return
    }
    defer f.Close()
    r := bufio.NewReader(f)
    line, err := r.ReadString('\n')
    for err == nil {
        print(line)
        line, err = r.ReadString('\n')
    }
    if err != nil {
        println(err)
        return
    }
}

func main() {
    filename := `/home/zhaodj/文档/work/时尚大号.txt`
    ReadLine(filename)
    ReadString(filename)
}
