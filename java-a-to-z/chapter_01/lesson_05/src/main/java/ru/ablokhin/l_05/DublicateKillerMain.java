package ru.ablokhin.l_05;

/**
 * Created by Andrey on 15.08.2016.
 */
public class DublicateKillerMain {
    public static void main(String[] args){

        DublicateKiller dublicateKiller = new DublicateKiller(args);
        String[] result = dublicateKiller.kill();

        for(String arg:result){
			System.out.print(arg + " ");
		}
    }
}
