package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient  {
    private String url;

    public NetworkClient() {
        System.out.println("call constructor" + url);
        connect();
        call("initalize connect messeage");

    }
    public void setUrl(String url){
        this.url = url;
    }

    public void connect(){
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + "message = " + message);
    }

    public void disconnect(){
        System.out.println("close" + url);
    }

    @PreDestroy
    public void close() {
        disconnect();

    }

    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메시지");
    }
}
