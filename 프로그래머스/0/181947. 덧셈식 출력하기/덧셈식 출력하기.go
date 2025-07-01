package main

import "fmt"

func main() {
    var a, b int
    fmt.Scan(&a, &b)
    fmt.Printf("%d + %d = %d", a, b, a+b)
}