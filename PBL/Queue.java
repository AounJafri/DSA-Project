import java.util.EmptyStackException;

public class Queue {
    Cropdata[] cropdata;
    int size;

    public Queue(Node x){
        cropdata = new Cropdata[x.count()];
        addCrop(x, this); 
    }

    public void add(Cropdata x){
        cropdata[size++] = x;
    }
    public Cropdata first(){
        if (size()==0) {
            throw new EmptyStackException();
        }
        return cropdata[0];
    }

    public Cropdata remove(){
        if (size()==0) {
            throw new EmptyStackException();
        }
        Cropdata temp = cropdata[0];
        for(int i=0; i<size(); i++ ){
            if(i==size()-1){
                cropdata[i] = null;
                break;
            }
            cropdata[i] = cropdata[i+1];
        }
        --size;
        return temp;
    }

    private void addCrop(Node start,Queue queue){
        queue.add(start.data);
        Node p = start;
        while (p.next!=null) {
            queue.add(p.next.data);
            p=p.next;
        }
// sorting array queue based on year
        int n=queue.cropdata.length;
        for(int i=0; i<n -1; i++){
            for(int j=0; j<n-i-1; j++){
                int a = Integer.parseInt(queue.cropdata[j].getYear().substring(0, 4));
                int b = Integer.parseInt(queue.cropdata[j+1].getYear().substring(0, 4));
                if (a > b) {
                    Cropdata temp = queue.cropdata[j];
                    queue.cropdata[j] = queue.cropdata[j+1];
                    queue.cropdata[j+1] = temp;
                }
            }
        }
    }

//************************ PROBLEM 3. FINDING M0ST RECENT AND OLDEST CROP OF ANDHRA PRADESH *****************/ 

    public Cropdata mostRecent(){
        return this.cropdata[size()-1];
    }
    public Cropdata oldest(){
        return this.cropdata[0];
    }
    public void print(){
        for(int i=0; i<size()-1; i++){
            System.out.println(this.cropdata[i]);
        }
    }

    public int size(){
        return size;
    }

}