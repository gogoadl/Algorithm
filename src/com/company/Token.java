package com.company;

public class Token {

    // 입력된 토큰의 시작
    private int beginIndex;

    // 입력 된 토큰의 끝
    private int endIndex;

    // 토큰 유형 (카테고리)
    private TokenType tokenType;

    // 이 토큰의 문자 스트링
    private String tokenString;

    // 지정된 파라미터로 새로운 {@code Token} 객체를 구축합니다.
    //
    // @param beginIndex
    // 	입력에서이 토큰의 시작 색인.
    // @param endIndex
    // 	입력에서 토큰의 끝 색인, 제외
    // @param tokenString
    // 	문자의 문자열
    // @param tokenType
    //	토큰 유형

    public Token(int beginIndex, int endIndex, TokenType tokenType, String tokenString) {
        super();
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.tokenType = tokenType;
        this.tokenString = tokenString;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public String getTokenString() {
        return tokenString;
    }

    @Override
    public String toString() {
        return "Token [beginIndex=" + beginIndex + ", endIndex=" + endIndex + ", tokenType=" + tokenType
                + ", tokenString=\"" + tokenString + "\"]";
    }

}