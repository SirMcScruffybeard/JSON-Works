import com.sirmcscruffybeard.JSON_works.builders.JSONArrayBuilder;
import com.sirmcscruffybeard.JSON_works.builders.JSONObjectBuilder;

public class Test {

	public static void main(String[] args) {
		
		JSONArrayBuilder aBuilder = new JSONArrayBuilder(5);
		
		JSONObjectBuilder oBuilder = new JSONObjectBuilder();
		
		aBuilder.addString("This");
		
		aBuilder.add(null);
		
		oBuilder.put("Array", aBuilder.toString());
		
		oBuilder.put("Null", null);
		
		display(oBuilder.toString());
		
	}
	
	private static void display(String inString) {
		
		System.out.println(inString);
	}

}
