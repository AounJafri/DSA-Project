import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Node{
     Node next;
     Cropdata data;

    public Node(Cropdata data){
        this.data = data;
    }

    public Node(String statename){
        this.data = null;
        this.next = null;
        addCropdata(statename);
    }

    public void print(Node start){
        Node p = start;
        while (p!=null) {
            System.out.println(p.data);
            p=p.next;
        }
    }

    // COUNTS NO OF NODES IN LIST
    public int count(){
        Node p = this;
        int count = 0;
        while (p!=null) {
            p=p.next;
            count++;
        }
        return count;
    }


    private void addCropdata(String stateName){

        String filePath = "src\\India Agriculture Crop Production.csv";

        try (Scanner scanner = new Scanner(new File(filePath))) {  

        scanner.nextLine();
        scanner.useDelimiter(",");

        this.data = new Cropdata(scanner.next(), scanner.next(),scanner.next(),scanner.next());
        Node p = this;
        scanner.nextLine();
        
        while(scanner.hasNextLine()) {
            String state = scanner.next();
            if(state.equals(stateName)) {
                p.next = new Node(new Cropdata(state,scanner.next(),scanner.next(),scanner.next()));
                p=p.next;
            }
        scanner.nextLine();      
    }

        if(!stateName.equals("Andaman and Nicobar Islands"))  {
            this.data = this.next.data;
            this.next = this.next.next;
        }
            
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
    
// ******************** PROBLEM 1. HOW TO FIND MOST POPULAR CROP IN A PARTICULAR YEAR*****************************
    
    private int size = 0;
    public String popularCropInYear(String year,Node start){
        
        CropnameCount[] array = new CropnameCount[50];
        Node p = start;
        while(p!=null) {
            if (p.data.getYear().equals(year)) {
                if (!alreadyInArray(p.data.getCrop(),array)) {
                 array[size] = new CropnameCount(p.data.getCrop(), count(start, year, p.data.getCrop()));   size++;
                }
            }
            p=p.next;
        }

        int max=0;
        String cropName = array[0].getCropname();

        for(int i=0; i<size; i++){
            if (array[i].getCropCount() > max) {
                max = array[i].getCropCount();
                cropName = array[i].getCropname();
            }
        }
        return cropName;
    }

    private int count(Node start,String year,String crop){
        int count=0;
        Node p =start;
        while (p!=null) {
            if (p.data.getCrop().equals(crop) && p.data.getYear().equals(year)) {
                count++;
            }
            p=p.next;
        }
        return count;
    }

    private boolean alreadyInArray(String name,CropnameCount[] array){
        for(int i=0; i<size; i++){
            if (array[i].getCropname().equals(name)) {
                return true;
            }
        }
       return false;
        }

}