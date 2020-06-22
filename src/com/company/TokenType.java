package com.company;


public enum TokenType {
    TBLOCKCOMMENT,
    TLINECOMMENT,
    TWHITESPACE,
    TTAB,
    TNEWLINE,

    TLBRACKET,
    TRBRACKET,
    TLPAREN,  // (
    TRPAREN,  // )
    TPACKAGE, // 프로그램의 시작
    TIS,      // PACKAGE 뒤에
    TBEGIN,   // 코드작성 시작
    TEND,     // 코드작성 끝
    TSEMICOL, // ;
    TIDENT,   // ID
    TNUMBER,  // NUMBER
    TASSIGN,  // :=
    TADD,     // +
    TSUB,     // -
    TMUL,     // *
    TDIV,;    // /

    public boolean isAuxiliary(){
        return this == TBLOCKCOMMENT || this == TLINECOMMENT ||
                this == TNEWLINE || this == TTAB || this == TWHITESPACE;
    }
}
