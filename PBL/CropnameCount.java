public class CropnameCount{
    private String cropname;
    private int cropCount;
    
        public CropnameCount(String cn, int cc){
            cropname = cn;
            cropCount = cc;
        }
    
        public int getCropCount() {
            return cropCount;
        }
        public String getCropname() {
            return cropname;
        }
    
        public String toString() {
            return cropname + "\t " + cropCount;
        }
    }

