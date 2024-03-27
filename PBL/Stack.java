
public class Stack {
    Node1 top;
    int size;
    public Stack(Node list){
        top = null;
        size = 0;
        this.top = addCrops(list, this);
    }
    public void pop(){
        top = top.next;
        --size;
    }

    public void print(Stack s){
        Node1 p = this.top;
        while(p!=null) {
            System.out.println(p.data);
            p=p.next;
        }
    }
    public CropnameCount peek(){
        return top.data;
    }

    public boolean isEmpty(){
        return (size()==0);
    }
    public void push(CropnameCount obj){
        top = new Node1(obj, top);
        size++;
    }

    public int size(){ return size;}


    private Node1 addCrops(Node start,Stack s){
        
       for(Node p = start; p!=null; p=p.next){

        if (!alreadyinstack(p.data.getCrop(),s)) {
            s.push(new CropnameCount(p.data.getCrop(), count(p.data.getCrop(), start)));
         }
       }

       sortStack(s);
       
       return s.top;
    }
    private boolean alreadyinstack(String s,Stack stack){
        Node1 p = stack.top;
        while (p!=null) {
            if (p.data.getCropname().equals(s)) {
                return true;
            }
            p=p.next;
        }
        return false;
    }
    
    // METHOD TO SORTING STACK BASED ON CROP COUNT
    private void sortStack(Stack s){

        CropnameCount[] array = new CropnameCount[s.size()];

        // CONVERTING STACK TO ARRAY
       Node1 p=s.top;
       for(int i=0; i<s.size() && p!=null; i++,p=p.next){
        array[i] = p.data;
       }

    //   SORTING ARRAY BASED ON CROP COUNT
       int n=array.length;
       for(int i=0; i<n -1; i++){
           for(int j=0; j<n-i-1; j++){
               if (array[j].getCropCount() > array[j+1].getCropCount()) {
                   CropnameCount temp = array[j];
                   array[j] = array[j+1];
                   array[j+1] = temp;
               }
           }
       }

    //    REFILLING STACK WITH SORTED DATA
       int len = s.size();
       while (!s.isEmpty()) {
        s.pop();
       }
       for(int i=len-1; i>=0; i--){
        s.push(array[i]);
       }
    }


//************************ PROBLEM 2.WHICH STATE IS POPULAR FOR WHICH CROP *************************************************
   
    public void popularCrop(){

        Node1 popular=null,scLast=null,p = this.top;

        while (p.next!=null) {
            if (p.next.next==null) {
                scLast = p;
                popular = p.next;
            }
            p=p.next;
        }
        if (scLast.data.getCropCount()==popular.data.getCropCount()) {
            System.out.println("The most popular crops for this state are: " + popular.data.getCropname() + " and " + scLast.data.getCropname());
        }
        else
            System.out.println("The most popular crop for this state is : " + popular.data);
    }


    
// *************************************************************************************************************
    
    public int count(String crop,Node start){
        Node p = start;
        int count=0;
        while(p!=null) {
            if (p.data.getCrop().equals(crop)) {
                count++;    
            }
            p=p.next;
        }
        return count;
    }

    
     class  Node1 {
        CropnameCount data;
        Node1 next;
        Node1(CropnameCount abc){ data = abc; next = null;}

        Node1(CropnameCount cr,Node1 next){
            data = cr;
            this.next = next;
        }
        
    }
}