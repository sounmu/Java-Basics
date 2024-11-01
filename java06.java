import java.io.*;
import java.util.Scanner;

public class java06 {
    public static void main(String[] args) throws IOException {
        /*try {
            ReadCharExample();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        BufferedReaderExample();*/
        PrintWriterExample();

    }
    public static void ReadByteExample() throws IOException{
        // 사용자에게 문자열을 보여 주는 것이 바로 콘솔 출력이고, 출력된 질문에 사용자가 답변을 입력하는 것을 콘솔 입력이라고 한다.
        /* 콘솔 입력 */
        InputStream in = System.in; // System.in은 InputStream의 객체이다.

        int a1;
        a1 = in.read(); // InputStream의 read 메서드는 1byte 크기의 사용자의 입력을 받아드림. 하지만, read 메서드로 읽은 1byte의 데이터는
        // byte 자료형으로 저장되는 것이 아니라 int 자료형으로 저장됨.
        // 그래서 'a'를 입력하면 아스키코드값인 97이 출력됨.
        System.out.println(a1);

        byte[] a2 = new byte[3];
        try {
            int bytesRead = in.read(a2);
            if (bytesRead == -1) {
                System.out.println("EOF");
            } else {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.println("바이트: " + a2[i]);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void ReadCharExample() throws IOException{
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        char[] a = new char[3];
        int charsRead = reader.read(a);

        if (charsRead == -1) {
            System.out.println("EOF");
        } else {
            System.out.println(a);
        }
    }

    public static void BufferedReaderExample() throws IOException{
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        String s = br.readLine();
        System.out.println(s);
    }

    /*
    - InputStream : byte를 읽는다.
    - InputStreamReader : character을 읽는다.
    - BufferedReader : String을 읽는다.
     */

    // J2SE 5.0부터 java.util.Scanner 클래스가 새로 추가되었다. Scanner 클래스를 이용하면 콘솔 입력을 보다 쉽게 처리할 수 있다.
    public static void ScannerExample() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println(in.next()); // Scanner의 객체의 next() 메서드는 한 개의 토큰을 읽어 들인다.
        // 토큰 뿐만 아니라 숫자, 문자열들을 읽어 들일 수 있는 다양한 메서드들이 있다.
        // - next: 토큰을 읽어 들일 수 있다.
        // - nextLine: 라인을 읽어 들일 수 있다.
        // - nextInt: 정수를 읽어 들일 수 있다.
    }

    /* 파일 쓰기 */

    public static void FileOutputStreamExample() throws IOException{
        try (FileOutputStream output = new FileOutputStream("output.txt")){
            for(int i=1; i<11; i++) {
                String data = 1+" 번째 줄입니다.\r\n";
                output.write(data.getBytes());
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    // 문자열을 파일에 쓸 때는 FileOutputStream이 조금 불편하다. String을 byte 배열로 변환해야 하기 때문.
    public static void FileWriterExample() throws IOException{
        try (FileWriter output = new FileWriter("output.txt")) {
            for(int i=1; i<11; i++) {
                String data = i + " 번째 줄입니다.\r\n";
                output.write(data);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    // \r\n을 붙이는 대신에 println이라는 메서드를 사용해서 파일을 작성하는 예제가 있다.
    public static void PrintWriterExample() throws IOException{
        try (PrintWriter output = new PrintWriter("output.txt")) {
            for(int i=1; i<11; i++) {
                String data = i+" 번째 줄입니다";
                output.println(data);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
