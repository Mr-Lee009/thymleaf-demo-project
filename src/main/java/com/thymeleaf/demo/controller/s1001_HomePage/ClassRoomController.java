package com.thymeleaf.demo.controller.s1001_HomePage;

import com.thymeleaf.demo.dto.Human;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/page/class")
public class ClassRoomController {

    public static List<Human> people ;

    static {
        people = new ArrayList<Human>();
        people.add(new Human("1","ducla1",2,"119",2d,"A","A1"));
        people.add(new Human("2","ducla3",2,"119",2d,"A","A1"));
        people.add(new Human("3","ducla2",2,"119",2d,"A","A1"));
        people.add(new Human("3","ducla2",2,"119",2d,"A","A2"));
        people.add(new Human("3","ducla2",2,"119",2d,"A","A2"));
        people.add(new Human("3","ducla2",2,"119",2d,"A","A2"));
        people.add(new Human("3","ducla2",2,"119",2d,"A","A2"));
        people.add(new Human("3","ducla2",2,"119",2d,"C","C1"));
        people.add(new Human("3","ducla2",2,"119",2d,"C","C1"));
        people.add(new Human("3","ducla2",2,"119",2d,"C","C2"));
        people.add(new Human("3","ducla2",2,"119",2d,"C","C2"));
        people.add(new Human("3","ducla2",2,"119",2d,"D","D1"));
        people.add(new Human("3","ducla2",2,"119",2d,"D","D1"));
        people.add(new Human("3","ducla2",2,"119",2d,"D","D2"));
        people.add(new Human("3","ducla2",2,"119",2d,"D","D2"));
   }

   public Map<String,Map<String,List<Human>>> map(List<Human> people){
       Map<String,List<Human>> peopleMap = new HashMap<>();
       return null;
   }

   public static Map<String,List<Human>> groupByClass (List<Human> people){
       Map<String,List<Human>> peopleMap = people.stream().collect(
               Collectors.groupingBy(human -> human.getClassRoom())
       );
       return peopleMap;
   }

    public static Map<String,List<Human>> groupByType (List<Human> people){
        Map<String,List<Human>> peopleMap = people.stream().collect(
                Collectors.groupingBy(human -> human.getType())
        );
        return peopleMap;
    }

    public static Map<String,Map<String,List<Human>>> groupByTypeAndClass (List<Human> people){
        Map<String,Map<String,List<Human>>> peopleMap = people.stream().collect(
                Collectors.groupingBy(human -> human.getType(),Collectors.groupingBy(human2 -> human2.getClassRoom())));
        return peopleMap;
    }

    @GetMapping("")
    public Map<String,List<Human>> groupByClass(){
        // init screen
        return groupByClass(people);
    }

    @ResponseBody
    @GetMapping("/1")
    public Map<String,List<Human>> groupByType(){
        // init screen
        return groupByType(people);
    }

    @GetMapping("/2")
    @ResponseBody
    public Map<String, Map<String, List<Human>>> testingPage() throws InterruptedException {
        // init screen
        return groupByTypeAndClass(people);
    }

    @GetMapping("/show")
    public String classRoom(Model model) {
        model.addAttribute("people",groupByTypeAndClass(people));
        return "s1001_class_page";
    }

}
