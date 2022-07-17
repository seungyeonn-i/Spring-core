package hello.core.singleton;

public class SingletonService {
    /*

    1. static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
    2. 이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회할 수 있다. 이 메서드를 호출하면 항상 같은 인스턴스를 반환한다.
    3. 딱 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다.

    */

    //자기자신을 내부에 하나 private static 으로 가지고 있음 -> 클래스 레벨에 올라가 하나만 존재
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){
        //private 생성자 다른데서 만들 수 없음
        //private으로 new 키워드를 막아두었다.

    }

    public void login(){
        System.out.println("singleton object logic print");
    }
}
