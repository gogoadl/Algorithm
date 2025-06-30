package main

import (
    "fmt" 
    "unicode"
)

func main() {
    var s1 string
    fmt.Scan(&s1)
    var s string
    for _, element := range s1 {
        if unicode.IsUpper(element) {
            s += string(unicode.ToLower(element))
        } else {
            s += string(unicode.ToUpper(element))
        }
    }
    fmt.Print(s)
}