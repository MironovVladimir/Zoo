package com.company;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

class Zoo {

    final private static int REST = 0;
    boolean predatorsNoise;
    boolean herbivorousNoise;
    private boolean stormNoise;
    private boolean isNight;
    private int supervisor;
    private int food;
    private int iterations =0;

    private LinkedList<Living> animals;

    Zoo(){
        animals = new LinkedList<>();
    }

    Zoo(Living New){
        animals = new LinkedList<>();
        animals.add(New);
    }

    Zoo(String filename){
        animals = new LinkedList<>();
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            StringBuilder json = new StringBuilder();
            while (line != null) {
                json.append("\n").append(line);
                line = reader.readLine();
            }
            System.out.println(json);
            for(Token t : JacksonParses.Parse(json.toString())){
                switch (t.type.toLowerCase()) {
                    case "wolf":
                        animals.add(new Wolf(t.name, t.state));
                        break;
                    case "cow":
                        animals.add(new Cow(t.name, t.state));
                        break;
                    case "fox":
                        animals.add(new Fox(t.name, t.state));
                        break;
                    case "panda":
                        animals.add(new Panda(t.name, t.state));
                        break;
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    void add(Living add){
        animals.add(add);
    }

    void makeNight(boolean arg){
        isNight = arg;
    }

    void makeStorm(boolean arg){
        stormNoise = arg;
    }

    void sendSupervisorTo(int cage){
        supervisor = cage;
        listen();
        food = cage;
        supervisor = REST;
    }

    void loadTo(String filename) throws IOException {

        File file = new File(filename);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        String ls = System.getProperty("line.separator");
        String ret = "";
        bw.write("\n[\n"+ls);
        Iterator<Living> i = animals.iterator();
        while(i.hasNext()){
            Living l = i.next();
            bw.write("\t{\n"+ls);
            String n = l.getName();
            String t = l.getType();
            String s = l.getState();
            bw.write("\t\t\"name\":\""+n+"\",\n"+ls);
            bw.write("\t\t\"state\":\""+s+"\",\n"+ls);
            bw.write("\t\t\"type\":\""+t+"\"\n"+ls);
            if(i.hasNext()) bw.write("\t},\n"+ls);
            else bw.write("\t}\n"+ls);
        }
        bw.write("]");
        bw.close();
        fw.close();
        System.out.print(ret);
    }

    void listen() {
        System.out.println("Iteration number:"+ iterations+++" *******************");
        boolean tmpPredatorsNoise = false;
        boolean tmpHerbivorousNoise = false;

        for (Living i : animals){
            int d = i.reactOn(predatorsNoise, herbivorousNoise, stormNoise, supervisor, isNight, food);
            if(d == Predator.SCREAMING) tmpPredatorsNoise = true;
            else if(d==Herbivorous.SCREAMING) tmpHerbivorousNoise = true;
        }
        predatorsNoise = tmpPredatorsNoise;
        herbivorousNoise = tmpHerbivorousNoise;

        if (!isNight) food = REST;
    }
}
