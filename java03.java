import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class java03 {
    public static void main(String arg[]){
        int age = 10;
        long countOfStar = 873811231231255L;

        float pi = 3.14F;
        double morePi = 3.14159265358979323846;

        double d1 = 123.4;
        double d2 = 1.234e2;

        System.out.printf("%d %d %f %f\n", age, countOfStar, pi, morePi);
        System.out.printf("%f %f\n", d1, d2);

        /* 불 */
        int base = 180;
        int height = 185;
        boolean isTall = height > base;

        if(isTall) {
            System.out.println("키가 큽니다");
        }

        /* 문자 */
        char a1 = 'a'; // 문자
        char a2 = 97; // 아스키코드
        char a3 = '\u0061'; // 유니코드

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        /* 문자열 */
        // String a1 = "Happy Java";
        // String b1 = "a";
        // String c1 = "123";

        // String a2 = new String("Happy Java");
        // new 키워드는 객체를 만들 때 사용됨. new를 사용한 방법도 있지만, 리터럴 표기 방식(위)가 
        // 더 가독성이 좋고 커파일 할 때 최적화에 더 좋음

        /* Wrapper 클래스
         * 멀티 스레드 환경에서 동기화를 지원하는 자료형. 
         * 원시 자료형은 리터럴 표기 방식을 지원
         * int - Integer
         * long - Long
         * double - Double
         * float - Float
         * boolean - Boolean
         * char - Character
         */
        
        /* equals */
        String a = "hello";
        String b = "java";
        String c = "hello";

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

        /* indexOf */
        // 문자열에서 특정 문자열이 시작되는 위치(인덱스 값)을 출력
        String e1 = "Hello Java";
        System.out.println(e1.indexOf("Java"));  // 6 출력
        
        /* contains */
        // 문자열에서 특정 문자열이 포함되어 있는지 여부를 리턴함

        /* charAt */
        // 문자열에서 특정 위치의 문자를 리턴함

        /* replaceAll */
        // 문자열에서 특정 문자열을 다른 문자열로 바꿀 때 사용함.
        String e4 = "Hello Java";
        System.out.println(e4.replaceAll("Java", "world"));

        /* substring */
        // 문자열에서 특정 문자열을 뽑아낼 때 사용함.
        String e5 = "Hello Java";
        System.out.println(e5.substring(0, 4));

        /* toUpperCase */
        // 문자열을 모두 대문자로 변경할 때 사용함.

        /* split */
        // 문자열을 특정한 구분자로 나누어 문자열 배열로 리턴함.
        String e7 = "a:b:c:d";
        String[] result7 = e7.split(":");
        System.out.println(result7[0]);

        /* 문자 포맷팅 */
        /*
         * %s 문자열
         * %c 문자 1개
         * %d 정수
         * %f 부동소수
         * %o 8진수
         * %x 16진수
         * %% Literal % 
         */

        /* 포맷팅 포맷 코드 응용하기 */
        // 1. 정렬과 공백 표현하기
        // System.out.println(String.format("%10s", "hi"));  // "        hi" 출력
        // System.out.println(String.format("%-10sjane.", "hi"));  // "hi        jane." 출력
        
        // 2. 소수점 표현하기
        // System.out.println(String.format("%.4f", 3.42134234));  // 3.4213 출력
        // System.out.println(String.format("%10.4f", 3.42134234));  // '    3.4213' 출력

        /* String buffer */
        // 문자열을 추가하거나 변경할 때 주로 사용하는 자료형

        /* append */
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("jump to java");
        String res1 = sb.toString();
        System.out.println(res1);

        // StringBuffer 객체를 사용하는 이유. 
        /* StringBuffer를 사용하면 내부적으로 StringBuffer 객체를 한 번만 생성하지만
         * String 자료형에 + 연산이 있을 때마다 Stirng 객체를 생성하므로 
         * 총 4개의 String 자료형 객체가 만들어짐.
         * 하지만, StringBuffer 자체가 무겁기 때문에 문자열에 추가하거나 변경하는 작업이 
         * 많으면 StringBuffer, 아니면 String을 사용하는게 낫다.
         */

        /* insert */

        sb.insert(0, "hello");
        String res2 = sb.toString();
        System.out.println(res2);

        /* sustring */

        System.out.println(sb.substring(0, 4));

        /* 배열 */

        int[] odds = {1, 3, 5, 7, 9};

        String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};

        // 배열의 길이 설정하기

        String[] weeks2 = new String[7]; // 명시적으로 길이를 설정할 수 있음. 여기서 숫자가 없으면 컴파일 에러
        // 배열값에 접근하기
        System.out.printf("%s %s %s\n", odds[1], weeks[0], weeks2[3]); // 3, 월, null

        // 배열의 길이 구하기
        System.out.println(weeks.length);

        // ArrayIndexOutOfBoundsException <- 정의된 인덱스 값을 넘어가면 반환함.

        /* 리스트 */

        // ArrayList, Vector, LinkedList ...

        // <ArrayList>

        // add 
        // import java.util.ArrayList

        
    }

    public static void CustomList(String[] args) {
        ArrayList<String> pitches = new ArrayList<>();
        // add
        pitches.add(0, "138");
        pitches.add(1, "129");
        pitches.add(2, "142");
        // get
        System.out.println(pitches.get(1));
        // size
        System.out.println(pitches.size());
        // contains
        System.out.println(pitches.contains("142")); // true
        //remove
        // 객체로 지우는 방법. 인덱스로 지우는 방법
        System.out.println(pitches.remove("142")); // true 
        System.out.println(0); // 138

        /* 제네릭스 */
        /* J2SE 5.0 버전 이후로 도입된 개념.  
         * 자료형을 안전하게 사용할 수 있도록 만들어주는 기능
        */
        ArrayList<String> pitches2 = new ArrayList<>(Arrays.asList("138", "129", "142"));
        System.out.println(pitches2);

        // String[] data = {"138", "129", "142"};  // 이미 투구수 데이터 배열이 있다.
        // ArrayList<String> pitches = new ArrayList<>(Arrays.asList(data));

        /* 리스트 정렬하기 */
        pitches.sort(Comparator.naturalOrder()); // reverseOrder 내림차순(역방향순)
        System.out.println(pitches);
    }
}

