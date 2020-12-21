package dz.teletic.springfiledownloadclient.service;

import dz.teletic.springfiledownloadclient.utils.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author HouariZegai, created on 22/12/2020
 */
@Service
public class FileDownloadService {
    private static final String DIST_STORE_FOLDER = "D:/TeleticData"; // The folder where we store the data
    private static final String IP = "http://localhost:8080/";

    public void saveToFolder(String[] ids) {
        RestTemplate templ = new RestTemplate();
        byte[] downloadedBytes = templ.postForObject(IP + "downloadMultiFiles", ids, byte[].class);

        String dateStr = new SimpleDateFormat("_yyyy-MM-dd_hh-mm-ss").format(new Date());

//        FileUtils.saveToFile.accept(downloadedBytes, DIST_STORE_FOLDER + dateStr + ".zip");
        FileUtils.extractAndSaveToFolder.accept(downloadedBytes, DIST_STORE_FOLDER + dateStr);
    }


}
