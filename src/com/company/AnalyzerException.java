package com.company;

/**
 * {@code AnalyzerException} 클래스는 발생할 수있는 예외를 나타냅니다.
 * 어휘 또는 구문 오류로
 */

@SuppressWarnings("serial")
public class AnalyzerException extends Exception {
    /**
     * 입력 소스 (렉서) 또는 토큰 (파서)의 위치, 여기서
     * 오류가 발생했습니다.
     */
    private int errorPosition;

    /** 세부 메시지 */
    private String message;

    /**
     * 지정된 에러 위치를 가지는 {@code AnalyzerException} 오브젝트를 작성합니다.
     *
     * @param errorPosition
     * 		오류 위치
     */
    public AnalyzerException(int errorPosition) {
        this.errorPosition = errorPosition;
    }

    /**
     * 지정된 에러 위치를 가지는 {@code AnalyzerException} 오브젝트를 작성합니다.
     * 및 메시지
     *
     * @param message
     *            상세한 메시지
     * @param errorPosition
     *            오류 위치
     */
    public AnalyzerException(String message, int errorPosition) {
        this.errorPosition = errorPosition;
        this.message = message;
    }

    /**
     * 입력에서 오류 위치를 반환합니다.
     *
     * @return error's position
     */
    public int getErrorPosition() {
        return errorPosition;
    }

    @Override
    public String getMessage() {
        return message;
    }
}