<%-- 
    Document   : index
    Created on : 30-ene-2018, 11:37:25
    Author     : alex
--%>

<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code Uploader</title>
    </head>
    <body>
        <h1>Code Uploader</h1>
        <form name="uploadForm" action="index.jsp" method="POST" enctype="multipart/form-data">
            <%
                String saveFile = new String();
                String contentType = request.getContentType();

                if ((contentType != null && (contentType.indexOf("multipart/form-data") >= 0))) {
                    DataInputStream in = new DataInputStream(request.getInputStream());

                    int formDataLength = request.getContentLength();
                    byte dataBytes[] = new byte[formDataLength];
                    int byteRead = 0;
                    int totalBytesRead = 0;

                    while (totalBytesRead < formDataLength) {
                        byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
                        totalBytesRead += byteRead;
                    }

                    String file = new String(dataBytes);
                    saveFile = file.substring(file.indexOf("filename=\"") + 10);
                    saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
                    saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));

                    int lastIndex = contentType.lastIndexOf("=");

                    String boundary = contentType.substring(lastIndex + 1, contentType.length());

                    int pos;

                    pos = file.indexOf("filename=\"");
                    pos = file.indexOf("\n", pos) + 1;
                    pos = file.indexOf("\n", pos) + 1;
                    pos = file.indexOf("\n", pos) + 1;

                    int boundaryLocation = file.indexOf(boundary, pos) - 4;
                    int startPos = ((file.substring(0, pos)).getBytes()).length;
                    int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

                    File dir = new File("C:\\solDirectory");
                    dir.mkdir();
                    saveFile = "C:\\solDirectory\\" + saveFile;

                    File ff = new File(saveFile);

                    try {
                        FileOutputStream fileOut = new FileOutputStream(ff);
                        fileOut.write(dataBytes, startPos, (endPos - startPos));
                        fileOut.flush();
                        fileOut.close();
                    } catch (Exception e) {
                        out.println(e);
                    }
                }

            %>
            
            <input type="file" name="file" value="" width="100" />
            <input type="submit" value="Upload" name="sumbit" />
        </form>
        <form name="myForm" action="mainPage.jsp" method="POST">
            <input type="submit" value="Go back" />
        </form>
            
    </body>
</html>
