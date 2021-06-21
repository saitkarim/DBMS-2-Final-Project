package sample;




public class Laptops_Info {
     private int sno;
     private String brand, laptop_name, display_size, processor_type, graphics_card, disk_space;

     public Laptops_Info( String brand, String laptop_name, String display_size, String processor_type, String graphics_card, String disk_space){

         this.brand = brand;
         this.laptop_name = laptop_name;
         this.display_size = display_size;
         this.processor_type = processor_type;
         this.graphics_card = graphics_card;
         this.disk_space = disk_space;

     }

     public int getSno() {
         return sno;
     }

     public void setSno(int sno) {
         this.sno = sno;
     }

     public String getBrand() {
         return brand;
     }

     public void setBrand(String brand) {
         this.brand = brand;
     }

     public String getLaptop_name() {
         return laptop_name;
     }

     public void setLaptop_name(String laptop_name) {
         this.laptop_name = laptop_name;
     }

     public String getDisplay_size() {
         return display_size;
     }

     public void setDisplay_size(String display_size) {
         this.display_size = display_size;
     }

     public String getProcessor_type() {
         return processor_type;
     }

     public void setProcessor_type(String processor_type) {
         this.processor_type = processor_type;
     }

     public String getGraphics_card() {
         return graphics_card;
     }

     public void setGraphics_card(String graphics_card) {
         this.graphics_card = graphics_card;
     }

     public String getDisk_space() {
         return disk_space;
     }

     public void setDisk_space(String disk_space) {
         this.disk_space = disk_space;
     }
}
