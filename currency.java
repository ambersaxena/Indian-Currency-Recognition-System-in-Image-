package ibmnn;
import java.io.File;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class ImageCracker {
    private static final String subscriptionKey = "{subcription key}";

   
    private static final String uriBase =
            "https://westcentralus.api.cognitive.microsoft.com/vision/v1.0/ocr";

    public static void main(String[] args) {
    	String text;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
        	
            URIBuilder uriBuilder = new URIBuilder(uriBase);

            uriBuilder.setParameter("language", "unk");
            uriBuilder.setParameter("detectOrientation", "true");

            URI uri = uriBuilder.build();
            HttpPost request = new HttpPost(uri);
            
            
            request.setHeader("Content-Type", "application/octet-stream");
            request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);
            
            File file = new File("{image path}");
            FileEntity reqEntity = new FileEntity(file);
            request.setEntity(reqEntity);
            
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonString = EntityUtils.toString(entity);
                JSONObject json = new JSONObject(jsonString);
            System.out.println("REST Response:\n");
                System.out.println(json.toString(2));
               String word=json.toString();
             //   System.out.println(text);
                
                
               String s="",str=word;
         		String imagetotext="";
         		int i=0,len=str.length();
         		while(true)
         		{
     				if((len-i)<2)
     					break;
     				if(str.charAt(i)=='"')
         			{
     					i++;
         				while(str.charAt(i)!='"')
         				{
         					s=s+str.charAt(i);
         					i++;
         				}
         				//if(s.equals("language"))
         					//break;
         				i++;
         				if(s.equals("text"))
         				{
         					s="";
         					i=i+2;
         					while(str.charAt(i)!='"')
             				{
             					s=s+str.charAt(i);
             					i++;
             				}
         					imagetotext=imagetotext+s+" ";
         				
         				}
         				else if(s.equals("sentences_tone"))
         					break;
         			}
     				s="";
     				i++;
         		}
         		System.out.println("final text is: "+imagetotext);          
               
         		String[] splited = imagetotext.split("\\s+");
         		System.out.println("llllllllllll"+splited[0]);
         		int l=splited.length;
               int flag =0;
         		for(i=0;i<l;i++)
               {
            	  
         			for (int m = 0; m < splited[i].length(); m++) 
         				for (int n = m+1; n <= splited[i].length() ; n++) 
         				{
         					
         						System.out.println(splited[i].substring(m, n));
         			//if(splited[i].length()-splited[i].substring(m, n).length()<)
         			{
         				//System.out.println(splited[i].substring(m, n));

         			String temp=splited[i].substring(m, n);
         			if(temp.equalsIgnoreCase("RUPEES"))                                                                                                                                                                                                                                                                                  
             	   {
             		   System.out.println("corrected one is INDIA ");
             	   }
         			if(temp.equalsIgnoreCase("NDIA")||
            			   temp.equalsIgnoreCase("IDIA")||
            			   temp.equalsIgnoreCase("INIA")||
            			   temp.equalsIgnoreCase("INDA")||
            			   temp.equalsIgnoreCase("INDI")
            			   )                                                                                                                                                                                                                                                                                   
            	   {
            		   flag=1;
            		   System.out.println("corrected one is INDIA ");
            	   }
         			if(temp.equalsIgnoreCase("GUARANTEE")||
             			   temp.equalsIgnoreCase("UARANTEED")||
             			   temp.equalsIgnoreCase("GARANTEED")||
             			   temp.equalsIgnoreCase("GURANTEED")||
             			   temp.equalsIgnoreCase("GUAANTEED")||
             			   temp.equalsIgnoreCase("GUARNTEED")||
             			   temp.equalsIgnoreCase("GUARATEED")||
             			   temp.equalsIgnoreCase("GUARANEED")||
             			   temp.equalsIgnoreCase("GUARANTED")
             			   )                                                                                                                                                                                                                                                                                   
             	   {
             		   flag=1;
             		   System.out.println("corrected one is INDIA ");
             	   }
         			
            	   if(temp.equalsIgnoreCase("OVERNOR")||
            			   temp.equalsIgnoreCase("GVERNOR")||
            			   temp.equalsIgnoreCase("GOERNOR")||
            			   temp.equalsIgnoreCase("GOVRNOR")||
            			   temp.equalsIgnoreCase("GOVENOR")||
            			   temp.equalsIgnoreCase("GOVEROR")||
            			   temp.equalsIgnoreCase("GOVERNR")||
            			   temp.equalsIgnoreCase("GOVERNO")||
            			   temp.equalsIgnoreCase("VERNOR")||
            			   temp.equalsIgnoreCase("OERNOR")||
            			   temp.equalsIgnoreCase("OVRNOR")||
            			   temp.equalsIgnoreCase("OVENOR")||
            			   temp.equalsIgnoreCase("OVEROR")||             
            			   temp.equalsIgnoreCase("OVERNR")||
            			   temp.equalsIgnoreCase("OVERNO")||
            			   temp.equalsIgnoreCase("GERNOR")||
            			   temp.equalsIgnoreCase("GVRNOR")||
            			   temp.equalsIgnoreCase("GVENOR")||
            			   temp.equalsIgnoreCase("GVEROR")||
            			   temp.equalsIgnoreCase("GVERNR")||
            			   temp.equalsIgnoreCase("GVERNO")|| 
            			   temp.equalsIgnoreCase("GORNOR")||
            			   temp.equalsIgnoreCase("GOENOR")||
            			   temp.equalsIgnoreCase("GOEROR")||
            			   temp.equalsIgnoreCase("GOERNR")||
            			   temp.equalsIgnoreCase("GOERNO")||
            			   temp.equalsIgnoreCase("GOVNOR")||
            			   temp.equalsIgnoreCase("GOVROR")||
            			   temp.equalsIgnoreCase("GOVRNR")||
            			   temp.equalsIgnoreCase("GOVRNO")||
            			   temp.equalsIgnoreCase("GOVEOR")||
            			   temp.equalsIgnoreCase("GOVENR")||
            			   temp.equalsIgnoreCase("GOVENO")||         
            			   temp.equalsIgnoreCase("GOVERR")||
            			   temp.equalsIgnoreCase("GOVERO")||
            			   temp.equalsIgnoreCase("GOVERN")
            			   )
            	   {
            		   flag=1;
            		   System.out.println("corrected one is GOVERNER ");
            	   }
            	   if(temp.equalsIgnoreCase("ESERVE")||
            			   temp.equalsIgnoreCase("RSERVE")||
            			   temp.equalsIgnoreCase("REERVE")||
            			   temp.equalsIgnoreCase("RESRVE")||
            			   temp.equalsIgnoreCase("RESEVE")||
            			   temp.equalsIgnoreCase("RESERE")||
            			   temp.equalsIgnoreCase("RESERV")
            	     )
            	   {
            		   flag=1;
            		   System.out.println("corrected one is RESERVE ");
            	   }   
         			}
         				}
            		   
               }
                int num = 0;
                
                boolean bool=false;
                if((bool= word.contains("NDIA"))==true||(bool= word.contains("GOVERNO"))==true||(bool= word.contains("UPEES"))==true)
                	System.out.println("tjjj  Indian Currency");
               if((bool= word.contains("ONE"))==true)
                  num = 1;
               else if((bool=word.contains("TWO"))==true)
              	  num = 2;
              	else if((bool= word.contains("FIVE"))==true)
                	num=5;
              	else if((bool= word.contains("TEN"))==true)
                    num = 10;
                	
               if((bool= word.contains("HUNDRED"))==true)
                    num = num*100;
               
               else if((bool= word.contains("THOUSAND"))==true)
                     		num = num*1000;    
               
               
                if(num==0)
                	System.out.println("\n unable to detect currency value");
                else
                	System.out.println("\n Currency Value:- "+num);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
   
}