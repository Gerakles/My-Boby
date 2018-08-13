package JavaRush.patern;

interface Image {
    void display();
}
class RealImage implements Image {
    private String file;
    public RealImage(String file){
        this.file = file;
        load(file);
    }
    private void load(String file){
        System.out.println("Загрузка " + file);
    }
    public void display() {
        System.out.println("Просмотр " + file);
    }
}
class ProxyImage implements Image {
    private String file;
    private RealImage image;
    public ProxyImage(String file){
        this.file = file;
    }
    public void display() {
        if(image == null){
            image = new RealImage(file);
        }
        image.display();
    }
}

public class ProxyTest {//тест
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display();
        image.display();
    }
}