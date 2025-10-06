import java.util.Arrays;
import java.util.Comparator;

public class Aplicación {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona[] personas = new Persona[3];
		personas[0] = new Persona("Juan", 25);
		personas[1] = new Persona("Ana", 30);
		personas[2] = new Persona("Luis", 20);
		
		Arrays.sort(personas,(Object o1, Object o2) -> {
				// TODO Auto-generated method stub3
				Persona p1 = (Persona)o1;
				Persona p2 = (Persona)o2;
				return Integer.compare(p1.edad(), p2.edad());
			
			
		});
		System.out.println(Arrays.toString(personas));
	}

}
