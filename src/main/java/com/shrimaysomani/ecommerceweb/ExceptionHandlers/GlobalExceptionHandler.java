package com.shrimaysomani.ecommerceweb.ExceptionHandlers;

import com.shrimaysomani.ecommerceweb.DTOS.ExceptionDTO;
import com.shrimaysomani.ecommerceweb.exceptions.ProductNotFoundException;
import com.shrimaysomani.ecommerceweb.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //This annotation is used to handle exceptions globally
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> handleArithmeticException(){
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Something went wrong");
        dto.setResolution("Arithmetic issue");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDTO> handleArrayIndexOutOfBound(){
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Something went wrong");
        dto.setResolution("AIOUB issue");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionDTO> handleGeneralException(){
//        ExceptionDTO dto = new ExceptionDTO();
//        dto.setMessage("Something went wrong");
//        dto.setResolution("Exception");
//        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
//        return response;
//    }

//        @ExceptionHandler(ProductNotFoundException.class) {
//        public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//            ExceptionDTO dto = new ExceptionDTO();
//            dto.setMessage("Invalid product id"
//            dto.setResolution("Please check the product id");
//            ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
//            return response;
//        }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Invalid productId " + productNotFoundException.getId());
        dto.setResolution("ProductNotFoundException caught");
        ResponseEntity<ExceptionDTO> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
}


