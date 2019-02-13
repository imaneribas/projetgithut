package store;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Store {

	public static Item item[]=new Item[20];
	public static int  size=0;
	public static int  [] cart=new int [10];
	public static Customer [] customer=new Customer[20];
	public static int size1=0;
	public static void main(String[] args) {
		for(int i=0;i<cart.length;i++){
			cart[i]=-1;
			}
		mainMenu();
	}
	public static void mainMenu() {
		while(true) {
		String Menu="1 Store system Menu \n"
	                 +"2 Add a new item to the Store\n"
				+"3 Add a new Custmer to the Store \n"
	                 +"4 Remove an item from Custmer shopping cart \n"
				+"5 View the items in custmer shopping cart \n"
	                 +"6 End shoping and go to checkout \n"
				+"7 Empty Custmer shopping cart \n"
	                 +"8 Exist the program";
		String Num=JOptionPane.showInputDialog(null,Menu);
		int ch=Integer.parseInt(Num);switch(ch){
		case 1:
			AddItem();
			break;
		case 2:
			AddCustomer();
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
			
		case 8:
			System.exit(0);
			break;
	}}
	}
	private static void AddItem() {
		int nu=-1;
		do {
		    JTextField id=new JTextField();  
		    JTextField name=new JTextField();			
		    JTextField quan=new JTextField();	
		    JTextField price=new JTextField();	
		    JTextField type=new JTextField();
		    JTextField nameType=new JTextField();
		    JTextField palceandother=new JTextField();
		    Object [] Messages ={" Enter item Number", id,"Enter item name",name," Enter item quantit�",quan," Enter item prix",price," Enter item type of item (B)Book, (S)shoes, (G)Game ?",type};
    int yes_no =JOptionPane.showConfirmDialog(null,Messages);
    if(yes_no==0){
    	Object [] Book={"Enter Book Title : " ,nameType,"Enter booki author: ",palceandother };
    	Object [] Game ={"Enter Game number: " ,nameType,"Enter place of manufacture: ",palceandother };
    	Object [] Shoes={"Enter shoes number: " ,nameType,"Enter place of manufacture: ",palceandother };
    	int result1=1;
    	if(type.getText().toUpperCase().equals("B")){
    		result1=JOptionPane.showConfirmDialog(null,Book);
    		}
    	if(type.getText().toUpperCase().equals("G")){
    		result1=JOptionPane.showConfirmDialog(null,Game);
    		}
    	if(type.getText().toUpperCase().equals("S")){
    		result1=JOptionPane.showConfirmDialog(null,Shoes);
    		}
    	if(yes_no==JOptionPane.YES_OPTION && result1== JOptionPane.YES_OPTION) {
    		int ID=Integer.parseInt(id.getText());
    		String Name=name.getText();
    		String TYPE=type.getText();
    		String NAMETYPE=nameType.getText();
    		String PLACE =palceandother.getText();
    		int Quan=Integer.parseInt(quan.getText());
    		int PRICE=Integer.parseInt(price.getText());
    		
    		int index=searchIDITem(ID);
    		int indexName=searchNameItem(Name);
    		if(indexName!=-1) {
    			item[indexName]. AddQuant(Quan); 
    			JOptionPane.showMessageDialog(null, "nom existe deja");
    			
    		}
    		if(index ==-1) {
    			item[size]=new Item(ID,Quan,PRICE,Name,TYPE,NAMETYPE,PLACE); 
    			size++;
    			JOptionPane.showMessageDialog(null, "bien saisi");
    		}
    	}
    		else {
    			JOptionPane.showMessageDialog(null, "existe deja");
    		}
    }
  
    String re=JOptionPane.showInputDialog(null, "do you want add onother item 1/0");
    nu=Integer.parseInt(re);
    
}while(nu == 1);} 
	private static int searchNameItem(String name) {
		// TODO Auto-generated method stub
		for (int i=0;i<size;i++) {
    		if(name.equals(item[i].getname())) {
    			return i;
    		}
    		
    	}
    	return -1;
    }
	
	
	private static int searchIDITem(int iD) {
		
		// TODO Auto-generated method stub
		for (int i=0;i<size;i++) {
		if(iD==item[i].getID()) {
			return i;
		}
		}
	
	return -1;
}
	private static void AddCustomer() {
		int nu=-1;
		do{
		JTextField id = new JTextField();
		JTextField name = new JTextField();
		Object message[]={"Enter Customer number :",id,"Enter Customer name",name};
		int yes =JOptionPane.showConfirmDialog(null,message);
		if(yes==JOptionPane.YES_OPTION){
			int ID=Integer.parseInt(id.getText());
			int index=SearchCart(ID);
			if(SearchIdCustomer(ID)!=-1){
				JOptionPane.showMessageDialog(null,"client deja ajouté");
				return;
				}
			if(index!=-1) {
				customer[size1]=new Customer(ID,index+1,name.getText());
				size1++;
				JOptionPane.showMessageDialog(null,"client ajouté");
				}
			else {
				JOptionPane.showMessageDialog(null,"il n'ya pas de cart vide");
			}
		}
		String re=JOptionPane.showInputDialog(null, "do you want add onother item 1/0");
	    nu=Integer.parseInt(re);
		}while(nu==1);
		
	}
	
	private static int SearchCart(int ID) {
		for(int i=0;i<cart.length;i++){
			if(cart[i]==-1){
			cart[i]=ID;
			return i;
			}
			}
			return -1;
	}
	private static int SearchIdCustomer(int ID) {
		for(int i=0;i<size1;i++){
			if(customer[i].getId()==ID){
			return i;
			}
			}
			return -1;
	}
	}