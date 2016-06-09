package com.saple.parking;

import com.saple.parking.run.RunFromCommondAndFile;


public class Main 
{
    public static void main( String[] args )
    {
       if(args.length==0){
    	   RunFromCommondAndFile.runCommond();
       }else{
    	   RunFromCommondAndFile.runFromFile(args[0]);
       }
    }
}
