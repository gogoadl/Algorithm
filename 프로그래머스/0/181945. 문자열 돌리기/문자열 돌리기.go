package main

import "fmt"

func main() {
    var s1 string
    fmt.Scan(&s1)
    for _, e := range s1 {
        fmt.Println(string(e))
    }
}