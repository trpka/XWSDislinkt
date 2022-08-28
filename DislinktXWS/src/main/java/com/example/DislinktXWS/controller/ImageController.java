package com.example.DislinktXWS.controller;

import com.example.DislinktXWS.DTO.ResponseMessageDTO;
import com.example.DislinktXWS.model.Image;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

import com.example.DislinktXWS.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin("*")
@RestController
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessageDTO> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        Image img = new Image(file.getOriginalFilename(), file.getContentType(),
                compressBytes(file.getBytes()));
        imageRepository.save(img);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
}
