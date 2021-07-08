// pick latest downloaded file from system and then read PDF
package com.framework.helper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;

public class PDFHelper {
	
	
	public static String getPrintPDFData(String downloadPath) throws InterruptedException, IOException {

        String fileName = verifyDownloadedFileName(downloadPath);     
        File file = new File(fileName);
        PDDocument pdDocument = PDDocument.load(file);        
        PDFTextStripper pdStripper = new PDFTextStripper();
        pdStripper.setStartPage(1);
        pdStripper.setEndPage(1);

        String TestText = pdStripper.getText(pdDocument);
        pdDocument.close();

        return TestText;

    }
    private static String verifyDownloadedFileName(String downloadPath) {
        File getLatestFile = getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getAbsolutePath();
        String expectedFileName = getExpectedFileName();
        Assert.assertTrue(fileName.contains(expectedFileName), "Downloaded file name " + fileName + " is not matching with expected file name " +expectedFileName);
        return fileName;
    }

 

    private static String getExpectedFileName() {
        String finalFileName = null;
        String expFileName = "uDoc-";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy");
        LocalDateTime currDate = LocalDateTime.now();
        String expDate = dtf.format(currDate);
        finalFileName = expFileName + expDate + "-";
        return finalFileName;
    }
    
    private static File getLatestFilefromDir(String downloadPath){
        File dir = new File(downloadPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

}
