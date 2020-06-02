package hurricane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hurricane, yo.
 * @author plesio + rousko
 */
public class Hurricane {

	private int year;
	private int speed;
	private String name;
	private String month;
	private int pressure;

	public Hurricane(int year, int speed, String name, String month, 
		int pressure) {
		this.year = year;
		this.speed = speed;
		this.name = name;
		this.month = month;
		this.pressure = pressure;
	}

	@Override
	public String toString() {
		return "Hurricane: " + "[year = " + year + 
			"] [speed = " + speed + "] [name = " + name 
			+ "] [month = " + month + "] [pressure = "  
			+ pressure + "]";
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	
	public float getSpeedInKMH(){
		return (float) (speed * 1.876);
	}

	public static List<Hurricane> loadFile(String filename) {

		List<Hurricane> list = new ArrayList<>();

		try {
			File file = new File(filename);
			Scanner sc = new Scanner(file);

			while (sc.hasNext()) {
				int year = sc.nextInt();
				String month = sc.next();
				int pressure = sc.nextInt();
				int speed = sc.nextInt();
				String name = sc.next();

				list.add(new Hurricane(
					year,
					speed,
					name,
					month,
					pressure));

			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Hurricane.class.getName()).log(
				Level.SEVERE, null, ex);
		}

		return list;
		
	}
	
	public static List<Hurricane> getRange(List<Hurricane> hurricanes, 
		int min, int max){
		
		List<Hurricane> result = new ArrayList<>();
		
		for(Hurricane h : hurricanes){
			if(h.getYear() >= min && h.getYear() <= max){
				result.add(h);
			}
		}
		
		return result;
		
	}
	
	public static String getLevel(List<Hurricane> hurricanes, String name){
		
		Hurricane h = null;
		
		for(Hurricane hurricane : hurricanes){
			if(hurricane.getName().equals(name)){
				h = hurricane;
			}
		}
		
		if(h == null){
			return null;
		}
		
		float speedInKMH = h.getSpeedInKMH();
		
		if(speedInKMH >= 119 && speedInKMH <= 153){
			return speedInKMH + " km/h -> " + "Category 1";
		}
		
		if(speedInKMH >= 154 && speedInKMH <= 177){
			return speedInKMH + " km/h -> " + "Category 2";
		}
		
		if(speedInKMH >= 178 && speedInKMH <= 208){
			return speedInKMH + " km/h -> " + "Category 3";
		}
		
		if(speedInKMH >= 209 && speedInKMH <= 251){
			return speedInKMH + " km/h -> " + "Category 4";
		}
		
		if(speedInKMH >= 252){
			return speedInKMH + " km/h -> " + "Category 5";
		}
		
		return null;
		
	}
	
	public static String sortHurricanes(List<Hurricane> hurricanes){
		List<Hurricane> canes = new ArrayList<>(hurricanes);
		
		canes.sort((o1, o2) -> {
			return o2.getSpeed() - o1.getSpeed();
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(Hurricane hurricane : canes){
			sb.append(hurricane).append(System.lineSeparator());
		}
		
		return sb.toString();
	}
	
}
