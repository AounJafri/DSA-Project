public class Main {

    public static void main(String[] args) {
        Node andman = new Node("Andaman and Nicobar Islands");
        // andman.print(andman);
        // andman.popularCropInYear("2016-17", andman);


        Stack anStack = new Stack(andman);
        // anStack.print(anStack);
        // anStack.popularCrop();

        Node andhra = new Node("Andhra Pradesh");
        
        Queue andhraqQueue = new Queue(andhra);
        // andhraqQueue.print();
        // andhraqQueue.mostRecent();
        
    }
}
