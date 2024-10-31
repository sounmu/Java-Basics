import java.util.ArrayList;

public class java04 {
    public static void main(String[] args) {
        System.out.println(CustomIf());
        java04 instance = new java04();
        System.out.println(instance.CustomFor());
        return;
    }

    public static String CustomIf(){
        boolean money = true;
        if (money){
            System.out.println(
                    "택시를 타고 가라"
            );
        } else {
            System.out.println("걸어가라");
        }
        /* 비교 연산자 */
        /* 논리 연산자 */
        // x && y
        // x || y
        // !x

        ArrayList<String> pocket = new ArrayList<String>();
        pocket.add("paper");
        pocket.add("handphone");
        pocket.add("money");

        if(pocket.contains("money")){
            System.out.println("택시를 타고 가라");
        } else {
            System.out.println("걸어가라");
        }
        return null;
    }

    public String CustomFor(){
        String[] numbers = {"one", "two", "three", "four", "five"};
        // for문
        for(int i=0; i<numbers.length; i++){
            System.out.println(numbers[i]);
        }
        // for each문
        for(String number: numbers){
            System.out.println(number);
        }
    }
}
