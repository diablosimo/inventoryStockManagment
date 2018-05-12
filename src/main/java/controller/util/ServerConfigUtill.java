/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Chaimaa-abd
 */
public class ServerConfigUtill {

    private static String rootPath = "C:\\Users\\HP\\Documents\\NetBeansProjects\\MergedPFE-master\\web\\resources\\MyFilesImages";


   

    public static void upload(UploadedFile uploadedFile, String nameOfUploadeFile) {
        try {
            String fileSavePath = rootPath + "\\" + nameOfUploadeFile;
            InputStream fileContent = uploadedFile.getInputstream();
            Path path = new File(fileSavePath).toPath();
            System.out.println(path);
            Files.copy(fileContent, path , StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            JsfUtil.addErrorMessage(e, "Erreur Upload image");

        }

    }

}
