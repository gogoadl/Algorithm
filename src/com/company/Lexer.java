package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/** Lexer 클래스는 Java 하위 집합에 대한 어휘 분석기를 나타냅니다. */

public class Lexer {

    /** 토큰 유형에서 정규 표현식으로의 매핑 */
    private Map<TokenType, String> regEx;

    /** 입력 소스에 나타나는 토큰 목록 */
    private List<Token> result;

    /**
     * 새로 생성 된 {@code Lexer} 객체를 초기화합니다.
     */
    public Lexer() {
        regEx = new TreeMap<TokenType, String>();
        launchRegEx();
        result = new ArrayList<Token>();
    }

    /**
     * 입력 소스 코드의 토큰 화를 수행합니다.
     *
     * @param source
     * 	분석 할 문자열
     * @throws AnalyzerException
     *	근원에 어휘 에러가있는 경우
     */
    public void tokenize(String source) {
        int position = 0;
        Token token = null;
        do {

            token = separateToken(source, position);
            if (token != null) {
                position = token.getEndIndex();
                result.add(token);
            }
        } while (token != null && position != source.length());

        if (position != source.length()) {
        }
    }

    /**
     * 일련의 토큰을 반환합니다.
     *
     * @return 토큰의리스트
     */
    public List<Token> getTokens() {
        return result;
    }

    /**
     * 형태가없는 토큰의 순서를 돌려줍니다.
     * 주석이나  단일주석 공백 또는 스페이스바와 같은 형태가 없는 것
     * {@code BlockComment},
     * {@code LineComment} , {@code NewLine}, {@code Tab}, {@code WhiteSpace}
     *
     * @return list of tokens
     */
    public List<Token> getFilteredTokens() {
        List<Token> filteredResult = new ArrayList<Token>();
        for (Token t : this.result) {
            if (!t.getTokenType().isAuxiliary()) {
                filteredResult.add(t);
            }
        }
        return filteredResult;
    }

    /**
     * 특정 인덱스에서 소스를 스캔하고 첫 번째로 분리 된 값을 반환합니다.
     * token
     *
     * @param source
     * 	스캔 할 소스 코드
     * @param fromIndex
     * 	검색을 시작할 인덱스
     * @return 토큰이 최초로 단락 지어진지, 토큰이 발견되지 않았던 경우는 {@code null}
     *
     */
    private Token separateToken(String source, int fromIndex) {

        if (fromIndex < 0 || fromIndex >= source.length()) {
            throw new IllegalArgumentException("입력 스트림의 인덱스가 잘못되었습니다!");
        }
        for (TokenType tokenType : TokenType.values()) {

            Pattern p = Pattern.compile(".{" + fromIndex + "}" + regEx.get(tokenType),
                    Pattern.DOTALL);

            Matcher m = p.matcher(source);
            //  source의 값이 저희가 선언한 패턴 p 에 맞는 조건인지 검사해서 m에 저장합니다.

            if (m.matches()) {
                String lexema = m.group(1);
                return new Token(fromIndex, fromIndex + lexema.length(), tokenType, lexema);
            }
        }

        return null;
    }

    /**
     * 토큰 유형에서 정규 표현식으로 맵을 작성합니다.
     *
     */
    private void launchRegEx() {
        // 형태가 없는 정규식 토큰
        regEx.put(TokenType.TBLOCKCOMMENT, "(/\\*.*?\\*/).*");
        regEx.put(TokenType.TLINECOMMENT, "(//(.*?)[\r$]?\n).*");
        regEx.put(TokenType.TWHITESPACE, "(\\s).*");
        regEx.put(TokenType.TTAB, "(\\t).*");
        regEx.put(TokenType.TNEWLINE, "(\\n).*");

        //	형태가 있는 정규식 토큰
        regEx.put(TokenType.TLBRACKET, "(\\[).*");
        regEx.put(TokenType.TRBRACKET, "(\\]).*");
        regEx.put(TokenType.TLPAREN, "(\\().*");
        regEx.put(TokenType.TRPAREN, "(\\)).*");
        regEx.put(TokenType.TPACKAGE, "\\b(package)\\b.*");
        regEx.put(TokenType.TIS, "\\b(is)\\b.*");
        regEx.put(TokenType.TBEGIN, "\\b(begin)\\b.*");
        regEx.put(TokenType.TEND, "\\b(end)\\b.*");
        regEx.put(TokenType.TIDENT, "\\b([^0-9][a-zA-Z_]{0,31}[0-9a-zA-Z_]{0,31})\\b.*");
        regEx.put(TokenType.TNUMBER, "(\\d{1,9}).*");
        regEx.put(TokenType.TASSIGN, "(:=).*");
        regEx.put(TokenType.TSEMICOL, "(;).*");
        regEx.put(TokenType.TADD, "([+]).*");
        regEx.put(TokenType.TSUB, "(-).*");
        regEx.put(TokenType.TMUL, "([*]).*");
        regEx.put(TokenType.TDIV, "(/).*");
    }

    public static void main(String[] args) {
        String source = "package TestProgram is " +
                "begin " +
                "a := b * (c + 365) - d;" +
                "x := ab345/(b3 + c4);" +
                " end;";
        Lexer lexer = new Lexer();

        lexer.tokenize(source);
        for (Token t: lexer.getFilteredTokens()) {
            System.out.println(t);
        }

    }
}