public class java05 {
    public static void main(String[] args) {
        System.out.println(Calculator1.add(3));
        System.out.println(Calculator1.add(4));
        // 위처럼 Calculator_Sum을 사용하면 또다른 계산기를 구현할 수 없음.
        // 그래서 Calculator_Sum2라는 새로운 클래스를 만들어도 되지만, 그러면 새로운 계산기를 열고
        // 싶을 때 마다 새로운 클래스를 선언할 것인가?
        // No. 그래서 '객체'라는 것을 사용
        Calculator_Sum cal1 = new Calculator_Sum();
        Calculator_Sum cal2 = new Calculator_Sum();

        System.out.println(cal1.add(3));
        System.out.println(cal1.add(4));

        System.out.println(cal2.add(3));
        System.out.println(cal2.add(7));


        Animal cat = new Animal();
        Animal dog = new Animal();
        Animal horse = new Animal();
        cat.setName("body");
        System.out.println(cat.name);

        Counter myCounter = new Counter();
        System.out.println("before update:"+myCounter.count);
        Updater myUpdater = new Updater();
        myUpdater.update(myCounter.count);
        System.out.println("after update:"+myCounter.count);

        NewUpdater newUpdater = new NewUpdater();
        newUpdater.update(myCounter);
        System.out.println("after newUpdater:"+myCounter.count);

        Dog dog1 = new Dog();
        dog1.setName("poppy");
        System.out.println(dog1.name);
        dog1.sleep();

        //HouseDog houseDog1 = new HouseDog();
        HouseDog houseDog1 = new HouseDog("happy");
        //houseDog1.setName("happy");
        houseDog1.sleep();
        houseDog1.sleep(3);

        HouseDog houseDog2 = new HouseDog(1);
        System.out.println(houseDog2.name);

        Tiger tiger1 = new Tiger();
        Lion lion1 = new Lion();

        Bouncer bouncer = new Bouncer();
        bouncer.barkAnimal(tiger1); // tiger1과 lion1 객체가 어떤 클래스의 객체이냐에 따라
        bouncer.barkAnimal(lion1);

    }
}

class Calculator1 {
    static int result = 0;

    static int add(int num) {
        result += num;
        return result;
    }
}

class Calculator_Sum {
    int result = 0;

    int add(int num) {
        result += num;
        return result;
    }
}

class Animal { // 클래스 내의 함수를 메서드
    String name;

    public void setName(String name) {
        this.name = name;
    }
}

/* 상속 */
// 자식 클래스가 부모 클래스의 기능을 그대로 물려받을 수 있는 상속
class Dog extends Animal {
    void sleep() {
        System.out.println(this.name+" zzz");
    }
} // 그래서 부모 클래스와는 독립적으로 새로운 기능들을 추가 할 수 있음

class Updater {
    void update(int count) { // update 메서드는 값(int 자료형)을 전달 받는 것이기 때문에 counter를 인식하지 못함.
        count++;
    }
}

class NewUpdater {
    void update(Counter counter) {
        counter.count++;
    }
}

class Counter {
    int count = 0;
}

/// 자바에서 만드는 모든 클래스는 Object 클래스를 상속받는다.

// Dog 클래스를 좀 더 구체화시키는 HouseDog 클래스를 만들어 보자.

class HouseDog extends Dog {
    // HouseDog 클래스로 만들어진 객체들을 sleep 메서드 호출 시 "happy zzz'가 아닌
    // 'happy zzz in house'
    void sleep() {
        System.out.println(this.name+" zzz in house");
    }
    // 이번에는 추가하는 메서드 오버로딩을 해보자
    void sleep(int hour) {
        System.out.println(this.name+" zzz in hpouse for " + hour + " hours");
    }
    // 이렇게 이미 존재하는 함수와 동일한 sleep 메서드를 또 생성할 수 있다. 파라미터에 int hour를 추가한 꼴.
    // 이렇듯 입력 항목이 다른 경우 동일한 이름의 메서드를 만들 수 있는데 이를 메서드 오버로딩
    HouseDog(String name) { // 이와 같이 메서드 명이 클래스명과 동일하고 리턴 자료형을 정의하지 않는 메서드를 생성자라고 함.
        this.setName(name);
    }
    // 생성자도 메서드이니까 오버로딩이 가능함.
    HouseDog(int type) {
        if (type == 1){
            this.setName(("yorkshire"));
        } else if (type == 2){
            this.setName(("bulldog"));
        }
    }


}

// 자바에는 다중 상속이 없다.

/* 생성자 */

// 아까 name이라는 값이 설정되어 있지 않아도 객체를 생성할 수 있었음.
// 그럼 객체 변수에 값을 무조건 설정해야만 객체가 생성될 수 있도록 강제할 수 있는 방법은?
//

/* 인터페이스 */

// 반복적인 메서드를 추가할 일이 필요할 때 인터페이스를 사용할 수 있음.

interface Predator {
    // 그러면 동물 별로 출력 값을 어떻게 다르게 할 수 있을까?
    String getFood();
}

class Tiger extends Animal implements Predator {
    // tiger 클래스의 객체이자 Predator 인터페이스의 객체
    public String getFood() {
        return "apple";
    }
}

class Lion extends Animal implements Predator {
    // lion 클래스의 객체이자 Predator 인터페이스의 객체
    public String getFood() {
        return "banana";
    }
}

class ZooKeeper {
    void feed(Predator predator) {
        //System.out.println("feed apple");
        System.out.println("feed " +predator.getFood());
    }
}


/* 다형성 */
class Bouncer {
    void barkAnimal(Animal animal) {
        if (animal instanceof Tiger) {
            System.out.println("어흥");
        } else if (animal instanceof Lion) {
            System.out.println("으르렁");
        }
    }
}
