/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsegpw;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Slishu
 */
public class ParseGPW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        final URL url = new URL("http://www.gpw.pl/ajaxindex.php?action=GPWQuotations&start=showTable&tab=all&lang=PL&full=1");
        final URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        urlConnection.connect();
        final OutputStream outputStream = urlConnection.getOutputStream();

        final InputStream inputStream = urlConnection.getInputStream();
        String theString = IOUtils.toString(inputStream, "UTF-8");
        System.out.println(theString);
    }

}
