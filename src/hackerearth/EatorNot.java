package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EatorNot {

	static class Diet {
		int Vitamins;
		int Carbs;
		int Fats;
		int Proteins;

		public void setVitamins(int vitamins) {
			Vitamins = vitamins;
		}
		public void setCarbs(int carbs) {
			Carbs = carbs;
		}
		public void setFats(int fats) {
			Fats = fats;
		}
		public void setProteins(int proteins) {
			Proteins = proteins;
		}
		public Diet(int vitamins, int carbs, int fats, int proteins) {
			Vitamins = vitamins;
			Carbs = carbs;
			Fats = fats;
			Proteins = proteins;
		}
		public boolean equalsOrGreater(Diet toCompare){
			if(this.Vitamins>=toCompare.Vitamins && this.Carbs>=toCompare.Carbs && this.Fats>=toCompare.Fats && this.Proteins>=toCompare.Proteins)
				return true;
			else
				return false;
		}

		public Diet Minus(Diet Main, Diet ToRemove){
			Diet newTempObj = Main;
			newTempObj.Vitamins = newTempObj.Vitamins-ToRemove.Vitamins;
			newTempObj.Carbs = newTempObj.Carbs-ToRemove.Carbs;
			newTempObj.Fats = newTempObj.Fats-ToRemove.Fats;
			newTempObj.Proteins = newTempObj.Proteins-ToRemove.Proteins;
			return newTempObj;
		}
		
	}

	public static void main(String[] args) throws Exception {
		List<Diet> fruitList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] requiredDiet = br.readLine().split(" ");
		Diet requiredDeitObj = new Diet(Integer.parseInt(requiredDiet[0]),
				Integer.parseInt(requiredDiet[1]),
				Integer.parseInt(requiredDiet[2]),
				Integer.parseInt(requiredDiet[3]));

		int noOfFruits = Integer.parseInt(br.readLine());
		Diet superFruit = new Diet(0, 0, 0, 0);
		
		for (int i = 0; i < noOfFruits; i++) {
			String[] currentFruit = br.readLine().split(" ");
			Diet RequiredObjectTemp =  new  Diet(Integer.parseInt(currentFruit[0]),
					Integer.parseInt(currentFruit[1]),
					Integer.parseInt(currentFruit[2]),
					Integer.parseInt(currentFruit[3]));
			fruitList.add(RequiredObjectTemp);
			superFruit.setVitamins(superFruit.Vitamins+Integer.parseInt(currentFruit[0]));
			superFruit.setCarbs(superFruit.Carbs+Integer.parseInt(currentFruit[1]));
			superFruit.setFats(superFruit.Fats+Integer.parseInt(currentFruit[2]));
			superFruit.setProteins(superFruit.Proteins+Integer.parseInt(currentFruit[3]));
		}
		boolean flag = false;
		if(!superFruit.equalsOrGreater(requiredDeitObj))
			System.out.println("NO");
		else if(superFruit.Vitamins==requiredDeitObj.Vitamins&&superFruit.Carbs==requiredDeitObj.Carbs&&superFruit.Fats==requiredDeitObj.Fats&&superFruit.Proteins==requiredDeitObj.Proteins){
			System.out.println("YES");
		}
		else{
			Iterator<Diet> fruitIterator = fruitList.iterator();
			while(fruitIterator.hasNext()){
				if(superFruit.Minus(superFruit, fruitIterator.next()).equalsOrGreater(requiredDeitObj)){
					System.out.println("YES");
					flag = true;
					break;
				}
			}
			if(!flag)
				System.out.println("NO");
		}
	}
}
