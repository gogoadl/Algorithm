package com.company.programmers;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxNumber {
//    private Map<TokenType, String> regEx;
//
//    private List<Token> result;
//
//    public MaxNumber()
//    {
//        regEx = new TreeMap<TokenType, String >();
//        launchRegEx();
//        result = new ArrayList<>();
//    }
//    public void tokenize(String source) {
//       String[] token = source.split("");
//    }
//    private Token separateToken(String source, int fromIndex) {
//
//        if (fromIndex < 0 || fromIndex >= source.length()) {
//            throw new IllegalArgumentException("입력 스트림의 인덱스가 잘못되었습니다!");
//        }
//        for (TokenType tokenType : TokenType.values()) {
//
//            // Pattern 에서의 fromIndex 는 검색할 대상의 위치라 생각하면 됩니다.
//            // dotall 모드에서 표현식 . 은 어떠한 문자든이란 의미로 매칭된다.
//            // 마침 문자까지 합쳐서 말이다.
//            Pattern p = Pattern.compile(".{" + fromIndex + "}" + regEx.get(tokenType),
//                    Pattern.DOTALL);
//
//            Matcher m = p.matcher(source);
//            //  source의 값이 저희가 선언한 패턴 p 에 맞는 조건인지 검사해서 m에 저장합니다.
//
//            if (m.matches()) {
//                String lexema = m.group(1);
//                // group() (패턴에 맞는 값 1개씩 찾아내기)
//                // group()을 하면 모두 반환하고
//                // group(1)은 첫번째 sub group
//                // group(2)는 두번째 sub group을 반환
//
//                return new Token(fromIndex, fromIndex + lexema.length(), tokenType, lexema);
//            }
//        }
//        return null;
//    }
//    private void launchRegEx() {
//        // 형태가 없는 정규식 토큰
//        regEx.put(TokenType.TBLOCKCOMMENT, "(/\\*.*?\\*/).*");
//        regEx.put(TokenType.TLINECOMMENT, "(//(.*?)[\r$]?\n).*");
//        regEx.put(TokenType.TWHITESPACE, "(\\s).*");
//        regEx.put(TokenType.TTAB, "(\\t).*");
//        regEx.put(TokenType.TNEWLINE, "(\\n).*");
//
//        //	형태가 있는 정규식 토큰
//        regEx.put(TokenType.TLPAREN, "(\\[).*");
//        regEx.put(TokenType.TRPAREN, "(\\]).*");
//        regEx.put(TokenType.TPACKAGE, "\\b(package)\\b.*");
//        regEx.put(TokenType.TIS, "\\b(is)\\b.*");
//        regEx.put(TokenType.TIDENT, "([\\'][a-zA-Z]{0,31}[0-9a-zA-Z_]{0,31}[\\']).*");
////        regEx.put(TokenType.TIDENT, "\\b([\\'][a-zA-Z]{1, 31}[0-9a-zA-Z_]{0,31})\\b.*");
//        regEx.put(TokenType.TNUMBER, "\\b(\\d{1,9})\\b.*");
//        regEx.put(TokenType.TADD, "\\b[\\+]\\b.*");
//        regEx.put(TokenType.TSUB, "\\b(\\-)\\b.*");
//        regEx.put(TokenType.TMUL, "\\b(\\*)\\b.*");
//        regEx.put(TokenType.TDIV, "\\b(\\/)\\b.*");
//    }
    public static void main(String[] args) {
        String source = "package is 21 + 5";

        Pattern p = Pattern.compile(".{3}[+]");
        Matcher matcher = p.matcher("a + bc");
        if(matcher.find())
        {
            System.out.println(matcher.group());
        }


//        System.out.println(lexer.getFilteredTokens());

    }
}

