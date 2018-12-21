package divider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Divider {

	public void divide(String file, String dataset) {
   
      	// Markers for parsing elements.

        String whereToDivide = "<html>";
        String whereToDivide2 = "<HTML>";
        String whereToEnd ="</html>";
        String whereToEnd2 ="</HTML>";
        String websiteName = "website";
        
        String docBegin = "<DOC>";
        String docEnd = "</DOC>";
        
        String docNoBegin = "<DOCNO>";
        String docNoEnd = "</DOCNO>";
        
        int IDcount = 1;
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            
        		String line;
            String content;
            String docNo = "";
            
            while ((line = br.readLine()) != null) {
            	 
            	
            	// Look for <DOCNO>
            	if (line.length() > 6 && line.substring(0, 7).equalsIgnoreCase(docNoBegin)) {	
            			docNo = line.replace(docNoBegin, "").replace(docNoEnd, "");
            			System.out.println(docNo);
            	}
            	
            	// Condition to find <html>
            	if (line.length() > 5) {
            		if (line.substring(0, 6).equalsIgnoreCase(whereToDivide)) {

            			System.out.println(line);
            			
            			// Buffered writer to write contents of each <DOC> into a file.
            			BufferedWriter writer = new BufferedWriter(new FileWriter(docNo + ".html", true));
            			writer.append("<html>");
            			content = br.readLine();
            			
            			// Keep reading until </html> is reached.
            			while (content != null) {
            				if (content.contains(whereToEnd) || content.contains(whereToEnd2)) {
            					writer.append("</html>");
            					writer.close();
            					IDcount++;
            					break;
            				}
            				else {
            					writer.append(content);
            					content = br.readLine();
            				}
            			}
            			
            		}
            	}
           }
        } catch (IOException e) {
        		e.printStackTrace();
        }
        
}
}
