package com.company.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Lexer {


    private Map<TokenType, String> regEx;

    private List<Token> result;

    public Lexer() {
        regEx = new TreeMap<TokenType, String>();
        launchRegEx();
        result = new ArrayList<Token>();
    }

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

    public List<Token> getTokens() {
        return result;
    }

    public List<Token> getFilteredTokens() {
        List<Token> filteredResult = new ArrayList<Token>();
        for (Token t : this.result) {
            if (!t.getTokenType().isAuxiliary()) {
                filteredResult.add(t);
            }
        }
        return filteredResult;
    }

    private Token separateToken(String source, int fromIndex) {

        if (fromIndex < 0 || fromIndex >= source.length()) {
            throw new IllegalArgumentException("입력 스트림의 인덱스가 잘못되었습니다!");
        }
        for (TokenType tokenType : TokenType.values()) {

            Pattern p = Pattern.compile(".{" + fromIndex + "}" + regEx.get(tokenType),
                    Pattern.DOTALL);

            Matcher m = p.matcher(source);

            if (m.matches()) {
                String lexema = m.group(1);
                return new Token(fromIndex, fromIndex + lexema.length(), tokenType, lexema);
            }
        }

        return null;
    }

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