package com.company;

public class JimSsa {

    // 자연수 n 이 매개변수로 주어질 때, 0 부터 n 까지 0.1 씩 증가하는 숫자를 문자열로 변환한 배열을
    // return 하도록 solution 함수를 완성해 주세요, 각 문자열은 소수점 1자리까지 표시하는 #.# 형태
//    function solution(n) { 1번 문제
//        var answer = [];
//        for (var i = 0; i <= n * 10; i++){
//            var value = i * 0.1;
//
//            answer.push(value.toFixed(1));
//            console.log(value.toFixed(1));
//        }
//        return answer;
//    }

    // AM/PM 12시간제 형식의 문자열 s가 주어졌을 때 24시간제 표시 형태로 바꾸어 return

//    function solution(s) { 2번 문제
//        var answer = '';
//
//        var str = s.split(":");
//
//        if(str.length == 3){
//
//            var sec = str[2].substring(0,2);
//            var ampm = str[2].substring(str[2].length - 2, str[2].length);
//
//            if(ampm == "AM"){
//                if(str[0] == "12") { str[0] = "00"; }
//                answer = str[0] + ":" + str[1] + ":" + sec;
//            }else{ // PM
//                if(str[0] != 12) { str[0] = Number(str[0]) + 12; }
//                else{ str[0] = "12" }
//                answer = str[0] + ":" + str[1] + ":" + sec;
//            }
//
//        }else{
//
//            if(str[3] == "AM"){
//                if(str[0] == 12) { str[0] = 0; }
//                answer = s.substring(s.length - 3, s.length);
//            }else{
//                if(str[0] == 12){ str[0] = 12; }
//                else{ str[0] = Number(str[0]) + 12; }
//
//                answer = str[0] + ":" + str[1] + ":" + str[2];
//            }
//
//        }
//
//        return answer;
//    }

    // 아래 3가지 유형 중 한가지에 맞춰 휴대폰 번호를 입력 받으려 합니다.
    // 유형 1 : 010-xxxx-xxxx
    // 유형 2 : 010xxxxxxxx
    // 유형 3 : +82-10-xxxx-xxxx

    // 휴대폰 번호가 매개변수로 주어질 때 유형 1~3중 어디에 해당하는지 return
//    function solution(phone_number) { 3번 문제
//        var answer = 0;
//
//        var regExp1 = /^010-\d{4}-\d{4}$/;
//        var regExp2 = /^010\d{4}\d{4}$/;
//        var regExp3 = /^\+82-10-\d{4}-\d{4}$/;
//
//        if(phone_number.match(regExp1) != null){
//            answer = 1;
//        }else if (phone_number.match(regExp2) != null){
//            answer = 2;
//        }else if (phone_number.match(regExp3) != null){
//            answer = 3;
//        }else{
//            return -1;
//        }
//        return answer;
//    }

    // 수열을 어떤 규칙에 의해 여러가지 항으로 나누었을 때, 각각의 항으로 이루어진 수열을 군수열이라고 합니다.
    // 무한수열 S = (1), (1,2), (1,2,3), (1,2,3,4) ,,,, 있을 때, 이 수열의 규칙은 다음과 같습니다.
    // 1. N 번째 군에는 1부터 N까지의 자연수가 크기 순서대로 있습니다.
    // 2. 수열의 k 번째 항은 군에 상관없이 맨 앞부터 세기 시작합니다. 즉, 수열 S의 4번째 항은 1이 됩니다.

//    function solution(k) { 4번 문제
//        var answer = 0;
//
//        var root = Math.sqrt(k*8-7);
//        var sum = 0;
//        var n = 1 + root;
//        var g = Math.floor((1+root)*1/2);
//
//        for(var i = 1; i <= g - 1; i++){
//            sum += i;
//        }
//
//        answer = k - sum;
//        return answer;
//    }

    // 증가하는 수란 숫자의 가장 왼쪽부터 오른쪽으로 읽을 때, 작거나 같은 경우가 없이 항상 증가하는 수를
    // 의미합니다. 즉 0,05,47,123,1789 등은 증가하는 수이지만, 455,790 등은 증가하는 수가 아닙니다.
    // 단 숫자는 0에서 시작할 수 있고, 증가하는 기준은 길이 기준과 숫자 기준이 있습니다. 예를들어 길이가
    // 4인 6789보다 길이가 5인 01234가 더 큰 수입니다. 또한 길이가 같을 때는, 05보다 12가 더 큰 수 입니다.
    // 숫자 K가 주어졌을 때, K번째 증가하는 수를 반환하는 함수를 완성해 주세요. 이 때, K번째로 증가하는
    // 수가 존재하지 않는다면 -1 반환

//    function solution(k) 5번 문제
//    {
//        var result = "";
//
//        var digit = k.toString();
//        var len = digit.length;
//        var s = "";
//        if(len < 2){
//
//        }
//        else{
//            for(var i = 0; i < len - 1; i++){
//                s += "1";
//            }
//            s += "0";
//            var j = Number(s);
//            result = k - j + 1;
//            console.log(s);
//            return String(result);
//        }
//
//    }
}
