import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

   // This program creates a .cue file for use when splitting a large audio file into
   // seperate tracks based on timestamps. An example is a 5 hour playlist on Youtube
   // which has timestamps in the comments.
   //
   // The program takes in a file in the format: "timestamp;performer;title;composer"
   // and converts it into a .cue file for running through a splitter such as
   // mp3splt.
   public static void main(String[] args) {
      // Change the String here to reflect the actual supplied file to be converted
      File file = new File("songListSC.txt");
      Scanner reader;
      FileWriter writer = null;

      // Enter title for the playlist
      String playlistTitle = "Best Opera Playlist";

      try {
         reader = new Scanner(file);
      }
      catch (FileNotFoundException e) {
         System.out.println("File not Found");
         return;
      }

      try {
         // This will be the output file
         writer = new FileWriter("file.cue");
      }
      catch (IOException e) {
         System.out.println("Error writing to file");
      }

      try {
         writer.write("TITLE \"" + playlistTitle + "\"\n");
         writer.append("PERFORMER \"Various\"\n");
         writer.append("FILE \"File.mp3\" MP3\n");

         int count = 1;
         while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] lineArr = line.split(";");
            writer.append("  TRACK " + count + " AUDIO\n");
            writer.append("    TITLE \"" + lineArr[2] + "\"\n");
            writer.append("    PERFORMER \"" + lineArr[1] + "\"\n");
            writer.append("    SONGWRITER \"" + lineArr[3] + "\"\n");
            writer.append("    INDEX 01 " + lineArr[0] + "\n");
            count++;
         }
      }
      catch (IOException e) {
         System.out.println("Error writing to file");
      }

      reader.close();
      try {
         writer.close();
      }
      catch (IOException e) {
         System.out.println("Error closing file");
      }
   }

}
