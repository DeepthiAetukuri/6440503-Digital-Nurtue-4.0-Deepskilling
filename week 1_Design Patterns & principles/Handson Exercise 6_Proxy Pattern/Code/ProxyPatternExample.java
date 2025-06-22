public class ProxyPatternExample {
    interface Image {
        void display();
    }
    static class RealImage implements Image {
        private String filename;
        public RealImage(String filename) {
            this.filename = filename;
            loadFromRemoteServer();
        }
        private void loadFromRemoteServer() {
            System.out.println("Loading image from remote server: " + filename);
        }
        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }
    static class ProxyImage implements Image {
        private String filename;
        private RealImage realImage;
        public ProxyImage(String filename) {
            this.filename = filename;
        }
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename); 
            } else {
                System.out.println("Using cached image: " + filename);
            }
            realImage.display();
        }
    }
    public static void main(String[] args) {
        Image img1 = new ProxyImage("pic1.jpg");
        Image img2 = new ProxyImage("pic2.jpg");
        img1.display();
        img1.display();
        img2.display();
        img2.display();
    }
}
