package com.micha.elecciones.controller;

import com.micha.elecciones.upload.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ap/assets")
public class AssetsController extends BaseController {

    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    @GetMapping("/{filename:.+}")
    Resource getResource(@PathVariable String filename) {
        return fileSystemStorageService.loadAsResource(filename);
    }


    @PostMapping("/upload")
    Map<String, String> subirArchivo(@RequestParam("file") MultipartFile multipartFile) {
        String rutaArchivo = fileSystemStorageService.store(multipartFile);
        String rutaAbsoluta = buildUriString(rutaArchivo);

        Map<String, String> resultado = new HashMap<>();
        resultado.put("ruta", rutaArchivo);
        resultado.put("url", rutaAbsoluta);

        return resultado;
    }

}
