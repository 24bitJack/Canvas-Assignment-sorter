import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;
public class Client {
    //my bad, this is the file handler, haha
    public ArrayList<dualObject<Assignment, Double>> Assignments = new ArrayList<>();
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
       Assignment a1 = new Assignment(false,"Apush","test", 10 , 2);
       System.out.println(a1.toString());
       checkSiteData("https://smuhsd.instructure.com/courses/43367/assignments/1125670");
    }
    
    public static void textToArray(File textfile, ArrayList<Assignment> arr1, Scanner console) {
        
        boolean isDone = false;
        if (textfile.exists()) {
            boolean x = true;
            String[] stringstuff = {"gendisc","URL","d_todo","m_todo"};
            while(x) {
                String[] arr4 = new String[7];
                String line = console.nextLine();
                x = console.hasNextLine();
                arr4 = line.split(";");
                switch(arr4[0].replace(" ", "")) {
                    case "true" -> isDone = true;
                    case "false" -> isDone = false;
                }
                Assignment newAs = new Assignment(isDone, arr4[1],arr4[2],Integer.parseInt(arr4[3]),Integer.parseInt(arr4[4]));
                String gendisc;
                String URL;
                int d_todo;
                int m_todo;
                for(int i = 5; i <8; i++) {
                        for(int j = 0; j< 3; j++) {
                            if (arr4[i].contains(stringstuff[j])) {
                                switch (j) {
                                    case 0:
                                        gendisc = arr4[i].replace("gendisc:", "").replace(" ", "");
                                        newAs.addDisc(gendisc);
                                        break;
                                    case 1:
                                        URL = arr4[i].replace("URL:", "").replace(" ", "");
                                        newAs.addURL(URL);
                                        break;
                                    case 2,3:
                                        d_todo = Integer.parseInt(arr4[i].replace("d_todo:", "").replace(" ", ""));
                                        m_todo = Integer.parseInt(arr4[i].replace("m_todo:", "").replace(" ", ""));
                                        newAs.addDateToDO(d_todo, m_todo);
                                        break;
                                }
                                
                            }
                        }
                }
                arr1.add(newAs);
            }
        }
    }

    public void addToFile(File textfile, Assignment as1) throws IOException {
        if(textfile.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(textfile, true))) {
                writer.newLine(); // Add a new line character
                writer.write(as1.toString());
            } catch (IOException e) {
                System.err.println("An error occurred while writing to the file: " + e.getMessage());
            }
        } else {
            System.out.println("This file does not exist");
        }
    }

    public static void checkSiteData(String ur) throws URISyntaxException {

    }
}