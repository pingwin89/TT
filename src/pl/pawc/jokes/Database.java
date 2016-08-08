package pl.pawc.jokes;

import java.util.HashMap;
import java.util.Calendar;

import pl.pawc.jokes.model.Joke;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Database{

	private static final String file = "jokes.csv";

	public static HashMap<Integer, Joke> getJokes(){

		HashMap<Integer, Joke> results = new HashMap<Integer, Joke>();
		BufferedReader bfr = null;

		try{
			bfr = new BufferedReader(new FileReader(file));
			String line;
			int id = 1;
			while((line = bfr.readLine())!=null){
				String[] record = line.split(";");
				Joke joke = new Joke();
				joke.setContent(record[0]);
				joke.setComments(record[1]);
				joke.setDate(Integer.parseInt(record[2]));
				joke.setLikeCount(Integer.parseInt(record[3]));
				results.put(id, joke);		
				id++;
			}
			bfr.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}

		return results;

	}

	public static void writeJokes(HashMap<Integer, Joke> map){
		try{
			FileWriter fw = new FileWriter(file);
			for(int i=1; i<=map.size(); i++){
				if(map.get(i)==null) continue;
				String line = "";
				line+=map.get(i).getContent();
				line+=";";
				for(String comment : map.get(i).getComments()){
					line+=comment+"#";
				}
				line+=";";
				line+=map.get(i).getDate().getDate();
				line+=";";
				line+=map.get(i).getLikeCount();
				line+="\n";
				fw.write(line);
				fw.flush();
			}
			fw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}	
	}

}
