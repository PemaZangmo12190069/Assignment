public class SolutionTest{
	public static void main(String[] args) {
		Solution<String, Integer> obj = new Solution<String, Integer>();
		assert(obj.isEmpty()==true);
		System.out.println(obj.isEmpty());
		obj.put("Abdul",1);
                System.out.println("Get: " + obj.get("Abdul"));
                obj.put("Hritik",2);
                obj.put("Sai",3);
                obj.put("Samal",6);
                System.out.println("Get: " + obj.get("Sai"));
                obj.put("Tashi",4);

                System.out.println("size: " + obj.size());
                System.out.println("Minimum: " + obj.min());
                System.out.println("Floor: " + obj.floor("Hritik"));
                System.out.println("Floor: " + obj.floor("HAHA"));


                System.out.println("Select: " + obj.select(3));
                System.out.println("Keys: " + obj.keys("Abdul", "Tashi"));
                obj.put("Chimi",5);
                obj.put("Samal",4);
                System.out.println("Get: " + obj.get("Samal"));
                obj.put("Nima",7);
                System.out.println("Size: " + obj.size());
                System.out.println("Get: " + obj.get("Chimi"));
                System.out.println("Floor: " + obj.floor("Chima"));
                obj.put("Sonam", 8);
                System.out.println("Keys: " + obj.keys("Abdul","Tashi"));
                System.out.println("Size: " + obj.size());

                System.out.print("\n");

                System.out.println("All test case pass");
        
	}
}