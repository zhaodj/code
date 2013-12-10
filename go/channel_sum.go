package main

import (
	"fmt"
)

func sum(n int, c chan int) {
	total := 0
	for i := 0; i <= n; i++ {
		total += i
	}
	c <- total
}

func main() {
	c := make(chan int)
	go sum(3, c)
	go sum(5, c)
	x, y := <-c, <-c
	fmt.Println(x, y)
}
