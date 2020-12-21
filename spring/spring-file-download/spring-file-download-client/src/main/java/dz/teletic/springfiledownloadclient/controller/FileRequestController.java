package dz.teletic.springfiledownloadclient.controller;

import dz.teletic.springfiledownloadclient.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author HouariZegai, created on 22/12/2020
 */
@Controller
public class FileRequestController {

    @Autowired
    private FileDownloadService fileDownloadService;

    @GetMapping("/data")
    public ResponseEntity<Void> getDataFromServer() {
        String[] ids = {"com_01", "com_02", "com_03", "com_02"};
        fileDownloadService.saveToFolder(ids);

        return new ResponseEntity(HttpStatus.OK);
    }
}
