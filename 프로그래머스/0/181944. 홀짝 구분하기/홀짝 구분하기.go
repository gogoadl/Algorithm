package main

import "fmt"

func main() {
    var a int
    fmt.Scan(&a)
    
    if a % 2 == 0 {
        fmt.Print(a, " is even")
    } else {
        fmt.Print(a, " is odd")
    }
}