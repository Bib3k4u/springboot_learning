package net.engineeringdigest.journalApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MyClass {
   @GetMapping("abc")
   public String sayHello(){
        return "Hello";
    }
}
