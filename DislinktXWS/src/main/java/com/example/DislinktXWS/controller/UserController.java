package com.example.DislinktXWS.controller;
import com.example.DislinktXWS.model.User;
import com.example.DislinktXWS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="api/user/{id}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getById(@PathVariable Long id){
        User user=this.userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value="api/user",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> save(@RequestBody User user){
        User savedUser=this.userService.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //Pronalazenje Usera Po Delu Korisnickog imena

    /*@RequestMapping(value="api/search/{username}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<User>> searchByPartUsername(@PathVariable String username)
    {
        List<User> users = userService.searchByPartUsername(username);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }*/

    //Pronalazenje Korisnika po korisnickom imenu
    @RequestMapping(value="api/search/{username}",method = RequestMethod.GET,produces= {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getByUsername(@PathVariable String username)
    {
        User user=this.userService.getByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    //Izmena Podataka o Useru
    @PutMapping("api/update")
    public ResponseEntity<User> UpdateUser(@RequestBody User u)
    {
        User user = this.userService.UpdateUser(u);
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }






    @DeleteMapping("/api/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id)
    {
        User user = userService.findById(id);
        this.userService.delete(user);
        return "Succesfully deleted user!";
    }






}
