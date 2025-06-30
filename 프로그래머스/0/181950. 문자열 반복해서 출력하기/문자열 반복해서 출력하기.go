package main

import "fmt"

func main() {
    var s1 string
    var a int
    fmt.Scan(&s1, &a)
    var s string
    for i:= 0; i <a; i++ {
        s += s1;
    }
    fmt.Print(s)
}