
package com.houarizegai.javase.file;

import java.io.File;

public class FoldersDemo {

    public static void main(String[] args){
        String newDir = "C:\\Users\\Houari\\Desktop\\newFolder";
        File f = new File(newDir);
        f.mkdir(); // create new folder
        
        newDir = "C:\\Users\\Houari\\Desktop\\Folder1\\Folder2";
        f = new File(newDir);
        f.mkdirs(); // create multi folder
        
        f = new File("C:\\Users\\Houari\\Desktop");
        for(String s : f.list()){ // get name of file
            System.out.println(s); // print the content of current directory (file & folders)
        }
    }
}
