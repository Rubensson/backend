
package com.portfolio.backendPortfolio.Entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter 
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1,max= 50, message = "no cumple con la longitud")
    private String name;
    
     @NotNull
    @Size(min = 1,max= 50, message = "no cumple con la longitud")
    private String location;
     
    
    @NotNull
   
    private String profile_text;
      
       @NotNull
    
    @Size(min = 1,max= 50, message = "no cumple con la longitud")
    private String email;
       
        @NotNull
    @Size(min = 1,max= 50, message = "no cumple con la longitud")
    private String position;
        
     
    @Size(min = 1,max= 50, message = "no cumple con la longitud")
    private String profile_img;
         @Size(min = 1,max= 50, message = "no cumple con la longitud")
    private String hero_img;
    
    
    
}
